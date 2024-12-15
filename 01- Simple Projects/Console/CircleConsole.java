package Console;

public class CircleConsole {

    public static void main(String[] args) {
        int radius = 10;
        int diameter = radius * 2;
        for (int y = 0; y <= diameter; y++) {
            for (int x = 0; x <= diameter; x++) {
                if (Math.pow(x - radius, 2) + Math.pow(y - radius, 2) <= Math.pow(radius, 2)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
