package ma.gov.cmr.echangeaf.dto.create;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WsPasDemandeCreateDto {

    @NotNull(message = "id_lot ne pouvait pas être nul")
    private Long idLot;

    @NotNull(message = "cin ne pouvait pas être nul")
    private String cin;

    @NotNull(message = "idcs ne pouvait pas être nul")
    private Integer idcs;

    @NotNull(message = "statut ne pouvait pas être nul")
    private Integer statut;
}
