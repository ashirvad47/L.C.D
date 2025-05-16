class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {        
        int n = words.length;
        int max = 0;
        int maxIndex = -1;
        int DP[][] = new int[n][2];
        for(int i = 0; i<n; i++){
            int currMax = 1;
            int currMaxIndex = -1;
            for(int j = 0; j< i; j++){
                if(groups[i]!=groups[j]&&hammingDist(words[i],words[j])){
                    if(DP[j][0]> currMax){
                        currMax = DP[j][0];
                        currMaxIndex = j;
                    }   
                }
            }
            DP[i][0] = currMax+1;
            DP[i][1] = currMaxIndex;
            if(DP[i][0]>max){
                max = DP[i][0];
                maxIndex = i;
            }
        }
        
        List<String> res = new ArrayList<>();
        
        while(maxIndex > -1){
            //System.out.println(maxIndex);
            res.add(words[maxIndex]);
            maxIndex = DP[maxIndex][1];
        }
        
        Collections.reverse(res);
        return res;
    }
    
    private boolean hammingDist(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        int curr = 0;
        for(int i =0; i< s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                curr++;
                if(curr >1 ) return false;
            }
        }
        return curr ==1;
    }
}