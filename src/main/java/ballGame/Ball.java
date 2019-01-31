package ballGame;

import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by amarsoft on 17-7-31.
 */
public class Ball {
    private int x,y,size,movex,movey;
    private Color color;

    public Ball(int x, int y, int size, int movex, int movey, Color color){
        super();
        this.x = x;
        this.y = y;
        this.size = size;
        this.movex = movex;
        this.movey = movey;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMovex() {
        return movex;
    }

    public void setMovex(int movex) {
        this.movex = movex;
    }

    public int getMovey() {
        return movey;
    }

    public void setMovey(int movey) {
        this.movey = movey;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawBall(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,size,size);
    }

    public void moveBall(){
        x = x + movex;
        y = y + movey;
    }

    public void clearBall(Graphics g,BallMain bm){
        g.setColor(bm.getBackground());
        g.fillOval(x - movex, y-movey,size,size);
    }

    //碰撞函数
    public void collision(Graphics g, BallMain bm, ArrayList<Ball> ball){
        if(x+size >= bm.getWidth() || x <= 0){
            movex = -movex;
        }
        if(y<=30||y+size>=bm.getHeight()){
            movey = -movey;
        }
        for(int i=0; i < ball.size(); i++){
            Ball myball = (Ball) ball.get(i);
            if(myball != this){
                double xx = Math.abs(this.x - myball.x);
                double yy = Math.abs(this.y - myball.y);
                double xy = Math.sqrt(xx*xx+yy*yy);
                int tempx = 0;
                int tempy = 0;
                if(xy<=(this.size/2+myball.size/2)){
                    tempx = this.movex;
                    tempy = this.movey;
                    this.movex = myball.movex;
                    this.movey = myball.movey;
                    myball.movey = tempx;
                    myball.movex = tempy;
                    this.movex = -this.movex;
                    this.movey = -this.movey;
                    myball.movey = -myball.movey;
                    myball.movex = -myball.movex;
                }
            }
        }
    }
}
