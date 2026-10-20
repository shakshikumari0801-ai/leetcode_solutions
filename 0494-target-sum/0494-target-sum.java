class Solution {
    public int findTargetSumWays(int[] nums, int target) {
          return solve(0, nums, target);
    }

    private int solve(int i, int[] nums, int remaining) {
        if (i == nums.length) {
            return remaining == 0 ? 1 : 0;
        }

        int add = solve(i + 1, nums, remaining - nums[i]);
        int subtract = solve(i + 1, nums, remaining + nums[i]);

        return add + subtract;
    }
}