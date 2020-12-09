package Control;

import DAO.ShipData;
import Model.Cruise;
import Model.Sailor.Sailors;
import Model.Ship;

import java.util.ArrayList;

/*
 *2020/12/6创建by@Shaotong
 */
public class Controller {
    public Controller(){};
    //mission1：随机的创建一条航线
    public void createCruiseRandomly(){
        Cruise cruise = new Cruise();
        cruise.setCruiseSerialNumber(Util.getCruiseSerialNumber());
        cruise.setDeparturePort(Util.getDeparturePort()); ;
        cruise.setSailingDate(Util.getSailingDate());
        cruise.setReturnDate(Util.getReturnDate());
        //初始化一艘船，n个水手，n个港口
        Ship ship = ShipData.randomShip();
        cruise.setShip(ship);
        //船确定了，船上的人数也就确定了
        int shipPassenger = ship.getPassengerCapacity();
        ArrayList<Sailors> sailors= new ArrayList<Sailors>();
    }

}
