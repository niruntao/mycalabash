package main;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import java.util.concurrent.locks.ReentrantLock;

import formation.*;
import create.*;
import classification.*;
import initimage.*;
import thread.*;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class MainControl {

    @FXML private Button forma;
    @FXML private Button start;
    @FXML private Button stop;
    @FXML private Button replay;
    @FXML private GridPane imgPane;
    @FXML private Canvas mainCanvas;
    @FXML private Canvas backCanvas;
    private Empty temp = new Empty(0,"empty",0,0,0);
    List<Creature>fieldlist = Empty.getCreatureList();
    public static Creature [][]field = new Creature[15][15];//= temp.CreateField();
    private GraphicsContext mainGraphicsContext;
    private GraphicsContext backContext;
    private Boolean a=false,b=false;
    private int monsters;

    class KeyBoredHandler implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            buttonStartHandle();
        }
    }

    public  void initCalabashStart()
    {
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
            {
                if(i<7)
                    fieldlist.set(i*15+j,new Empty(0,"empty",0,0,0));
            }
        }
        mainGraphicsContext = mainCanvas.getGraphicsContext2D();
    }

    public  void initMonsterStart()
    {
        mainGraphicsContext = mainCanvas.getGraphicsContext2D();
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++)
            {
                if(i>=7)
                    fieldlist.set(i*15+j,new Empty(0,"empty",0,0,0));
            }
        }
    }

    @FXML private void buttonReplayHandle(){
        new Thread(new FileThread(mainCanvas)).start();
    }

    @FXML private void buttonStartHandle()
    {
        File f = new File("e:"+File.separator+"test.txt");
        try{
            if(!f.exists())
                f.createNewFile();
            FileWriter fileWriter =new FileWriter(f);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace() ;
        }
        if(a && b)
        {
            if(monsters > 8){
                for(int i=0;i<fieldlist.size();i++)
                {
                    if(fieldlist.get(i).name == "yeye" || fieldlist.get(i).name == "huluwa") {
                        double te = monsters/8;
                        fieldlist.get(i).hp = (int)te*fieldlist.get(i).hp;
                    }
                }
            }
            new Thread(new MainThread(mainCanvas,fieldlist,new ReentrantLock(),monsters)).start();
        }
        else
        {
            if(a == false){
                initCalabashStart();
                Changshe csa = new Changshe(Classification.values()[0],field,fieldlist);
                InitImage in = new InitImage();
                in.setImage(mainGraphicsContext,fieldlist);
            }
            if(b == false){
                initMonsterStart();
                Changshe cs = new Changshe(Classification.values()[1],field,fieldlist);
                InitImage in = new InitImage();
                in.setImage(mainGraphicsContext,fieldlist);
            }
            try {
                Thread.sleep(500);
            }catch(InterruptedException ex)
            {
                Thread.interrupted();
            }
            new Thread(new MainThread(mainCanvas,fieldlist,new ReentrantLock(),monsters)).start();
        }
    }

    @FXML private void calabashChangshe()
    {
        a = true;
        initCalabashStart();
        Changshe csa = new Changshe(Classification.values()[0],field,fieldlist);
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void calabashHeyi()
    {
        a = true;
        initCalabashStart();
        Heyi csa = new Heyi(Classification.values()[0],field,fieldlist);
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void calabashChonge()
    {
        a = true;
        initCalabashStart();
        Chonge cea = new Chonge(Classification.values()[0],field,fieldlist);
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void calabashYanxing()
    {
        a = true;
        initCalabashStart();
        Yanxing yxa = new Yanxing(Classification.values()[0],field,fieldlist);
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void monsterChangshe()
    {
        b = true;
        initMonsterStart();
        Changshe cs = new Changshe(Classification.values()[1],field,fieldlist);
        monsters = cs.getNumberOfMonster();
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void monsterHeyi()
    {
        b = true;
        initMonsterStart();
        Heyi hy = new Heyi(Classification.values()[1],field,fieldlist);
        monsters = hy.getNumberOfMonster();
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void monsterYanyue()
    {
        b = true;
        initMonsterStart();
        Yanyue yy = new Yanyue(Classification.values()[1],field,fieldlist);
        monsters = yy.getNumberOfMonster();
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void monsterYanxing()
    {
        b = true;
        initMonsterStart();
        Yanxing yy = new Yanxing(Classification.values()[1],field,fieldlist);
        monsters = yy.getNumberOfMonster();
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void monsterFangyuan()
    {
        b = true;
        initMonsterStart();
        Fangyuan fy = new Fangyuan(Classification.values()[1],field,fieldlist);
        monsters = fy.getNumberOfMonster();
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void monsterChonge()
    {
        b = true;
        initMonsterStart();
        Chonge ce = new Chonge(Classification.values()[1],field,fieldlist);
        monsters = ce.getNumberOfMonster();
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void monsterFengshi()
    {
        b = true;
        initMonsterStart();
        Fengshi fs = new Fengshi(Classification.values()[1],field,fieldlist);
        monsters = fs.getNumberOfMonster();
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
    @FXML private void monsterYulin()
    {
        b = true;
        initMonsterStart();
        Yulin yl = new Yulin(Classification.values()[1],field,fieldlist);
        monsters = yl.getNumberOfMonster();
        InitImage in = new InitImage();
        in.setImage(mainGraphicsContext,fieldlist);
    }
}
