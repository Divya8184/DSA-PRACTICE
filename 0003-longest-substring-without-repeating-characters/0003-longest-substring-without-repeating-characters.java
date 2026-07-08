class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        for(int i = 0; i < s.length(); i++){
            
            String temp = "";
            for(int j = i; j < s.length(); j++){
                char ch = s.charAt(j);
                if(temp.contains("" + ch)){
                    break;
                }
                temp += ch;
                if(temp.length() > max){
                    max = temp.length();
                }
            }
        }
        return max;
        
    }
}