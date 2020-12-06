package Model;

import java.math.BigDecimal;

/*
 *2020/12/5创建by@Shaotong
 */
public class Ports {
    private String portName;
    private String portCountry;
    private long portPopulation;
    private boolean isRequirePassport;
    private BigDecimal dockingFee;

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortCountry() {
        return portCountry;
    }

    public void setPortCountry(String portCountry) {
        this.portCountry = portCountry;
    }

    public long getPortPopulation() {
        return portPopulation;
    }

    public void setPortPopulation(long portPopulation) {
        this.portPopulation = portPopulation;
    }

    public boolean isRequirePassport() {
        return isRequirePassport;
    }

    public void setRequirePassport(boolean requirePassport) {
        isRequirePassport = requirePassport;
    }

    public BigDecimal getDockingFee() {
        return dockingFee;
    }

    public void setDockingFee(BigDecimal dockingFee) {
        this.dockingFee = dockingFee;
    }
}
