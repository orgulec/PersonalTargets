package app.personaltargets.dto;

import lombok.Data;

@Data
public class GoalStatsDto {
    private Long done=0L;
    private Long failed=0L;
    private Long inProgress=0L;
    private Long scheduled=0L;
    private Long onHold=0L;
    private Long all=0L;
}
