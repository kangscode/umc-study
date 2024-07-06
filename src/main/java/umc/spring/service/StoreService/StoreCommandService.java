package umc.spring.service.StoreService;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public interface StoreCommandService {

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);

}
