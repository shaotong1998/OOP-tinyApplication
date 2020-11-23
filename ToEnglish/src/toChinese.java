import java.math.BigDecimal;
import java.util.ArrayList;

public class toChinese {
    private double number;
    private BigDecimal bigDecimal;
    private String[] digits = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
    private String[] tenToTwenty = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    private String[] tens = {"","Ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    private String[] numericalUnit = {"拾","佰","仟","萬","亿","quadrillion","quintillion "};
    toChinese(BigDecimal bg){
        this.bigDecimal = bg;
        //judge();
    }

    //核心逻辑
    public String bigNumber2Chinese(){
        long longBigDecimal = this.bigDecimal.longValue();
        //System.out.println(longBigDecimal);
        ArrayList<String> al = new ArrayList<String>();
        int numericalIndex = 0;
        String res = "";
        if(longBigDecimal<1000){
            return judge((int)longBigDecimal) + "\tand\t" + getDecimal();
        }
        while(longBigDecimal/1000>0){
            long num = longBigDecimal % 1000;
            String string = judge((int)num);
            if(numericalIndex==0) {
                if(string.equals("ZERO")){
                    al.add("");
                }
                else {
                    al.add(string + " " + this.numericalUnit[numericalIndex] + "and");
                }
            }
            else{
                if(string.equals("ZERO")){
                    al.add("");
                }
                else {
                    al.add(string + " " + this.numericalUnit[numericalIndex] + ",");
                }
            }
            numericalIndex++;
            longBigDecimal = (longBigDecimal-num)/1000;
            if(longBigDecimal<1000){
                al.add(judge((int)longBigDecimal)+" "+this.numericalUnit[numericalIndex+1]+",");
            }
        }

        for(int i = al.size();i > 0;i--){
            res = res + al.get(i-1);
        }
        return res +" "+ getDecimal();
    }
    //把大数分解成一到多个小于1000的数据，可以重复利用judge方法
    public String judge(int num){
        if(num<=10){
            return getDigits(num).toUpperCase();
        }
        if(10<num && num<100){
            return getTen(num).toUpperCase();
        }
        if(100<=num && num<1000){
            int ten = num % 100;
            int hundred = (num - ten)/100;

            return getDigits(hundred).toUpperCase() +" Hundred " +getTen(ten).toUpperCase();
        }
        return "";
    }

    private String getDigits(int num){
        return this.digits[num];
    }
    private String getTen(int num){
        //要加上个位数
        //末尾为0就不要输出zero了！
        if(num == 0){//比如200 只返回2hundred
            return "";
        }
        if(0<num && num<10){
            return this.digits[num];
        }
        //上下都不包括10
        if(10<num && num<20){
            return this.tenToTwenty[num-11];
        }
        int a = num;
        int digit = a % 10;
        int ten = (a - digit)/10;
        if(digit==0){
            return this.tens[ten];
        }
        return  tens[ten] + "-" + getDigits(digit);
    }

    private String getDecimal(){
        //首先得到小数的精度
        //使用int还是会出现越界的问题
        long scale = this.bigDecimal.scale();
        long pow = (long) Math.pow(10,scale);
        BigDecimal bg = new BigDecimal(pow);
        long fnum = this.bigDecimal.multiply(bg).longValue() % pow;
        return fnum + "/" + pow;
    }


}

/**
 * pow用法：https://www.runoob.com/java/number-pow.html
 */
