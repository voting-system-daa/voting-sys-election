package voting.sys.election.domain.service;

import voting.sys.election.domain.entity.Election;

import java.util.List;
import java.util.Optional;

public interface ElectionService {

    List<Election> getAllElectionItems();

    Optional<Election> getElectionByElectionId(long electionId);

}
