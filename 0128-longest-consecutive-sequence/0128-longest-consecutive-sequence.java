class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> conset = new HashSet<>();

        for(int num : nums){
            conset.add(num);
        }

        int longest = 0;
        for(int num : conset){

            //if the no. is starting
            if(!conset.contains(num - 1)){
                int current = num;
                int largest = 1;

                while(conset.contains(current + 1)){
                    current++;
                    largest++;
                }
                 longest = Math.max(longest , largest);
            }
        }
        return longest;
    }
}