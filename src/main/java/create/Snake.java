package create;

public class Snake extends Creature {
    int spell;
    public Snake(int h, String n, int p, int s, int a)
    {
        super(h, n, p, s, a);
        spell = 50;
        this.justorevil = false;
    }
    public String getName()
    {
        return name;
    }
}
