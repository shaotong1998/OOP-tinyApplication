import javax.naming.Name;

public class Gandalf extends Fighter{

    Gandalf(){
        setName("Gandalf");
        setAccurate(0.3333);
        setAlive(true);
    }

    @Override
    public void shootAtTarget(Fighter target) {
        /*模拟击中目标
        * 分析： d->1，m->0,1,g->0,0,1
        * 对m来说：[0,1] ->随机出1和2 ->对0.5来说：随机生成[0,100)的数字x，x<accurate*x 成功
        * 对g来说：[0,0,1] ->随机出1，2，3
        *
        * 取随机数参考资料：https://www.cnblogs.com/skywang12345/p/3341423.html
        * */
//        final long randMills = System.currentTimeMillis();
//        final int rand = (int)(randMills % 100);
        target.setAlive(false);

    }
//    public void test(){
//        final long randMills = System.currentTimeMillis();
//        final int rand = (int)(randMills % 100);
//
//        System.out.println(rand);
//    }

}


