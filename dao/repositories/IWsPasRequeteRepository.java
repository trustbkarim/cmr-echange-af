package ma.gov.cmr.echangeaf.dao.repositories;

import ma.gov.cmr.echangeaf.dao.models.WsPasRequeteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWsPasRequeteRepository extends JpaRepository<WsPasRequeteEntity, Long> {

    Optional<WsPasRequeteEntity> findByIdLot(Long idLot);
}
