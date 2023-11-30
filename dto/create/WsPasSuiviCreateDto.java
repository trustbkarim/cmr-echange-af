package ma.gov.cmr.echangeaf.dto.create;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class WsPasSuiviCreateDto {

    @NotNull(message = "id_lot ne pouvait pas être nul")
    private Long idLot;

    private Instant dateLot = Instant.now();

    @NotNull(message = "cin ne pouvait pas être nul")
    private String cin;

    @NotNull(message = "idcs ne pouvait pas être nul")
    private Integer idcs;

    @NotNull(message = "statut ne pouvait pas être nul")
    private Integer statut;

    private Instant dateCreation = Instant.now();

    private Instant dateModification = Instant.now();

    private Integer flagSituation;

    private Integer flagCouvertAf;

    private String envoiReponse;

    private Instant dateEnvoiReponse;
}
