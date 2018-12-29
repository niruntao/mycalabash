package thread;

import create.Creature;
import java.util.concurrent.locks.Lock;
import javafx.scene.canvas.Canvas;
import java.util.*;

public class MyThread implements Runnable {
    private Canvas mainCanvas;
    private Lock lock;
    private Creature being;
    private List<Creature>fieldlist;

    public MyThread(Canvas mainCanvas, Creature being, Lock lock, List<Creature>fieldlist)
    {
        this.being = being;
        this.lock = lock;
        this.mainCanvas = mainCanvas;
        this.fieldlist = fieldlist;
    }

    @Override
    public synchronized void run()
    {
        while(true){
            lock.lock();
            try{
                being.movet(fieldlist);
                try {
                    Thread.sleep(200);
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