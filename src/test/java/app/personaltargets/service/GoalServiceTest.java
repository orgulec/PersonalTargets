package app.personaltargets.service;

import app.personaltargets.repository.GoalRepository;
import app.personaltargets.utils.mappers.Mappers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GoalServiceTest {

    @Mock
    private GoalRepository goalRepository;
    @Mock
    private UserService userService;
    private Mappers mapper;
    @Test
    void addGoal_shouldCreateNewGoal() {
        //given


        //when


        //then



    }

    @Test
    void getById() {
    }
}