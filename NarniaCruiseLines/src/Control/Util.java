package Control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;

/*
 *2020/12/6创建by@Shaotong
 */
public class Util {
    //对于cruiseSerialNumber得到一次，set一次
    private static int cruiseSerialNumber = 0;
    private static  String[] port = {"QD","SH","HK","MK","AK","DA","CS","FB","QQ","VX"};
    private String tempDate;
    private int randomNumber;

    Util(){

    };

    /*
     * 对每次航行进行随机初始化
     */
    public static int getCruiseSerialNumber() {
        //这个值应该在本地读取
        cruiseSerialNumber++;
        return cruiseSerialNumber;
    }
    public static String getSailingDate(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        return gregorianCalendar.getTime().toString();
    }
    public static String getReturnDate(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.HOUR,(int)(Math.random()*1000));
        return gregorianCalendar.getTime().toString();
    }
    public static String getDeparturePort(){
            return port[((int)(Math.random()*100))%(port.length)];
    }

    public static String getRandomDateBefore(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(GregorianCalendar.HOUR,-((int)(Math.random())*10000));
        return gregorianCalendar.getTime().toString();
    }

    public void readTest() throws IOException {
        try(InputStream inputStream = new FileInputStream("T:\\coding\\OOP\\NarniaCruiseLines\\src\\Control\\Data\\Cruise.txt")){
        for(;;){
            int n = inputStream.read();
            if(n==-1){
                break;
            }
            System.out.println(n);
        }
        inputStream.close();
     }
    }



}
