package dev.runnergame.chainOfResponsibility;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends AbstractLogger {
    public FileLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message) {
        try {
//            FileWriter myWriter = new FileWriter("colorRunner/res/logs/logs.txt");
            FileWriter myWriter = new FileWriter(System.getProperty("user.dir") + "/res/logs/logs.txt");
            myWriter.write(message);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to write to log file.");
            e.printStackTrace();
        }
    }
}