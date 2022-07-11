package middle;

/**
 * 礼物的最大价值
 * @author Slience
 * @date 2022/7/11 14:46
 **/
public class MaxValueOfPresent {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i< rows; i++){
            for (int j = 0; j< cols; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    grid[i][j] += grid[i][j - 1];
                    continue;
                }
                if(j == 0){
                    grid[i][j] += grid[i - 1][j];
                    continue;
                }
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
