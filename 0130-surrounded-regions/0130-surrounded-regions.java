class Solution {
    public class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                q.offer(new Pair(0,i));
                vis[0][i]=true;
            }
            if(board[n-1][i]=='O'){
                q.offer(new Pair(n-1,i));
                vis[n-1][i]=true;
            }
        }
        for(int i=1;i<n-1;i++){
            if(board[i][0]=='O'){
                q.offer(new Pair(i,0));
                vis[i][0]=true;
            }
            if(board[i][m-1]=='O'){
                q.offer(new Pair(i,m-1));
                vis[i][m-1]=true;
            }
        }
        int dir[][]=new int[][]{{-1,0},{0,-1},{0,+1},{1,0}};
        while(!q.isEmpty()){
            Pair curr=q.remove();

            for(int i=0;i<4;i++){
                if(curr.a+dir[i][0]<n && curr.a+dir[i][0]>=0 && curr.b+dir[i][1]<m && curr.b+dir[i][1]>=0 && 'O'==board[curr.a+dir[i][0]][curr.b+dir[i][1]] && !vis[curr.a+dir[i][0]][curr.b+dir[i][1]]){       
                    q.offer(new Pair(curr.a+dir[i][0],curr.b+dir[i][1]));
                    vis[curr.a+dir[i][0]][curr.b+dir[i][1]]=true;
                }
            }
            
        }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]=='O'&&!vis[i][j]){
                        board[i][j]='X';
                    }
                }
            }
    }
}