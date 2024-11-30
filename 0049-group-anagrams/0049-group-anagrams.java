class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String i : strs) {
            char[] c = i.toCharArray();
            Arrays.sort(c);
            String st = new String(c);

            if (!map.containsKey(st)) {
                map.put(st, new ArrayList<>());
            }
            map.get(st).add(i);

        }

        return new ArrayList<>(map.values());
    }
}