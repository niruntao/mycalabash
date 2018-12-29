package create;

import java.util.List;

public class Creature {
    public int hp;
    public String name; //名称
    public int power;   //力量
    public int speed;   //速度
    public int agility; //敏捷
    public int X;
    public int Y;
    public boolean justorevil;

    public Creature(int h, String n, int p, int s, int a)
    {
        this.name = n;
        this.hp = h;
        this.power = p;
        this.speed = s;
        this.agility = a;
    }

    public void setHp(int c)
    {
        hp = c;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setPower(int p)
    {
        power = p;
    }

    public void setSpeed(int s)
    {
        speed = s;
    }

    public void setAgility(int a)
    {
        agility = a;
    }

    public String getName(){
        return null;
    }

    public int getHp(){
        return  hp;
    }

    public int getPower(){
        return power;
    }

    public int getSpeed(){
        return power;
    }

    public int getAgility(){
        return agility;
    }

    public void setX(int x){
        this.X = x;
    }

    public void setY(int y){
        this.Y = y;
    }

    private void setField(int a, Creature [][]field)
    {
        if(a==0){
            field[this.X][this.Y-1] = field[this.X][this.Y];
            field[this.X][this.Y-1].X = this.X;
            field[this.X][this.Y-1].Y = this.Y;
            field[this.X][this.Y] = new Empty(0,"empty",0,0,0);
        }
        else {
            field[this.X][this.Y+1] = field[this.X][this.Y];
            field[this.X][this.Y-1].X = this.X;
            field[this.X][this.Y-1].Y = this.Y-1;
            field[this.X][this.Y] = new Empty(0,"empty",0,0,0);
        }
    }

    private void setAGrap(int xnum, int ynum,List<Creature>fieldlist)
    {
        if(this.X+xnum<0 || this.X+xnum>=15 || this.Y+ynum<0 || this.Y+ynum>=15)
        {
            return;
            //System.out.print(this.X+" X   "+this.Y+" Y   "+xnum+" xnum    "+ynum+" ynum");
            //assert(false);
        }
        else{
            int xt = this.X;
            int yt = this.Y;
            this.X += xnum;
            this.Y += ynum;
            fieldlist.set(this.X*15+this.Y,fieldlist.get(xt*15+yt));
            fieldlist.set(xt*15+yt,new Empty(0,"empty",0,0,0));

            /*Creature temp = fieldlist.get(this.X*15+this.Y);
            temp = fieldlist.get(this.X*15+this.Y);
            temp.X = temp.X+xnum;
            temp.Y = temp.Y+ynum;
            fieldlist.set(this.X*15+this.Y,temp);
            fieldlist.set((this.X-xnum)*15+this.Y-ynum,new Empty(0,"empty",0,0,0));*/
        }
    }

    private void judgeWinner(int xnum, int ynum, List<Creature>fieldlist)
    {
        int temp1 = this.hp+this.agility*3+this.speed*3+this.power*4;
        Creature temp = fieldlist.get((this.X+xnum)+this.Y+ynum);
        int temp2 = temp.hp+this.agility*3+this.speed*3+this.power*4;
        int ran1 = (int)(Math.random()*(temp1-1)+1);
        int ran2 = (int)(Math.random()*(temp2-1)+1);
        //field[this.X+1][this.Y].name = "siwangzhe";
        if(ran1>ran2) fieldlist.get((this.X + xnum) * 15 + this.Y + ynum).name = "siwangzhe";
        else
            this.name = "siwangzhe";
    }

    private int judgeNeighbor(List<Creature>fieldlist)
    {
        if(!this.name.equals("siwangzhe") && !this.name.equals("empty"))
        {
            if(this.X+1<=14 && !fieldlist.get((this.X + 1) * 15 + this.Y).name.equals("empty") && !fieldlist.get((this.X + 1) * 15 + this.Y).name.equals("siwangzhe") && fieldlist.get((this.X+1)*15+this.Y).justorevil != fieldlist.get(this.X*15+this.Y).justorevil)
            {
                judgeWinner(1,0,fieldlist);
                return 1;
            }
            if(this.X-1>=0 && !fieldlist.get((this.X - 1) * 15 + this.Y).name.equals("empty") && !fieldlist.get((this.X - 1) * 15 + this.Y).name.equals("siwangzhe") && fieldlist.get((this.X-1)*15+this.Y).justorevil != fieldlist.get(this.X*15+this.Y).justorevil)
            {
                judgeWinner(-1,0,fieldlist);
                return 1;
            }
            if( this.Y+1<=14 && !fieldlist.get(this.X * 15 + this.Y + 1).name.equals("empty") && !fieldlist.get(this.X * 15 + this.Y + 1).name.equals("siwangzhe") && fieldlist.get(this.X*15+this.Y+1).justorevil != fieldlist.get(this.X*15+this.Y).justorevil)
            {
                judgeWinner(0,1,fieldlist);
                return 1;
            }
            if(this.Y-1>=0 && !fieldlist.get(this.X * 15 + this.Y - 1).name.equals("empty") && !fieldlist.get(this.X * 15 + this.Y - 1).name.equals("siwangzhe") && fieldlist.get(this.X*15+this.Y-1).justorevil != fieldlist.get(this.X*15+this.Y).justorevil)
            {
                judgeWinner(0,-1,fieldlist);
                return 1;
            }
            return 2;
        }
        return 3;
    }

    private void gotoNext(int num, boolean a, boolean b, boolean c, boolean d, List<Creature>fieldlist)
    {
        int max=600,min=1;
        int ran = (int) (Math.random()*(max-min)+min);
        if(num == 4)
        {
            ran = ran%4;
            if(ran == 0){
                setAGrap(1,0,fieldlist);
            }
            else if(ran == 1){
                setAGrap(0,1,fieldlist);
            }
            else if(ran == 2){
                setAGrap(-1,0,fieldlist);
            }
            else if(ran == 3){
                setAGrap(0,-1,fieldlist);
            }
        }
        else if(num == 3)
        {
            ran = ran%3;
            if(!a)
            {
                if(ran == 0) {
                    setAGrap(0,1,fieldlist);
                }
                else if(ran == 1) {
                    setAGrap(-1,0,fieldlist);
                }
                else if(ran == 2){
                    setAGrap(0,-1,fieldlist);
                }
            }
            if(!b)
            {
                if(ran == 0) {
                    setAGrap(1,0,fieldlist);
                }
                else if(ran == 1) {
                    setAGrap(-1,0,fieldlist);
                }
                else if(ran == 2){
                    setAGrap(0,-1,fieldlist);
                }
            }
            if(!c)
            {
                if(ran == 0) {
                    setAGrap(1,0,fieldlist);
                }
                else if(ran == 1) {
                    setAGrap(0,1,fieldlist);
                }
                else if(ran == 2){
                    setAGrap(0,-1,fieldlist);
                }
            }
            if(!d)
            {
                if(ran == 0) {
                    setAGrap(1,0,fieldlist);
                }
                else if(ran == 1) {
                    setAGrap(0,1,fieldlist);
                }
                else if(ran == 2){
                    setAGrap(-1,0,fieldlist);
                }
            }
        }
        else if(num == 2)
        {
            ran = ran%2;
            if(!a && !b)
            {
                if(ran == 0) {
                    setAGrap(-1,0,fieldlist);
                }
                else if(ran == 1){
                    setAGrap(0,-1,fieldlist);
                }
            }
            if(!a && !c)
            {
                if(ran == 0) {
                    setAGrap(0,1,fieldlist);
                }
                else if(ran == 1){
                    setAGrap(0,-1,fieldlist);
                }
            }
            if(!a && !d)
            {
                if(ran == 0){
                    setAGrap(0,1,fieldlist);
                }
                else if(ran == 1){
                    setAGrap(-1,0,fieldlist);
                }
            }
            if(!b && !c)
            {
                if(ran == 0){
                    setAGrap(1,0,fieldlist);
                }
                else if(ran == 1){
                    setAGrap(0,-1,fieldlist);
                }
            }
            if(!b && !d)
            {
                if(ran == 0){
                    setAGrap(1,0,fieldlist);
                }
                else if(ran == 1){
                    setAGrap(-1,0,fieldlist);
                }
            }
            if(!c && !d)
            {
                if(ran == 0){
                    setAGrap(1,0,fieldlist);
                }
                else if(ran == 1){
                    setAGrap(0,1,fieldlist);
                }
            }
        }
        else if(num == 1)
        {
            if(a){
                setAGrap(1,0,fieldlist);
            }
            if(b){
                setAGrap(0,1,fieldlist);
            }
            if(c){
                setAGrap(-1,0,fieldlist);
            }
            if(d){
                setAGrap(0,-1,fieldlist);
            }
        }
    }

    public synchronized void move(List<Creature>fieldlist)
    {
        int neibreturn = judgeNeighbor(fieldlist);
        if(neibreturn == 1 || neibreturn == 3)
            return;
        if(this.name.equals("siwangzhe"))
            return;
        int count = 0;
        boolean a = false,b = false,c = false,d = false;
        if(this.X+1<=14 && fieldlist.get((this.X + 1) * 15 + this.Y).name.equals("empty")) {
            a = true;
            count++;
        }
        if(this.Y+1<=14 && fieldlist.get(this.X * 15 + this.Y + 1).name.equals("empty")) {
            b = true;
            count++;
        }
        if(this.X-1>=0 && fieldlist.get((this.X - 1) * 15 + this.Y).name.equals("empty")) {
            c = true;
            count++;
        }
        if(this.Y-1>=0 && fieldlist.get(this.X * 15 + this.Y - 1).name.equals("empty")) {
            d = true;
            count++;
        }
        if(count == 0)
        {
            return;
        }
        else gotoNext(count,a,b,c,d,fieldlist);
    }

    private void caAndMonMove(List<Creature>fieldlist)
    {
        int []a = new int[210];
        int size = 0;
        for(int i=0;i<225;i++)
        {
            if(fieldlist.get(i).name.equals("empty")) {
                a[size] = i;
                size++;
            }
        }
        int ran = (int) (Math.random()*(size-1)+1);
        fieldlist.set(a[ran],this);
        fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
        this.X = a[ran]/15;
        this.Y = a[ran]%15;
    }

    private void shejingMove(List<Creature>fieldlist)
    {
        if(this.Y-1>=0 && fieldlist.get(this.X * 15 + this.Y-1).name.equals("empty"))
        {
            fieldlist.set(this.X*15+this.Y-1,this);
            fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
            this.Y -= 1;
            return;
        }
        if(this.Y == 0)
        {
            for(int i=14;i>=1;i--)
            {
                if(fieldlist.get(this.X*15+i).name.equals("empty"))
                {
                    fieldlist.set(this.X*15+i,this);
                    fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
                    this.Y = i;
                    return;
                }
            }
        }
        if(this.Y-1>=0 && fieldlist.get(this.X * 15 + this.Y-1).name.equals("siwangzhe"))
        {
            for(int i=8;i<14;i++)
            {
                if(fieldlist.get(i*15+this.Y).name.equals("empty"))
                {
                    fieldlist.set(i*15+this.Y,this);
                    fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
                    this.X = i;
                    return;
                }
            }
        }
    }

    private void grandpaMove(List<Creature>fieldlist)
    {
        if(this.Y+1<=14 && fieldlist.get(this.X * 15 + this.Y+1).name.equals("empty"))
        {
            fieldlist.set(this.X*15+this.Y+1,this);
            fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
            this.Y += 1;
            return;
        }
        if(this.Y == 14)
        {
            for(int i=0;i<13;i++)
            {
                if(fieldlist.get(this.X*15+i).name.equals("empty"))
                {
                    fieldlist.set(this.X*15+i,this);
                    fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
                    this.Y = i;
                    return;
                }
            }
        }
        if(this.Y+1<=14 && fieldlist.get(this.X * 15 + this.Y+1).name.equals("siwangzhe"))
        {
            for(int i=0;i<7;i++)
            {
                if(fieldlist.get(i*15+this.Y).name.equals("empty"))
                {
                    fieldlist.set(i*15+this.Y,this);
                    fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
                    this.X = i;
                    return;
                }
            }
        }
    }

    public synchronized void movet(List<Creature>fieldlist)
    {
        int neibreturn = judgeNeighbor(fieldlist);
        if(neibreturn == 1 || neibreturn == 3)
            return;
        if(this.justorevil)
        {
            if(this.name.equals("yeye")) {
                grandpaMove(fieldlist);
                return;
            }
            if(this.X+1<=14 && fieldlist.get((this.X + 1) * 15 + this.Y).name.equals("empty")) {
                fieldlist.set(this.X*15+15+this.Y,this);
                fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
                this.X += 1;
                return;
            }
            if(this.X == 14)
            {
                int count = 0;
                for(int i=0;i<13;i++)
                {
                    if(!fieldlist.get(i*15+this.Y).name.equals("empty") && !fieldlist.get(i*15+this.Y).name.equals("siwangzhe") && fieldlist.get(i*15+this.Y).justorevil != this.justorevil)
                        count++;
                }
                if(count!=0) {
                    for (int i = 0; i < 13; i++) {
                        if (fieldlist.get(i * 15 + this.Y).name.equals("empty")) {
                            fieldlist.set(i * 15 + this.Y, this);
                            fieldlist.set(this.X * 15 + this.Y, new Empty(0, "empty", 0, 0, 0));
                            this.X = i;
                            return;
                        }
                    }
                }
                else
                {
                    int ran;
                    if(this.Y<=7) {
                        ran = (int) (Math.random()*(14-7)+7);
                    }
                    else ran = (int)(Math.random()*(7-1)+1);
                    for(int i=0;i<13;i++){
                        if(fieldlist.get(i * 15 + ran).name.equals("empty"))
                        {
                            fieldlist.set(i*15+ran,this);
                            fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
                            this.X = i;
                            this.Y = ran;
                        }
                    }
                }
            }
            if(this.X+1<=14 && fieldlist.get((this.X + 1) * 15 + this.Y).name.equals("siwangzhe"))
            {
                caAndMonMove(fieldlist);
            }
        }
        else
        {
            if(this.name.equals("shejing")){
                shejingMove(fieldlist);
                return;
            }
            if(this.X-1>=0 && fieldlist.get((this.X - 1) * 15 + this.Y).name.equals("empty")) {
                fieldlist.set(this.X*15-15+this.Y,this);
                fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
                this.X -= 1;
                return;
            }
            if(this.X == 0)
            {
                for(int i=14;i>=1;i--)
                {
                    if(fieldlist.get(i*15+this.Y).name.equals("empty"))
                    {
                        fieldlist.set(i*15+this.Y,this);
                        fieldlist.set(this.X*15+this.Y,new Empty(0,"empty",0,0,0));
                        this.X = i;
                        return;
                    }
                }
            }
            if(this.X-1>=0 && fieldlist.get((this.X - 1) * 15 + this.Y).name.equals("siwangzhe"))
            {
                caAndMonMove(fieldlist);
            }
        }

    }
}
