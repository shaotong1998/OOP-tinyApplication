import java.math.BigDecimal;
import java.util.ArrayList;

public class toChinese {
    private double number;
    private BigDecimal bigDecimal;
    private String[] digits = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
    private String[] numericalUnit = {"拾","佰","仟","萬","亿","兆","京"};
    private BigDecimal decimal10000 = new BigDecimal("10000");
    private BigDecimal decimal1 = new BigDecimal("1");
    toChinese(BigDecimal bg){
        this.bigDecimal = bg;
    }

    //核心逻辑
    public String bigNumber2Chinese(){
        ArrayList<String> al = new ArrayList<String>();
        int numericalIndex = 0;
        String res = "";

        //小于一万的情况单独考虑
        if(this.bigDecimal.compareTo(this.decimal10000)==-1){
            return judge(this.bigDecimal.intValue()) + getDecimal();
        }

        while(this.bigDecimal.divide(this.decimal10000).compareTo(this.decimal1)==1 ||this.bigDecimal.divide(this.decimal10000).compareTo(this.decimal1)==0){
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
                al.add(judge(bigDecimal.intValue())+this.numericalUnit[numericalIndex]+" ");
            }
        }

        for(int i = al.size();i > 0;i--){
            res = res + al.get(i-1);
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
 * 维基百科：https://zh.wikipedia.org/wiki/%E5%85%86
 * pow用法：https://www.runoob.com/java/number-pow.html
 */
