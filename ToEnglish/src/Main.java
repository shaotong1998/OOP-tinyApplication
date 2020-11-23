import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            String bigDecimal = null;
            System.out.println("Please enter a dollar amount:");
            Scanner scan = new Scanner(System.in);
            if (scan.hasNext()) {
                bigDecimal = scan.next();
            }
            BigDecimal a = new BigDecimal(bigDecimal);

            toEnglish t = new toEnglish(a);
            String answer = t.bigNumber2English();
            System.out.println("Dollar amount in words:"+answer);
            System.out.println();
        }
//        BigDecimal bd = new BigDecimal("649846513123.152016155605");
//        toEnglish t = new toEnglish(bd);
//        String a = t.bigNumber2English();
//        System.out.println(a);

    }
}




/**参考资料
 * double/float不能用来表示精确的金额？https://www.runoob.com/java/java-basic-datatypes.html
 *                                https://blog.csdn.net/qq_40147863/article/details/99687726
 *BigDecimal用法https://www.liaoxuefeng.com/wiki/1252599548343744/1279768011997217
 *          API http://www.javaweb.cc/help/JavaAPI1.6/java/math/class-use/BigDecimal.html
 */


/*
2020/11/22 19：15修改：TEN Trillion,ZERO Million,ZERO Thousand,ZERO and 1526515/10000000
"10100000001.1526515"

*/
