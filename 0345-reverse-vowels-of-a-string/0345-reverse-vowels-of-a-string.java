class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'));
        
        char[] chars = s.toCharArray();
        
        List<Character> vowelList = new ArrayList<>();
        for (char c : chars) {
            if (vowels.contains(c)) {
                vowelList.add(c);
            }
        }
        
        int reverseIndex = vowelList.size() - 1;
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                chars[i] = vowelList.get(reverseIndex--);
            }
        }
        
        return new String(chars);
    }
}
