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
        ReminderModel reminderToUpdate = updatingReminderIfNeeded(reminder, reminderOpt);

        return reminderRepository.save(reminderToUpdate);
    }

    private static ReminderModel updatingReminderIfNeeded(ReminderModel reminder, Optional<ReminderModel> reminderOpt) {
        ReminderModel reminderToUpdate = reminderOpt.get();
        if(reminder.getGoal()!=null)    reminderToUpdate.setGoal(reminder.getGoal());
        if(reminder.getHabit()!=null)   reminderToUpdate.setHabit(reminder.getHabit());
        if(reminder.getRemindTime()!=null)   reminderToUpdate.setRemindTime(reminder.getRemindTime());
        if(reminder.getName()!=null)   reminderToUpdate.setName(reminder.getName());
        reminderToUpdate.setActive(reminder.isActive());
        return reminderToUpdate;
    }
}
