package app.personaltargets.service;

import app.personaltargets.dto.GoalDto;
import app.personaltargets.model.GoalModel;
import app.personaltargets.repository.GoalRepository;
import app.personaltargets.utils.mappers.Mappers;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.action.internal.EntityActionVetoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(mapper.goalToModel(newGoal)).thenReturn(goalModel);
        when(goalService.addGoal(newGoal)).thenReturn(goalModel);
        when(goalRepository.save(goalModel)).thenReturn(goalModel);

        //then
        goalService.addGoal(newGoal);
        verify(goalRepository).save(ArgumentMatchers.any(GoalModel.class));
    }

    @Test
    void getById_shouldCorrectlyGetGoal() {
        //given
        String name = "goal1";
        Long id = 1L;

        GoalModel goalModel = new GoalModel();
        goalModel.setName(name);
        goalModel.setUser_id(id);

        //when
        when(goalRepository.findById(id)).thenReturn(Optional.of(goalModel));

        //then
        GoalModel resultGoal = goalService.getById(id);
        assertEquals(goalModel, resultGoal);

    }
    @Test
    void getById_shouldThrowEntityNotFoundException() {
        //given
        String name = "goal1";
        Long id = 1L;

        GoalModel goalModel = new GoalModel();
        goalModel.setName(name);
        goalModel.setUser_id(id);

        //when
        when(goalRepository.findById(id)).thenReturn(Optional.empty());

        //then
        assertThrows(EntityNotFoundException.class, () -> goalService.getById(id));

    }
}