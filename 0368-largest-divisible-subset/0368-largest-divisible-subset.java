class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp , 1);
        Arrays.fill(parent,-1);

        int maxlen = 1;
        int lastindex = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                
                if(nums[i] % nums[j] == 0){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if(dp[i] > maxlen){
                maxlen = dp[i];
                lastindex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();

        while(lastindex != -1){
            ans.add(nums[lastindex]);
            lastindex = parent[lastindex];
        }
        return ans;
    }
}