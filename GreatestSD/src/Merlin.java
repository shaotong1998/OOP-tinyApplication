public class Merlin extends Fighter{
    Merlin(){
        setName("Merlin");
        setAccurate(0.5);
        setAlive(true);
    }

    @Override
    public void shootAtTarget(Fighter target) {
        target.setAlive(false);
    }
}
