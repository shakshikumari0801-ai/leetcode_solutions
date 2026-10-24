class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b) -> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int maxlen = 0; 

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){

                if(words[j].length()+1 == words[i].length() && ispredecessor(words[j] , words[i])){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
            maxlen = Math.max(maxlen , dp[i]);
        }
        return maxlen;
    }

    private boolean ispredecessor(String shorter , String longer){
        int i = 0 ; 
        int j = 0;

        while(i < shorter.length() && j < longer.length()){
            if(shorter.charAt(i) == longer.charAt(j)){
                i++;
            }
            j++;
        }
        return i == shorter.length();
    }
}