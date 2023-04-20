public class RailwayStation {
    private static int counter;
    private int id;

    private String name;

    public RailwayStation(String name){
        this.name = name;
        this.id = counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RailwayStation[" + "name='" + name + '\'' + ']';
    }
}
