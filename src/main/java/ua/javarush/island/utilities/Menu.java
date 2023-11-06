package ua.javarush.island.utilities;

import ua.javarush.island.map.GameMap;
import ua.javarush.island.threads.Task;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Menu {
    public static void openMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(Settings.SALUTATION + "\n" + Settings.CREATE_MAP);
            System.out.println(Settings.INPUT_ROWS);

            while (true) {
                if (sc.hasNextInt()) {
                    int size = sc.nextInt();
                    if (size > 0) {
                        Settings.ROWS = size;
                        break;
                    } else {
                        System.out.println("Введіть число більше 0!");
                    }
                } else {
                    System.out.println("Введіть число!");
                    sc.next();
                }
            }

            System.out.println(Settings.INPUT_COLS);

            while (true) {
                if (sc.hasNextInt()) {
                    int size = sc.nextInt();
                    if (size > 0) {
                        Settings.COLS = size;
                        break;
                    } else {
                        System.out.println("Введіть число більше 0!");
                    }
                } else {
                    System.out.println("Введіть число!");
                    sc.next();
                }
            }

        }

        GameMap gameMap = GameMap.getInstance();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

        long sizeBefore = Settings.calculateTotalEntityCount(gameMap);
        System.out.println("Початок життя. Кількість істот на острові: " + sizeBefore);
        Settings.infoTotalEntity(gameMap);

        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(new Task(), 0, Settings.PERIOD, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(Settings.TIMEOUT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        scheduledFuture.cancel(true);
        executorService.shutdown();

    }
}

