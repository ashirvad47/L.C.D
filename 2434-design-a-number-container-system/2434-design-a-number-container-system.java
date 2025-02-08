class NumberContainers {
    private HashMap<Integer, Integer> indexToNum;
    private HashMap<Integer, TreeSet<Integer>> numToIndices;
    
    public NumberContainers() {
        indexToNum = new HashMap<>();
        numToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexToNum.containsKey(index)) {

            int oldNum = indexToNum.get(index);
            numToIndices.get(oldNum).remove(index);

            if (numToIndices.get(oldNum).isEmpty()) {
                numToIndices.remove(oldNum);
            }
        }
        
        indexToNum.put(index, number);
        
        numToIndices.putIfAbsent(number, new TreeSet<>());
        numToIndices.get(number).add(index);
    }
    
    public int find(int number) {
        if (numToIndices.containsKey(number)) {
            return numToIndices.get(number).first();
        }
        return -1;
    }
}