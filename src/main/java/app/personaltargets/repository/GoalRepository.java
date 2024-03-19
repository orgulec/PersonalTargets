package app.personaltargets.repository;

import app.personaltargets.model.GoalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<GoalModel, Long> {



}
