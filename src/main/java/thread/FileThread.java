package thread;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

public class FileThread implements Runnable{
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
    private static Image back = new Image("dise.png");
    private Canvas mainCanvas;

    public FileThread(Canvas mainCanvas){
        this.mainCanvas = mainCanvas;
    }

    public void toSreen(String temp){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                mainCanvas.getGraphicsContext2D().drawImage(dise,40*i+13,40*j+2,40,40);
            }
        }
        String[] sourceStrArray = temp.split(" ");
        for(int i=0;i<sourceStrArray.length - 2;i=i+3){
            int x = Integer.valueOf(sourceStrArray[i+1]);
            int y = Integer.valueOf(sourceStrArray[i+2]);
            if(sourceStrArray[i].equals("yeye"))
            {
                mainCanvas.getGraphicsContext2D().drawImage(yeye,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("first")){
                mainCanvas.getGraphicsContext2D().drawImage(first,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("second")){
                mainCanvas.getGraphicsContext2D().drawImage(second,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("third")){
                mainCanvas.getGraphicsContext2D().drawImage(third,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("forth")){
                mainCanvas.getGraphicsContext2D().drawImage(forth,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("fifth")){
                mainCanvas.getGraphicsContext2D().drawImage(fifth,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("sixth")){
                mainCanvas.getGraphicsContext2D().drawImage(sixth,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("seventh")){
                mainCanvas.getGraphicsContext2D().drawImage(seventh,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("shejing")){
                mainCanvas.getGraphicsContext2D().drawImage(snake,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("xizijing")){
                mainCanvas.getGraphicsContext2D().drawImage(xiezijing,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("xiaoyaojing")){
                mainCanvas.getGraphicsContext2D().drawImage(xiaoyaojing,40*x+13,40*y+3,38,38);
            }
            else if(sourceStrArray[i].equals("siwangzhe")){
                mainCanvas.getGraphicsContext2D().drawImage(youling,40*x+13,40*y+3,38,38);
            }
        }
    }

    private void readFile(){
        File f = new File("e:"+File.separator+"test.txt");
        if(!f.exists()) {
            System.out.println("There isn't a file to read.");
            return;
        }
        try{
            FileInputStream in=new FileInputStream(f);
            int size = in.available();
            System.out.println(size);
            char []text = new char[size];
            String str="";
            for (int i = 0; i < text.length; i++) {
                text[i] = ((char)in.read());
                if(text[i]!='\n')
                {
                    str = str.concat(""+text[i]);
                }
                else
                {
                    //System.out.println(str);
                    toSreen(str);
                    str = "";
                    try {
                        Thread.sleep(100);
                    }catch(InterruptedException ex)
                    {
                        Thread.interrupted();
                    }
                }
            }
            in.close();
        }catch(IOException e){
            e.printStackTrace() ;
        }
    }

    @Override
    public synchronized void run(){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                mainCanvas.getGraphicsContext2D().drawImage(dise,40*i+13,40*j+2,40,40);
            }
        }
        readFile();
    }
}
