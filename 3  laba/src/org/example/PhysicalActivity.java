package org.example;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class PhysicalActivity {
    private String goal;
    private Double calories;
    private String activityLevel;

    public PhysicalActivity(String goalType, double kcal, String actLevel) {
        this.goal = goalType;
        this.calories = kcal;
        this.activityLevel = actLevel;
    }

    public PhysicalActivity() {} // для JPA

    // Геттеры и сеттеры
    public String getGoal() {
        return goal;
    }

    public void setGoal(String goalType) {
        this.goal = goalType;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double kcal) {
        this.calories = kcal;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String actLevel) {
        this.activityLevel = actLevel;
    }

    public void startTraining() {
        System.out.println("\n\u001B[32mТренировка начата! Разогреваемся...\u001B[0m");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("* ");
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Готово!");
    }

    public void stopTraining() {
        System.out.println("\n\u001B[31mТренировка завершена! Хорошая работа!\u001B[0m");
    }

    public void adjustNutrition() {
        System.out.print("Коррекция питания: ");
        if ("Набор массы".equals(goal)) {
            System.out.println("Добавьте больше белка и углеводов!");
        } else {
            System.out.println("Сократите калории и увеличьте белок!");
        }
    }

    public void selectActivity() {
        System.out.println("Выбор активности: Для укрепления мышц используйте упражнения с отягощениями.");
    }

    public void analyzeProgress() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Введите количество недель тренировки: ");
        int weeks = scanner.nextInt();

        System.out.print("Введите изменение веса (в кг): ");
        double weightChange = scanner.nextDouble();

        System.out.print("Прогресс за " + weeks + " недель: ");
        if (weightChange > 0) {
            System.out.println("Вы набрали " + weightChange + " кг.");
        } else if (weightChange < 0) {
            System.out.println("Вы сбросили " + Math.abs(weightChange) + " кг.");
        } else {
            System.out.println("Вес остался неизменным.");
        }
    }

    // Абстрактные методы — подклассы ОБЯЗАНЫ их реализовать
    public abstract void calculateSetsAndReps();


    public abstract void determineRestTime();

    public void showInfo() {
        System.out.println("\n*** Информация о тренировке ***");
        System.out.println("Цель: " + goal);
        System.out.println("Калории: " + calories);
        System.out.println("Уровень активности: " + activityLevel);
    }
}
