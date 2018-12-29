package create;

public class Scorpion extends Creature {
    public Scorpion(int h, String n, int p, int s, int a)
    {
        super(h,n,p,s,a);
        this.justorevil = false;
    }

    public String getName()
    {
        return name;
    }
}
