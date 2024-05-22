package voting.sys.election.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voting.sys.election.domain.entity.ElectionVote;

import java.util.Optional;

@Repository
public interface ElectionVoteRepository extends JpaRepository<ElectionVote, Long> {

    Optional<ElectionVote> getElectionVoteByIdnp(String idnp);

}
