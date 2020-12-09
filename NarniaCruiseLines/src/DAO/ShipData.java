package DAO;

import Control.Util;
import Model.Ship;
import jdk.jfr.SettingControl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*
 *2020/12/8创建by@Shaotong
 */
public class ShipData {
    private static  String[] shipName = {"TY","SJ","JS","C++","Python","Java","C#","QQ","Wechat"};
    private static  Ship ship;
    public ShipData(){};

    public void readData() throws IOException {
        try{
            BufferedReader in = new BufferedReader(new FileReader(Setting.ShipText));
            String str ;
            while ((str = in.readLine())!=null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Ship randomShip(){
        ship.setShipName(shipName[(int)((Math.random()*100) % shipName.length)]);
        ship.setDateOfBuilt(Util.getRandomDateBefore());
        ship.setPassengerCapacity((int)(Math.random()*10000));
        ship.setShipNumber((int)(Math.random()*1000));
        ship.setShipWeight(Math.random()*1000000);
        return ship;
    }
}



/*
参考资料：
读文件：https://www.runoob.com/java/file-read.html
 */