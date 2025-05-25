package org.example;

import java.util.List;
import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;
public class MainMenu {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    StrengthTraining strengthTraining = new StrengthTraining("Тренировка на массу", 7, 60, "Набор массы", 500, "Средний");

    public void show() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        StrengthTraining strength = new StrengthTraining(
                "Силовая", 7, 60, "Набор массы", 2500, "Средний"
        );

        CardioTraining cardio = new CardioTraining(
                "Кардио", 5, 45, "Похудение", 400, "Средний", 130
        );

        while (true) {
            System.out.println("\nВыберите тип тренировки:");
            System.out.println("1. Силовая тренировка");
            System.out.println("2. Кардиотренировка");
            System.out.println("4. Выход");

            System.out.print("Ваш выбор: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> trainingMenu2(strength);
                case 2 -> trainingMenu(cardio);
                case 4 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Ошибка ввода, попробуйте снова.");
            }

        }
    }

    private void trainingMenu2(StrengthTraining session) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nМеню силовой тренировки:");
            System.out.println("1. Общие свойства тренировки");
            System.out.println("2. Специальные свойства тренировки");
            System.out.println("3. Методы (начало/конец тренировки)");
            System.out.println("4. Переопределяющие методы");
            System.out.println("5. Специальные методы");
            System.out.println("6. Вернуться назад");
            System.out.print("Ваш выбор: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    boolean back = false;
                    while (!back) {
                        System.out.println("\n*** Общие свойства тренировки ***");

                        System.out.println("1. Показать таблицу Спортсмены");
                        System.out.println("2. Показать таблицу Тренировки");
                        System.out.println("3. Показать сразу обе таблицы");
                        System.out.println("4. Добавить нового спортсмена");
                        System.out.println("5. Добавить новую тренировку");
                        System.out.println("6. Удалить запись таблице Спортсмены");
                        System.out.println("7. Удалить запись таблице Тренировки");
                        System.out.println("8. Связать спортсмена к типу тренировки");
                        System.out.println("9. Просмотр тренировок у спортсменов");
                        System.out.println("10. Разорвать связь");
                        System.out.println("11. Назад");
                        System.out.print("Выберите действие: ");

                        String subChoice = scanner.nextLine();

                        switch (subChoice) {
                            case "1" -> showSportsmanOnlyTable();
                            case "2" -> showTrainings();
                            case "3" -> alltable();
                            case "4" -> addsport();
                            case "5" -> addtrain();
                            case "6" -> {
                                System.out.print("Введите ID спортсмена для удаления: ");
                                Long id = Long.parseLong(scanner.nextLine());
                                deletesport(id);
                            }
                            case "7" -> {
                                System.out.print("Введите ID тренировки для удаления: ");
                                Long id = Long.parseLong(scanner.nextLine());
                                deletetrain(id);
                            }
                            case "8" -> {
                                try {
                                    System.out.print("Введите ID спортсмена: ");
                                    Long sportsmanId = Long.parseLong(scanner.nextLine());

                                    System.out.print("Введите ID тренировки: ");
                                    Long trainingId = Long.parseLong(scanner.nextLine());

                                    linkSportsmanToTraining(sportsmanId, trainingId);
                                } catch (NumberFormatException e) {
                                    System.out.println("Ошибка: введён неправильный формат ID. Введите числа.");
                                }
                            }
                            case "9" -> {
                                System.out.print("Введите ID спортсмена: ");
                                Long id = Long.parseLong(scanner.nextLine());
                                showTrainingsForSportsman(id);
                            }
                            case "10" -> {
                                System.out.print("Введите ID спортсмена: ");
                                Long sId = Long.parseLong(scanner.nextLine());
                                System.out.print("Введите ID тренировки: ");
                                Long tId = Long.parseLong(scanner.nextLine());
                                unlinkSportsmanFromTraining(sId, tId);
                            }

                            case "11" -> back = true;
                            default -> System.out.println("Неверный ввод. Попробуйте снова.");
                        }
                    }
                }


                case 2 -> {
                    System.out.println("\n*** Специальные свойства ***");
                    System.out.println("Название: " + session.getName());
                    System.out.println("Интенсивность: " + session.getIntensity());
                    System.out.println("Длительность: " + session.getDuration() + " мин");
                }
                case 3 -> {
                    System.out.println("\n*** Методы: начать / закончить тренировку ***");
                    System.out.println("1. Начать тренировку");
                    System.out.println("2. Завершить тренировку");
                    System.out.println("3. Назад");
                    System.out.print("Ваш выбор: ");
                    int sub = Integer.parseInt(scanner.nextLine());

                    // Предполагается, что объект strengthTraining объявлен вне этого блока и доступен здесь
                    if (sub == 1) {
                        strengthTraining.startTraining();  // вызов через объект
                    }
                    else if (sub == 2) {
                        strengthTraining.stopTraining();   // вызов через объект
                    }
                    else if (sub == 3) {
                        continue;  // или break, в зависимости от контекста цикла
                    }
                    else {
                        System.out.println("Неверный выбор.");
                    }
                }
                case 4 -> {
                    System.out.println("\n*** Переопределяющие методы (Силовая тренировка) ***");

                    // Запрос у пользователя параметров тренировки
                    System.out.print("Введите название тренировки: ");
                    String name = scanner.nextLine();

                    System.out.print("Введите интенсивность (от 1 до 10): ");
                    int intensity = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введите длительность тренировки (в минутах): ");
                    int duration = Integer.parseInt(scanner.nextLine());

                    // Остальные параметры можно задать по умолчанию
                    String goal = "Общая физическая форма";
                    double calories = 350;
                    String level = "Средний";

                    // Создание объекта тренировки
                    session = new StrengthTraining(name, intensity, duration, goal, calories, level);

                    // Меню взаимодействия
                    while (true) {
                        System.out.println("\nВыберите действие:");
                        System.out.println("1. Рассчитать подходы и повторения");
                        System.out.println("2. Определить уровень отдыха");
                        System.out.println("3. Оценить восстановление");
                        System.out.println("4. Назад");
                        System.out.print("Ваш выбор: ");
                        int sub = Integer.parseInt(scanner.nextLine());

                        if (sub == 1) session.calculateSetsAndReps();
                        else if (sub == 2) session.determineRestTime();
                        else if (sub == 3) session.evaluateRecovery();
                        else if (sub == 4) break;
                        else System.out.println("Неверный выбор.");
                    }
                }

                case 5 -> {
                    System.out.println("\n*** Специальные методы ***");
                    System.out.println("1. Выбрать упражнения для мышц");
                    System.out.println("2. Оценить восстановление");
                    System.out.println("3. Назад");
                    System.out.print("Ваш выбор: ");
                    int sub = Integer.parseInt(scanner.nextLine());

                    if (sub == 1) session.selectOptimalExercises();
                    else if (sub == 2) session.evaluateRecovery();
                    else if (sub == 3) continue;
                    else System.out.println("Неверный выбор.");
                }
                case 6 -> {
                    System.out.println("Возврат в главное меню...");
                    return;
                }
                default -> System.out.println("Ошибка ввода, попробуйте снова.");
            }
        }
    }

    private void trainingMenu(CardioTraining session) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nМеню кардиотренировки:");
            System.out.println("1. Общие свойства тренировки");
            System.out.println("2. Специальные свойства тренировки");
            System.out.println("3. Методы (начало/конец тренировки)");
            System.out.println("4. Переопределяющие методы");
            System.out.println("5. Специальные методы");
            System.out.println("6. Вернуться назад");
            System.out.print("Ваш выбор: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> session.showInfo();
                case 2 -> {
                    System.out.println("\n*** Специальные свойства ***");
                    System.out.println("Название: " + session.getName());
                    System.out.println("Интенсивность: " + session.getIntensity());
                    System.out.println("Длительность: " + session.getDuration() + " мин");
                    System.out.println("Пульс: " + session.getHeartRate() + " уд/мин");
                }
                case 3 -> {
                    System.out.println("\n*** Методы: начать / закончить тренировку ***");
                    System.out.println("1. Начать тренировку");
                    System.out.println("2. Завершить тренировку");
                    System.out.println("3. Назад");
                    System.out.print("Ваш выбор: ");
                    int sub = Integer.parseInt(scanner.nextLine());

                    if (sub == 1) System.out.println("Кардиотренировка началась...");
                    else if (sub == 2) System.out.println("Кардиотренировка завершена.");
                    else if (sub == 3) continue;
                    else System.out.println("Неверный выбор.");
                }
                case 4 -> {
                    System.out.println("\n*** Переопределяющие методы ***");
                    System.out.println("1. Выбор активности");
                    System.out.println("2. Назад");
                    System.out.print("Ваш выбор: ");
                    int sub = Integer.parseInt(scanner.nextLine());

                    if (sub == 1) session.selectActivity();
                    else if (sub == 2) continue;
                    else System.out.println("Неверный выбор.");
                }
                case 5 -> {
                    boolean back = false;
                    while (!back) {
                        System.out.println("\n*** Специальные методы ***");
                        System.out.println("1. Определить скорость и дистанцию");
                        System.out.println("2. Рассчитать интервалы");
                        System.out.println("3. Настроить дыхание");
                        System.out.println("4. Подобрать темп и ритм");
                        System.out.println("5. Назад");
                        System.out.print("Ваш выбор: ");
                        int sub = Integer.parseInt(scanner.nextLine());

                        switch (sub) {
                            case 1 -> session.determineSpeedAndDistance();
                            case 2 -> session.calculateIntervals();
                            case 3 -> session.adjustBreathing();
                            case 4 -> session.selectPaceAndRhythm();
                            case 5 -> back = true;
                            default -> System.out.println("Неверный выбор.");
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Возврат в главное меню...");
                    return;
                }
                default -> System.out.println("Ошибка ввода, попробуйте снова.");
            }
        }
    }
    public void unlinkSportsmanFromTraining(Long sportsmanId, Long trainingId) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Sportsman sportsman = em.find(Sportsman.class, sportsmanId);
            Training training = em.find(Training.class, trainingId);

            if (sportsman == null || training == null) {
                System.out.println("Спортсмен или тренировка не найдены.");
                em.getTransaction().rollback();
                return;
            }

            // Удаляем связь
            if (sportsman.getTrainings() != null) {
                sportsman.getTrainings().remove(training);
            }

            if (training.getSportsmen() != null) {
                training.getSportsmen().remove(sportsman);
            }

            em.merge(sportsman);
            em.merge(training);
            em.getTransaction().commit();

            System.out.println("Связь между спортсменом и тренировкой удалена.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ошибка при удалении связи: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deletesport(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Sportsman sportsman = em.find(Sportsman.class, id);
            if (sportsman != null) {
                em.remove(sportsman);
                System.out.println("Спортсмен с id " + id + " удалён.");
            } else {
                System.out.println("Спортсмен с id " + id + " не найден.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ошибка при удалении спортсмена: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void linkSportsmanToTraining(Long sportsmanId, Long trainingId) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Sportsman sportsman = em.find(Sportsman.class, sportsmanId);
            Training training = em.find(Training.class, trainingId);

            if (sportsman == null) {
                System.out.println("Спортсмен с ID " + sportsmanId + " не найден.");
                em.getTransaction().rollback();
                return;
            }

            if (training == null) {
                System.out.println("Тренировка с ID " + trainingId + " не найдена.");
                em.getTransaction().rollback();
                return;
            }

            // Инициализируем коллекцию, если null
            if (sportsman.getTrainings() == null) {
                sportsman.setTrainings(new HashSet<>());
            }

            // Добавляем тренировку в набор спортсмена
            sportsman.getTrainings().add(training);

            // Аналогично для двунаправленной связи (если хочешь)
            if (training.getSportsmen() == null) {
                training.setSportsmen(new HashSet<>());
            }
            training.getSportsmen().add(sportsman);

            // Сохраняем изменения
            em.merge(sportsman);
            em.merge(training);

            em.getTransaction().commit();
            System.out.println("Спортсмен и тренировка успешно связаны.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ошибка при связывании: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void showTrainingsForSportsman(Long sportsmanId) {
        EntityManager em = emf.createEntityManager();

        try {
            Sportsman sportsman = em.find(Sportsman.class, sportsmanId);
            if (sportsman == null) {
                System.out.println("Спортсмен с ID " + sportsmanId + " не найден.");
                return;
            }

            Set<Training> trainings = sportsman.getTrainings();

            System.out.println("\nТренировки для спортсмена: " + sportsman.getFirstName() + " " + sportsman.getLastName());
            if (trainings == null || trainings.isEmpty()) {
                System.out.println("Нет тренировок.");
            } else {
                System.out.printf("%-5s | %-20s | %-15s%n", "ID", "Тип тренировки", "Время (мин)");
                System.out.println("-----------------------------------------------------");
                for (Training t : trainings) {
                    System.out.printf("%-5d | %-20s | %-15d%n",
                            t.getId(),
                            t.getTypeTrain(),
                            t.getTrainingTime());
                }
            }

        } catch (Exception e) {
            System.out.println("Ошибка при выводе тренировок спортсмена: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deletetrain(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Training training = em.find(Training.class, id);
            if (training != null) {
                em.remove(training);
                System.out.println("Тренировка с id " + id + " удалена.");
            } else {
                System.out.println("Тренировка с id " + id + " не найдена.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Ошибка при удалении тренировки: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void addsport() {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("\n*** Добавление нового спортсмена ***");
            System.out.print("Введите имя: ");
            String firstName = scanner.nextLine();

            System.out.print("Введите фамилию: ");
            String lastName = scanner.nextLine();

            Sportsman newSportsman = new Sportsman();
            newSportsman.setFirstName(firstName);
            newSportsman.setLastName(lastName);

            em.getTransaction().begin();
            em.persist(newSportsman);
            em.getTransaction().commit();

            System.out.println("Спортсмен успешно добавлен!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Ошибка при добавлении спортсмена: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void showTrainings() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Training> trainings = em.createQuery("from Training", Training.class).getResultList();
            for (Training t : trainings) {
                System.out.println(t);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при выводе тренировок: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void addtrain() {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("\n*** Добавление новой тренировки ***");

            System.out.print("Введите тип тренировки: ");
            String type = scanner.nextLine();

            System.out.print("Введите длительность тренировки (в минутах): ");
            int duration = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите цель тренировки: ");
            String goal = scanner.nextLine();

            System.out.print("Введите количество сожжённых калорий: ");
            double calories = Double.parseDouble(scanner.nextLine());

            System.out.print("Введите уровень активности (низкий/средний/высокий): ");
            String activityLevel = scanner.nextLine();

            Training training = new Training();
            training.setTypeTrain(type);
            training.setTrainingTime((long) duration);
            training.setGoal(goal);
            training.setCalories(calories);
            training.setActivityLevel(activityLevel);

            em.getTransaction().begin();
            em.persist(training);
            em.getTransaction().commit();

            System.out.println("Тренировка успешно добавлена!");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Ошибка при добавлении тренировки: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public void alltable() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Sportsman> sportsmen = em.createQuery("from Sportsman", Sportsman.class).getResultList();
            List<Training> trainings = em.createQuery("from Training", Training.class).getResultList();

            System.out.printf("%-5s | %-12s | %-10s || %-5s | %-20s | %-15s | %-15s | %-10s | %-15s%n",
                    "ID", "Имя", "Фамилия",
                    "ID", "Тип", "Время (мин)", "Цель", "Ккал", "Активность");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

            int maxRows = Math.max(sportsmen.size(), trainings.size());
            for (int i = 0; i < maxRows; i++) {
                String sportsmanStr;
                String trainingStr = "";

                if (i < sportsmen.size()) {
                    Sportsman s = sportsmen.get(i);
                    sportsmanStr = String.format("%-5d | %-12s | %-10s", s.getId(), s.getFirstName(), s.getLastName());
                } else {
                    sportsmanStr = String.format("%-5s | %-12s | %-10s", "", "", "");
                }

                if (i < trainings.size()) {
                    Training t = trainings.get(i);
                    // Проверка на null, чтобы избежать ошибок
                    String goal = t.getGoal() != null ? t.getGoal() : "";
                    String activityLevel = t.getActivityLevel() != null ? t.getActivityLevel() : "";
                    double calories = t.getCalories();

                    trainingStr = String.format("%-5d | %-20s | %-15d | %-15s | %-10.1f | %-15s",
                            t.getId(),
                            t.getTypeTrain(),
                            t.getTrainingTime() != null ? t.getTrainingTime() : 0,
                            goal,
                            calories,
                            activityLevel);
                }

                System.out.printf("%s || %s%n", sportsmanStr, trainingStr);
            }

        } catch (Exception e) {
            System.out.println("Ошибка при выводе данных: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public void showSportsmanOnlyTable() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Sportsman> sportsmen = em.createQuery("from Sportsman", Sportsman.class).getResultList();

            System.out.printf("%-5s | %-15s | %-15s%n", "ID", "Имя", "Фамилия");
            System.out.println("-------------------------------------");

            for (Sportsman s : sportsmen) {
                System.out.printf("%-5d | %-15s | %-15s%n",
                        s.getId(), s.getFirstName(), s.getLastName());
            }
        } catch (Exception e) {
            System.out.println("Ошибка при выводе спортсменов: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
