package ma.gov.cmr.echangeaf.service;

import ma.gov.cmr.echangeaf.dto.create.WsPasRequeteCreateDto;
import ma.gov.cmr.echangeaf.dto.response.WsPasRequeteResponseDto;

import java.util.Optional;

public interface IWsBeneficiaireService {

    Optional<WsPasRequeteResponseDto> createWsPasRequete(WsPasRequeteCreateDto wsPasRequeteCreateDto);
}
