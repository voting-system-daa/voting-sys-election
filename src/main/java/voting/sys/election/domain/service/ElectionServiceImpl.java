package voting.sys.election.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import voting.sys.election.domain.entity.Election;
import voting.sys.election.domain.repository.ElectionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectionServiceImpl implements ElectionService {

    private final ElectionRepository electionRepository;

    @Override
    public List<Election> getAllElectionItems() {
        return electionRepository.findAll();
    }

}
