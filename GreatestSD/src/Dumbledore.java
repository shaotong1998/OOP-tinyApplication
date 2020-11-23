public class Dumbledore extends Fighter{
    Dumbledore(){
        setName("Dumbledore");
        setAccurate(1);
        setAlive(true);
    }
    @Override
    public void shootAtTarget(Fighter target) {
        target.setAlive(false);
    }
}
