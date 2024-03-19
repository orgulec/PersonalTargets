package app.personaltargets.dto;

import app.personaltargets.model.Category;
import app.personaltargets.model.HabitFrequency;
import app.personaltargets.model.UserModel;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class HabitDto {

    private Long id;
    private UserModel user;
    private String name;
    private String description;
    private Category category;
    private HabitFrequency frequency;
    private boolean tracking;
    private LocalDateTime startDate;

}
