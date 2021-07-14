package ca.elecsoft.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Folder {
    public static Folder INSTANCE;

    private Folder() {

    }

    public static Folder getInstance() {
        if (INSTANCE == null) {
            return new Folder();
        }
        return INSTANCE;
    }


    public boolean createFolder(String directoryPath) {
        String dir = directoryPath;// "./RegressionRuns/SBN-Suite";
        try {
            Path path = Paths.get(dir);
            Files.createDirectories(path);
            System.out.println("Directory is created!");

        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
            return false;
        }

        return true;

    }


}
