class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;
        if(n==2 || n==3) return false;

        HashSet<Integer> set = new HashSet<>();
        int sum=n;
        while(sum!=1 && set.contains(sum)==false){
           
           set.add(sum);
           sum= sumSquare(sum);
        }
       return sum==1;
    }

    public int sumSquare(int n){
        int sum =0;

        while(n >0){
            int dig = n%10;
            sum += dig*dig;
            n /= 10;
        }
        return sum;
    }
}