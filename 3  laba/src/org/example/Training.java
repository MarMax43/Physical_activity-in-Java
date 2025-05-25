package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Training")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "training_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter

public class Training extends PhysicalActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_train")
    private String typeTrain;

    @Column(name = "training_time")
    private Long trainingTime;

    @ManyToMany(mappedBy = "trainings", fetch = FetchType.LAZY)
    private Set<Sportsman> sportsmen = new HashSet<>();

    public Training() {
        super(null, 0, null);
    }

    public Training(String goal, double calories, String activityLevel, String typeTrain, Long trainingTime) {
        super(goal, calories, activityLevel);
        this.typeTrain = typeTrain;
        this.trainingTime = trainingTime;
    }

    @Override
    public void calculateSetsAndReps() {
        System.out.println("Подходы и повторения не заданы.");
    }

    @Override
    public void determineRestTime() {
        System.out.println("Время отдыха не задано.");
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", typeTrain=" + typeTrain +
                ", goal=" + getGoal() +
                ", calories=" + getCalories() +
                ", activityLevel=" + getActivityLevel()
                ;
    }
}
