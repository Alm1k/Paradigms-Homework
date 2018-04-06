public class Main {
    public static void main(String[] args) {
        GenericTabulator tabulator = new GenericTabulator();
        try {
            tabulator.tabulate("s", "10", 2147483629, 2147483629, 2147483628, 2147483628, 2147483630, 2147483630);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
