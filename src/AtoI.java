public class AtoI {

    public static int myAtoi(String s) {
        double result = 0;
        int sign = 1;
        int index = 0;

        if(s == null || s.length() < 1) {
            return 0;
        }

        s = s.trim();

        if(s.charAt(0) == '-'){
            sign = -1;
            index++;
        }
        else if (s.charAt(index) == '+') {
            sign = 1;
            index++;
        }

        for(int i = index; i < s.length(); i++) {

            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                break;
            else
                result = result * 10 + (s.charAt(i) - '0');

        }
        result = result * sign;

        if (result > 2147483647) {
            return 2147483647;
        }

        if (result < -2147483648) {
            return -2147483648;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
