package app.personaltargets.service;

import app.personaltargets.dto.GoalDto;
import app.personaltargets.model.GoalModel;
import app.personaltargets.repository.GoalRepository;
import app.personaltargets.utils.mappers.Mappers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GoalServiceTest {

    @Mock
    private GoalRepository goalRepository;
    @Mock
    private UserService userService;
    @InjectMocks
    private GoalService goalService;
    @Mock
    private  Mappers mapper;

    @Test
    void addGoal_shouldCreateNewGoal() {
        //given
        String name = "goal1";
        Long id = 1L;

        GoalDto newGoal = new GoalDto();
        newGoal.setName(name);
        newGoal.setUser_id(id);
        GoalModel goalModel = new GoalModel();
        goalModel.setName(name);
        goalModel.setUser_id(id);

        //when
        Mockito.when(mapper.goalToModel(newGoal)).thenReturn(goalModel);
        Mockito.when(goalService.addGoal(newGoal)).thenReturn(goalModel);
        Mockito.when(goalRepository.save(goalModel)).thenReturn(goalModel);

        //then
        goalService.addGoal(newGoal);
        verify(goalRepository).save(ArgumentMatchers.any(GoalModel.class));
    }

    @Test
    void getById() {



    }
}