package voting.sys.election.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import voting.sys.election.application.dto.request.ElectionItemRequestDto;
import voting.sys.election.application.dto.response.ElectionItemResponseDto;
import voting.sys.election.domain.entity.Election;
import voting.sys.election.domain.entity.ElectionVote;

@Mapper
public interface ElectionMapper {

    ElectionItemResponseDto electionToElectionItemResponseDto(Election election);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "electionId", ignore = true)
    ElectionVote electionItemRequestDtoToElectionVote(ElectionItemRequestDto electionItemRequestDto);

}
