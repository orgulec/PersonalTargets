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
        ReminderModel updatedReminder = updatingReminderIfNeeded(reminder, reminderOpt.get());

        return reminderRepository.save(updatedReminder);
    }

    private static ReminderModel updatingReminderIfNeeded(ReminderModel update, ReminderModel reminderToUpdate) {
        if(update.getGoal()!=null)    reminderToUpdate.setGoal(update.getGoal());
        if(update.getHabit()!=null)   reminderToUpdate.setHabit(update.getHabit());
        if(update.getRemindTime()!=null)   reminderToUpdate.setRemindTime(update.getRemindTime());
        if(update.getName()!=null)   reminderToUpdate.setName(update.getName());
        reminderToUpdate.setActive(update.isActive());
        return reminderToUpdate;
    }
}
