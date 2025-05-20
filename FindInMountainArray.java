//Find in Mountain Array
package Questions;
import java.util.*;

public class FindInMountainArray {

    // Binary search helper for ascending order
    static int binarySearchAsc(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Binary search helper for descending order
    static int binarySearchDesc(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] > target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Function to find peak of mountain array
    static int findPeak(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) low = mid + 1; // Go right
            else high = mid;
        }
        return low; // Peak index
    }

    // Main function to find target in mountain array
    public static int findInMountainArray(int[] arr, int target) {
        int peak = findPeak(arr);

        // Search in ascending part
        int index = binarySearchAsc(arr, target, 0, peak);
        if (index != -1) return index;

        // Search in descending part
        return binarySearchDesc(arr, target, peak + 1, arr.length - 1);
    }

    // Main method to handle input/output
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] mountainArr = new int[n];

        String[] elements = sc.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            mountainArr[i] = Integer.parseInt(elements[i]);
        }

        int target = Integer.parseInt(sc.nextLine());

        int index = findInMountainArray(mountainArr, target);
        System.out.println(index);
    }
}
