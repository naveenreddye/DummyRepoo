package outLookpkg;
public class PatternPrint {
    public static void main(String[] args) {
        printI();
        System.out.println(); // Add a line break between patterns
        printHeart();
        System.out.println(); // Add a line break between patterns
        printU();
    }

    // Function to print the letter "I"
    private static void printI() {
        int height = 5; // Adjust this value to change the height of the letter "I"

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if (j == height / 2 || (i == 0 && j != 0 && j != height - 1) || (i == height - 1 && j != 0 && j != height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Function to print a heart shape
    private static void printHeart() {
        int n = 6; // Adjust this value to change the size of the heart

        for (int i = n / 2; i <= n; i += 2) {
            for (int j = 1; j < n - i; j += 2) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n; i >= 1; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (i * 2) - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // Function to print the letter "U"
    private static void printU() {
        int height = 5; // Adjust this value to change the height of the letter "U"

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if ((j == 0 || j == height - 1) || (i == height - 1 && j > 0 && j < height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
