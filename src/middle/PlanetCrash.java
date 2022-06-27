package middle;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * 小行星碰撞
 * @author Slience
 * @date 2022/6/22 14:20
 **/
public class PlanetCrash {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i : asteroids){
            stack.push(i);
        }
        Stack<Integer> res = crash(stack);
        int size = res.size();
        int[] arr = new int[size];
        for(int i=0; i< size;i++){
            arr[i] = res.pop();
        }
        return arr;
    }

    private Stack<Integer> crash(Stack<Integer> stack){
        Stack<Integer> res = new Stack<>();
        res.push(stack.pop());
        while(!stack.isEmpty()){
            int survivor = res.pop();
            int challenger = stack.pop();
            //撞击
            if(challenger > 0 &&  survivor< 0){
                if(challenger > Math.abs(survivor)){
                    survivor = challenger;
                    while(true){
                        //重置挑战者
                        challenger = 0;
                        if(res.size() == 0){
                            break;
                        }
                        challenger = res.pop();
                        if(survivor * challenger > 0){
                            res.push(challenger);
                            break;
                        }
                        if(survivor > 0 && challenger < 0){
                            if(survivor < Math.abs(challenger)){
                                survivor = challenger;
                            }
                            if(survivor == Math.abs(challenger)){
                                if(stack.isEmpty()){
                                    survivor = 0;
                                    break;
                                }
                                survivor = stack.pop();
                            }
                        }
                        if(survivor < 0 && challenger > 0){
                            res.push(challenger);
                            break;
                        }
                    }
                    if(survivor!=0){
                        res.push(survivor);
                    }
                    continue;
                }
                else if(challenger == Math.abs(survivor)){
                    if(stack.isEmpty()){
                        continue;
                    }
                    survivor = stack.pop();
                    while(true){
                        //重置挑战者
                        challenger = 0;
                        if(res.size() == 0){
                            break;
                        }
                        challenger = res.pop();
                        if(survivor * challenger > 0){
                            res.push(challenger);
                            break;
                        }
                        if(survivor > 0 && challenger < 0){
                            if(survivor < Math.abs(challenger)){
                                survivor = challenger;
                            }
                            if(survivor == Math.abs(challenger)){
                                if(stack.isEmpty()){
                                    survivor = 0;
                                    break;
                                }
                                survivor = stack.pop();
                            }
                        }
                        if(survivor < 0 && challenger > 0){
                            res.push(challenger);
                            break;
                        }
                    }
                    if(survivor != 0){
                        res.push(survivor);
                    }
                    continue;
                }else{
                    res.push(survivor);
                    continue;
                }
            }
            //同方向
            if(survivor * challenger > 0){
                res.push(survivor);
                res.push(challenger);
                continue;
            }
            //反方向
            if(challenger < 0 && survivor > 0){
                res.push(survivor);
                res.push(challenger);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,2,-5};
        PlanetCrash temp = new PlanetCrash();
        System.out.println(Arrays.toString(temp.asteroidCollision(arr)));
    }

}
