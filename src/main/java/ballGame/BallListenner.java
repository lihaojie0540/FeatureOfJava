package ballGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by amarsoft on 17-7-31.
 */
public class BallListenner extends MouseAdapter implements Runnable,KeyListener{
    private BallMain bm;
    private Graphics g;
    private volatile boolean pauseFlag = true,stopFlag = true;
    private Random rand = new Random();
    private ArrayList<Ball> ball= new ArrayList<Ball>();

    public BallListenner(BallMain bm,ArrayList ball){
        this.bm = bm;
        this.ball = ball;
    }

    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        Ball myball = new Ball(x,y,30,-5,5,new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
        ball.add(myball);
    }

    public void run(){
        while (stopFlag){
            if(pauseFlag){
                bm.repaint();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        System.out.println(code);
        switch(code){
            case 32:
                pauseFlag = !pauseFlag;
                break;
            case 27:
                stopFlag = false;
                break;
            case 82:
                ball.clear();
                bm.repaint();
                stopFlag = true;
                pauseFlag = true;
                new Thread(this).start();
                break;
        }
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }
}
