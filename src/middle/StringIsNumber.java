package middle;

/**
 * 表示数值的字符串
 * @author Slience
 * @date 2022/7/6 13:41
 **/
public class StringIsNumber {
    public boolean isNumber(String s) {
        char[] arr = s.trim().toCharArray();
        //e与.都具有唯一性
        boolean dotFlag = false, eFlag = false;
        //排除空字符串的结果
        if(0 == arr.length){
            return false;
        }
        //开始筛选
        int startIndex = 0;
        //判断符号
        if(arr[0] > '9' || arr[0] < '0'){
            if(arr[0] == '+' || arr[0] == '-'){
                startIndex++;
            }else if(arr[0] == '.'){
                startIndex++;
                dotFlag = true;
            } else{
                return false;
            }
        }
        if(startIndex == arr.length){
            return false;
        }
        for(int i=startIndex; i<arr.length; i++){
            if(!eFlag){
                //e前，e为合法字符
                if(!Character.isDigit(arr[i]) && arr[i] != 'e' && arr[i] != 'E' && arr[i] != '.'){
                    return false;
                }
            }else{
                //e后，e和小数点均为非法字符
                if(!Character.isDigit(arr[i])){
                    return false;
                }
            }
            //小数点与e唯一
            if((dotFlag && arr[i] == '.')){
                return false;
            }
            //小数点处理，仅处理特殊情况，常规情况可由前面判断
            if(arr[i] == '.'){
                dotFlag = true;
                //排除仅存在小数点的情况
                if(i == startIndex && i == arr.length - 1){
                    return false;
                }
                //小数点在最后
                if(i == arr.length - 1){
                    if(!Character.isDigit(arr[i-1])){
                        return  false;
                    }
                }
                //小数点在开始
                if(i == startIndex){
                    if(!Character.isDigit(arr[i+1])){
                        return false;
                    }
                }
            }
            //e处理，也仅处理特殊情况
            if(arr[i] == 'e' || arr[i] == 'E'){
                eFlag = true;
                //e必定在两个数字之间
                if(i == startIndex || i == arr.length - 1){
                    return false;
                }
                //判断e后整数是否存在符号
                if(arr[i+1] == '+' || arr[i+1] == '-'){
                    if(i+1 != arr.length - 1){
                        i++;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringIsNumber temp = new StringIsNumber();
        System.out.println(temp.isNumber(".1.2"));
    }

}
