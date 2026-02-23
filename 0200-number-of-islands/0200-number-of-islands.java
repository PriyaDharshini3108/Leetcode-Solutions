class Solution {

    int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){

                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                     dfsGrid(i,j , grid,visited);
                   
                }
            }
        }
        return count;
    }

    private void dfsGrid(int r, int c, char[][] grid, boolean[][] visited){

        if( r < 0 || c < 0 || r >=n || c>=m ) return ;

        if(grid[r][c] == '0' || visited[r][c]) return;

        visited[r][c] = true;

        dfsGrid(r + 1, c , grid, visited);
        dfsGrid(r - 1, c , grid, visited);
        dfsGrid(r, c + 1 , grid, visited);
        dfsGrid(r , c - 1, grid, visited);
    }
}