package dev.runnergame.chainOfResponsibility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonLogger  extends AbstractLogger{
    public JsonLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        JSONParser jsonParser = new JSONParser();
        try {

            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "/res/logs/logs.json"));
            //Object obj = jsonParser.parse(new FileReader("colorRunner/res/logs/logs.txt"));
            JSONArray jsonArray = (JSONArray) obj;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            JSONObject error = new JSONObject();
            error.put("message", message);
            error.put("date_created", now.toString());

            jsonArray.add(error);

            FileWriter file = new FileWriter(System.getProperty("user.dir") + "/res/logs/logs.json",false);
            //FileWriter file = new FileWriter("colorRunner/res/logs/logs.txt");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
