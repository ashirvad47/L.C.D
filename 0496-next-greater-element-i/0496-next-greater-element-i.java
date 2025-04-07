class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mapVal = new HashMap<>();
        HashMap<Integer,Integer> mapInd = new HashMap<>();
        
        for(int i =0; i<nums2.length;i++){
            mapVal.put(nums2[i],i);
            mapInd.put(i,nums2[i]);
        }

        for(int i =0; i <nums1.length;i++){
            int x = mapVal.get(nums1[i]);
            int y= nums1[i];
            while(x<nums2.length-1){
                x++;
                int temp = mapInd.get(x);
                if(temp> nums1[i]) {
                    nums1[i] = temp;
                    break;
                }
            }
            if(nums1[i]==y) nums1[i] = -1;
            

        }

        return nums1;


    }
}