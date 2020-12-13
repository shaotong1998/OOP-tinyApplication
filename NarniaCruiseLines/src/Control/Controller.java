package Control;

import DAO.SailorsData;
import DAO.Setting;
import DAO.ShipData;
import Model.Cruise;
import Model.Sailor.Sailors;
import Model.Ship;

import java.io.IOException;
import java.util.ArrayList;

/*
 *2020/12/6创建by@Shaotong
 */
public class Controller {
    public Controller(){};
    //mission1：随机的创建一条航线
    public void createCruiseRandomly() throws IOException {
        Cruise cruise = new Cruise();
        cruise.setCruiseSerialNumber(Util.getCruiseSerialNumber());
        cruise.setDeparturePort(Util.getDeparturePort()); ;
        cruise.setSailingDate(Util.getSailingDate());
        cruise.setReturnDate(Util.getReturnDate());
        //初始化一艘船，n个水手，n个港口
        Ship ship = ShipData.randomShip();
        cruise.setShip(ship);
        //船确定了，船上的人数也就确定了。船员可以为总人数的百分之十
        int shipPassenger = ship.getPassengerCapacity();
        int sailorNumber = (int) (shipPassenger * Setting.SailorsRatio);
        int allSalior = SailorsData.findLastId();//共有这么多人
        ArrayList<Sailors> sailors= new ArrayList<Sailors>(sailorNumber);
        for(int i = 0;i<sailorNumber;i++){
            //暂时不考虑一艘船上有几个个船长，！！！！不能出现一样的随机数
            int randomID = (int)(Math.random() * 10000 % allSalior);
            Sailors s = SailorsData.readSailorByID(randomID);
            sailors.add(s);
        }
        cruise.setSailors(sailors);
        //就剩下港口没确定了
    }

}
