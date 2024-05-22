package voting.sys.election.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voting.sys.election.application.dto.request.ElectionItemRequestDto;
import voting.sys.election.application.dto.response.ElectionItemResponseDto;
import voting.sys.election.application.facade.ElectionFacade;

import java.util.List;

@RestController
@RequestMapping("/election")
@RequiredArgsConstructor
public class ElectionController {

    private final ElectionFacade electionFacade;

    @PreAuthorize("hasAnyAuthority('Admin', 'User')")
    @GetMapping
    public ResponseEntity<List<ElectionItemResponseDto>> retrieveListOfAllElectionItems() {
        return new ResponseEntity<>(electionFacade.getAllElectionItemList(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('User')")
    @PostMapping("/save")
    public ResponseEntity<Long> saveElectionResponse(@RequestBody ElectionItemRequestDto electionItemRequestDto,
                                                     BindingResult bindingResult) {
        return new ResponseEntity<>(electionFacade.saveElectionVote(electionItemRequestDto, bindingResult), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('User')")
    @GetMapping("/checkVote/{idnp}")
    public ResponseEntity<Boolean> saveElectionResponse(@PathVariable("idnp") String idnp) {
        return new ResponseEntity<>(electionFacade.checkVotedByIdnp(idnp), HttpStatus.OK);
    }

}
