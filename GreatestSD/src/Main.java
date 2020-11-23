public class Main {
    public static void main(String[] args) {

        Strategy1 s1 = new Strategy1();
        s1.getWin(500000);

        System.out.println("\n");

        Strategy2 s2 = new Strategy2();
        s2.getWin(500000);
//        StrategyGetDetail s = new StrategyGetDetail();
//        s.getWin(10000);


    }
}
