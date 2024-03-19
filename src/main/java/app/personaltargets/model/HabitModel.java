package app.personaltargets.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HABITS")
public class HabitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserModel user;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "FREQUENCY")
    private HabitFrequency frequency;

    @Column(name = "TRACKING")
    private boolean tracking;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;


    @PrePersist
    void onCreate() {
        this.startDate = LocalDateTime.now();
    }
}
