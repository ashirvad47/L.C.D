class NumberContainers {
    HashMap<Integer, Integer> hmap = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> tmap = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {
        if (hmap.containsKey(index)) {
            int oldNumber = hmap.get(index);
            TreeSet<Integer> oldSet = tmap.get(oldNumber);
            if (oldSet != null) {
                oldSet.remove(index);
                if (oldSet.isEmpty()) {
                    tmap.remove(oldNumber);
                }
            }
        }

        hmap.put(index, number);
        tmap.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> indices = tmap.get(number);
        return (indices == null || indices.isEmpty()) ? -1 : indices.first();
    }
}


/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */