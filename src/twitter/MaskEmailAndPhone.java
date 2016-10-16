package twitter;

import java.util.Scanner;

/**
 * Created by gaohan on 10/15/16.
 */
public class MaskEmailAndPhone {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line = null;
        while ((line = scan.nextLine()) != null) {
            if (line.charAt(0) == 'E') {
                String output = "E:" + line.charAt(2) + "*****" + line.substring(line.indexOf('@') - 1);
                System.out.println(output);
            } else if (line.charAt(0) == 'P') {
                String phoneNumStr = line.substring(2);
                String output = "P:";
                int num = getNumber(phoneNumStr);
                if (phoneNumStr.indexOf('+') != -1)
                    output += "+" + getStar(num) + "-";
                output += "***-***-" + phoneNumStr.substring(phoneNumStr.length() - 4);
                System.out.println(output);
            }
        }
    }

    private static String getStar(int num) {
        String res = "";
        for (int i = 0; i < num; i++) {
            res += "*";
        }
        return res;
    }

    private static int getNumber(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                count++;
        }
        return count - 10;
    }
}
