package app.personaltargets.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GOALS")
public class GoalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "USER_ID", nullable = false)
    private Long user_id;

    @Column(name = "NAME", length = 128, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "PLANNED_END_DATE")
    private LocalDateTime plannedEndDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "STATE")
    private State state;

    @PrePersist
    void onCreate() {
        this.creationDate = LocalDateTime.now();
    }

}
