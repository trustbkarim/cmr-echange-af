package ma.gov.cmr.echangeaf.service;

import ma.gov.cmr.echangeaf.dto.create.WsPasSuiviCreateDto;
import ma.gov.cmr.echangeaf.dto.response.WsPasSuiviResponseDto;

import java.util.Optional;

public interface IWsPasSuiviService {

    Optional<WsPasSuiviResponseDto> createWsPasSuivi(WsPasSuiviCreateDto wsPasSuiviCreateDto);
}
