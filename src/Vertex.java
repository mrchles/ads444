public class Vertex {

    private int value;

    public Vertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Vertex" + value;
    }
}