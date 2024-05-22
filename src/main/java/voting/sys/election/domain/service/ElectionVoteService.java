package voting.sys.election.domain.service;

import voting.sys.election.domain.entity.ElectionVote;

import java.util.Optional;

public interface ElectionVoteService {

    Long saveElectionVote(ElectionVote electionVote);

    Optional<ElectionVote> findElectionVoteByIdnp(String idnp);

}
