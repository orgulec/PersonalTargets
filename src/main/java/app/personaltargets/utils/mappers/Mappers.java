package app.personaltargets.utils.mappers;

import app.personaltargets.dto.GoalDto;
import app.personaltargets.dto.HabitDto;
import app.personaltargets.dto.UserDto;
import app.personaltargets.model.GoalModel;
import app.personaltargets.model.HabitModel;
import app.personaltargets.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class Mappers {

    public UserDto userToDto(UserModel model){
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setEmail(model.getEmail());
        dto.setPassword(model.getPassword());
        return dto;
    }
    public UserModel userToModel(UserDto dto){
        UserModel model = new UserModel();
        model.setUsername(dto.getUsername());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setEmail(dto.getEmail());
        model.setPassword(dto.getPassword());
        return model;
    }

    public GoalDto goalToDto(GoalModel model){
        GoalDto dto = new GoalDto();
        dto.setId(model.getId());
        dto.setUser_id(model.getUser_id());
        dto.setCategory(model.getCategory());
        dto.setDescription(model.getDescription());
        dto.setName(model.getName());
        dto.setCreationDate(model.getCreationDate());
        dto.setStartDate(model.getStartDate());
        dto.setEndDate(model.getEndDate());
        dto.setPlannedEndDate(model.getPlannedEndDate());
        dto.setState(model.getState());
        return dto;
    }
    public GoalModel goalToModel(GoalDto dto){
        GoalModel model = new GoalModel();
        model.setUser_id(dto.getUser_id());
        model.setCategory(dto.getCategory());
        model.setDescription(dto.getDescription());
        model.setName(dto.getName());
        model.setCreationDate(dto.getCreationDate());
        model.setStartDate(dto.getStartDate());
        model.setEndDate(dto.getEndDate());
        model.setPlannedEndDate(dto.getPlannedEndDate());
        model.setState(dto.getState());
        return model;
    }

    public HabitDto habitToDto(HabitModel model){
        HabitDto dto = new HabitDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setCategory(model.getCategory());
        dto.setUser(model.getUser());
        dto.setFrequency(model.getFrequency());
        dto.setTracking(model.isTracking());
        dto.setStartDate(model.getStartDate());
        return dto;
    }
    public HabitModel habitToDModel(HabitDto dto){
        HabitModel model = new HabitModel();
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setCategory(dto.getCategory());
        model.setUser(dto.getUser());
        model.setFrequency(dto.getFrequency());
        model.setTracking(dto.isTracking());
        model.setStartDate(dto.getStartDate());
        return model;
    }

}
