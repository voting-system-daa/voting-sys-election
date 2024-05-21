package voting.sys.election.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voting.sys.election.domain.entity.Election;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Long> {
}
