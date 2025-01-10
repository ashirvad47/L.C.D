class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String i : words2) {
            char[] arr = i.toCharArray();
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (char j : arr) {
                tempMap.put(j, tempMap.getOrDefault(j, 0) + 1);
            }
            for (char key : tempMap.keySet()) {
                map.put(key, Math.max(map.getOrDefault(key, 0), tempMap.get(key)));
            }
        }

        for (String i : words1) {
            char[] arr = i.toCharArray();
            HashMap<Character, Integer> map2 = new HashMap<>();
            for (char j : arr) {
                map2.put(j, map2.getOrDefault(j, 0) + 1);
            }

            boolean isUniversal = true;
            for (char key : map.keySet()) {
                if (map2.getOrDefault(key, 0) < map.get(key)) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                res.add(i);
            }
        }

        return res;
    }
}
