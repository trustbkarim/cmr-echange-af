package ma.gov.cmr.echangeaf.dao.repositories;

import ma.gov.cmr.echangeaf.dao.models.WsPasSuiviEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWsPasSuiviRepository extends JpaRepository<WsPasSuiviEntity, Long> {
}
