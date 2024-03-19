package app.personaltargets.service;

import app.personaltargets.dto.GoalDto;
import app.personaltargets.model.GoalModel;
import app.personaltargets.repository.GoalRepository;
import app.personaltargets.utils.mappers.Mappers;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
