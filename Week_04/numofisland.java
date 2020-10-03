class Solution {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    DFSMark(grid,i,j);
                    count++;
                }
            }
        }

        return count;

    }

    public void DFSMark(char[][] grid,int i, int j){
        if(i<0||j<0||i>=n||j>=m||grid[i][j]!='1'){
            return ;
        }

        grid[i][j] = '0';
        DFSMark(grid,i+1,j);
        DFSMark(grid,i-1,j);
        DFSMark(grid,i,j+1);
        DFSMark(grid,i,j-1);
    }
}
