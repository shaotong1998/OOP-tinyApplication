package Model.Sailor;
/*
 *2020/12/5创建
 */

import java.math.BigDecimal;

public class Sailors {
    private int identificationNumber;
    private String name;
    private String dateOfbirth;
    private BigDecimal salary;
    private String nationality;
    private String position;
    private boolean isSuperviser;

    public Sailors(int identificationNumber, String name, String dateOfbirth, String salary, String nationality, String position, boolean isSuperviser) {
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.salary = new BigDecimal(salary);
        this.nationality = nationality;
        this.position = position;
        this.isSuperviser = isSuperviser;
    }

    public Sailors() {

    }

    public boolean isSuperviser() {
        return isSuperviser;
    }

    public void setSuperviser(boolean superviser) {
        isSuperviser = superviser;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }



    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public String getSalary() {
        return salary.toString();
    }


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
