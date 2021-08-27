
package brickbreaker17;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MENU extends JPanel {
    
    public Rectangle playButton=new Rectangle(285,150,120,50);
    public Rectangle helpButton=new Rectangle(285,250,120,50);
    public Rectangle quitButton=new Rectangle(285,350,120,50);
    
    public ImageIcon image1;
    public JLabel imageLabel1;
    public Image img1;
   
     public void intiComponent1(){
         this.setLayout(null);
        image1=new ImageIcon(getClass().getResource("universe3.jpg"));
        img1=new ImageIcon(getClass().getResource("universe3.jpg")).getImage();
        imageLabel1=new JLabel(image1);
        imageLabel1.setBounds(10,10,700,600);
        this.add(imageLabel1);   
     }
  
    
    public void render(Graphics g){
        
       
        Graphics2D g2d= (Graphics2D)g;
        
        //for background
        g.setColor(Color.black);
        g.fillRect(1, 1, 700, 600);
       //for background color
        
        
        Font fnt0=new Font("arial",Font.BOLD,50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("BRICK BREAKER",130,80);
        
        Font fnt1= new Font("arial",Font.BOLD,25);
        g.setFont(fnt1);
        g.drawString("PLAY", playButton.x+30,playButton.y+35);
        g.drawString("HELP", helpButton.x+30,helpButton.y+35);
        g.drawString("EXIT", quitButton.x+30,quitButton.y+35);
        
        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(quitButton);
         
    }
}
