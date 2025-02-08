class NumberContainers {

    HashMap<Integer,Integer> hmap = new HashMap<>();
    TreeMap<Integer,TreeSet<Integer>> tmap = new TreeMap<>();

    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        if(hmap.containsKey(index)){
            
            if(tmap.containsKey(hmap.get(index))){
                tmap.get(hmap.get(index)).remove(index);
                if(tmap.get(hmap.get(index)).isEmpty()) tmap.remove(hmap.get(index));
            }
        }
        hmap.put(index,number);
        tmap.putIfAbsent(number, new TreeSet<>());
        tmap.get(number).add(index);

    }
    
    public int find(int number) {
        if(!tmap.containsKey(number) || tmap.get(number).isEmpty()){
            return -1;
        }

        return tmap.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */