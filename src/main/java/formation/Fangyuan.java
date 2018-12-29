package formation;

import classification.Classification;
import create.*;
import java.util.List;

public class Fangyuan extends Formation {
    public static final int NUM = 11;
    public Fangyuan(Classification c, Creature [][]field, List<Creature>fieldlist)
    {
        super(c);
        getFangyuan(c,field, fieldlist);
    }

    private void getFangyuan(Classification c, Creature [][]field, List<Creature>fieldlist)
    {
        Snake snake = new Snake(100,"shejing",0,20,20);
        Scorpion scorpion = new Scorpion(700,"xiezijing",60,45,45);
        Monster []monsters = new Monster[NUM];
        for(int i=0;i<NUM;i++)
        {
            monsters[i] = new Monster(300,"xiaoyaojing",30,20,20,i);
        }
        scorpion.X=7;scorpion.Y=7;
        fieldlist.set(7*15+7,scorpion);
        field[7][7] = scorpion;
        monsters[0].X=8;monsters[0].Y=6;
        fieldlist.set(8*15+6,monsters[0]);
        field[8][6] = monsters[0];
        monsters[1].X=8;monsters[1].Y=8;
        fieldlist.set(8*15+8,monsters[1]);
        field[8][8] = monsters[1];
        monsters[2].X=9;monsters[2].Y=5;
        fieldlist.set(9*15+5,monsters[2]);
        field[9][5] = monsters[2];
        monsters[3].X=9;monsters[3].Y=9;
        fieldlist.set(9*15+9,monsters[3]);
        field[9][9] = monsters[3];
        monsters[4].X=10;monsters[4].Y=4;
        fieldlist.set(10*15+4,monsters[4]);
        field[10][4] = monsters[4];
        monsters[5].X=10;monsters[5].Y=10;
        fieldlist.set(10*15+10,monsters[5]);
        field[10][10] = monsters[5];
        monsters[6].X=11;monsters[6].Y=5;
        fieldlist.set(11*15+5,monsters[6]);
        field[11][5] = monsters[6];
        monsters[7].X=11;monsters[7].Y=9;
        fieldlist.set(11*15+9,monsters[7]);
        field[11][9] = monsters[7];
        monsters[8].X=12;monsters[8].Y=6;
        fieldlist.set(12*15+6,monsters[8]);
        field[12][6] = monsters[8];
        monsters[9].X=12;monsters[9].Y=8;
        fieldlist.set(12*15+8,monsters[9]);
        field[12][8] = monsters[9];
        monsters[10].X=13;monsters[10].Y=7;
        fieldlist.set(13*15+7,monsters[10]);
        field[13][7] = monsters[10];
        snake.X=10;snake.Y=7;
        fieldlist.set(10*15+7,snake);
        field[10][7] = snake;
    }

    public String getName()
    {
        return "Square array";
    }

    public int getNumberOfMonster(){
        return 13;
    }
}
