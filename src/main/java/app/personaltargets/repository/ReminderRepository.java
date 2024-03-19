package app.personaltargets.repository;

import app.personaltargets.model.ReminderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<ReminderModel, Long> {

    List<ReminderModel> findAllByUserId(Long id);


}
