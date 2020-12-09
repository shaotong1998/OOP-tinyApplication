import DAO.SailorsData;
import DAO.Setting;
import DAO.randomUtil;
import Model.Sailor.Sailors;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  {

        BigDecimal bigDecimal = new BigDecimal("4050.0");
        Sailors sailors = new Sailors(5,"Kris","1998",bigDecimal,"CN","Cooker",true);
        String t = " ";
        String str = sailors.getIdentificationNumber() +t+ sailors.getName()+t+sailors.getDateOfbirth()+t+sailors.getSalary();
        str = str +t+ sailors.getNationality()+t+sailors.getPosition()+t+sailors.isSuperviser()+"\n";
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter(Setting.testText,true);
            for(int i =0;i<100;i++){
                fileWriter.write(str);
                fileWriter.write(str);
            }
            fileWriter.write(str);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

