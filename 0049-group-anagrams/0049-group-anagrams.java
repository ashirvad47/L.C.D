class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String i : strs) {
            char[] ch = i.toCharArray();
            Arrays.sort(ch);
            String sortedStr = new String(ch);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(i);
        }

        return new ArrayList<>(map.values());
    }
}