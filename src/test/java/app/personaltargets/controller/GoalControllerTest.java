package app.personaltargets.controller;

import app.personaltargets.dto.GoalDto;
import app.personaltargets.model.GoalModel;
import app.personaltargets.service.GoalService;
import app.personaltargets.utils.mappers.Mappers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GoalControllerTest {

    @Mock
    public GoalService goalService;
    @InjectMocks
    public GoalController goalController;
    public final Mappers mapper = new Mappers();


    @Test
    void addNewGoal_shouldReturnNewGoal() {
        //given
        GoalDto requestDto = new GoalDto();
        requestDto.setName("goal");
        requestDto.setUser_id(1L);

        GoalModel newGoal = mapper.goalToModel(requestDto);

        Mockito.when(goalService.addGoal(requestDto)).thenReturn(newGoal);
        //when
        ResponseEntity<GoalModel> response = goalController.addNewGoal(requestDto);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(newGoal, response.getBody());

    }


    @Test
    void changeGoal() {
        //given
        Long id = 1L;
        GoalModel goalToUpdate = new GoalModel();
        goalToUpdate.setName("goal to update");
        goalToUpdate.setDescription("first goal");

        GoalDto requestDto = new GoalDto();
        requestDto.setName("updated goal");
        requestDto.setDescription("updated first goal");

        GoalModel updatedGoal = new GoalModel();
        updatedGoal.setName(requestDto.getName());
        updatedGoal.setDescription(requestDto.getDescription());

        Mockito.when(goalService.updateGoalById(id, requestDto)).thenReturn(updatedGoal);

        //when
        ResponseEntity<GoalModel> response = goalController.changeGoal(id, requestDto);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedGoal, response.getBody());


    }
}