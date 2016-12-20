package com.lviv.advertisingagency;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



/**
 * The class is created for storing and handle of information about the Advertising Agency application.
 */
public class AdvertisingAgency {
    private static final Scanner scanner = new Scanner(System.in);
    List<AdvertisingPlatform> list;

    public AdvertisingAgency() {
        list = new LinkedList<>();
        list.add(new AdvertisingPlatform(OS.LINUX, Browser.YANDEX, "AdvertisingPlatformLinuxYandex",
                checkAllScreensForContainInfo("AdvertisingPlatformLinuxYandex"),
                checkAllScreensFromPlatform("AdvertisingPlatformLinuxYandex")));
        list.add(new AdvertisingPlatform(OS.MAC, Browser.OPERA, "AdvertisingPlatformMacOpera",
                checkAllScreensForContainInfo("AdvertisingPlatformMacOpera"),
                checkAllScreensFromPlatform("AdvertisingPlatformMacOpera")));
        list.add(new AdvertisingPlatform(OS.SOLARIS, Browser.FIREFOX, "AdvertisingPlatformSolarisFirefox",
                checkAllScreensForContainInfo("AdvertisingPlatformSolarisFirefox"),
                checkAllScreensFromPlatform("AdvertisingPlatformSolarisFirefox")));
        list.add(new AdvertisingPlatform(OS.SUN_OS, Browser.INTERNET_EXPLORER, "AdvertisingPlatformSunInternetExplorer", checkAllScreensForContainInfo("AdvertisingPlatformSunInternetExplorer"), checkAllScreensFromPlatform("AdvertisingPlatformSunInternetExplorer")));
        list.add(new AdvertisingPlatform(OS.WINDOWS7, Browser.GOOGLE_CHROME, "AdvertisingPlatformWindows7GoogleChrome", checkAllScreensForContainInfo("AdvertisingPlatformWindows7GoogleChrome"), checkAllScreensFromPlatform("AdvertisingPlatformWindows7GoogleChrome")));
        serializatorIn(list.get(0), "AdvertisingPlatformLinuxYandex", "InfoAdvertisingPlatformLinuxYandex");
        serializatorIn(list.get(1), "AdvertisingPlatformMacOpera", "InfoAdvertisingPlatformMacOpera");
        serializatorIn(list.get(2), "AdvertisingPlatformSolarisFirefox", "InfoAdvertisingPlatformSolarisFirefox");
        serializatorIn(list.get(3), "AdvertisingPlatformSunInternetExplorer", "InfoAdvertisingPlatformSunInternetExplorer");
        serializatorIn(list.get(4), "AdvertisingPlatformWindows7GoogleChrome", "InfoAdvertisingPlatformWindows7GoogleChrome");

    }

    /**
     * The method allows to count the screens.
     */
    public int countAllScreensFromPlatform() {
        String nameOfPlatform = getInfo("Input name of Platform");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform);
        int count = 0;
        if (Files.isDirectory(path)) {
            try {
                try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
                    for (Path file : files) {
                        if (Files.isRegularFile(file) || Files.isSymbolicLink(file)) {
                            if (file.getFileName().toString().startsWith("Screen")) {
                                count++;
                            }

                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            try {
                throw new FileIsNotADirectoryException("Check it");
            } catch (FileIsNotADirectoryException e) {
                e.print();
            }

        return count;
    }

    private boolean isEmptyFile(String source) {
        try {
            for (String line : Files.readAllLines(Paths.get(source))) {
                if (line != null && !line.trim().isEmpty()) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * The method allows to check screen for empty.
     */
    private int checkAllScreensFromPlatform(String nameOfPlatform) {
//        String nameOfPlatform = getInfo("Input name of Platform");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform);
        int count = 0;
        if (Files.isDirectory(path)) {
            try {
                try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
                    for (Path file : files) {
                        if (Files.isRegularFile(file) || Files.isSymbolicLink(file)) {
                            if (file.getFileName().toString().startsWith("Screen") && isEmptyFile(String.valueOf(file))) {
                                count++;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            try {
                throw new FileIsNotADirectoryException("Check it");
            } catch (FileIsNotADirectoryException e) {
                e.print();
            }
        return count;
    }

    /**
     * The method allows to check screen for contain info.
     */
    private int checkAllScreensForContainInfo(String nameOfPlatform) {
//        String nameOfPlatform = getInfo("Input name of Platform");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform);
        int count = 0;
        if (Files.isDirectory(path)) {
            try {
                try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
                    for (Path file : files) {
                        if (Files.isRegularFile(file) || Files.isSymbolicLink(file)) {
                            if (file.getFileName().toString().startsWith("Screen") && !isEmptyFile(String.valueOf(file))) {
                                count++;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            try {
                throw new FileIsNotADirectoryException("Check it");
            } catch (FileIsNotADirectoryException e) {
                e.print();
            }

        return count;
    }

    /**
     * The method allows to create the menu.
     */
    public void menu() {
        System.out.println("1) Post reclame on the screen.\n2) Change reclame on screen.\n3) Create new platform.\n4) Create new reclame screen.\n5) Delete platform with all screens.\n6) Delete all screens from the platform.\n7) Add screen to the platform.\n8) Show screen from the platform.\n9) Show all screens from the platform.\n10) Show info about platform.\n11) Count the screens from platform.\n12) Show all from Platform.\n14) Exit.");
    }

    /**
     * The method allows to serializate the object.
     */
    public void serializatorIn(Object object, String nameOfPlatform, String nameOfFile) {
        try (FileOutputStream outputStream = new FileOutputStream("./AdvertisingAgency/" + nameOfPlatform + "/" + nameOfFile + ".ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method allows to read serializate object.
     */
    public void serializatorOut() {
        String nameOfPlatform = getInfo("Input name of Platform");
        String nameOfFile = getInfo("Input name of file");
        try (FileInputStream inputStream = new FileInputStream("./AdvertisingAgency/" + nameOfPlatform + "/" + nameOfFile + ".ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            AdvertisingPlatform advertisingPlatform = (AdvertisingPlatform) objectInputStream.readObject();
            AdvertisingPlatform adv = (AdvertisingPlatform) advertisingPlatform;
            System.out.println(adv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The method allows to get a string value.
     *
     * @param string for show info what input.
     * @return get a string value.
     */
    private String getInfo(String string) {
        System.out.println(string);
        return scanner.next();
    }

    /**
     * The method allows to create the menu.
     */
    public void menuOnScreen() {
        System.out.println("\tDefault Platforms:\n->I AdvertisingPlatformLinuxYandex\n->II AdvertisingPlatformMacOpera\n->III AdvertisingPlatformSolarisFirefox\n->IV AdvertisingPlatformSunInternetExplorer\n ->V AdvertisingPlatformWindows7GoogleChrome\n->VI Choose another platform\n-> 0 - Exit.");
    }

    /**
     * The method allows to post reclame on screen.
     */
    public void postAdvertisingOnScreen() {
        menuOnScreen();
        int key = Integer.parseInt(getInfo("Select the item of the menu please..."));
        try {
            switch (key) {
                case 1: {
                    String filePath = "./AdvertisingAgency/AdvertisingPlatformLinuxYandex/";
                    postAdvertisingToScreen(filePath);
                    break;
                }
                case 2: {
                    String filePath = "./AdvertisingAgency/AdvertisingPlatformMacOpera/";
                    postAdvertisingToScreen(filePath);
                    break;
                }
                case 3: {
                    String filePath = "./AdvertisingAgency/AdvertisingPlatformSolarisFirefox/";
                    postAdvertisingToScreen(filePath);
                    break;
                }
                case 4: {
                    String filePath = "./AdvertisingAgency/AdvertisingPlatformSunInternetExplorer/";
                    postAdvertisingToScreen(filePath);
                    break;
                }
                case 5: {
                    String filePath = "./AdvertisingAgency/AdvertisingPlatformWindows7GoogleChrome/";
                    postAdvertisingToScreen(filePath);
                    break;
                }
                case 6: {
                    String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
                    String nameOfScreen = getInfo("Input name of screen like(screen.txt).");
                    Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform + "/" + nameOfScreen);
                    postAdvertisingToScreen(String.valueOf(path));
                    break;
                }
                case 0:
                    return;
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }

    /**
     * The method allows to show all screens from platform with param.
     */
    public void showAllScreensFromPlatformWithParam(String path) {
        Path paths = Paths.get(path);
        try {
            Files.walkFileTree(paths, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes fileAttributes) {
                    if (file.getFileName().toString().startsWith("Screen")) {
                        System.out.println("Matching screen : " + file.getFileName());

                    }
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getPathToScreen(String pathOfFile, String text) {
        try {
            Files.write(Paths.get(pathOfFile), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void postAdvertisingToScreen(String filePath) {
        String text = getInfo("Input text of reclame please...");
        showAllScreensFromPlatformWithParam(filePath);
        String screenName = getInfo("Input screen name.");
        String pathOfFile = filePath + screenName;
        getPathToScreen(pathOfFile, text);
    }


    /**
     * The method allows to change reclame on screen.
     */
    public void changeAdvertisingOnScreen() {
        String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
        String nameOfScreen = getInfo("Input name of screen like(screen.txt).");
        String text = getInfo("Input change text of reclame please...");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform + "/" + nameOfScreen);
        try {
            Files.copy(path, path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Source file copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * The method allows to create a new Platform.
     */
    public void createNewPlatform() {
        String nameOfPlatform = getInfo("Input name of platform like (AdvertisingPlatform)");
        String os = getInfo("Input os please...like(WINDOWS7, MAC, LINUX, SOLARIS, SUN_OS)");
        String browser = getInfo("Input browser please...like(GOOGLE_CHROME,YANDEX,OPERA,FIREFOX,INTERNET_EXPLORER)");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform + os + browser);
        try {
            Files.createDirectories(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String nameOfInfo = getInfo("Input name of info like (Info)");
        Path paths = Paths.get("./AdvertisingAgency/" + nameOfPlatform + "/" + nameOfInfo);
        try {
            Files.createFile(paths);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.add(new AdvertisingPlatform(OS.valueOf(os), Browser.valueOf(browser), nameOfPlatform, checkAllScreensForContainInfo(nameOfPlatform), checkAllScreensFromPlatform(nameOfPlatform)));
        serializatorIn(list.get(list.size() - 1), nameOfPlatform, nameOfInfo);
    }


    /**
     * The method allows to create a new screen with text reclame.
     */
    public void createNewAdvertisingScreen() {
        String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
        String nameOfScreen = getInfo("Input name of screen like(screen.txt).");
        String text = getInfo("Input text of reclame please...");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform + "/" + nameOfScreen);
        try {
            Files.createFile(path);
            getPathToScreen(String.valueOf(path), text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * The method allows to delete a platform with all screens.
     */
    public void deletePlatformWithAllScreens() {
        String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform);
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return delete(dir);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    return delete(file);
                }

                private FileVisitResult delete(Path pathToFile) throws IOException {
                    Files.delete(pathToFile);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Deleted platform :" + path);
    }


    /**
     * The method allows to delete all screens from the platform.
     */
    public void deleteAllScreensFromPlatform() {
        String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform);
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    String name = file.getFileName().toString();
//                    if(!name.startsWith("Info"))
                    return delete(file);
//                    return null;
                }

                private FileVisitResult delete(Path pathToFile) throws IOException {
                    Files.delete(pathToFile);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Deleted screns from platform :" + path);
    }


    /**
     * The method allows to create a screen choosing a platform.
     */
    public void addScreenToPlatform() {
        String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
        String nameOfScreen = getInfo("Input name of screen like(screen.txt).");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform + "/" + nameOfScreen);
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method allows to get and save an information about path.
     *
     * @return path to file.
     */
    private Path getPath() {
        String pathOfFile = scanner.next();
        return Paths.get(pathOfFile);
    }

    /**
     * The method allows to show the screen from the platform.
     */
    public void showScreenFromPlatform() {
        String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform);
        String pathOfFileToFind = getInfo("Input name of file like(Screen.txt)");
        String fileToFind = File.separator + pathOfFileToFind;
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    if (fileString.endsWith(fileToFind)) {
                        System.out.println("Screen is found: " + file.getFileName());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method allows to show all screens from the platform.
     */
    public void showAllScreensFromPlatform() {
        String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform);
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes fileAttributes) {
                    if (file.getFileName().toString().startsWith("Screen")) {
                        System.out.println("Matching screen : " + file.getFileName());
                    }

                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method allows to show all from the platform.
     */
    public void showAllFromPlatform() {
        String nameOfPlatform = getInfo("Input name of platform like(AdvertisingPlatformWindows7GoogleChrome).");
        Path path = Paths.get("./AdvertisingAgency/" + nameOfPlatform);
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes fileAttributes) {
                    System.out.println("Matching screen : " + file.getFileName());
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

