package voting.sys.election.application.facade;

import org.springframework.validation.BindingResult;
import voting.sys.election.application.dto.request.ElectionItemRequestDto;
import voting.sys.election.application.dto.response.ElectionItemResponseDto;

import java.util.List;

public interface ElectionFacade {

    List<ElectionItemResponseDto> getAllElectionItemList();

    Long saveElectionVote(ElectionItemRequestDto electionItemRequestDto, BindingResult bindingResult);

    Boolean checkVotedByIdnp(String idnp);

}
