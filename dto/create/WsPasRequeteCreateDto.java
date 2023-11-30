package ma.gov.cmr.echangeaf.dto.create;

import lombok.Data;
import ma.gov.cmr.echangeaf.dto.response.WsPasDemandeResponseDto;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Data
public class WsPasRequeteCreateDto {

    @NotNull(message = "id_lot ne pouvait pas être nul")
    private Long idLot;

    private Instant dateLot = Instant.now();

    private Instant dateCreation = Instant.now();

    private List<WsPasDemandeResponseDto> listBeneficiaire;

    private Integer nombreEnregistrement;
}
