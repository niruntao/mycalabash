package create;

enum Color{red, orange, yellow, green, cyan, blue, purple}
enum CalabashName{first, second, third, fourth, fifth, sixth, seventh}

public class Calabash extends Creature {
    Color color;
    CalabashName cname;
    public Calabash(int h, String n, int p, int s, int a, int num)
    {
        super(h,n,p,s,a);
        this.name = CalabashName.values()[num].toString();
        this.color = Color.values()[num];
        this.cname = CalabashName.values()[num];
        this.justorevil = true;
        switch(num)
        {
            case 0:
                this.power+=20;break;
            case 1:
                this.agility+=20;break;
            case 2:
                this.hp+=200;break;
            case 3:
                this.power+=10;break;
            case 4:
                this.power+=10;break;
            case 5:
                this.speed+=10;
                this.agility+=10;break;
            case 6:
                this.power+=10;break;
            default:break;
        }
    }

    public Color getColor(int num)
    {
        return Color.values()[num];
    }

    public CalabashName getCname(int num)
    {
        return CalabashName.values()[num];
    }
}
