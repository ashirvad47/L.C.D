// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int n = numbers.length;
//         int result[]= new int[2];
//         for(int i =0; i <n;i++){
//             int complement = target- numbers[i];
//             if (map.containsKey(complement)) {
//                 result[0]= map.get(complement) +1;  // Index of the complement
//                 result[1]= i +1;  // This would be put in the second index as it'd be possible to find a complement only when the complement is stored previously and hence it'd obviously take the previous index.
//                 return result;
//             }
//             else{
//                 map.put(numbers[i],i);
//             }
//         }return result;
//     }
// }

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        
        while(numbers[left]+numbers[right]!= target){
            if(numbers[left]+numbers[right] < target){
                left++; //since the array is in ascending order, left++ makes the sum bigger
            }
            else{
                right--; //since the array is in ascending order, right-- makes the sum lesser
            }
        }
        int [] result= {left+1,right+1};
        return result;
    }
}