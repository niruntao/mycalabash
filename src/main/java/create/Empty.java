package create;

import java.util.*;

public class Empty extends Creature {
    public Empty(int h, String n, int p, int s, int a)
    {
        super(h,n,p,s,a);
        this.justorevil= false;
    }
    public static Creature[][] CreateField()
    {
        Creature [][]field = new Creature[15][15];
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
            {
                field[i][j] = new Empty(0,"empty",0,0,0);
            }
        }
        return field;
    }

    public static List<Creature> getCreatureList(){
        List<Creature> fieldlist = new ArrayList<>();
        for(int i=0;i<15*15;i++){
            fieldlist.add(new Empty(0,"empty",0,0,0));
        }
        return fieldlist;
    }
}
