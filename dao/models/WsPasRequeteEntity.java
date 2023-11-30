package ma.gov.cmr.echangeaf.dao.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "ws_pas_requete")
@Data
public class WsPasRequeteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_lot", nullable = false)
    private Long idLot;

    @Column(name = "date_lot")
    private Instant dateLot = Instant.now();

    @Column(name = "date_creation")
    private Instant dateCreation = Instant.now();

    @OneToMany(targetEntity = WsPasDemandeEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lot", referencedColumnName = "id_lot")
    private List<WsPasDemandeEntity> listBeneficiaire;
}
