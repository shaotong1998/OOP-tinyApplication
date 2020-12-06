public class Dumbledore extends Fighter{
    Dumbledore(){
        setName("Dumbledore");
        setAccurate(0.9);
        setAlive(true);
    }
    @Override
    public void shootTarget(Fighter target) {
        target.setAlive(false);
    }
}
