class Solution {
    public int countDigitOne(int n) {
        //If n is 0 just return 0
        if(n == 0) return 0;
        //Convert n into a string
        long temp = n;
        StringBuilder ans = new StringBuilder();
        while(temp > 0){
            ans.insert(0,temp%10);
            temp/=10;
        }
        //dp[i][j] denotes i represents the index and j is the tight which implies if j = 0 then no restriction on any of the upcoming digits and if j = 1 its restricted
        int[][] dp = new int[ans.length()][2];
        for(int[] row : dp) Arrays.fill(row,-1);
        int res = helper(dp,ans.toString(),0,1);
        return dp[0][1];
    }

    public int helper(int[][] dp,String str,int i,int tight){
        if(i == str.length()){
            return 0;
        }
        //If already precomputed return the value
        if(dp[i][tight] != -1) return dp[i][tight];
        //If tight is 1 which means it's constrained then the max value which it can go is only str.charAt(i) - '0' because if more than it becomes more than the original n but tight = 0 then as no constraint go to the max value that is 9
        int limit = tight == 1 ? str.charAt(i) - '0' : 9;
        int ans = 0;
        for(int j = 0;j <= limit;j++){
            if(j == 1){
                //Found occurences of one and pass into a new function pos 
                if(j == limit){
                    ans += pos(i,str,1);
                }else{
                    ans += pos(i,str,0);
                }
            }
            //Updating the new tight if j is limit and if tight is 1 then only tight for the next index becomes 1 else it remains 0
            ans += (j == limit && tight == 1 ? helper(dp,str,i+1,1) : helper(dp,str,i+1,0));
        }

        return dp[i][tight] = ans;
    }

    public int pos(int i,String str,int tight){
        if(tight == 0){
            //If no tight for all the further places from index i+1 to str.length()-1 any value from 0-9 can take place that is 10 possibilities for each index so multiply 10 for each digit
            int c = 1;
            for(int j = i+1;j < str.length();j++){
                c*=10;
            }
            return c;
        }
        //If tight is 1 then just consider the number from i+1 to str.length()-1 just parse it and add 1 reason if like 1234 is the subtring value from i+1 to str.length()-1 then only values from 0-1234 can take place or else it overflows and becomes bigger than n
        int c = 1;
        StringBuilder ans = new StringBuilder();
        for(int k = i+1;k < str.length();k++){
            ans.append(str.charAt(k));
        }
        if(ans.length() == 0) return 1;
        return Integer.parseInt(ans.toString())+1;
    }
}