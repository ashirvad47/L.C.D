class Solution {
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : tiles.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        return helper(map);
    }
    private int helper(HashMap<Character,Integer> map){
        int count =0;

        for(char c : map.keySet()){
            if(map.get(c)==0) continue;
            map.put(c,map.get(c)-1);

            count += 1+ helper(map);

            map.put(c,map.get(c)+1);
        }

        return count;
    }
}