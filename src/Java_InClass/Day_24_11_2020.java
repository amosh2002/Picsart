package Java_InClass;

public class Day_24_11_2020 {
    public static void main(String[] args) {
        String s = "baRR556a5";
        System.out.println(isStrong(s));

        Student st=new Student("Armen,18,M");
        System.out.println(st.getName());
        System.out.println(st.getAge());
        System.out.println(st.getGender());
    }

    public static boolean isStrong(String s) {
        if (s.length() <= 8) {
            return false;
        }
        int uppers = 0;
        int numbers = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                uppers++;
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                numbers++;
            }
        }
        return numbers >= 3 && uppers >= 2;
    }
}
