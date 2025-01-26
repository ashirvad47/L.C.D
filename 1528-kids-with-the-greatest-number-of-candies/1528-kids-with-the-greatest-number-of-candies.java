class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int count =0;

        for(int i : candies){
            count = i> count ? i:count;
        }
        System.out.println(count);

        for(int i=0; i < candies.length; i ++){
            candies[i] = count - candies[i];
        }

        System.out.println(Arrays.toString(candies));

        List<Boolean> ls = new ArrayList<Boolean>();

        for(int i : candies) {
            if(i>extraCandies) ls.add(false);
            else ls.add(true);
        }

        return ls;
    }
}