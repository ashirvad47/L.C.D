class Solution {
    public int maxDifference(String s) {
        int [] arr = new int[26];

        for(char c : s.toCharArray()){
            int idx = c -'a';
            arr[idx]++;
        }

        int maxA1 =Integer.MIN_VALUE;
        // int maxA2 =0;
        // int minA1 =0;
        int minA2 =Integer.MAX_VALUE;

        for(int i : arr){
            if(i%2!=0) maxA1 = Math.max(maxA1,i);
            else if(i>0) minA2 = Math.min(minA2,i);
        }

        return maxA1-minA2;

    }
}