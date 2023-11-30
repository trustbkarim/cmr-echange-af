package ma.gov.cmr.echangeaf.dao.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ws_pas_demande")
@Data
public class WsPasDemandeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cin", nullable = false)
    private String cin;

    @Column(name = "idcs", nullable = false)
    private Integer idcs;

    @Column(name = "statut", nullable = false)
    private Integer statut;
}
