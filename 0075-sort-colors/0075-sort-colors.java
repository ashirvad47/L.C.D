class Solution {
    public void sortColors(int[] arr) {
        for(int i =0; i < arr.length; i++){
            boolean  isSwap = false;
           for (int j =0; j < arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                arr[j]= arr[j] +arr[j+1];
                arr[j+1] = arr[j]-arr[j+1];
                arr[j]= arr[j]-arr[j+1];
                isSwap =true;
           } 
           }
           if(!isSwap){
            break;
            }
        }
    }
}