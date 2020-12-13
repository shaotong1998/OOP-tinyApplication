package DAO;

import Model.Sailor.Sailors;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.StringTokenizer;

/*
 *2020/12/9创建
 *@author shaotong
 */
public class randomUtil {
    private int identificationNumber;
    private String name;
    private String dateOfbirth;
    private String[] salary = {"300000","80000","50000","80000","50000"};
    //private double salary;
    private String[] nation = {"中国","日本","美国","韩国","朝鲜","越南","澳大利亚","新加坡","澳大利亚","加拿大","印度","英国","泰国","缅甸","俄罗斯"};
    private String nationality;
    private String[] pos = {"Captain","Cook","Doctor","Engineer","Sailor"};
   // private String position;
    boolean  isSuperviser;

    public void randomGenerateSailor() throws IOException {
        int lastNumber = SailorsData.findLastId();
        FileWriter fileWriter;
        fileWriter = new FileWriter(Setting.SailorsText,true);
        //fileWriter.write("\n");

        for(int i= 0;i<2500;i++){
            lastNumber++;
            String name = Setting.getRandomChara().substring(i,i+2).toUpperCase();
            //随机的日期
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(GregorianCalendar.YEAR,1950+(int)(Math.random()*100%60));
            gregorianCalendar.add(GregorianCalendar.MONTH,(int)(Math.random()*100%12));
            String dateOfbirth = simpleDateFormat.format(gregorianCalendar.getTime());
            //随机的国家
           int length = nation.length;
           int randomNaIndex = (int)(Math.random()*100%length);
           String national = this.nation[randomNaIndex];
           //随机的职位
            int randomPosIndex = (int)(Math.random()*10%this.pos.length);
            String postion = this.pos[randomPosIndex];
            //随机是否为supervisor
           Boolean randomBool = getRandomBoolean();
            //工资根据职位和是否为supervisor来决定
           String salary;
           if(randomBool = true && randomPosIndex==4){
                String baseSalary = this.salary[randomPosIndex];
                BigDecimal salar = new BigDecimal(baseSalary);
                BigDecimal mul = new BigDecimal("1.2");
                salary = salar.multiply(mul).toString();
           }
           else{
               salary = this.salary[randomPosIndex];
           }
           //用这些数据创建一个类
            String t = " ";
            String str = lastNumber +t+ name+t+dateOfbirth+t+salary;
            str = str +t+ national+t+postion+t+randomBool+"\n";
            fileWriter.write(str);

        }
        fileWriter.close();

    }
    public Boolean getRandomBoolean(){
        //大概五分之一的概率返回true；
        double tem = 0.2;
        if(Math.random()<tem){
            return true;
        }
        return false;
    }

    public int getIdentificationNumber(){
        //应当与数据打交道
        return 1;
    }

    public String getName() {
        //如果已存人员中有这个人，就返回，否则随机生成
        return name;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }



    public String getNationality() {
        return nationality;
    }


    public boolean isSuperviser() {
        return isSuperviser;
    }
}
