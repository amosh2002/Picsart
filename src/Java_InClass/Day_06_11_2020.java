package Java_InClass;

public class Day_06_11_2020 {
    public static void main(String[] args) {
        String[] names = {"Bob", "Mike", "John"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + 1 + ". " + names[i]);
        }

        int[] arr = {1, 2, 3, -1, 5, -1};
        int min = arr[0];
        int minind = 0;
        for (int i = 1; i < arr.length; i++) {
            if (min >= arr[i]) {
                min = arr[i];
                minind = i;
            }
        }
        System.out.println(min);
        System.out.println(minind);
    }
}
