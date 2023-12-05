package ma.gov.cmr.echangeaf.service.impl;

import lombok.RequiredArgsConstructor;
import ma.gov.cmr.echangeaf.dao.models.WsPasRequeteEntity;
import ma.gov.cmr.echangeaf.dao.repositories.IWsPasDemandeRepository;
import ma.gov.cmr.echangeaf.dao.repositories.IWsPasRequeteRepository;
import ma.gov.cmr.echangeaf.dto.create.WsPasRequeteCreateDto;
import ma.gov.cmr.echangeaf.dto.create.WsPasSuiviCreateDto;
import ma.gov.cmr.echangeaf.dto.response.WsPasDemandeResponseDto;
import ma.gov.cmr.echangeaf.dto.response.WsPasRequeteResponseDto;
import ma.gov.cmr.echangeaf.exceptions.BadRequestException;
import ma.gov.cmr.echangeaf.service.IWsBeneficiaireService;
import ma.gov.cmr.echangeaf.service.IWsPasSuiviService;
import ma.gov.cmr.echangeaf.utils.Messages;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WsBeneficiaireServiceImpl implements IWsBeneficiaireService {

    private final IWsPasRequeteRepository wsPasRequeteRepository;
    private final IWsPasDemandeRepository wsPasDemandeRepository;
    private final IWsPasSuiviService wsPasSuiviService;
    private final ModelMapper modelMapper;
    private Integer nombreEnregistrement = 0;

    @Override
    public Optional<WsPasRequeteResponseDto> createWsPasRequete(WsPasRequeteCreateDto wsPasRequeteCreateDto) {

        if (wsPasRequeteRepository.findByIdLot(wsPasRequeteCreateDto.getIdLot()).isPresent()) {
            throw new BadRequestException(Messages.format("BAD_REQUEST_REQUETE_ID", wsPasRequeteCreateDto.getIdLot()));
        }

        List<WsPasDemandeResponseDto> wsPasDemandeResponseList = wsPasRequeteCreateDto.getListBeneficiaire();

        List<WsPasDemandeResponseDto> wsPasDemande = new ArrayList<>();

        List<WsPasDemandeResponseDto> wsPasDemandeResponseDtoList = new ArrayList<>();

        for (WsPasDemandeResponseDto wsPasRequeteIndex : wsPasDemandeResponseList) {

            if (wsPasDemandeRepository.existsByCin(wsPasRequeteIndex.getCin()).equals(Boolean.TRUE)) {

                wsPasDemande.add(wsPasRequeteIndex);

            } else {

                WsPasSuiviCreateDto wsPasSuiviCreateDto = new WsPasSuiviCreateDto();

                wsPasSuiviCreateDto.setIdLot(wsPasRequeteCreateDto.getIdLot());
                wsPasSuiviCreateDto.setCin(wsPasRequeteIndex.getCin());
                wsPasSuiviCreateDto.setIdcs(wsPasRequeteIndex.getIdcs());
                wsPasSuiviCreateDto.setStatut(wsPasRequeteIndex.getStatut());
                wsPasRequeteCreateDto.setNombreEnregistrement(this.nombreEnregistrement++);
                wsPasSuiviService.createWsPasSuivi(wsPasSuiviCreateDto);
                wsPasDemandeResponseDtoList.add(wsPasRequeteIndex);
            }
        }
        
        WsPasRequeteEntity wsPasRequete = wsPasRequeteRepository.save(modelMapper.map(wsPasRequeteCreateDto, WsPasRequeteEntity.class));
        WsPasRequeteResponseDto wsPasRequeteResponseDto = modelMapper.map(wsPasRequete, WsPasRequeteResponseDto.class);
        wsPasRequeteResponseDto.setNombreEnregistrement(this.nombreEnregistrement);
        wsPasRequeteResponseDto.setCinNonEnregistres(wsPasDemande);
        this.nombreEnregistrement = 0;
        return Optional.of(wsPasRequeteResponseDto);
    }
}
