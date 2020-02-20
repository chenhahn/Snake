import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//next paint

public class Yard extends Frame{

    private static final int ROWS = 50;
    private static final int COLUMNS = 50;
    private static final int BLOCK_SIZE = 10;

    //Image offScreenImage = null;




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
    }



    public static void main(String[] args){
        new Yard().launch();

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
        g.setColor(c);
    }
}
