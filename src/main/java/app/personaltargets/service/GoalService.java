package app.personaltargets.service;

import app.personaltargets.dto.GoalDto;
import app.personaltargets.dto.GoalStatsDto;
import app.personaltargets.model.GoalModel;
import app.personaltargets.model.State;
import app.personaltargets.model.UserModel;
import app.personaltargets.repository.GoalRepository;
import app.personaltargets.utils.mappers.Mappers;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GoalService {
    private final GoalRepository goalRepository;
    private final UserService userService;
    private final Mappers mapper;

    public GoalModel addGoal(GoalDto goal) {
        GoalModel goalModel = mapper.goalToModel(goal);
        return goalRepository.save(goalModel);
    }

    public GoalModel getById(Long id) {
        Optional<GoalModel> goalOpt = goalRepository.findById(id);
        if(goalOpt.isEmpty()){
            throw new EntityNotFoundException("No goal founded.");
        }
        return goalOpt.get();
    }

    public GoalModel updateGoalById(Long id, GoalDto goal) {
        GoalModel goalToUpdate = getById(id);
        if(goal.getName()!=null)    goalToUpdate.setName(goal.getName());
        if(goal.getDescription()!=null)    goalToUpdate.setDescription(goal.getDescription());
        if(goal.getCategory()!=null)    goalToUpdate.setCategory(goal.getCategory());
        if(goal.getState()!=null)    goalToUpdate.setState(goal.getState());
        if(goal.getEndDate()!=null)    goalToUpdate.setEndDate(goal.getEndDate());
        if(goal.getStartDate()!=null)    goalToUpdate.setStartDate(goal.getStartDate());
        if(goal.getPlannedEndDate()!=null)    goalToUpdate.setPlannedEndDate(goal.getPlannedEndDate());
        return goalRepository.save(goalToUpdate);
    }

    public List<GoalModel> getAllByUserId(Long id) {
        UserModel user = userService.getUserById(id);
        List<GoalModel> goals = user.getGoals();
        if(goals.isEmpty()){
            throw new EntityNotFoundException("No goals founded for user "+ user.getUsername()+".");
        }
        return goals;
    }

    public String getStatisticsByUserId(Long id) {
        List<GoalModel> goalsByUserId = getAllByUserId(id);
        if(goalsByUserId.isEmpty()){
            throw new EntityNotFoundException("No goals founded for this user.");
        }
        GoalStatsDto statistics = new GoalStatsDto();

        Map<State, Long> goalsCountByState = goalsByUserId.stream()
                .collect(Collectors.groupingBy(GoalModel::getState, Collectors.counting()));

        statistics.setDone(goalsCountByState.getOrDefault(State.DONE, 0L));
        statistics.setFailed(goalsCountByState.getOrDefault(State.FAILED, 0L));
        statistics.setScheduled(goalsCountByState.getOrDefault(State.SCHEDULED, 0L));
        statistics.setOnHold(goalsCountByState.getOrDefault(State.ON_HOLD, 0L));
        statistics.setInProgress(goalsCountByState.getOrDefault(State.IN_PROGRESS, 0L));

        return String.format("Goals done: %d\nGoals failed: %d\nGoals scheduled: %d\nGoals on hold: %d\nGoals in progress: %d\nAll goals: %d",
                statistics.getDone(),
                statistics.getFailed(),
                statistics.getScheduled(),
                statistics.getOnHold(),
                statistics.getInProgress(),
                goalsByUserId.size());

    }
}
