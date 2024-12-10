class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
            int consecutiveCount = 1;
            
            for (int j = i; j < ch.length; j++) {
                if (j > i && ch[j] != ch[i]) break;
                
                String substring = s.substring(i, j + 1);
                
                map.put(substring, map.getOrDefault(substring, 0) + 1);
            }
        }
        
        int maxLength = -1;
        for (String key : map.keySet()) {
            if (isSpecial(key) && map.get(key) >= 3) {
                maxLength = Math.max(maxLength, key.length());
            }
        }
        
        return maxLength;
    }
    
    private boolean isSpecial(String s) {
        if (s.length() == 0) return false;
        char first = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != first) return false;
        }
        return true;
    }
}