class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int count =0;

        for(int i : candies){
            count = i> count ? i:count;
        }
        
        List<Boolean> ls = new ArrayList<Boolean>();

        for(int i=0; i < candies.length; i ++){
            ls.add(candies[i] + extraCandies >=count);
        }

        return ls;
    }
}
