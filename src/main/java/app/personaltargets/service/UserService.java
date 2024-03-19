package app.personaltargets.service;

import app.personaltargets.dto.UserDto;
import app.personaltargets.model.UserModel;
import app.personaltargets.repository.UserRepository;
import app.personaltargets.utils.mappers.Mappers;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Mappers mapper;

    public UserModel createUser(UserDto user) {
        UserModel newUser = mapper.userToModel(user);

        return userRepository.save(newUser);
    }

    public UserModel getUserById(Long id) {
        Optional<UserModel> userOpt = userRepository.findById(id);
        if(userOpt.isEmpty()){
            throw new EntityNotFoundException("User not found");
        }
        return userOpt.get();
    }
}
