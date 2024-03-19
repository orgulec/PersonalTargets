package app.personaltargets.utils.mappers;

import app.personaltargets.dto.GoalDto;
import app.personaltargets.dto.UserDto;
import app.personaltargets.model.GoalModel;
import app.personaltargets.model.UserModel;

public class Mapper {

    public static UserDto userToDto(UserModel model){
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setEmail(model.getEmail());
        dto.setPassword(model.getPassword());
        return dto;
    }

    public static GoalDto goalToDto(GoalModel model){
        GoalDto dto = new GoalDto();
        dto.setId(model.getId());
        dto.setCategory(model.getUsername());
        dto.setDescription(model.getFirstName());
        dto.setName(model.getLastName());
        dto.setStartDate(model.getEmail());
        dto.setPlannedEndDate(model.getPassword());
        return dto;
    }

    public static UserDto userToDto(UserModel model){
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setEmail(model.getEmail());
        dto.setPassword(model.getPassword());
        return dto;
    }

}
