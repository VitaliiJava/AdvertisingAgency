package com.lviv.advertisingagency;

import java.util.Scanner;

/**
 * Создать приложение для связи рекламодателя и агенства по размещению рекламы.
 * Рекламное агенство имеет 5 площадок с экранами для размещения рекламы, каждая с разным браузером и ОС.
 * Каждая площадка - директория с пятью текстовыми файлами("экранами") и  одним файлом, в  котором сериализована
 * информация о данной площадке(ось, браузер, количество файлов с рекламой и без, название площадки).
 * Приложение должно позволять:
 * 1) Размещать рекламу рекламодателя только на устройствах с определенным браузером и ОС.
 * 2) Менять определенную рекламу на определенной площадке.
 * 3) Создавать новую площадку.
 * 4) Создавать рекламу(текстовую).
 * 5) Удалять площадку со всей рекламой.
 * 6) Менять конфигурацию площадки с удалением всей рекламы.
 * 7) Добавлять экран на определенную площадку.
 * В  приложении использовать сериализацию.
 */

/**
 * The class is created for storing and handle of information about the Advertising Agency application.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AdvertisingAgency advertisingAgency = new AdvertisingAgency();
        while (true) {
            advertisingAgency.menu();
            String key = scanner.next();
            try {
                switch (key) {
                    case "1": {
                        advertisingAgency.postAdvertisingOnScreen();
                        break;
                    }
                    case "2": {
                        advertisingAgency.changeAdvertisingOnScreen();
                        break;
                    }
                    case "3": {
                        advertisingAgency.createNewPlatform();
                        break;
                    }
                    case "4": {
                        advertisingAgency.createNewAdvertisingScreen();
                        break;
                    }
                    case "5": {
                        advertisingAgency.deletePlatformWithAllScreens();
                        break;
                    }
                    case "6": {
                        advertisingAgency.deleteAllScreensFromPlatform();
                        break;
                    }
                    case "7": {
                        advertisingAgency.addScreenToPlatform();
                        break;
                    }
                    case "8": {
                        advertisingAgency.showScreenFromPlatform();
                        break;
                    }
                    case "9": {
                        advertisingAgency.showAllScreensFromPlatform();
                        break;
                    }
                    case "10": {
                        advertisingAgency.serializatorOut();
                        break;
                    }
                    case "11": {
                        System.out.println(advertisingAgency.countAllScreensFromPlatform());
                        break;
                    }
                    case "12": {
                        advertisingAgency.showAllFromPlatform();
                        break;
                    }
                    case "14":
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
    }
}
