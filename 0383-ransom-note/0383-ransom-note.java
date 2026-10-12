class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] freq = new int[26];

        // Count available letters in magazine
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Use letters to construct ransomNote
        for (char ch : ransomNote.toCharArray()) {
            freq[ch - 'a']--;

            // Not enough copies of this character
            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    
    }
}