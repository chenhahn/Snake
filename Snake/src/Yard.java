import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//next paint

public class Yard extends Frame{

    private boolean flag = true;

    public static final int ROWS = 30;
    public static final int COLUMNS = 30;
    public static final int BLOCK_SIZE = 15;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score = 0;

    private Snake s = new Snake(this);
    private Egg e = new Egg();

    Image offScreenImage = null;




    public void launch(){
        this.setLocation(300,300);
        this.setSize(COLUMNS*BLOCK_SIZE,ROWS*BLOCK_SIZE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        this.addKeyListener(new KeyMonitor());
        new Thread(new PaintThread()).start();
    }



    public static void main(String[] args){
        new Yard().launch();
    }

    public void stop(){
        flag = false;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(0,0,COLUMNS*BLOCK_SIZE,ROWS*BLOCK_SIZE);
        g.setColor(Color.DARK_GRAY);
        //print the line
        for(int i=1;i<ROWS; i++){
            g.drawLine(0,BLOCK_SIZE*i,COLUMNS*BLOCK_SIZE,BLOCK_SIZE*i);
        }
        //print columns
        for(int i=1;i<COLUMNS; i++){
            g.drawLine(BLOCK_SIZE*i,0,BLOCK_SIZE*i,ROWS*BLOCK_SIZE);
        }

        g.setColor(Color.yellow);
        g.drawString("score:" + score, 10, 60);
        g.setColor(c);
        s.eat(e);
        e.draw(g);
        s.draw(g);

        if(flag == false){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString("game over", 10, 80);
        }
    }

    @Override
    public void update(Graphics g) {
        if(offScreenImage==null){
            offScreenImage = this.createImage(COLUMNS*BLOCK_SIZE,ROWS*BLOCK_SIZE);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    private class PaintThread implements Runnable{

        @Override
        public void run() {
            while(flag){
                repaint();
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private class KeyMonitor extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent k) {
            s.keyPressed(k);
        }
    }
}
