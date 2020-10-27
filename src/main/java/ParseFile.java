import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class ParseFile {
    private String filePath;

    public ParseFile(String filePath) {
        this.filePath = filePath;
    }

    public JSONArray parse() throws IOException {
        StringBuilder json = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath))) {
            bufferedReader.lines().forEach(json::append);
        }
        JSONObject jsonObject = new JSONObject(json.toString());
        return jsonObject.getJSONArray("tickets");
    }

    public Ticket createTicket(JSONObject jsonTicket) throws ParseException {
        DateFormat formatter1 = new SimpleDateFormat("dd.MM.yy");
        String[] departureTime = jsonTicket.getString("departure_time").split(":");
        String[] arrivalTime = jsonTicket.getString("arrival_time").split(":");
        return new Ticket(jsonTicket.getString("origin"),
                jsonTicket.getString("origin_name"),
                jsonTicket.getString("destination"),
                jsonTicket.getString("destination_name"),
                formatter1.parse(jsonTicket.getString("departure_date")),
                LocalTime.of(Integer.parseInt(departureTime[0]), Integer.parseInt(departureTime[1])),
                formatter1.parse(jsonTicket.getString("arrival_date")),
                LocalTime.of(Integer.parseInt(arrivalTime[0]), Integer.parseInt(arrivalTime[1])),
                jsonTicket.getString("carrier"),
                jsonTicket.getInt("stops"),
                jsonTicket.getInt("price"));
    }

}
