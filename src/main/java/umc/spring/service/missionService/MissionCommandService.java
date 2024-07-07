package umc.spring.service.missionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;

public interface MissionCommandService {
    MemberMission challengeMission(Long missionId, MemberMissionRequestDTO.ChallengeMission request);
}
