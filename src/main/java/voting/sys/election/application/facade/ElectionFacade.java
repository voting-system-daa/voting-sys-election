package voting.sys.election.application.facade;

import voting.sys.election.application.dto.response.ElectionItemResponseDto;

import java.util.List;

public interface ElectionFacade {

    List<ElectionItemResponseDto> getAllElectionItemList();

}
