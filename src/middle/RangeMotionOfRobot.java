package middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 机器人的范围运动
 * @author Slience
 * @date 2022/5/19 14:19
 **/
public class RangeMotionOfRobot {

    public static void main(String[] args) {
        System.out.println(movingCount(38,15,9));
    }

    private static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    /**
     * 深度优先遍历
     * @author Slience
     * @date 2022/5/19 16:48
     **/
    private static int dfs(int i, int j, int m, int n , int k, boolean[][] visited){
        if(i < 0 || j < 0 || i>=m || j >= n || visited[i][j] || add(i) + add(j) > k){
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i-1, j, m ,n ,k ,visited) + dfs(i+1, j, m, n, k, visited) +
                dfs(i, j+1, m, n, k, visited) + dfs(i, j-1, m, n, k, visited);
    }

    /**
     * 广度优先遍历
     * @author Slience
     * @date 2022/5/19 16:49
     **/
    private static int bfs(int m, int n, int k){
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        int res = 1;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            //向右和向下探索
            for(int i = 0; i < 2;i++){
                int mx = cell[0] + dx[i];
                int my = cell[1] + dy[i];
                if(mx < 0 || my < 0 || mx >= m || my >= n || visited[mx][my] || add(mx) + add(my) > k){
                    continue;
                }else{
                    res++;
                    visited[mx][my] = true;
                    queue.offer(new int[]{mx,my});
                }
            }
        }
        return res;
    }

    private static int add(int num){
        int res = 0;
        while(num != 0){
            res += num % 10;
            num = num /10;
        }
        return res;
    }

}
