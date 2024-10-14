// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap <Integer,Integer> map = new HashMap<>();
//         int[] result = new int[k];
//         for(int i :nums){
//             map.put(i, map.getOrDefault(i,0)+1);
//         }
        
//         PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b),map.get(a)));
//            queue.addAll(map.keySet());
        
//         for(int i =0;i <k;i++){
//             result[i]=queue.poll();
//         }
//         return result;
//     }
// }

// To improve the efficiency, we need to implement min heap instead of max heap like we did above 

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element using a HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Maintain a min-heap of size k
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));
        for (int key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.poll(); // Remove the element with the lowest frequency
            }
        }

        // Step 3: Extract the top K elements from the priority queue
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}


