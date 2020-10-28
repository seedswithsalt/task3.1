package vsu.chirkova.ru;
import java.util.Scanner;

import java.io.PrintStream;
class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static final Line L1 = new Line(-1, 6, 5.0 / 2);
    public static final HorizontalParabola P1 = new HorizontalParabola(2, 2, 1);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        double[] coordinate = new double[]{10, 10, 5, 3, -6, -6.123, -5, -4.5, 3, -3};
        System.out.println("Заданные точки:");
        for (int i = 0; i < 8; i += 2) {
            answer(coordinate[i], coordinate[i + 1]);
        }
        out.println("");
        double y = (double) Math.round(Math.random() * 2000 - 1000) / 100;
        double x = (double) Math.round(Math.random() * 2000 - 1000) / 100;
        out.println("Случайная точка:");
        answer(x, y);
        out.println("");
        out.println("Введите координаты:");
        out.print("x = ");
        x = scanner.nextDouble();
        out.print("y = ");
        y = scanner.nextDouble();
        answer(x, y);
    }

    public static void answer(double x, double y) {
        out.println("Точка (" + x + "; " + y + ") находится в " + getColor(x, y) + " области.");
    }

    public static SimpleColor getColor(double x, double y) {
        if (P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (y < -2 && L1.isPointAboveLine(x, y)) {
            return SimpleColor.GREEN;
        }
        if (y < -2 && !L1.isPointAboveLine(x, y)) {
            return SimpleColor.YELLOW;
        }
        return SimpleColor.GRAY;
    }
}