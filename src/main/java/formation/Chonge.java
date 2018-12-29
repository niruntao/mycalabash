package formation;
import classification.Classification;
import create.*;
import java.util.List;

public class Chonge extends Formation {
    public static final int NUM = 7;
    public Chonge(Classification c, Creature [][]field, List<Creature> fieldlist)
    {
        super(c);
        getChonge(c,field,fieldlist);
    }

    private void getChonge(Classification c, Creature [][]field, List<Creature>fieldlist)
    {
        if(c == Classification.Calabashs)
        {
            Grandpa pa = new Grandpa(100,"yeye",0,20,20);
            Calabash []cs = new Calabash[NUM];
            for(int i=0;i<NUM;i++)
            {
                cs[i] = new Calabash(500,"huluwa",50,40,40,i);
            }
            cs[0].X=4;cs[0].Y=7;
            fieldlist.set(4*15+7,cs[0]);
            field[4][7] = cs[0];
            cs[1].X=4;cs[1].Y=5;
            fieldlist.set(4*15+5,cs[1]);
            field[4][5] = cs[1];
            cs[2].X=4;cs[2].Y=9;
            fieldlist.set(4*15+9,cs[2]);
            field[4][9] = cs[2];
            cs[3].X=3;cs[3].Y=4;
            fieldlist.set(3*15+4,cs[3]);
            field[3][4] = cs[3];
            cs[4].X=3;cs[4].Y=6;
            fieldlist.set(3*15+6,cs[4]);
            field[3][6] = cs[4];
            cs[5].X=3;cs[5].Y=8;
            fieldlist.set(3*15+8,cs[5]);
            field[3][8] = cs[5];
            cs[6].X=3;cs[6].Y=10;
            fieldlist.set(3*15+10,cs[6]);
            field[3][10] = cs[6];
            pa.X=2;pa.Y=7;
            fieldlist.set(2*15+7,pa);
            field[2][7] = pa;
        }
        else
        {
            Snake snake = new Snake(100,"shejing",0,20,20);
            Scorpion scorpion = new Scorpion(700,"xiezijing",60,45,45);
            Monster []monsters = new Monster[NUM-1];
            for(int i=0;i<NUM-1;i++)
            {
                monsters[i] = new Monster(300,"xiaoyaojing",30,20,20,i);
            }
            scorpion.X=10;scorpion.Y=7;
            fieldlist.set(10*15+7,scorpion);
            field[10][7] = scorpion;
            monsters[0].X=10;monsters[0].Y=5;
            fieldlist.set(10*15+5,monsters[0]);
            field[10][5] = monsters[0];
            monsters[1].X=10;monsters[1].Y=9;
            fieldlist.set(10*15+9,monsters[1]);
            field[10][9] = monsters[1];
            monsters[2].X=11;monsters[2].Y=4;
            fieldlist.set(11*15+4,monsters[2]);
            field[11][4] = monsters[2];
            monsters[3].X=11;monsters[3].Y=6;
            fieldlist.set(11*15+6,monsters[3]);
            field[11][6] = monsters[3];
            monsters[4].X=11;monsters[4].Y=8;
            fieldlist.set(11*15+8,monsters[4]);
            field[11][8] = monsters[4];
            monsters[5].X=11;monsters[5].Y=10;
            fieldlist.set(11*15+10,monsters[5]);
            field[11][10] = monsters[5];
            snake.X=13;snake.Y=7;
            fieldlist.set(13*15+7,snake);
            field[13][7] = snake;
        }
    }

    public String getName()
    {
        return "Yoke array";
    }

    public int getNumberOfMonster(){
        return 8;
    }
}
