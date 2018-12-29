package formation;

import classification.Classification;
import create.*;

import java.util.List;

public class Fengshi extends Formation{
    public static final int NUM = 10;
    public Fengshi(Classification c, Creature [][]field, List<Creature>fieldlist)
    {
        super(c);
        getFengshi(c,field,fieldlist);
    }

    private void getFengshi(Classification c,Creature [][]field,List<Creature>fieldlist)
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
        monsters[1].X=8;monsters[1].Y=7;
        fieldlist.set(8*15+7,monsters[1]);
        field[8][7] = monsters[1];
        monsters[2].X=8;monsters[2].Y=8;
        fieldlist.set(8*15+8,monsters[2]);
        field[8][8] = monsters[2];
        monsters[3].X=9;monsters[3].Y=5;
        fieldlist.set(9*15+5,monsters[3]);
        field[9][5] = monsters[3];
        monsters[4].X=9;monsters[4].Y=7;
        fieldlist.set(9*15+7,monsters[4]);
        field[9][7] = monsters[4];
        monsters[5].X=9;monsters[5].Y=9;
        fieldlist.set(9*15+9,monsters[5]);
        field[9][9] = monsters[5];
        monsters[6].X=10;monsters[6].Y=4;
        fieldlist.set(10*15+4,monsters[6]);
        field[10][4] = monsters[6];
        monsters[7].X=10;monsters[7].Y=7;
        fieldlist.set(10*15+7,monsters[7]);
        field[10][7] = monsters[7];
        monsters[8].X=10;monsters[8].Y=10;
        fieldlist.set(10*15+10,monsters[8]);
        field[10][10] = monsters[8];
        monsters[9].X=11;monsters[9].Y=7;
        fieldlist.set(11*15+7,monsters[9]);
        field[11][7] = monsters[9];
        snake.X=13;snake.Y=7;
        fieldlist.set(13*15+7,snake);
        field[13][7] = snake;
    }

    public String getName()
    {
        return "Frontal vector array";
    }

    public int getNumberOfMonster(){
        return 12;
    }
}
