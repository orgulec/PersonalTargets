package app.personaltargets.service;

import app.personaltargets.dto.HabitDto;
import app.personaltargets.model.HabitModel;
import app.personaltargets.repository.HabitRepository;
import app.personaltargets.utils.mappers.Mappers;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final UserService userService;
    private final Mappers mapper;

    public List<HabitModel> getAllByUserId(Long id) {
        List<HabitModel> habitsList = habitRepository.findAllByUser_Id(id);
        if(habitsList.isEmpty()){
            throw new EntityNotFoundException("No habits founded.");
        }
        return habitsList;
    }

    public HabitModel createNewHabit(HabitDto habit) {
        HabitModel habitModel = mapper.habitToDModel(habit);
        return habitRepository.save(habitModel);

    }
}
