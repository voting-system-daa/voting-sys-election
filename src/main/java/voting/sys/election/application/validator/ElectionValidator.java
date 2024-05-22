package voting.sys.election.application.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import voting.sys.election.application.dto.request.ElectionItemRequestDto;
import voting.sys.election.application.exception.ValidationCustomException;
import voting.sys.election.domain.entity.ElectionVote;
import voting.sys.election.domain.service.ElectionVoteService;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ElectionValidator {

    private final ElectionVoteService electionVoteService;

    public void validate(ElectionItemRequestDto electionItemRequestDto,
                         BindingResult bindingResult) {
        if (electionItemRequestDto.getIdnp() != null) {
            Optional<ElectionVote> electionVoteById =
                    electionVoteService.findElectionVoteByIdnp(electionItemRequestDto.getIdnp());
            if (electionVoteById.isPresent() && electionVoteById.get().getElectionId() != null) {
                bindingResult.rejectValue("idnp", "",
                        "User with idnp = ["
                                + electionItemRequestDto.getIdnp()
                                + "] already voted!");
            }
        }

        if (bindingResult.hasErrors()) {
            throw new ValidationCustomException(bindingResult);
        }
    }

}
