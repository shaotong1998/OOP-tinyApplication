import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class toChinese {
    private BigDecimal bigDecimal;
    //private BigDecimal bigDecimal2;
    private String[] digits = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
    private String[] numericalUnit = {"拾","佰","仟","萬","亿","兆","京","垓","秭","穰","沟","涧","正","载","极","恒河沙","阿僧祇","那由他","不可思议","无量大数","*","*","*","*","*","*","*","*","*","*","*","*","*"};
    private BigDecimal decimal10000 = new BigDecimal("10000");
    private BigDecimal decimal1 = new BigDecimal("1");
    private String number;//该字符的string形式
    toChinese(BigDecimal bg){
        this.bigDecimal = bg;
        this.number = bg.toPlainString();
    }

    //核心逻辑
    public String bigNumber2Chinese(){
        ArrayList<String> al = new ArrayList<String>();
        int numericalIndex = 0;
        String res = "";

        //小于一万的情况单独考虑
        if(this.bigDecimal.compareTo(this.decimal10000)==-1){
            if(this.bigDecimal.intValue() == 0){
                return "零 " + getDecimal();
            }
            return judge(this.bigDecimal.intValue()) +" "+ getDecimal();
        }

        while(this.bigDecimal.divide(this.decimal10000).compareTo(this.decimal1)==1 || this.bigDecimal.divide(this.decimal10000).compareTo(this.decimal1)==0){
            BigDecimal num = this.bigDecimal.remainder(this.decimal10000);
            //num一定是一个10000以内的数，所以精度不会丢失
            String string = judge(num.intValue());
            if(numericalIndex==0) {
                al.add(string);
                numericalIndex = 2;
            }
            else {
                if(num.intValue()==0){
                    al.add("");
                }else {
                    al.add(string + this.numericalUnit[numericalIndex] + " ");
                }

            }
            numericalIndex++;
            this.bigDecimal = this.bigDecimal.subtract(num).divide(this.decimal10000);
            if(this.bigDecimal.compareTo(this.decimal10000)==-1){
                //只要末尾有零就把他的map值设置为1
                if(bigDecimal.intValue()%10==0){
                }
                al.add(judge(bigDecimal.intValue())+this.numericalUnit[numericalIndex]+" ");
            }
        }

        for(int i = al.size();i > 0;i--){
            //从前往后！ 1.首先考虑最后全为零的情况
//            System.out.println(map);
//            if(map.get(i-1)>0&&map.get(i)!=4){
//                res = res + al.get(i-1) + "零";
//            }
//            else {
//                res = res + al.get(i - 1);
//            }
            res = res + al.get(i - 1);
        }
        return res +" "+ getDecimal();
    }

    //把大数分解为0~10000的数 可以重复使用
    public String judge(int num){
        if(num==0){
            return "";
        }
        if(num<=10){
            return getDigits(num);
        }
        if(10<num && num<100){
            return getTen(num);
        }
        if(100<=num && num<1000){
            return getHundred(num);
        }
        return getThousand(num);
    }

    //得到个位数
    private String getDigits(int num){
        return this.digits[num];
    }

    //10-20要单独考虑
    private String getTen(int num){
        if(num == 0){//比如200 只返回2hundred
            return "";
        }
        if(10< num && num<100){
            int digit = num % 10;
            int ten = (num-digit)/10;
            if(digit==0){
                return this.digits[ten] + this.numericalUnit[0];
            }
            else{
                return this.digits[ten] + this.numericalUnit[0] + this.digits[digit];
            }
        }
        return "";
    }

    //中间是0怎么办！
    private String getHundred(int num){
        int digit = num % 100;
        int hund = (num - digit)/100;
        if(digit == 0){
            return this.digits[hund] + this.numericalUnit[1];
        }
        if(0<digit && digit<10){//叁佰一十
            return this.digits[hund] + this.numericalUnit[1] + "零" + this.digits[digit];
        }
        return this.digits[hund] + this.numericalUnit[1] + getTen(digit);
    }

    private String getThousand(int num){
        int digit = num%1000;
        int thou = (num-digit)/1000;
        if(digit==0){
            return this.digits[thou] + this.numericalUnit[2];
        }
        if(0<digit&&digit<100){
            return this.digits[thou] + this.numericalUnit[2]+"零" + getTen(digit);
        }
        //三千一
        return this.digits[thou] + this.numericalUnit[2] + getHundred(digit);
    }

    private String getDecimal(){
        //要考虑0的情况
        StringTokenizer s = new StringTokenizer(this.number,".");
        s.nextToken();
        if(!s.hasMoreTokens()){
            return "";
        }
        //decimal即为需要的小数部分
        String decimal = s.nextToken();

        String res ="";
        for(int i =0;i<decimal.length() ;i++){
           res = res + digits[ Integer.parseInt(decimal.substring(i,i+1))]  ;
        }

        return "点 " + res;
    }

}


/**
 * 维基百科：https://zh.wikipedia.org/wiki/%E5%85%86
 * pow用法：https://www.runoob.com/java/number-pow.html
 * StringTokenizer使用：https://www.cnblogs.com/gaopeng527/p/4899237.html
 * 类型转换：https://blog.csdn.net/u012050154/article/details/51320638
 */
