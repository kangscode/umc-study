package umc.spring.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService{

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean findFoodCategory(List<Long> idList) {
        return idList.stream()
                .allMatch(id -> foodCategoryRepository.existsById(id));
    }


}
