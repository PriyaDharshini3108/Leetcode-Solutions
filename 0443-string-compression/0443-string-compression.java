class Solution {
    public int compress(char[] chars) {
        int cnt=1;
        char prev = chars[0];
        int idx=0;
        for(int i=1;i<chars.length;i++){
            char ch = chars[i];
            if(prev==ch){
                cnt++;
            }
            else{
                chars[idx++]=prev;
                if(cnt!=1){
                    for(char c : (cnt+"").toCharArray()){
                        chars[idx++]=c;
                    }
                }
                cnt=1;
                prev=ch;
            }
        }

        chars[idx++]=prev;
        if(cnt!=1){
            for(char c : (cnt+"").toCharArray()){
                chars[idx++]=c;
            }
        }

        return idx;
    }
}