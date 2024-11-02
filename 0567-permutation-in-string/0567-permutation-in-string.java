class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1= new HashMap<>();
        for(int i =0;i<s1.length();i++){
            char c = s1.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1 );
        }

        for(int i =s1.length()-1,j=0;i<s2.length();i++,j++){
            HashMap<Character,Integer> map2= new HashMap<>();

            for(int k=j;k<=i;k++){
                char c = s2.charAt(k);
                map2.put(c,map2.getOrDefault(c,0)+1);
            }

            if(map1.equals(map2)){
                return true;
            }
            
        }

        return false;
    }
}