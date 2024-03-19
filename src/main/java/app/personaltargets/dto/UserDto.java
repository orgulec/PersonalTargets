package app.personaltargets.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "FIRSTNAME", length = 128, nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", length = 128, nullable = false)
    private String lastName;

    @Column(name = "USERNAME", length = 128, nullable = false)
    private String username;

    @Column(name = "PASSWORD", length = 128, nullable = false)
    private String password;

    @Column(name = "EMAIL", length = 128, nullable = false)
    private String email;

    @OneToMany
    private List<GoalModel> goals = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(firstName, userModel.firstName) && Objects.equals(lastName, userModel.lastName) && Objects.equals(username, userModel.username) && Objects.equals(password, userModel.password) && Objects.equals(email, userModel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, email);
    }
}

