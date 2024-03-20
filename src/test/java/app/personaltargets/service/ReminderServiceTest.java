package app.personaltargets.service;

import app.personaltargets.model.GoalModel;
import app.personaltargets.model.HabitModel;
import app.personaltargets.model.ReminderModel;
import app.personaltargets.model.UserModel;
import app.personaltargets.repository.GoalRepository;
import app.personaltargets.repository.ReminderRepository;
import app.personaltargets.repository.UserRepository;
import app.personaltargets.utils.mappers.Mappers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ReminderServiceTest {
    @Mock
    private ReminderRepository reminderRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;
    @InjectMocks
    private ReminderService reminderService;
    @Mock
    private Mappers mapper;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createNewReminder_shouldCreateNewReminderWithGoal() {
        //given
        Long id = 1L;
        ReminderModel reminder = new ReminderModel();
        UserModel user = new UserModel();
        GoalModel goal = new GoalModel();
        goal.setUser_id(id);
        reminder.setGoal(goal);
        reminder.setUserId(id);

        //when
        Mockito.when(userService.getUserById(id)).thenReturn(user);
        Mockito.when(reminderRepository.save(reminder)).thenReturn(reminder);

        //then
        reminderService.createNewReminder(reminder);
        verify(reminderRepository).save(ArgumentMatchers.any(ReminderModel.class));

    }

    @Test
    void createNewReminder_shouldCreateNewReminderWithHabit() {
        //given
        Long id = 1L;
        ReminderModel reminder = new ReminderModel();
        HabitModel habit = new HabitModel();
        UserModel user = new UserModel();
        habit.setUser(user);
        reminder.setHabit(habit);
        reminder.setUserId(id);

        //when
        Mockito.when(userService.getUserById(id)).thenReturn(user);
        Mockito.when(reminderRepository.save(reminder)).thenReturn(reminder);

        //then
        reminderService.createNewReminder(reminder);
        verify(reminderRepository).save(ArgumentMatchers.any(ReminderModel.class));

    }

    @Test
    void updateReminder() {
    }
}