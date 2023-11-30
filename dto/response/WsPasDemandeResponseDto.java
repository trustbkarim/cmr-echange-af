package ma.gov.cmr.echangeaf.dto.response;

import lombok.Data;

@Data
public class WsPasDemandeResponseDto {

    private Long id;

    private Long idLot;

    private String cin;

    private Integer idcs;

    private Integer statut;
}
