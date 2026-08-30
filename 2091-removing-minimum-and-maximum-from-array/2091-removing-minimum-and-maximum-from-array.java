class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find minimum and maximum element
        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Delete both from front
        int front = Math.max(minIndex, maxIndex) + 1;

        // Delete both from back
        int back = n - Math.min(minIndex, maxIndex);

        // Delete one from front and one from back
        int both = Math.min(minIndex, maxIndex) + 1
                 + n - Math.max(minIndex, maxIndex);

        // Return the smallest option
        return Math.min(front, Math.min(back, both));
    }
}