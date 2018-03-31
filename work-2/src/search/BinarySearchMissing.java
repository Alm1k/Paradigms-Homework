package search;

public class BinarySearchMissing {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Input x as first argument");
            }

            int x = Integer.parseInt(args[0]);
            int[] a = new int[args.length - 1];
            for (int i = 1; i < args.length; ++i) {
                a[i - 1] = Integer.parseInt(args[i]);
            }

            int index = Searcher.find(a, -1, a.length, x, false);
            if (index == a.length || a[index] != x) {
                index = -(index + 1);
            }
            System.out.println(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
