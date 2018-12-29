package create;

public class Grandpa extends Creature {
    int cheer;
    public Grandpa(int h, String n, int p, int s, int a)
    {
        super(h,n,p,s,a);
        cheer = 500;
        this.justorevil = true;
    }

    public String getName()
    {
        return name;
    }
}
