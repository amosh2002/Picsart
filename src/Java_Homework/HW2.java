package Java_Homework;

public class HW2 {
    public static void main(String[] args) {
        int a = 1, b = 8;
        int c = a++ + --b; //c=8, b=7, a=1
        System.out.println(c); //c=8, b=7, a=2
        c = --a - ++b; //c=-7, b=8, a=1
        System.out.println(c); //c=-7 , b=8, a=1
        c = a * b++; //c=8, b=8, a=1
        System.out.println(c);//c=8, b=9, a=1
        c = b / ++a; //c=8, b=9, a=2
        System.out.println(c); //c=4, b=9, a=2
        System.out.println(a == c--); //c=4, b=9, a=2, False
        System.out.println(++a == c); //c=3, b=9, a=3, True
        System.out.println(a < b); //c=3, b=9, a=3, True
        System.out.println((b > c) && (b > a)); //c=3, b=9, a=3, True
        System.out.println(!((a == c) || (b < a))); //c=3, b=9, a=3, False
        a += 1; //c=3, b=9, a=4
        c %= 2; //c=1, b=9, a=4
        b -= 6; //c=1, b=3, a=4
        System.out.println("a=" + a + ", b=" + b + ", c=" + c); //c=1, b=3, a=4

        int[] arr = {c, 2, b, a};
        if (arr[0] == 1) {
            System.out.println(false);
        } else if (arr[0] == 2) {
            System.out.println(false);
        } else {
            System.out.println(true + ": bigger than 2");
        }

        switch (arr[2]) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("bigger than 2");
        }
    }
}
