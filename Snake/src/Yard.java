import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//next paint

public class Yard extends Frame{

    private static final int ROWS = 100;
    private static final int COLUMES = 100;
    private static final int BLOCK_SIZE = 5;

    //Image offScreenImage = null;


    public void launch(){
        this.setLocation(300,300);
        this.setSize(COLUMES*BLOCK_SIZE,ROWS*BLOCK_SIZE);
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

}
