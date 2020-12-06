package Model.Sailor;
/*
 *2020/12/5创建
 */

public class Sailors {
    private int identificationNumber;
    private int name;
    private String dateOfbirth;
    private double salary;
    private String nationality;
    private String position;
    private boolean isSuperviser;

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

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
