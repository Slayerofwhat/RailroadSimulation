public class RailwayConnection {
    private RailwayStation source;
    private RailwayStation destination;
    private boolean occupied;
    private int distance;

    public RailwayConnection(RailwayStation source, RailwayStation destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.occupied = false;
        this.distance = distance;
    }

    public RailwayStation getSource() {
        return source;
    }

    public RailwayStation getDestination() {
        return destination;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "RailwayConnection{" + "source=" + source.getName() + ", destination=" + destination.getName() + ", occupied=" + occupied + ", distance=" + distance + '}';
    }
}
