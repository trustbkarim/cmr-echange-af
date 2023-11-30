package ma.gov.cmr.echangeaf.dto.response;

import lombok.Data;

import java.time.Instant;

@Data
public class WsPasSuiviResponseDto {

    private Long id;

    private Long idLot;

    private Instant dateLot;

    private String cin;

    private Integer idcs;

    private Integer statut;

    private Instant dateCreation;

    private Instant dateModification;

    private Integer flagSituation;

    private Integer flagCouvertAf;

    private String envoiReponse;

    private Instant dateEnvoiReponse;
}
