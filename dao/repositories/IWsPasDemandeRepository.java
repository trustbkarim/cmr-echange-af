package ma.gov.cmr.echangeaf.dao.repositories;

import ma.gov.cmr.echangeaf.dao.models.WsPasDemandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWsPasDemandeRepository extends JpaRepository<WsPasDemandeEntity, Long> {

    Boolean existsByCin(String cin);
}
