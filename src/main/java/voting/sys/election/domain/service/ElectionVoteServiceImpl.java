package voting.sys.election.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voting.sys.election.domain.entity.ElectionVote;
import voting.sys.election.domain.repository.ElectionVoteRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectionVoteServiceImpl implements ElectionVoteService {

    private final ElectionVoteRepository electionVoteRepository;

    @Override
    public Long saveElectionVote(ElectionVote electionVote) {
        return electionVoteRepository.save(electionVote).getId();
    }

    @Override
    public Optional<ElectionVote> findElectionVoteByIdnp(String idnp) {
        return electionVoteRepository.getElectionVoteByIdnp(idnp);
    }
}
