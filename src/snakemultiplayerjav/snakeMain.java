package snakemultiplayerjav;

import java.awt.Color;
import javax.swing.JFrame;

public class snakeMain {
    
    static void snakeSes(String _mode){
        JFrame obj = new JFrame();
        
        obj.setBounds(10, 10, 905, 700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        if(_mode.equals("snakeSP")==true )
        {
            snakeSP sp = new snakeSP();
            obj.add(sp);
        }
        
        if(_mode.equals("snakeMP")==true )
        {
            snakeMP mp = new snakeMP();
            obj.add(mp);
        }              
    }
}
