class Solution {
    public int maxArea(int[] height) {
        int Volume=0;
        int i=0;
        int j=height.length-1;

        while(i<j){
            int localVolume=Math.min(height[i],height[j])*(j-i);

            if(localVolume>Volume){
                Volume = localVolume;
            }
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }

        }

        return Volume;
    }
}