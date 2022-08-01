package hard;

import java.util.*;

/**
 * 网格照明
 * @author Slience
 * @date 2022/7/12 14:58
 **/
public class GridIllumination {

    public static void main(String[] args) {
        GridIllumination temp = new GridIllumination();
//        System.out.println(Arrays.toString(temp.gridIllumination(5,
//                new int[][]{{2, 5}, {4, 2},{0,3},{0,5},{1,4},{4,2},{3,3},{1,0}},
//                new int[][]{{4, 3}, {3, 1},{5,3},{0,5},{4,4},{3,3}})));
        System.out.println(Arrays.toString(temp.gridIllumination(6,
                new int[][]{{1,1}},new int[][]{{2,0},{1,0}})));
    }

    int[][] dirs = new int[][]{{0,0},{0,-1},{0,1},{-1,0},{-1,-1},{-1,1},{1,0},{1,-1},{1,1}};
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;
        Map<Integer, Integer> row = new HashMap<>(), col = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for (int[] l : lamps) {
            int x = l[0], y = l[1];
            int a = x + y, b = x - y;
            if (set.contains(x * N + y)) continue;
            increment(row, x); increment(col, y);
            increment(left, a); increment(right, b);
            set.add(x * N + y);
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int x = q[0], y = q[1];
            int a = x + y, b = x - y;
            if (row.containsKey(x) || col.containsKey(y) || left.containsKey(a) || right.containsKey(b))
                ans[i] = 1;
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                int na = nx + ny, nb = nx - ny;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (set.contains(nx * N + ny)) {
                    set.remove(nx * N + ny);
                    decrement(row, nx); decrement(col, ny);
                    decrement(left, na); decrement(right, nb);
                }
            }
        }
        return ans;
    }
    void increment(Map<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    void decrement(Map<Integer, Integer> map, int key) {
        if (map.get(key) == 1) map.remove(key);
        else map.put(key, map.get(key) - 1);
    }

    //时间太长
    @Deprecated
    public int[] gridIlluminationDeprecated(int n, int[][] lamps, int[][] queries) {
        int index = 0;
        int[] res = new int[queries.length];
        //灯光初始化
        List<String> light = new ArrayList<>();
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            String location = x + "," + y;
            light.add(location);
        }

        for(int i = 0;i < queries.length;i++){
            boolean flag = false;
            //获取坐标
            int x = queries[i][0];
            int y = queries[i][1];
            for(String location : light){
                int lampX = Integer.parseInt(location.split(",")[0]);
                int lampY = Integer.parseInt(location.split(",")[1]);
                if(x == lampX || y == lampY || Math.abs(x-lampX) == Math.abs(y-lampY)){
                    flag = true;
                    break;
                }
            }
            //灭灯
            if(flag){
                List<String> noLight = new ArrayList<>();
                noLight.add(x + "," + y);
                noLight.add((x-1) + "," + y);
                noLight.add((x+1) + "," + y);
                noLight.add(x + "," + (y-1));
                noLight.add(x + "," + (y+1));
                noLight.add((x-1) + "," + (y+1));
                noLight.add((x-1) + "," + (y-1));
                noLight.add((x+1) + "," + (y-1));
                noLight.add((x+1) + "," + (y+1));
                for(String no : noLight){
                    light.remove(no);
                    light.remove(no);
                }
            }
            res[index++] = flag ? 1 : 0;
        }
        return res;
    }

}
