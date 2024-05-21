package voting.sys.election.application.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import voting.sys.election.application.dto.response.ElectionItemResponseDto;
import voting.sys.election.application.mapper.ElectionMapper;
import voting.sys.election.domain.entity.Election;
import voting.sys.election.domain.service.ElectionService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ElectionFacadeImpl implements ElectionFacade {

    private final ElectionService electionService;

    private final ElectionMapper electionMapper;

    @Override
    public List<ElectionItemResponseDto> getAllElectionItemList() {
        List<Election> electionList = electionService.getAllElectionItems();

        return electionList.stream()
                .map(electionMapper::electionToElectionItemResponseDto)
                .toList();
    }

}
