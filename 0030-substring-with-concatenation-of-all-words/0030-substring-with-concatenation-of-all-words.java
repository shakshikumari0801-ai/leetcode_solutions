class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordlen = words[0].length();
        int wordcount = words.length;

        Map<String , Integer> required = new HashMap<>();

        for(String word : words){
            required.put(word , required.getOrDefault(word,0)+1);
        }

        for(int i = 0; i < wordlen; i++){
            int left = i;
            int right = i;
            int count = 0;

            Map<String , Integer> window = new HashMap<>();

            while(right+wordlen <= s.length()){
                String word = s.substring(right , right+wordlen);
                right += wordlen;

                //word doesn't exist in required
                if(!required.containsKey(word)){
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                //add word
                window.put(word , window.getOrDefault(word , 0)+1);
                count++;

                //too many copies
                while(window.get(word) > required.get(word)){
                    String leftword = s.substring(left , left + wordlen);
                    window.put(leftword , window.get(leftword)-1);
                    left += wordlen;
                    count--;
                }

                //all words found
                if(count == wordcount){
                    ans.add(left);
                    String leftword = s.substring(left , left + wordlen);
                    window.put(leftword , window.get(leftword)-1);
                    left += wordlen;
                    count--;
                }
            }
        }
        return ans;
    }
}