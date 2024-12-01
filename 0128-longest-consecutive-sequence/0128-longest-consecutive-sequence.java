// Efficient

class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];
            // look left
            
            while (set.contains(num-1)) {
                count++;
                num-=1;
                set.remove(num);
            }

            // look right
            num = nums[i];
            while (set.contains(num+1)) {
                count++;
                num+=1;
                set.remove(num);
            }

            max = Math.max(max, count);
        }

        return max;
    }
}


// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         for(int i :nums){
//             set.add(i);
//         }

//         int maxCount=0;
//         for(int i =0;i < nums.length;i++){
//             int count =1;
//             if(!set.contains(nums[i]-1)){
//                 int x=nums[i];
//                 while(set.contains(++x)){
//                     count++;
//                 }
//             }
//             maxCount = Math.max(count,maxCount);
//         }

//         return maxCount;
        
//     }
// }