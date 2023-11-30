package ma.gov.cmr.echangeaf.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class WsPasRequeteResponseDto {

    private Long idLot;

    private Instant dateLot;

    private Integer nombreEnregistrement;

    @JsonIgnoreProperties({"id", "idLot", "idcs", "statut"})
    private List<WsPasDemandeResponseDto> cinNonEnregistres;
}
