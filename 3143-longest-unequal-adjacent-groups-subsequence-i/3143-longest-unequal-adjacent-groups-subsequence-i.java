class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        if (words.length == 1) return new ArrayList<>(Arrays.asList(words[0]));

        List<String> ls = new ArrayList<>();
        ls.add(words[0]);
        int start = groups[0];
        for(int i =1; i < words.length;i++){
            if(start!=groups[i]) {
                ls.add(words[i]);
                start= groups[i];
            }
        }

        return ls;
    }
}