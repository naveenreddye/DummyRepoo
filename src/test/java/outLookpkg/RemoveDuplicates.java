package outLookpkg;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] array) {
        if (array.length == 0) {
            return array;
        }
        
        Arrays.sort(array);
        
        int[] tempArray = new int[array.length];
        int j = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                tempArray[j++] = array[i];
            }
        }
        
        tempArray[j++] = array[array.length - 1];

        int[] resultArray = new int[j];
        System.arraycopy(tempArray, 0, resultArray, 0, j);
        
        return resultArray;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 7, 2, 4, 9,9, 1, 7, 3,3};
        
        int[] result = removeDuplicates(array);
        
        System.out.println("Array without duplicates: " + Arrays.toString(result));
    }
}

