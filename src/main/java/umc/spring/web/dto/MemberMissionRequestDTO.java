package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.ExistMember;

public class MemberMissionRequestDTO {

    @Getter
    public static class ChallengeMission {
        @ExistMember
        private Long memberId;

        @NotNull
        private MissionStatus missionStatus;
    }
}
