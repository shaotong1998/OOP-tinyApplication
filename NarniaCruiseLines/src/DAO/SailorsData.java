package DAO;

import Model.Sailor.Captain;
import Model.Sailor.Sailors;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *2020/12/8创建by@Shaotong
 * 管理数据
 */
public class SailorsData {
    private Sailors sailors;
    private Setting setting;

    public static ArrayList<Sailors> randomSailors(){
        //根据查找数据创建一个对象
        ArrayList<Sailors> sailors = new ArrayList<Sailors>();
        //随机数目的员工，把资格不符合的删除，缺少的项加上
        int captainNumber = (int)(Math.random()*10%3) + 1;
        for(int i = 0;i<captainNumber;i++){
            Sailors captain = new Captain();
        }
        return sailors;
    }

    /*
     * 寻找最大的id
     */
    public static int findLastId() throws IOException {
        try{
            BufferedReader in = new BufferedReader(new FileReader(Setting.SailorsText));
            String str ;
            int tem = 0;
            while((str = in.readLine())!=null){
                    tem++;
            }
            return tem;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*
     *需要从文件内读取并创建一个对象
     */
    public static Sailors readSailorByID(int id) throws IOException {
        try{
            BufferedReader in = new BufferedReader(new FileReader(Setting.SailorsText));
            String str ;
//            while ((str = in.readLine())!=null){
//                System.out.println(str);
//            }
            //遍历整个数据，知道找到目标ID
            //按行读取
            while((str = in.readLine())!=null){
                StringTokenizer st = new StringTokenizer(str);
                int identificationNumber = Integer.parseInt(st.nextToken());
                if(identificationNumber == id){
                    //int identificationNumber = Integer.getInteger(str);
                    String name = st.nextToken();
                    String dateOfbirth = st.nextToken();
                   // double salary = Double.parseDouble(st.nextToken());
                    BigDecimal salary = new BigDecimal(st.nextToken());
                    String nationality = st.nextToken();
                    String position = st.nextToken();
                    boolean isSuperviser= Boolean.parseBoolean(st.nextToken());
                    Sailors sailors = new Sailors(identificationNumber,name,dateOfbirth,salary.toString(),nationality,position,isSuperviser);
                    in.close();
                    return sailors;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
     * 使用FileWriter写文件
     */
    public void writeSailors(Sailors sailors){
        String t = " ";
        String str = sailors.getIdentificationNumber() +t+ sailors.getName()+t+sailors.getDateOfbirth()+t+sailors.getSalary();
        str = str +t+ sailors.getNationality()+t+sailors.getPosition()+t+sailors.isSuperviser()+"\n";
        //System.out.println(str);
        FileWriter fileWriter;
        try{
            fileWriter = new FileWriter(Setting.SailorsText,true);
            fileWriter.write(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }








}
