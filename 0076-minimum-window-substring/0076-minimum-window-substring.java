class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(n > m) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        for(char c : t.toCharArray()){
            need[c]++;
        }

        int required = 0;
        for(int i = 0 ; i < 128 ; i++){
            if(need[i] > 0) required++;
        }

        int formed = 0 ;
        int left = 0 ;
        int minlen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0 ; right < m ; right++){
            char c = s.charAt(right);
            window[c]++;

            if(need[c] > 0 && window[c] == need[c]){
                formed++;
            }

            while(formed == required){
                int len = right - left + 1;

                if(len < minlen){
                    minlen = len;
                    start = left;
                }

                char leftchar = s.charAt(left);
                window[leftchar]--;

                if(need[leftchar] > 0 && window[leftchar] < need[leftchar]){
                    formed--;
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start+minlen);
    }
}