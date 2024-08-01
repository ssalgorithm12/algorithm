import java.util.Scanner;

public class Swea2056 {

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        int t = scann.nextInt();

        int[] year = new int[t];
        int[] month = new int[t];
        int[] day = new int[t];

        for (int i = 0; i < t; i++) {
            int n = scann.nextInt();
            int y = n / 10000;
            year[i] = y;
            int m = (n - y * 10000) / 100;
            month[i] = m;
            int d = n - y * 10000 - m * 100;
            day[i] = d;
        }

        for (int i = 0; i < t; i++) {
            if (year[i] >= 0) {
                if (month[i] > 0 && month[i] <= 12) {
                    boolean valid = false;
                    switch (month[i]) {
                        case 2:
                            if (day[i] > 0 && day[i] <= 28) {
                                valid = true;
                            }
                            break;
                        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                            if (day[i] > 0 && day[i] <= 31) {
                                valid = true;
                            }
                            break;
                        case 4: case 6: case 9: case 11:
                            if (day[i] > 0 && day[i] <= 30) {
                                valid = true;
                            }
                            break;
                    }
                    if (valid) {
                        System.out.printf("#%d %04d/%02d/%02d%n", i + 1, year[i], month[i], day[i]);
                    } else {
                        System.out.printf("#%d -1%n", i + 1);
                    }
                } else {
                    System.out.printf("#%d -1%n", i + 1);
                }
            } else {
                System.out.printf("#%d -1%n", i + 1);
            }
        }

        scann.close();
    }
}
