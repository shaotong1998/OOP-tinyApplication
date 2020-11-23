public abstract class Fighter {
    private String name;
    private double accurate;
    private boolean isAlive;
    private int numberOfWin = 0;

    public abstract void shootAtTarget(Fighter target);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccurate() {
        return accurate;
    }

    public void setAccurate(double accurate) {
        this.accurate = accurate;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getNumberOfWin() {
        return numberOfWin;
    }

    public void setNumberOfWin(int numberOfWin) {
        this.numberOfWin = numberOfWin;
    }
}
