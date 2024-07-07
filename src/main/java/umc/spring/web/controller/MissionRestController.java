package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.missionService.MissionCommandService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MemberMissionResponseDTO.ChallengeMissionResultDTO> challenge(
            @RequestBody @Valid MemberMissionRequestDTO.ChallengeMission request,
            @ExistMission @PathVariable(name = "missionId") Long missionId
    ) {
        MemberMission memberMission = missionCommandService.challengeMission(missionId, request);
        return ApiResponse.onSuccess(MissionConverter.toChallengeMissionResultDTO(memberMission));

    }
}
