package voting.sys.election.application.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import voting.sys.election.application.dto.request.ElectionItemRequestDto;
import voting.sys.election.application.dto.response.ElectionItemResponseDto;
import voting.sys.election.application.mapper.ElectionMapper;
import voting.sys.election.application.validator.ElectionValidator;
import voting.sys.election.domain.entity.Election;
import voting.sys.election.domain.entity.ElectionVote;
import voting.sys.election.domain.service.ElectionService;
import voting.sys.election.domain.service.ElectionVoteService;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ElectionFacadeImpl implements ElectionFacade {

    private final ElectionService electionService;

    private final ElectionVoteService electionVoteService;

    private final ElectionMapper electionMapper;

    private final ElectionValidator electionValidator;

    @Override
    public List<ElectionItemResponseDto> getAllElectionItemList() {
        List<Election> electionList = electionService.getAllElectionItems();

        return electionList.stream()
                .map(electionMapper::electionToElectionItemResponseDto)
                .toList();
    }

    @Override
    public Long saveElectionVote(ElectionItemRequestDto electionItemRequestDto,
                                 BindingResult bindingResult) {
        electionValidator.validate(electionItemRequestDto, bindingResult);

        ElectionVote electionVote = electionMapper.electionItemRequestDtoToElectionVote(electionItemRequestDto);

        if (electionItemRequestDto.getElectionId() != null) {
            Optional<Election> electionOptional =
                    electionService.getElectionByElectionId(electionItemRequestDto.getElectionId());
            electionOptional.ifPresent(electionVote::setElectionId);
        }

        return electionVoteService.saveElectionVote(electionVote);
    }

    @Override
    public Boolean checkVotedByIdnp(String idnp) {
        Optional<ElectionVote> electionVote = electionVoteService.findElectionVoteByIdnp(idnp);
        return electionVote.isPresent();
    }

}
