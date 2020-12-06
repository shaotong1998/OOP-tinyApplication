/*
 *2020/12/5创建
 */
package Model;

import java.util.Calendar;

public class Ship {
    private int shipNumber;
    private String shipName;
    private double shipWeight;
    private Calendar dateOfBuilt;
    private int passengerCapacity;

    public int getShipNumber() {
        return shipNumber;
    }

    public void setShipNumber(int shipNumber) {
        this.shipNumber = shipNumber;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public double getShipWeight() {
        return shipWeight;
    }

    public void setShipWeight(double shipWeight) {
        this.shipWeight = shipWeight;
    }


    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
