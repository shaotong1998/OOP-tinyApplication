import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class toEnglish {
    private double number;
    private BigDecimal bigDecimal;
    private BigDecimal bigDecimal2;
    private String[] digits = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
    private String[] tenToTwenty = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    private String[] tens = {"","Ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    private String[] numericalUnit = {"","Thousand","Million","Billion","Trillion","quadrillion","quintillion","sextillion","septillion","octillion","nonillion","decillion"};
    private BigDecimal decimal1000 = new BigDecimal("1000");
    private BigDecimal decimal0 = new BigDecimal("1");

    toEnglish(BigDecimal bg){
        this.bigDecimal = bg;
        this.bigDecimal2 = bg;
        //judge();
    }
    //核心逻辑
    public String bigNumber2English(){
        //long longBigDecimal = this.bigDecimal.longValue();
        //System.out.println(longBigDecimal);
        ArrayList<String> al = new ArrayList<String>();
        int numericalIndex = 0;
        String res = "";

        //-1是小于 1是大于
        if(this.bigDecimal.compareTo(this.decimal1000)==-1){
            return judge(this.bigDecimal.intValue()) + "\tand\t" + getDecimal();
        }
        //while(longBigDecimal/1000>0){
        //this.bigDecimal.divide(this.decimal1000).longValue()>0
        //QQQ:6/1000compare0 = 1?
        while(this.bigDecimal.divide(this.decimal1000).compareTo(this.decimal0)==1){
//            System.out.println(this.bigDecimal.divide(this.decimal1000).compareTo(this.decimal0));
//            BigDecimal t = new BigDecimal("0.6");
//            System.out.println(t.compareTo(this.decimal0));
            //long num = longBigDecimal % 1000;
            BigDecimal num = this.bigDecimal.remainder(this.decimal1000);
            //num一定是一个1000以内的数，所以精度不会丢失
            String string = judge(num.intValue());
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
            //longBigDecimal = (longBigDecimal-num)/1000;
            this.bigDecimal = this.bigDecimal.subtract(num).divide(this.decimal1000);

            if(this.bigDecimal.compareTo(this.decimal1000)==-1){
                al.add(judge(bigDecimal.intValue())+" "+this.numericalUnit[numericalIndex]+",");
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
        long scale = this.bigDecimal2.scale();
        long pow = (long) Math.pow(10,scale);
        BigDecimal bg = new BigDecimal(pow);
        BigDecimal fn;
        //fn = this.bigDecimal2.multiply()
        fn = this.bigDecimal2.multiply(bg).remainder(bg);
        //long fnum = this.bigDecimal2.multiply(bg).longValue() % pow;
        return fn.longValue() + "/" + pow;
    }


}

/**
 * pow用法：https://www.runoob.com/java/number-pow.html
 * bigDecimal加减乘除运算https://blog.csdn.net/haiyinshushe/article/details/82721234
 */
