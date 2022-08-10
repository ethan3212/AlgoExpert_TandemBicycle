import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // generate & populate our arrays
        int[] redShirtSpeeds = {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = {3, 6, 7, 2, 1};
        // set the boolean variable
        boolean fastest = true;
        // run our method & display the output
        System.out.println(tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest));     // O(nLog(n)) time | O(1) space
    }

    // O(nLog(n)) time | O(1) space
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // sort both input arrays
        Arrays.sort(redShirtSpeeds);        // O(nLog(n)) time
        Arrays.sort(blueShirtSpeeds);       // O(nLog(n)) time
        // if FASTEST is true, reverse the order of one of the arrays (I chose redShirts)
        if(!fastest) {
            reverseArray(redShirtSpeeds);       // O(n) time | O(1) space
        }
        // create a runningSum variable
        int runningSum = 0;
        // iterate through both input arrays
        for(int i = 0; i < redShirtSpeeds.length; i++) {        // O(n) time
            // get the RED & BLUE rider speeds
            int red = redShirtSpeeds[i];
            int blue = blueShirtSpeeds[redShirtSpeeds.length - i - 1];
            // add the largest to the runningSum
            runningSum += Math.max(red, blue);
        }
        // return the runningSum
        return runningSum;
    }

    // O(n) time | O(1) space
    public static void reverseArray(int[] array) {
        // create 2 pointers: LEFT & RIGHT
        int left = 0;
        int right = array.length - 1;
        // until the pointers cross
        while( left < right) {      // O(n) time
            // swap the elements at the pointers
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            // increment LEFT : decrement RIGHT
            left++;
            right--;
        }
    }
}