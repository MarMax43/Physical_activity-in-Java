package org.example;

import java.util.Scanner;

public class CardioTraining extends PhysicalActivity {
    private String name;        // Название тренировки
    private int intensity;      // Интенсивность (1–10)
    private int duration;       // Длительность в минутах
    private int heartRate;      // Частота сердечных сокращений

    // Конструктор
    public CardioTraining(String name, int intensity, int duration, String goal, double calories, String activityLevel, int heartRate) {
        super(goal, calories, activityLevel);
        this.name = name;
        this.intensity = intensity;
        this.duration = duration;
        this.heartRate = heartRate;
    }

    // Геттеры
    public String getName() { return name; }
    public int getIntensity() { return intensity; }
    public int getDuration() { return duration; }
    public int getHeartRate() { return heartRate; }

    // Сеттеры
    public void setName(String name) { this.name = name; }
    public void setIntensity(int intensity) { this.intensity = intensity; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }

    // Определение скорости и дистанции
    public void determineSpeedAndDistance() {
        double speed, distance;
        if (intensity <= 3) {
            speed = 6.0;
            distance = duration * 0.1;
        } else if (intensity <= 6) {
            speed = 9.0;
            distance = duration * 0.15;
        } else {
            speed = 12.0;
            distance = duration * 0.2;
        }
        System.out.println("Рекомендуемая скорость: " + speed + " км/ч");
        System.out.println("Ожидаемая дистанция: " + distance + " км");
    }
    @Override
    public void calculateSetsAndReps() {
        System.out.println("Кардио не требует подходов и повторений, просто поддерживайте равномерную нагрузку.");
    }

    @Override
    public void determineRestTime() {
        System.out.println("Рекомендуемое время отдыха: 1-2 дня между тренировками.");
    }


    // Расчет интервалов
    public void calculateIntervals() {
        int work, rest;
        if (intensity <= 3) {
            work = 5; rest = 2;
        } else if (intensity <= 6) {
            work = 4; rest = 1;
        } else {
            work = 3; rest = 1;
        }
        System.out.println("Интервальная тренировка: " + work + " минут нагрузки / " + rest + " минут отдыха");
    }

    // Настройка дыхания
    public void adjustBreathing() {
        if (intensity <= 3) {
            System.out.println("Рекомендуется дыхание 2-2 (вдох на 2 шага, выдох на 2 шага).");
        } else if (intensity <= 6) {
            System.out.println("Рекомендуется дыхание 3-2 (вдох на 3 шага, выдох на 2 шага).");
        } else {
            System.out.println("Рекомендуется дыхание 2-1 (вдох на 2 шага, выдох на 1 шаг).");
        }
    }

    // Подбор темпа и ритма
    public void selectPaceAndRhythm() {
        if (intensity <= 3) {
            System.out.println("Темп: Медленный, ритмичные шаги.");
        } else if (intensity <= 6) {
            System.out.println("Темп: Средний, удобный ритм.");
        } else {
            System.out.println("Темп: Высокий, максимальная эффективность.");
        }
    }

    // Переопределение метода выбора активности
    @Override
    public void selectActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите кардионагрузку:");
        System.out.println("1. Бег (развитие выносливости)");
        System.out.println("2. Велотренажер (сжигание жира)");
        System.out.println("3. Прыжки на скакалке (развитие координации)");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> System.out.println("Вы выбрали бег: отличная тренировка выносливости!");
            case 2 -> System.out.println("Вы выбрали велотренажер: эффективное жиросжигание!");
            case 3 -> System.out.println("Вы выбрали прыжки на скакалке: развитие координации!");
            default -> System.out.println("Неверный выбор.");
        }
    }

    // Переопределённый метод отображения информации
    @Override
    public void showInfo() {
        System.out.println("\n*** Кардиотренировка ***");
        System.out.println("Название: " + name);
        System.out.println("Интенсивность: " + intensity + "/10");
        System.out.println("Длительность: " + duration + " минут");
        System.out.println("Частота сердечных сокращений: " + heartRate + " уд/мин");
        System.out.println("Цель: " + getGoal());
        System.out.println("Калории: " + getCalories());
        System.out.println("Уровень активности: " + getActivityLevel());
    }

    public static void main(String[] args) {
        CardioTraining cardio = new CardioTraining("Бег", 5, 45, "Похудение", 400, "Средний", 130);
        cardio.showInfo();
        cardio.determineSpeedAndDistance();
        cardio.calculateIntervals();
        cardio.adjustBreathing();
        cardio.selectPaceAndRhythm();
        cardio.selectActivity();
    }
}
