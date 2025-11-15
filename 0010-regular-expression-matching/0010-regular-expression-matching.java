class Solution {
    public boolean isMatch(String s, String p) {
        // Base Case
        if(p.length() == 0){
            return s.length() == 0;
        }

        boolean firstCharMatch = false;
        if(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')){
            firstCharMatch = true;
        }

        if(p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s,p.substring(2)) || (firstCharMatch && isMatch(s.substring(1), p)));
        }else{
            return firstCharMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}