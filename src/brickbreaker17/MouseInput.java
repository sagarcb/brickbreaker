
package brickbreaker17;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me) {
       
    }

    /**
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int mx=e.getX();
        int my=e.getY();
        
         /*public Rectangle playButton=new Rectangle(285,150,120,50);
    public Rectangle helpButton=new Rectangle(285,250,120,50);
    public Rectangle quitButton=new Rectangle(285,350,120,50);
        */
         
         //For the Play button
         if(mx >=285 && mx<=385){
             if(my >=150 && my<=200){
                 GamePlay.state = GamePlay.STATE.GAME;
             }
         }
         
          //For the help button
         if(mx >=285 && mx<=385){
             if(my >=250 && my<=300){
                 JOptionPane.showMessageDialog(null,"Code is not completed yet. Choose other options.","Message.", 2);
             }
         }
         
          //For the quit button
         if(mx >=285 && mx<=385){
             if(my >=350 && my<=400){
                 System.exit(1);
             }
         }
         
         
    }
    
    @Override
    public void mouseReleased(MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
