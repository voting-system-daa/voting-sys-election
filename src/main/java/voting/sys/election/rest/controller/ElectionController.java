package voting.sys.election.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
