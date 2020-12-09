package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 *2020/12/9创建
 *@author shaotong
 */
public class randomUtil {
    private int identificationNumber;
    private int name;
    private String dateOfbirth;
    private double salary;
    private String nationality;
    private String position;
    private boolean isSuperviser;



    public int getIdentificationNumber(){
        //应当与数据打交道
        return 1;
    }

    public int getName() {
        //如果已存人员中有这个人，就返回，否则随机生成
        return name;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public double getSalary() {
        return salary;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public boolean isSuperviser() {
        return isSuperviser;
    }
}
