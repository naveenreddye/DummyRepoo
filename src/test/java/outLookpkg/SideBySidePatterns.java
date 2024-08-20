package outLookpkg;

public class SideBySidePatterns {
    public static void main(String[] args) {
        int heightI = 5; // Height of letter "I"
        int heightHeart = 6; // Height of heart shape
        int heightU = 5; // Height of letter "U"

        for (int i = 0; i < Math.max(heightI, Math.max(heightHeart, heightU)); i++) {
            // Print letter "I"
            if (i < heightI) {
                printI(i, heightI);
            } else {
                printSpaces(heightI);
            }

            // Print heart shape
            if (i < heightHeart) {
                printHeart(i, heightHeart);
            } else {
                printSpaces(heightHeart);
            }

            // Print letter "U"
            if (i < heightU) {
                printU(i, heightU);
            } else {
                printSpaces(heightU);
            }

            // Move to the next line
            System.out.println();
        }
    }

    // Function to print spaces
    private static void printSpaces(int count) {
        for (int j = 0; j < count; j++) {
            System.out.print(" ");
        }
    }

    // Function to print the letter "I"
    private static void printI(int row, int height) {
        for (int j = 0; j < height; j++) {
            if (j == height / 2 || (row == 0 && j != 0 && j != height - 1) || (row == height - 1 && j != 0 && j != height - 1)) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.print(" "); // Add a space between patterns
    }

    // Function to print a heart shape
    private static void printHeart(int row, int height) {
        int n = height / 2;

        if (row < n) {
            for (int j = 1; j < height - row; j += 2) {
                System.out.print(" ");
            }

            for (int j = 1; j <= row + 1; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= height - row; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= row + 1; j++) {
                System.out.print("*");
            }
        } else {
            for (int j = row; j < height; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (row * 2) - height + 2; j++) {
                System.out.print("*");
            }
        }
        System.out.print(" "); // Add a space between patterns
    }

    // Function to print the letter "U"
    private static void printU(int row, int height) {
        for (int j = 0; j < height; j++) {
            if ((j == 0 || j == height - 1) || (row == height - 1 && j > 0 && j < height - 1)) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
    }
}
