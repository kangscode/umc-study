package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class StoreRequestDTO {

    @Getter
    public static class ReviewDTO {

        @NotBlank
        String title;

        @NotNull
        Float score;

        @NotBlank
        String body;

    }

    @Getter
    public static class MissionDTO {

        @NotNull
        Integer reward;

        @DateTimeFormat(pattern = "yyyy-mm-dd")
        LocalDate deadline;

        @NotBlank
        String missionSpec;
    }
}
