package Java_Homework_4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 7, 2, 1, 5, 4, 8};
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("---------");

        Car mercedesC2018 = new Car(2018, "Mercedes", "C-200",
                true, 5);
        mercedesC2018.details();

        Book dorianGray = new Book(224, "The Picture of Dorian Gray",
                "Oscar Wilde", 1890);
        dorianGray.details();

    }
}
