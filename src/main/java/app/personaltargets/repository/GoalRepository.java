package app.personaltargets.repository;

import app.personaltargets.model.TargetModel;
import app.personaltargets.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TargetRepository extends JpaRepository<TargetModel, Long> {

    List<TargetModel> findAllByUser_Id(Long id);

}
