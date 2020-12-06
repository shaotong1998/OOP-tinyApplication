public class Strategy1 {
    private Gandalf g = new Gandalf();
    private Merlin m = new Merlin();
    private Dumbledore d = new Dumbledore();


    Strategy1(){}
    public void simulate(){
        //g-m-d的顺序，先攻击活着&&准确度最高的，
        //比如g要shoot在场的概率最大的，只要d活着就d否则m 再加上成功的概率
        //一个循环事件，结束条件：场上只有一个活着的！
        init();
        while (!gameover()){
            //按照顺序攻击
            if(isAlive(g) && shoot(g)){
                //d活着就攻击d，否则攻击m
                if(isAlive((d))){
                    g.shootTarget(d);
                }
                else{
                    g.shootTarget(m);
                }
            }
            if(isAlive(m) && shoot(m)){
                if(isAlive((d))){
                    m.shootTarget(d);
                }
                else{
                    m.shootTarget(g);
                }
            }
            if(isAlive(d) && shoot(d)){
                if(isAlive(m)){
                    d.shootTarget(m);
                }
                else{
                    d.shootTarget(g);
                }
            }

        }
        winner();
    }
    public void getWin(int loopTime){
        for(int i = 0;i < loopTime;i++){
            simulate();
        }
        System.out.println("LEADERBOARD – AFTER\t"+loopTime+"\tDUELS"+"\t(Strategy1)");
        System.out.println("Contestant\t\t"+"Number of Wins\t\t"+"Winning Percentag");
        System.out.println("Gandalf\t\t\t"+g.getNumberOfWin()+"\t\t\t\t"+100*g.getNumberOfWin()/(double)(loopTime)+"%");
        System.out.println("Merlin\t\t\t"+m.getNumberOfWin()+"\t\t\t\t"+100*m.getNumberOfWin()/(double)(loopTime)+"%");
        System.out.println("Dumbledore\t\t"+d.getNumberOfWin()+"\t\t\t\t"+100*d.getNumberOfWin()/(double)(loopTime)+"%");

    }
    private boolean isAlive(Fighter target){
        return target.isAlive();
    }

    private boolean shoot(Fighter fighter){
        double accurate = fighter.getAccurate();
//        final long randM = System.currentTimeMillis();
//        int rand = (int)(randM % 100);
        final double d = Math.random();
        final int rand = (int)(d*100);

        if (rand < accurate * 100){
            return true;
        }
        return false;
    }
    private boolean gameover(){
        int dieNum = 0;
        boolean gIsDie = g.isAlive();
        boolean mIsDie = m.isAlive();
        boolean dIsDie = d.isAlive();
        if(!gIsDie){
            dieNum++;
        }
        if(!mIsDie){
            dieNum++;
        }
        if(!dIsDie){
            dieNum++;
        }
        if(dieNum==2){
            return true;
        }
        return false;
    }
    private void winner(){
        if(isAlive(g)){
            g.setNumberOfWin(g.getNumberOfWin()+1);
        }
        if(isAlive(m)){
            m.setNumberOfWin(m.getNumberOfWin()+1);
        }
        if(isAlive(d)){
            d.setNumberOfWin(d.getNumberOfWin()+1);
        }

    }
    private void init(){
        g.setAlive(true);
        m.setAlive(true);
        d.setAlive(true);
    }
}
