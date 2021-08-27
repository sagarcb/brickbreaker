
package brickbreaker17;

import javax.swing.JFrame;

public class main {

    
    public static void main(String[] args) {
    
        JFrame obj=new JFrame();
        
        GamePlay gamePlay = new GamePlay();
        //GamePlay1 gamePlay1 = new GamePlay1(); 
        
        obj.setBounds(50,50,700,600);
        obj.setTitle("Brick Breaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        obj.add(gamePlay);    
        //obj.add(gamePlay1); 
       
    }
    
}
