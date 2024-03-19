package app.personaltargets.repository;

import app.personaltargets.model.GoalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<GoalModel, Long> {

}
