package umc.spring.service.FoodCategoryService;

import java.util.List;

public interface FoodCategoryQueryService {
    boolean findFoodCategory(List<Long> idList);
}
