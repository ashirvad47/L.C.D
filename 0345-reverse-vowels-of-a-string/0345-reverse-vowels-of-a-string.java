class Solution {
    Set<Character> vowels = new HashSet<>(Arrays.asList('A','a','E','e','I','i','O','o','U','u'));

    public String reverseVowels(String s) {
        // HashMap<Character, Integer> map = new HashMap <>();
        StringBuilder sb = new StringBuilder(s);
        
        List<Character> ls = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(vowels.contains(c)) ls.add(c);
        }
        int end = ls.size()-1;
        for(int i =0; i < s.length();i++){
            if(vowels.contains(sb.charAt(i))) sb.setCharAt(i,ls.get(end--));
            
        }

        return  sb.toString();



    }
}