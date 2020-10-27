import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class Ticket {
    private String origin;
    private String originName;
    private String destination;
    private String destinationName;
    private Date departureDate;
    private LocalTime departureTime;
    private Date arrivalDate;
    private LocalTime arrivalTime;
    private String carrier;
    private int stops;
    private int price;

    public Ticket(String origin,
                  String originName,
                  String destination,
                  String destinationName,
                  Date departureDate,
                  LocalTime departureTime,
                  Date arrivalDate,
                  LocalTime arrivalTime,
                  String carrier,
                  int stops,
                  int price) {
        this.origin = origin;
        this.originName = originName;
        this.destination = destination;
        this.destinationName = destinationName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return stops == ticket.stops &&
                price == ticket.price &&
                Objects.equals(origin, ticket.origin) &&
                Objects.equals(originName, ticket.originName) &&
                Objects.equals(destination, ticket.destination) &&
                Objects.equals(destinationName, ticket.destinationName) &&
                Objects.equals(departureDate, ticket.departureDate) &&
                Objects.equals(departureTime, ticket.departureTime) &&
                Objects.equals(arrivalDate, ticket.arrivalDate) &&
                Objects.equals(arrivalTime, ticket.arrivalTime) &&
                Objects.equals(carrier, ticket.carrier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, originName, destination, destinationName, departureDate, departureTime, arrivalDate, arrivalTime, carrier, stops, price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "origin='" + origin + '\'' +
                ", originName='" + originName + '\'' +
                ", destination='" + destination + '\'' +
                ", destinationName='" + destinationName + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                ", carrier='" + carrier + '\'' +
                ", stops=" + stops +
                ", price=" + price +
                '}';
    }
}
