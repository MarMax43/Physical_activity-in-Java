package org.example;

import jakarta.persistence.*;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
@Entity
@Table(name = "sportsman")
public class Sportsman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "sportsman_trainings", // имя связующей таблицы
            joinColumns = @JoinColumn(name = "id_name"), // колонка, указывающая на sportsman.id
            inverseJoinColumns = @JoinColumn(name = "id_type") // колонка, указывающая на training.id
    )
    private Set<Training> trainings;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    // --- Сеттеры ---
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }
}
