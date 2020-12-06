package Model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/*
 *2020/12/5创建by@Shaotong
 * 理解：对于乘客来说需要保存已完成的航线花的钱，以及对该航线的评价
 * 每次航行的号是唯一的！
 */
public class Passenger {
    private int passengerId;
    private String passengerName;
    private String passengerHomeAddress;
    private String passengerNationality;
    private Calendar passengerDateOfBirth;
    private BigDecimal moneySpentOnCruise;
    private HashMap<Integer,BigDecimal> historySpent;
    private HashMap<Integer,Integer> historyRating;


    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerHomeAddress() {
        return passengerHomeAddress;
    }

    public void setPassengerHomeAddress(String passengerHomeAddress) {
        this.passengerHomeAddress = passengerHomeAddress;
    }

    public String getPassengerNationality() {
        return passengerNationality;
    }

    public void setPassengerNationality(String passengerNationality) {
        this.passengerNationality = passengerNationality;
    }


    public BigDecimal getMoneySpentOnCruise() {
        return moneySpentOnCruise;
    }

    public void setMoneySpentOnCruise(BigDecimal moneySpentOnCruise) {
        this.moneySpentOnCruise = moneySpentOnCruise;
    }
}
