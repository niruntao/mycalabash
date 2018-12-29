package formation;
import classification.*;
import create.*;

import java.util.List;

public class Changshe extends Formation {
    public static final int NUM = 7;
    public Changshe(Classification c, Creature [][]field, List<Creature>fieldlist)
    {
        super(c);
        getChangshe(c,field,fieldlist);
    }

    private void getChangshe(Classification c, Creature [][]field, List<Creature>fieldlist)
    {
        if(c == Classification.Calabashs)
        {
            Grandpa pa = new Grandpa(100,"yeye",0,20,20);
            Calabash []cs = new Calabash[NUM];
            for(int i=0;i<NUM;i++)
            {
                cs[i] = new Calabash(500,"huluwa",50,40,40,i);
            }
            cs[0].X = 4;cs[0].Y = 7;
            fieldlist.set(4*15+7,cs[0]);
            cs[2].X = 4;cs[2].Y = 8;
            fieldlist.set(4*15+8,cs[2]);
            cs[1].X = 4;cs[1].Y = 6;
            fieldlist.set(4*15+6,cs[1]);
            cs[3].X = 4;cs[3].Y = 5;
            fieldlist.set(4*15+5,cs[3]);
            cs[4].X = 4;cs[4].Y = 9;
            fieldlist.set(4*15+9,cs[4]);
            cs[6].X = 4;cs[6].Y = 10;
            fieldlist.set(4*15+10,cs[6]);
            cs[5].X = 4;cs[5].Y = 4;
            fieldlist.set(4*15+4,cs[5]);
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
            scorpion.X=10;scorpion.Y=7;
            fieldlist.set(10*15+7,scorpion);
            field[10][7] = scorpion;
            monsters[1].X=10;monsters[1].Y=8;
            fieldlist.set(10*15+8,monsters[1]);
            field[10][8] = monsters[1];
            monsters[0].X=10;monsters[0].Y=6;
            fieldlist.set(10*15+6,monsters[0]);
            field[10][6] = monsters[0];
            monsters[3].X=10;monsters[3].Y=9;
            fieldlist.set(10*15+9,monsters[3]);
            field[10][9] = monsters[3];
            monsters[2].X=10;monsters[2].Y=5;
            fieldlist.set(10*15+5,monsters[2]);
            field[10][5] = monsters[2];
            monsters[5].X=10;monsters[5].Y=10;
            fieldlist.set(10*15+10,monsters[5]);
            field[10][10] = monsters[5];
            monsters[4].X=10;monsters[4].Y=4;
            fieldlist.set(10*15+4,monsters[4]);
            field[10][4] = monsters[4];
            snake.X=13;snake.Y=7;
            fieldlist.set(13*15+7,snake);
            field[13][7] = snake;
        }
    }

    public String getName()
    {
        return "Long snake array";
    }

    public int getNumberOfMonster()
    {
        return 8;
    }
}
