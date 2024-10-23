// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashMap<Character,Integer> map= new HashMap<>();
//         int maxCount=0;
//         for(int left=0,right=0; right <s.length();right++){
//             if(!map.containsKey(s.charAt(right)) || map.get(s.charAt(right))<left){
//                 map.put(s.charAt(right),right);
//                 maxCount = Math.max(maxCount, right-left+1);
//             }else{
//                 left = map.get(s.charAt(right))+1;
//                 map.put(s.charAt(right),right);
//             }
//         }

//         return maxCount;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0,j=0; i <  s.length();i++){
            if(!map.containsKey(s.charAt(i)) || map.get(s.charAt(i))< j){
                map.put(s.charAt(i),i);
                len = Math.max(len,i-j+1);
            }else{
                j=map.get(s.charAt(i))+1;
                map.put(s.charAt(i),i);
            }
        }
        return len;
    }
}



// The map stores characters as keys and their indices as values.
// We still maintain the left and right pointers and the maxLength variable.
// We iterate through the string using the right pointer.
// If the current character is not in the map or its index is less than left, it means it is a new unique character.
// 6 We update the charMap with the character's index and update the maxLength if necessary.
// If the character is repeating within the current substring, we move the left pointer to the next position after the last occurrence of the character.
// We update the index of the current character in the charMap and continue the iteration.
// At the end, we return the maxLength as the length of the longest substring without repeating characters.


// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int len = 0;
//         int i = 0, j = 0;
//         HashSet<Character> set = new HashSet<>();

//         while (i < s.length()) {
//             if (!set.contains(s.charAt(i))) {
//                 set.add(s.charAt(i));
//                 len = Math.max(len, i - j + 1); 
//                 i++; 
//             } else {
//                 set.remove(s.charAt(j));
//                 j++;
//             }
//         }
//         return len;
//     }
// }


