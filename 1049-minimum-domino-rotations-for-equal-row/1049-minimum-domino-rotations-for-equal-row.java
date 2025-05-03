class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int t = minRotations(tops,bottoms,tops[0]);
        int b =  minRotations(tops,bottoms,bottoms[0]);

        if(t==-1) return b;
        else if(b==-1) return t;
        else return Math.min(t,b);


    }

    private static int  minRotations(int[] tops, int[] bottoms, int target) {

        int rotateTop=0,rotateBottom=0;

        for(int i= 0; i < tops.length;i++){
            if(tops[i]!=target && bottoms[i]!=target)return -1;
            else if(tops[i]!= target) rotateTop++;
            else if(bottoms[i]!=target) rotateBottom++;
        }
        return Math.min( rotateTop,rotateBottom);
    }
}