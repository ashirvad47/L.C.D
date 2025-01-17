class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res=0;
        for (int i : derived) res^=i;
        // res ^= derived[0];

        return res==0;
    }
}