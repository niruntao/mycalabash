package thread;

import create.Creature;
import initimage.*;
import javafx.scene.image.Image;
import java.util.List;
import java.util.concurrent.locks.Lock;
import javafx.scene.canvas.Canvas;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MainThread implements Runnable {
    private Canvas mainCanvas;
    private Lock lock;
    private List<Creature>fieldlist;
    private int monsterConut;
    List<Thread> allThread = new ArrayList<>();
    private static Image cwinner = new Image("huluwa.jpg");
    private static Image swinner = new Image("snake.jpeg");
    File f = new File("e:"+File.separator+"test.txt");

    public MainThread(Canvas mainCanvas, List<Creature> fieldlist, Lock lock, int monsterConut){
        this.fieldlist = fieldlist;
        this.lock = lock;
        this.mainCanvas = mainCanvas;
        this.monsterConut = monsterConut;
    }

    private void theCalabashIsWinner(){
        mainCanvas.getGraphicsContext2D().drawImage(cwinner,13,2,600,600);
    }

    private void theMonsterIsWinner(){
        mainCanvas.getGraphicsContext2D().drawImage(swinner,13,2,600,600);
    }

    private void writeFile(){
        try{
            FileOutputStream out=new FileOutputStream(f,true);
            PrintStream p=new PrintStream(out);
            for(int i=0;i<15;i++){
                for(int j=0;j<15;j++){
                    Creature temp = fieldlist.get(i*15+j);
                    if(temp.name!="empty"){
                        p.print(temp.name + " " + temp.X + " " + temp.Y + " ");
                    }
                }
            }
            p.println();
            p.close();
        }catch(IOException e){
            e.printStackTrace() ;
        }
    }

    @Override
    public synchronized void run()
    {
        long startTime=System.currentTimeMillis();
        for(int i=0;i<fieldlist.size();i++)
        {
            if(fieldlist.get(i).name!="empty")
            {
                allThread.add(new Thread(new MyThread(mainCanvas,fieldlist.get(i),new ReentrantLock(),fieldlist)));
            }
        }
        for (Thread t:allThread) {
            t.start();
        }
        while(true){
            lock.lock();
            try {
                InitImage.setImage(mainCanvas.getGraphicsContext2D(), fieldlist);
                writeFile();
                int calabashcount = 0;
                int monsterscount = 0;
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        String name = fieldlist.get(15*i+j).name;
                        if(name == "first" || name == "second" || name == "third" || name == "fourth" || name == "fifth" || name == "sixth" || name == "seventh" || name == "yeye")
                            calabashcount++;
                        if(name == "shejing" || name == "xiezijing" || name == "xiaoyaojing")
                            monsterscount++;
                    }
                    //System.out.println();
                }
                if(monsterscount == 0 || calabashcount == 0){
                    if(monsterscount == 0) {
                        theCalabashIsWinner();
                    }
                    if(calabashcount == 0){
                        theMonsterIsWinner();
                    }
                    for (Thread p:allThread) {
                        p.interrupt();
                    }
                    return;
                }
                if(System.currentTimeMillis()-startTime>=1000*30)
                {
                    if(this.monsterConut>8 && monsterscount-calabashcount>=2){
                        theMonsterIsWinner();
                    }
                    else if(this.monsterConut == 8 && monsterscount>calabashcount) {
                        theMonsterIsWinner();
                    }
                    else if(this.monsterConut == 8 && monsterscount<=calabashcount){
                        theCalabashIsWinner();
                    }
                    else theCalabashIsWinner();
                    for (Thread p:allThread) {
                        p.interrupt();
                    }
                    return;
                }
                try {
                    Thread.sleep(100);
                }catch(InterruptedException ex)
                {
                    Thread.interrupted();
                }
            }
            finally {
                lock.unlock();
            }
        }
    }
}
