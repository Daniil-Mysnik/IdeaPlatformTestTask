import org.json.JSONArray;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Counter {
    private List<Ticket> tickets = new ArrayList<>();
    private ParseFile parseFile;

    public Counter(ParseFile parseFile) {
        this.parseFile = parseFile;
    }

    private void getAllTickets() throws IOException, ParseException {
        int index = 0;
        JSONArray array = parseFile.parse();
        while (index != array.length()) {
            tickets.add(parseFile.createTicket(array.getJSONObject(index)));
            index++;
        }
    }

    public LocalTime AVGFlightTime() {
        int minutes = 0;
        int numOfFlights = 0;
        int avgFlightTimeMinutes;
        for (Ticket ticket : tickets) {
            minutes += flightTimeMinutesByTicket(ticket);
            numOfFlights++;
        }
        avgFlightTimeMinutes = minutes / numOfFlights;
        return LocalTime.of(avgFlightTimeMinutes / 60, avgFlightTimeMinutes % 60);
    }

    public LocalTime percentile(float percentile) {
        List<Integer> list = new ArrayList<>();
        for (Ticket ticket : tickets) {
            list.add(flightTimeMinutesByTicket(ticket));
        }
        list.sort(Comparator.naturalOrder());
        int pos = Math.round(list.size() * percentile / 100);
        return LocalTime.of(list.get(pos)/60, list.get(pos) % 60);
    }

    private int flightTimeMinutesByTicket(Ticket ticket) {
        if (ticket.getArrivalDate().equals(ticket.getDepartureDate())) {
            return ticket.getArrivalTime().getHour() * 60 -
                    ticket.getDepartureTime().getHour() * 60 +
                    ticket.getArrivalTime().getMinute() -
                    ticket.getDepartureTime().getMinute();
        } else {
            return 24 - ticket.getDepartureTime().getHour() * 60 -
                    ticket.getDepartureTime().getMinute() +
                    ticket.getArrivalTime().getHour() * 60 +
                    ticket.getArrivalTime().getMinute();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Enter path of file");
        }
        Counter counter = new Counter(new ParseFile(args[0]));
        counter.getAllTickets();
        System.out.println("Average flight time: " + counter.AVGFlightTime());
        System.out.println("Percentile 90 of flight time: " + counter.percentile(90));
    }
}
