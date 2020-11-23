public class StrategyGetDetail {
    private Gandalf g = new Gandalf();
    private Merlin m = new Merlin();
    private Dumbledore d = new Dumbledore();
    private boolean getDetail = true;
    private int temp = 0;


    StrategyGetDetail(){}
    public void simulate(){
        //g-m-d的顺序，先攻击活着&&准确度最高的，
        //比如g要shoot在场的概率最大的，只要d活着就d否则m 再加上成功的概率
        //一个循环事件，结束条件：场上只有一个活着的！
        init();
        while (!gameover()){
            //按照顺序攻击
            //******************甘道夫
            if(isAlive(g) && shoot(g)){
                //d活着就攻击d，否则攻击m
                if(isAlive((d))){
                    g.shootAtTarget(d);
                    if(getDetail){
                        System.out.println(d.getName()+"倒下了");
                    }
                }
                else{
                    if(getDetail){
                        System.out.println(m.getName()+"倒下了");
                    }
                    g.shootAtTarget(m);
                }
            }else{
                if(isAlive(g)&&getDetail){
                    System.out.println("可惜！"+g.getName()+"没有击中目标！"+"\t(攻击范围为"+this.temp+"大于"+g.getAccurate()*100+")");
                }
            }
            //**************梅林
            if(isAlive(m) && shoot(m)){
                if(isAlive((d))){
                    if(getDetail){
                        System.out.println(d.getName()+"倒下了");
                    }
                    m.shootAtTarget(d);
                }
                else{
                    if(getDetail){
                        System.out.println(g.getName()+"倒下了");
                    }
                    m.shootAtTarget(g);
                }
            }else{
                if(isAlive(m)&&getDetail){
                    System.out.println("可惜！"+m.getName()+"没有击中目标！"+"\t(攻击范围为"+this.temp+"大于"+m.getAccurate()*100+")");
                }
            }
            //***************邓布利多
            if(isAlive(d) && shoot(d)){
                if(isAlive(m)){
                    if(getDetail){
                        System.out.println(m.getName()+"倒下了");
                    }
                    d.shootAtTarget(m);
                }
                else{
                    if(getDetail){
                        System.out.println(g.getName()+"倒下了");
                    }
                    d.shootAtTarget(g);
                }
            }

        }
        winner();
    }

    public void getWin(int loop){

        for(int i = 0;i < loop;i++){
            int loo = i+1;
            if(getDetail){
                System.out.println("*********决斗第"+loo+"场开始！*********");
            }
            //this.looptime = loop + 1;
            simulate();
            if(getDetail){
                System.out.println("*********决斗第"+loo+"场结束！*********\n");
            }
        }
        System.out.println("LEADERBOARD – AFTER\t"+loop+"\tDUELS"+"\t(Strategy1)");
        System.out.println("Contestant\t\t"+"Number of Wins\t\t"+"Winning Percentag");
        System.out.println("Gandalf\t\t\t"+g.getNumberOfWin()+"\t\t\t\t"+100*g.getNumberOfWin()/(double)(loop)+"%");
        System.out.println("Merlin\t\t\t"+m.getNumberOfWin()+"\t\t\t\t"+100*m.getNumberOfWin()/(double)(loop)+"%");
        System.out.println("Dumbledore\t\t"+d.getNumberOfWin()+"\t\t\t\t"+100*d.getNumberOfWin()/(double)(loop)+"%");

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
            if(getDetail&&fighter.isAlive()){
                System.out.println(fighter.getName()+"击中目标！\t(攻击范围为"+rand+"小于"+accurate*100+")");
            }
            return true;
        }
        this.temp = rand;
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
            if(getDetail){
                System.out.println("\t\t胜利者是"+g.getName());
            }
            g.setNumberOfWin(g.getNumberOfWin()+1);
        }
        if(isAlive(m)){
            if(getDetail){
                System.out.println("\t\t胜利者是"+m.getName());
            }
            m.setNumberOfWin(m.getNumberOfWin()+1);
        }
        if(isAlive(d)){
            if(getDetail){
                System.out.println("\t\t胜利者是"+d.getName());
            }
            d.setNumberOfWin(d.getNumberOfWin()+1);
        }


    }
    private void init(){

        g.setAlive(true);
        m.setAlive(true);
        d.setAlive(true);

    }


}
