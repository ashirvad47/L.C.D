class Solution {
    

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> VOWELS = new HashSet<>(Arrays.asList(
        'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    ));
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            while (left < right && !VOWELS.contains(chars[left])) {
                left++;
            }
            
            while (left < right && !VOWELS.contains(chars[right])) {
                right--;
            }
            
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                
                left++;
                right--;
            }
        }
        
        return new String(chars);
    }
}