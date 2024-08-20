package outLookpkg;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 int rows = 3;  // Number of rows in the pattern
	        int number = 1; // Starting number
	        
	        for (int i = 1; i <= rows; i++) {
	            // Print leading spaces
	            for (int j = rows - i; j > 0; j--) {
	                System.out.print(" ");
	            }
	            // Print numbers
	            for (int j = 1; j <= 2 * i - 1; j++) {
	                System.out.print(number);
	                number++;
	            }
	            System.out.println();
	        }
	    }

}
