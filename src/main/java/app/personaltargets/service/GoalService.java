package app.personaltargets.service;

import app.personaltargets.model.TargetModel;
import app.personaltargets.model.UserModel;
import app.personaltargets.repository.TargetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TargetService {
    private final TargetRepository targetRepository;
    private final UserService userService;

    public List<TargetModel> getByUserId(Long id) {
        return targetRepository.findAllByUser_Id(id);
    }

    public TargetModel addTarget(TargetModel target) {

        return targetRepository.save(target);
    }
}
