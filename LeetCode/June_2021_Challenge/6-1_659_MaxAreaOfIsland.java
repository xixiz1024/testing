// 695. Max Area of Island

// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.



class Solution {
	int[][] grid;
	private int areaOfIsland(int row, int col){
		if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0)
		return 0;

		grid[row][col]=0;
		return (1+ areaOfIsland(row-1,col) + areaOfIsland(row+1,col) +
				areaOfIsland(row, col-1)+areaOfIsland(row,col+1));

	}

    public int maxAreaOfIsland(int[][] grid) {
    	this.grid = grid;
    	// int[][] visited = new int[grid.length][grid[0].length];
    	int max=0;

    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(grid[i][j]==1)
    				max = Math.max(max, areaOfIsland(i,j));
    		}
    	}
    	return max;
    }
}





// Example 1:
// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.


// Example 2:

// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
grid[i][j] is either 0 or 1.