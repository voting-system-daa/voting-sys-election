package voting.sys.election.domain.service;

import voting.sys.election.domain.entity.Election;

import java.util.List;

public interface ElectionService {

    List<Election> getAllElectionItems();

}
