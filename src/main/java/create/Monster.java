package create;

public class Monster extends  Creature {
    public Monster(int h, String n, int p, int s, int a, int num)
    {
        super(h,n,p,s,a);
        this.justorevil = false;
        //this.name +=String.valueOf(num);
    }

    public String getName()
    {
        return this.name;
    }
}
