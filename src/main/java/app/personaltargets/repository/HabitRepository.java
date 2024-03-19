package app.personaltargets.repository;

import app.personaltargets.model.HabitModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<HabitModel, Long> {

    List<HabitModel> findAllByUser_Id(Long id);
}
