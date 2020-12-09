package DAO;

import Model.Sailor.Captain;
import Model.Sailor.Sailors;

import java.util.ArrayList;

/*
 *2020/12/8创建by@Shaotong
 * 管理数据
 */
public class SailorsData {
    private Sailors sailors;

    public static ArrayList<Sailors> randomSailors(){
        ArrayList<Sailors> sailors = new ArrayList<Sailors>();
        //一到三名船长
        int captainNumber = (int)(Math.random()*10%3) + 1;
        for(int i = 0;i<captainNumber;i++){
            Sailors captain = new Captain();
        }
        return sailors;
    }
}
