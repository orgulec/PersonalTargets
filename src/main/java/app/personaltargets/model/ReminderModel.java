package app.personaltargets.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REMINDER")
public class ReminderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "NAME", length = 128)
    private String name;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "REMIND_TIME", nullable = false)
    private LocalTime remindTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goal_id", referencedColumnName = "id")
    @JsonBackReference("goals")
    private GoalModel goal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habit_id", referencedColumnName = "id")
    @JsonBackReference("habits")
    private HabitModel habit;

}
