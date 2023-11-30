package ma.gov.cmr.echangeaf.dao.repositories;

import ma.gov.cmr.echangeaf.dao.models.WsPasDemandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWsPasDemandeRepository extends JpaRepository<WsPasDemandeEntity, Long> {

    Optional<WsPasDemandeEntity> findByCin(String cin);
}
