package DAO;

import java.math.BigDecimal;
import java.util.HashMap;

/*
 *2020/12/9创建
 *@author shaotong
 */
public class Setting {
    private static HashMap<String, BigDecimal> salary = new HashMap<String,BigDecimal>();
    public static String SailorsText = "T:\\coding\\OOP\\NarniaCruiseLines\\src\\DAO\\Data\\Sailors.txt";
    public static String ShipText = "T:\\coding\\OOP\\NarniaCruiseLines\\src\\DAO\\Data\\Ship.txt";
    public static String testText = "T:\\coding\\OOP\\NarniaCruiseLines\\src\\DAO\\Data\\test.txt";





    public static String RandomName = "The cartoon meeting our eyes is quite worrying and thought-provoking, in which a not harmonious scene is depicted vividly. Just as what we can see from the picture above, a drowning man is signaling for help. A boy is about to give his aid when another man stops him and asks him “Have you thought of the consequences of helping him?” Helping others has always been a virtue in traditional Chinese culture. But nowadays it is strange that people dare not offer help to those in need.\n" +
            "\n" +
            "Why, in this prosperous society, are people in China more reluctant to help others? It forces us to rethink whether we should help others regardless of any results. Admittedly, there are cases that help-givers are successively reported to be falsely identified as offenders, which makes common people become more risk-conscious and unwilling to offer their help.\n" +
            "\n" +
            "Nevertheless, helping people in need should be advocated since it is always considered as a traditional virtue. To prevent such a tragedy as above from happening, efforts should be made for the benefit of those rescuers. Only in this way can we be sure that everyone in our society will be ready to help people in need."+"As can be seen in the picture, one boy remembers his own birthday and his friend's birthday; the other boy even knows his idol's birthday. Ironically, both of them forget their parents' birthdays. Our parents have done much for us since we were born. They give us lots of love and care, but we don't care for them enough. This picture reminds us that we should do something to show love for our parents in return.\n" +
            "\n" +
            "What can we do to repay our parents? Firstly, we should talk with them as much as possible. It's said that parents today always feel lonely, so it's important for us to communicate with them. Secondly, doing housework at home seems to be a great chance to show our love. To do some housework not only relieves our parents' burden but also shows our gratitude for what they have done for the family. Finally, we are supposed to have a good future. The harder we work, the better results we'll have. If we make certain achievements, they'll be proud of us.\n" +
            "\n" +
            "Parents' love is the most unconditional and thus the greatest love in the world. If we spend more time taking care of our parents, love will be always around them."+"Nowadays, children are too lazy to do housework at home unless they are given pocket money. Just as the girl in the picture above, when her parents ask her to do household chores, she says, “Pay me, or I'll never do that!”\n" +
            "\n" +
            "Simple as the picture is, the meaning it conveys is profound and thought-provoking. With many children being spoiled too much, their independence is gradually taken away, which in fact does great harm to their growth. Thus, it is necessary for children to realize the value of labor. For one thing, by doing housework, children will understand how hard it is for their parents to support the family, which in turn will urge them to make even greater efforts in their study. For another, doing housework contributes to cultivating children's sense of responsibility, and also helps them harvest the joy of labor. Last but not least, doing housework can develop the ability to stand on their own feet, which will benefit them in the whole life.";

    public static String getRandomChara(){
        return RandomName.replace("!","").replace("“","").replace("”","").replace("\n","").replace(",","").replace("."," ").replace(" ","").replace("-","").replace("'","").replace("?","");

    }
}
