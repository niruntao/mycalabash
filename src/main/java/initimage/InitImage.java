package initimage;

import create.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.List;

public class InitImage {
    private static Image dise = new Image("dise.png");
    private static Image first = new Image("1.jpg");
    private static Image second = new Image("2.jpg");
    private static Image third = new Image("3.jpg");
    private static Image forth = new Image("4.jpg");
    private static Image fifth = new Image("5.jpg");
    private static Image sixth = new Image("6.jpg");
    private static Image seventh = new Image("7.jpg");
    private static Image yeye = new Image("ye.jpg");
    private static Image snake = new Image("shejing.jpg");
    private static Image xiezijing = new Image("xiezijing.jpg");
    private static Image xiaoyaojing = new Image("xiaoyaojing.jpg");
    private static Image youling = new Image("youling.png");
    public static void setImage(GraphicsContext mainGraphicsContext, List<Creature>fieldlist)
    {
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
            {
                mainGraphicsContext.drawImage(dise,40*i+13,40*j+2,40,40);
            }
        }
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
            {
                String name = fieldlist.get(i*15+j).name;
                if(name == "yeye")
                    mainGraphicsContext.drawImage(yeye,40*i+14,40*j+3,38,38);
                else if(name == "first")
                    mainGraphicsContext.drawImage(first,40*i+14,40*j+3,38,38);
                else if(name == "second")
                    mainGraphicsContext.drawImage(second,40*i+14,40*j+3,38,38);
                else if(name == "third")
                    mainGraphicsContext.drawImage(third,40*i+14,40*j+3,38,38);
                else if(name == "fourth")
                    mainGraphicsContext.drawImage(forth,40*i+14,40*j+3,38,38);
                else if(name == "fifth")
                    mainGraphicsContext.drawImage(fifth,40*i+14,40*j+3,38,38);
                else if(name == "sixth")
                    mainGraphicsContext.drawImage(sixth,40*i+14,40*j+3,38,38);
                else if(name == "seventh")
                    mainGraphicsContext.drawImage(seventh,40*i+14,40*j+3,38,38);
                else if(name == "shejing")
                    mainGraphicsContext.drawImage(snake,40*i+14,40*j+3,38,38);
                else if(name == "xiezijing")
                    mainGraphicsContext.drawImage(xiezijing,40*i+14,40*j+3,38,38);
                else if(name == "xiaoyaojing")
                    mainGraphicsContext.drawImage(xiaoyaojing,40*i+14,40*j+3,38,38);
                else if(name == "siwangzhe")
                    mainGraphicsContext.drawImage(youling,40*i+14,40*j+3,38,38);
            }
        }
        /*for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
            {
                if(!fieldlist.get(j*15+i).name.equals("empty"))
                {
                    System.out.print(fieldlist.get(j*15+i).name+" "+fieldlist.get(j*15+i).X + " " + fieldlist.get(j*15+i).Y);
                }
                else
                {
                    System.out.print("       ");
                }
            }
            System.out.println();
        }*/
    }
}
