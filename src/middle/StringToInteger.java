package middle;

import java.util.Arrays;

/**
 * 把字符串转换成整数
 * @author Slience
 * @date 2022/7/5 14:11
 **/
public class StringToInteger {

    public int strToInt2(String str) {
        //先去空格再判空，不然" "教您做人，血的教训
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        //然后我想啊，下面要判断首位了
        //首位合格的无非就'+'或'-'或数字三种情况，其他的一概滚蛋
        //'+''-'肯定是要把它去掉的，这样三种情况就统一了
        //当然了，'-abc'这种有可能出现，不过只看首位它是没毛病的
        //让它进来，反正后面很容易解决
        //既然要去掉正负号，那肯定要出个boolean记一下是不是负数
        boolean isMinus = false;
        char[] ch = str.toCharArray();
        //首位是不是正负号或者数字啊
        if(ch[0] == '+' || ch[0] == '-' || Character.isDigit(ch[0])){
            //是不是正负号啊
            if(ch[0] == '+' || ch[0] == '-'){
                //是不是负号啊
                if(ch[0] == '-'){
                    isMinus = true;
                }
                //删除首位
                ch = Arrays.copyOfRange(ch,1,ch.length);
            }
            //首位搞定了就看后面是不是数字了，直到不是数字的地方或者倒底结束
            int index = 0;
            //结果可能超int范围，拿个long接一下
            //'-abc'这种情况返回的也是0，舒服，一箭双雕
            long res = 0;
            //短路与助您远离空指针喔，铁汁们，先后顺序关注一下
            while(index < ch.length && Character.isDigit(ch[index])){
                //一位一位往上算
                res *= 10;
                res += ch[index] - '0';
                //及时止损，一看到res超int范围立马return
                //你要是想着最后一起算，那肯定会有超long范围的测试用例等着你，你就哭去吧
                if(res > Integer.MAX_VALUE){
                    //正负号看是正数负数，返回最大值
                    return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                //别忘了往后走一位
                index++;
            }
            //long转int就是这么朴实无华
            return isMinus ? -(int)res : (int)res;
        }
        //兄弟首位都不对想啥呢，回去吧您
        return 0;
    }

    public int strToInt(String str) {
        char[] charArr = str.trim().toCharArray();
        int startIndex = 0;
        boolean isNegative = false;
        //空字符串
        if(charArr.length == 0){
            return 0;
        }
        //首字符不符合要求
        if((charArr[startIndex] < '0' || charArr[startIndex] > '9') &&
                (charArr[startIndex] != '+' && charArr[startIndex] != '-')){
            return 0;
        }
        if(charArr[startIndex] == '-'){
            isNegative = true;
            startIndex++;
        } else if(charArr[startIndex] == '+'){
            startIndex++;
        }
        if(startIndex >= charArr.length || charArr[startIndex] > '9' || charArr[startIndex] < '0'){
            return 0;
        }
        //确定范围
        int endIndex = startIndex;
        for(int i = startIndex;i < charArr.length;i++){
            if((charArr[i] >'9' || charArr[i] < '0')){
                break;
            }
            endIndex++;
        }
        //endIndex会多一位，此时要多减1
        endIndex--;
        for(int i=startIndex;i<=endIndex;i++){
            if(charArr[i] == '0'){
                startIndex++;
            }else{
                break;
            }
        }
        if(startIndex >= charArr.length || startIndex > endIndex){
            return 0;
        }
        int length = endIndex - startIndex + 1;
        if(length < 10){
            StringBuilder sb = new StringBuilder();
            for(int i = startIndex;i <= endIndex; i++){
                sb.append(charArr[i]);
            }
            int res = Integer.parseInt(sb.toString());
            return isNegative ? -res : res;
        }
        if(length == 10){
            StringBuilder sb = new StringBuilder();
            for(int i = startIndex;i <= endIndex; i++){
                sb.append(charArr[i]);
            }
            if((sb.toString().compareTo("2147483647") >= 0 && !isNegative)){
                return Integer.MAX_VALUE;
            }
            if((sb.toString().compareTo("2147483648") >= 0 && isNegative)){
                return Integer.MIN_VALUE;
            }
            int res = Integer.parseInt(sb.toString());
            return isNegative ? -res : res;
        }
        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        StringToInteger temp = new StringToInteger();
        System.out.println(temp.strToInt2("+-1 2"));
    }

}
