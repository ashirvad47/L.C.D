// Floyd’s Tortoise and Hare algorithm(with early exit hence better)

class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;
        if(n==2 || n==3) return false;
      int slow=n;
      int fast=n;
        do{
            slow=sumSquare(slow);
            fast=sumSquare(sumSquare(fast));
        }while(slow!=fast && (slow!=1 || fast!=1));
        
        if(slow==1 || fast==1){
            return true;
        }
        return false;
    }
    public int sumSquare(int num){
        int n=0;
        while(num>0){
            int mod=num%10;
            n+=mod*mod;
            num/=10;
            }
        return n;
    }
}

// Floyd’s Tortoise and Hare algorithm
// class Solution {
//     public boolean isHappy(int n) {
//         // Special case for early return
//         if (n == 1) return true;
        
//         int slow = n;
//         int fast = n;
        
//         do {
//             slow = sumSquare(slow); // Slow pointer moves 1 step
//             fast = sumSquare(sumSquare(fast)); // Fast pointer moves 2 steps
//         } while (slow != fast); // Continue until both pointers meet
        
//         // After the loop ends, check if the cycle ends at 1
//         return slow == 1; // If slow reaches 1, the number is happy
//     }

//     public int sumSquare(int num) {
//         int sum = 0;
//         while (num > 0) {
//             int digit = num % 10;
//             sum += digit * digit;
//             num /= 10;
//         }
//         return sum;
//     }
// }



// class Solution {
//     public boolean isHappy(int n) {
//         if(n==1) return true;
//         if(n==2 || n==3) return false;

//         HashSet<Integer> set = new HashSet<>();
//         int sum=n;
//         while(sum!=1 && set.contains(sum)==false){
           
//            set.add(sum);
//            sum= sumSquare(sum);
//         }
//        return sum==1;
//     }

//     public int sumSquare(int n){
//         int sum =0;

//         while(n >0){
//             int dig = n%10;
//             sum += dig*dig;
//             n /= 10;
//         }
//         return sum;
//     }
// }