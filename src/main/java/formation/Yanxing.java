package formation;
import classification.*;
import create.*;
import java.util.List;

public class Yanxing extends Formation{
    public static final int NUM = 7;
    public Yanxing(Classification c,Creature [][]field, List<Creature>fieldlist)
    {
        super(c);
        getYanxing(c,field,fieldlist);
    }

    private void getYanxing(Classification c, Creature [][]field, List<Creature>fieldlist)
    {
        if(c == Classification.Calabashs)
        {
            Grandpa pa = new Grandpa(100,"yeye",0,20,20);
            Calabash []cs = new Calabash[NUM];
            for(int i=0;i<NUM;i++)
            {
                cs[i] = new Calabash(500,"huluwa",50,40,40,i);
            }
            cs[0].X=6;cs[0].Y=4;
            fieldlist.set(6*15+4,cs[0]);
            field[6][4] = cs[0];
            cs[1].X=5;cs[1].Y=5;
            fieldlist.set(5*15+5,cs[1]);
            field[5][5] = cs[1];
            cs[2].X=4;cs[2].Y=6;
            fieldlist.set(4*15+6,cs[2]);
            field[4][6] = cs[2];
            cs[3].X=3;cs[3].Y=7;
            fieldlist.set(3*15+7,cs[3]);
            field[3][7] = cs[3];
            cs[4].X=2;cs[4].Y=8;
            fieldlist.set(2*15+8,cs[4]);
            field[2][8] = cs[4];
            cs[5].X=1;cs[5].Y=9;
            fieldlist.set(1*15+9,cs[5]);
            field[1][9] = cs[5];
            cs[6].X=0;cs[6].Y=10;
            fieldlist.set(0*15+10,cs[6]);
            field[0][10] = cs[6];
            pa.X=1;pa.Y=7;
            fieldlist.set(1*15+7,pa);
            field[1][7] = pa;
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
            scorpion.X=14;scorpion.Y=4;
            fieldlist.set(14*15+4,scorpion);
            field[14][4] = scorpion;
            monsters[0].X=13;monsters[0].Y=5;
            fieldlist.set(13*15+5,monsters[0]);
            field[13][5] = monsters[0];
            monsters[1].X=12;monsters[1].Y=6;
            fieldlist.set(12*15+6,monsters[1]);
            field[12][6] = monsters[1];
            monsters[2].X=11;monsters[2].Y=7;
            fieldlist.set(11*15+7,monsters[2]);
            field[11][7] = monsters[2];
            monsters[3].X=10;monsters[3].Y=8;
            fieldlist.set(10*15+8,monsters[3]);
            field[10][8] = monsters[3];
            monsters[4].X=9;monsters[4].Y=9;
            fieldlist.set(9*15+9,monsters[4]);
            field[9][9] = monsters[4];
            monsters[5].X=8;monsters[5].Y=10;
            fieldlist.set(8*15+10,monsters[5]);
            field[8][10] = monsters[5];
            snake.X=13;snake.Y=7;
            fieldlist.set(13*15+7,snake);
            field[13][7] = snake;
        }
    }

    public String getName()
    {
        return "Flying geese array";
    }

    public int getNumberOfMonster(){
        return 8;
    }
}
