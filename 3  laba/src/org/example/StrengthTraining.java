package org.example;

import java.util.Scanner;

public class StrengthTraining extends PhysicalActivity {
    private String name;       // Название тренировки
    private int intensity;     // Интенсивность (от 1 до 10)
    private int duration;      // Длительность тренировки в минутах

    // Конструктор
    public StrengthTraining(String name, int intensity, int duration, String goal, double calories, String activityLevel) {
        super(goal, calories, activityLevel);  // Вызов конструктора родительского класса
        this.name = name;
        this.intensity = intensity;
        this.duration = duration;
    }

    // Сеттеры
    public void setName(String newName) { name = newName; }
    public void setIntensity(int newIntensity) { intensity = newIntensity; }
    public void setDuration(int newDuration) { duration = newDuration; }

    // Геттеры
    public String getName() { return name; }
    public int getIntensity() { return intensity; }
    public int getDuration() { return duration; }

    // Переопределённый метод: отображение информации
    @Override
    public void showInfo() {
        System.out.println("\n*** Силовая тренировка ***");
        super.showInfo();  // Базовая информация из родительского класса
        System.out.println("Название: " + name);
        System.out.println("Интенсивность: " + intensity + "/10");
        System.out.println("Длительность: " + duration + " минут");
    }

    // Переопределённый метод: подбор подходов и повторений
    @Override
    public void calculateSetsAndReps() {
        int sets, reps;
        if (intensity <= 3) {
            sets = 3; reps = 12;
        } else if (intensity <= 6) {
            sets = 4; reps = 8;
        } else {
            sets = 5; reps = 5;
        }
        System.out.println("Рекомендуется " + sets + " подходов по " + reps + " повторений.");
    }

    // Переопределённый метод: определение времени отдыха
    @Override
    public void determineRestTime() {
        int restTime;
        if (intensity <= 3) {
            restTime = 60;
        } else if (intensity <= 6) {
            restTime = 90;
        } else {
            restTime = 120;
        }
        System.out.println("Рекомендуемое время отдыха: " + restTime + " секунд.");
    }

    // Специальный метод: оценка восстановления
    public void evaluateRecovery() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько часов вы спите в сутки? ");
        int sleepHours = scanner.nextInt();

        if (sleepHours < 6) {
            System.out.println("Восстановление недостаточное. Рекомендуется увеличить сон.");
        } else if (sleepHours <= 8) {
            System.out.println("Восстановление в норме.");
        } else {
            System.out.println("Отличное восстановление!");
        }
    }

    // Специальный метод: выбор упражнений
    public void selectOptimalExercises() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите целевую группу мышц:");
        System.out.println("1. Грудь (жим штанги, разведения гантелей)");
        System.out.println("2. Спина (подтягивания, тяга штанги)");
        System.out.println("3. Ноги (приседания, становая тяга)");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Вы выбрали грудные мышцы: жим штанги, разведения гантелей.");
        } else if (choice == 2) {
            System.out.println("Вы выбрали спину: подтягивания, тяга штанги.");
        } else if (choice == 3) {
            System.out.println("Вы выбрали ноги: приседания, становая тяга.");
        } else {
            System.out.println("Неверный выбор.");
        }
    }

    // Переопределённый метод: выбор активности
    @Override
    public void selectActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип силовой тренировки:");
        System.out.println("1. Тренировка на массу");
        System.out.println("2. Тренировка на силу");
        System.out.println("3. Функциональная тренировка");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Вы выбрали тренировку на массу.");
                break;
            case 2:
                System.out.println("Вы выбрали тренировку на силу.");
                break;
            case 3:
                System.out.println("Вы выбрали функциональную тренировку.");
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }
    }

    public static void main(String[] args) {
        // Создание экземпляра силовой тренировки
        StrengthTraining strengthTraining = new StrengthTraining("Тренировка на массу", 7, 60, "Набор массы", 500, "Средний");

        // Вызов метода showInfo() у объекта strengthTraining
        strengthTraining.showInfo();

        // Пример вызова других методов
        strengthTraining.startTraining();     // Унаследованный метод
        strengthTraining.stopTraining();     // Унаследованный метод
        strengthTraining.calculateSetsAndReps();
        strengthTraining.determineRestTime();
        strengthTraining.evaluateRecovery();
        strengthTraining.selectOptimalExercises();
        strengthTraining.selectActivity();
    }
}
