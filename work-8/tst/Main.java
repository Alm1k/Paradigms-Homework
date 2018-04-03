public class Main {
    public static void main(String[] args) {
        GenericTabulator tabulator = new GenericTabulator();
        try {
            tabulator.tabulate("i", "x * x", 0, 1, 1, 2, 2, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
