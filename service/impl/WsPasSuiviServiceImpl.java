package ma.gov.cmr.echangeaf.service.impl;

import lombok.RequiredArgsConstructor;
import ma.gov.cmr.echangeaf.dao.models.WsPasSuiviEntity;
import ma.gov.cmr.echangeaf.dao.repositories.IWsPasSuiviRepository;
import ma.gov.cmr.echangeaf.dto.create.WsPasSuiviCreateDto;
import ma.gov.cmr.echangeaf.dto.response.WsPasSuiviResponseDto;
import ma.gov.cmr.echangeaf.service.IWsPasSuiviService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class WsPasSuiviServiceImpl implements IWsPasSuiviService {

    private final IWsPasSuiviRepository wsPasSuiviRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<WsPasSuiviResponseDto> createWsPasSuivi(WsPasSuiviCreateDto wsPasSuiviCreateDto) {

        WsPasSuiviEntity wsPasSuiviEntity = modelMapper.map(wsPasSuiviCreateDto, WsPasSuiviEntity.class);

        return Optional.of(modelMapper.map(wsPasSuiviRepository.save(wsPasSuiviEntity), WsPasSuiviResponseDto.class));
    }
}
