package app.personaltargets.service;

import app.personaltargets.dto.GoalDto;
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
        goalToUpdate.setName(goal.getName());
        goalToUpdate.setDescription(goal.getDescription());
        goalToUpdate.setCategory(goal.getCategory());
        goalToUpdate.setState(goal.getState());
        goalToUpdate.setEndDate(goal.getEndDate());
        goalToUpdate.setStartDate(goal.getStartDate());
        goalToUpdate.setPlannedEndDate(goal.getPlannedEndDate());
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

        List<GoalModel> goalsDone = goalsByUserId.stream()
                .filter(a -> a.getState().equals(State.DONE)
                ).toList();
        List<GoalModel> goalsFailed = goalsByUserId.stream()
                .filter(a -> a.getState().equals(State.FAILED)
                ).toList();
        StringBuilder summary = new StringBuilder("Goals done: " + (long) goalsDone.size() + "\n Goals failed: "+ (long) goalsFailed.size() + "\n All goals: "+ goalsByUserId.size());
        return summary.toString();
    }
}
