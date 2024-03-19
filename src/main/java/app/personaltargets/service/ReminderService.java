package app.personaltargets.service;

import app.personaltargets.model.ReminderModel;
import app.personaltargets.model.UserModel;
import app.personaltargets.repository.ReminderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReminderService {
    private final ReminderRepository reminderRepository;
    private final UserService userService;

    public List<ReminderModel> getAllByUserId(Long id) {
        UserModel user = userService.getUserById(id);
        List<ReminderModel> remindersList = reminderRepository.findAllByUserId(user.getId());
        if(remindersList.isEmpty()){
            throw new EntityNotFoundException("No reminders founded.");
        }
        return remindersList;
    }

    public ReminderModel createNewReminder(ReminderModel reminder) {
        UserModel user = userService.getUserById(reminder.getUserId());
        if(reminder.getGoal() == null && reminder.getHabit()==null){
            throw new EntityNotFoundException("There is no goal or habit to remind.");
        }
        return reminderRepository.save(reminder);
    }

    public ReminderModel updateReminder(Long id, ReminderModel reminder) {
        Optional<ReminderModel> reminderOpt = reminderRepository.findById(id);
        if(reminderOpt.isEmpty()){
            throw new EntityNotFoundException("No reminder founded.");
        }
        ReminderModel reminderToUpdate = reminderOpt.get();
        reminderToUpdate.setGoal(reminder.getGoal());
        reminderToUpdate.setHabit(reminder.getHabit());
        reminderToUpdate.setRemindTime(reminder.getRemindTime());
        reminderToUpdate.setName(reminder.getName());
        reminderToUpdate.setActive(reminder.isActive());
        return reminderRepository.save(reminderToUpdate);
    }
}
