package ballGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by amarsoft on 17-Java7-31.
 */
public class BallMain extends JFrame{
    private ArrayList<Ball> ball = new ArrayList<Ball>();
    private Image img;
    private Graphics2D g2d;

    public static void main(String[] args){
        BallMain bm = new BallMain();
        bm.InitUI();
    }

    public void InitUI(){
        this.setTitle("Ball");
        this.setSize(1366,768);
        this.setDefaultCloseOperation(3);
        this.setPreferredSize(null);
        this.setResizable(false);
        this.setVisible(true);
        BallListenner bl = new BallListenner(this,ball);
        this.addMouseListener(bl);
        this.addKeyListener(bl);
        Thread td = new Thread(bl);
        td.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        if(img==null) img=this.createImage(this.getWidth(),this.getHeight());
        g2d = (Graphics2D) img.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        for(int i=0; i<ball.size(); i++){
            Ball myball = (Ball)ball.get(i);
            myball.clearBall(g2d,this);
            myball.moveBall();
            myball.collision(g2d,this,ball);
            myball.drawBall(g2d);
        }
        System.out.println(ball.size());
        g.drawImage(img,0,0,this);
    }
}
