package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MemberMission toMemberMission(MemberMissionRequestDTO.ChallengeMission request) {
        return MemberMission.builder()
                .status(request.getMissionStatus())
                .build();
    }

    public static MemberMissionResponseDTO.ChallengeMissionResultDTO toChallengeMissionResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengeMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMissionResponseDTO.MyMissionDTO toGetMyMissionDTO(MemberMission memberMission){
        //todo fetch join으로 한번에 가져오게 수정
        Mission mission = memberMission.getMission();
        Store store = mission.getStore();

        return MemberMissionResponseDTO.MyMissionDTO.builder()
                .storeName(store.getName())
                .storeCategoryName(store.getStoreCategory().getName())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MemberMissionResponseDTO.MyMissionListDTO toGetMyMissionListDTO(Page<MemberMission> memberMissionList){
        List<MemberMissionResponseDTO.MyMissionDTO> missionDTOList = memberMissionList.stream()
                .map(MissionConverter::toGetMyMissionDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MyMissionListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
