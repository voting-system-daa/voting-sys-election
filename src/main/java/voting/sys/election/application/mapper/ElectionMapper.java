package voting.sys.election.application.mapper;

import org.mapstruct.Mapper;
import voting.sys.election.application.dto.response.ElectionItemResponseDto;
import voting.sys.election.domain.entity.Election;

@Mapper
public interface ElectionMapper {

    ElectionItemResponseDto electionToElectionItemResponseDto(Election election);

}
