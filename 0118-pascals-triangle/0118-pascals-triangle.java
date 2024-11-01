class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ls = new ArrayList<>();
        if(n == 0) return ls;
        
        if(n == 1){
            ls.add(new ArrayList<Integer>());
            ls.get(0).add(1);
            return ls;
        }
        
        if(n == 2){
            ls.add(new ArrayList<Integer>());
            ls.add(new ArrayList<Integer>());
            ls.get(0).add(1);
            ls.get(1).add(1);
            ls.get(1).add(1);
            return ls;
        }
        
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        ls.add(a1);
        
        List<Integer> a2 = new ArrayList<>();
        a2.add(1);
        a2.add(1);
        ls.add(a2);

        for(int i = 2; i < n; i++) { 
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for(int j = 1; j < i; j++) {
                row.add(ls.get(i - 1).get(j - 1) + ls.get(i - 1).get(j));
            }
            
            row.add(1);
            ls.add(row);
        }

        return ls;
    }
}
