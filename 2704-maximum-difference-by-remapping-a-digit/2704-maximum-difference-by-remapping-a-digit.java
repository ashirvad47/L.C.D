class Solution {
    public int minMaxDifference(int num) {
        String s = ""+num;
        String max ="";
        String min = "";

        char toChange='a';
        for(char c : s.toCharArray()){
            
            if(c != '9' && toChange == 'a'){
                toChange = c;
            }
            if(toChange ==c){
                max += '9';
            }else {
                max +=c;
            }

        }
        toChange='a';
        for(char c : s.toCharArray()){
            
            if(c != '0' && toChange == 'a'){
                toChange = c;
            }
            if(toChange ==c){
                min += '0';
            }else {
                min +=c;
            }

        }

        return Integer.parseInt(max)-Integer.parseInt(min);
    }
}