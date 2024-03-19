package app.personaltargets.dto;

import app.personaltargets.model.Category;
import app.personaltargets.model.State;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class GoalDto {

    private Long id;
    private Long user_id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime startDate;
    private LocalDateTime plannedEndDate;
    private LocalDateTime endDate;
    private Category category;
    private State state;

}
