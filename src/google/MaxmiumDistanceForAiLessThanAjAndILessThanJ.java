package google;

public class MaxmiumDistanceForAiLessThanAjAndILessThanJ {
    public static int maxDistance(int[] A) {
        if (A.length < 2)
            return 0;
        int[] smallest = new int[A.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            min = A[i] > min ? min : A[i];
            smallest[i] = min;
        }
        // left从right左边一位开始逐渐左移
        int right = A.length - 1, left = right - 1;
        int max = 0;
        while (right >= max && left >= 0) {
            if (A[right] > smallest[left]) {
                max = max > right - left ? max : right - left;
                left--;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {110, 103, 99, 100, 101, 102, 18, 19, 4, 90, 91};
        // {100, 100, 100, 18 18 18 18 18 18, 5}
        System.out.println(maxDistance(A));
    }
}
