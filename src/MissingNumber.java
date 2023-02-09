import java.util.Arrays;
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);

        System.out.println("nums" + Arrays.toString(nums));
        System.out.println("numCopy" + Arrays.toString(numsCopy));

        int n = numsCopy.length;
        if (numsCopy[numsCopy.length - 1] != n) {
            return n;
        }

        for (int i = 0; i < numsCopy.length; i++) {
            if (numsCopy[i] != i) {
                return i;
            }
        }
        return -1;
    }
}
