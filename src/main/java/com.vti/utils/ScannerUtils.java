package com.vti.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerUtils {
    static Scanner scanner = new Scanner(System.in);

    public static String inputString() {
        return scanner.nextLine();
    }

    public static int inputNumber() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Số nhập vào không đúng định dạng, mời nhập lại");
            }
        }
    }

    public static int inputNumber(int min, int max) {
        while (true) {
            int number = inputNumber();
            if (number < min || number > max) {
                System.err.println("Giá trị nhập vào không hợp lệ, mời nhập lại");
            } else {
                return number;
            }
        }
    }

    public static void close() {
        scanner.close();
    }

    public static Date inputDate() {
        while (true){
            String dateStr = inputString();
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.parse(dateStr);
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ. Định dạng đúng là yyyy-MM-dd.");
                return null;
            }
        }
    }

    // inPutDate.... input email ,....
}
