
package brickbreaker17;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
//import static java.awt.SystemColor.MENU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;// it is for not to start play after open the game.
    private int score = 0;
    private int highScore  = 0; 

    private Timer time;
    private int delay = 8; // its for the ball speed with time

    private int playerx = 320; //slider position
    private int ballposx = 310;//ball position
    private int ballposy = 530;//ball position
    private int balldirecx = -1;//ball direction.
    private int balldirecy = -2;

    private int totalBricks = 12;
    //private int totalBricks1 = 35; 

    private MapGenarator map;
    //private MapGenarator map1; 
    
    //Front page
    public static enum STATE {

        MENU,
        GAME

    };
    public static STATE state = STATE.MENU;

    public static MENU manu;

    //adding image
    //for the game playing background
    public ImageIcon image;
    public JLabel imageLabel;
    public Image img;

    //for the Game playing background
    public void initComponent() {

        this.setLayout(null);
        image = new ImageIcon(getClass().getResource("img.jpg"));
        img = new ImageIcon(getClass().getResource("img.jpg")).getImage();
        imageLabel = new JLabel(image);
        imageLabel.setBounds(10, 10, 700, 600);
        this.add(imageLabel);
    }

    public GamePlay() { //it is a constructor 

        map = new MapGenarator(3, 4);
        
        manu = new MENU();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        time = new Timer(delay, this);
        time.start();
        initComponent();

        //for the mouse class
        this.addMouseListener(new MouseInput());

    }

    public void paint(Graphics g) {

        if (state == STATE.GAME) {
            //Back ground
            g.setColor(Color.GRAY);
            g.fillRect(1, 1, 692, 592);

            //drawing of image
            g.drawImage(img, 1, 1, 700, 600, this);

        //draw of brick
            map.draw((Graphics2D) g);
            //map1.draw((Graphics2D) g);
            
        //map1.draw((Graphics2D) g);

            //score
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Score:" + score, 570, 40);
            
            //High Score
            g.setColor(Color.WHITE);
            g.setFont(new Font ("serif", Font.BOLD, 25));
            g.drawString("High Score:" + highScore, 30, 40);

            //border
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 3, 592);
            g.fillRect(0, 0, 692, 3);
            g.fillRect(691, 0, 3, 592);

            //paddle
            g.setColor(Color.WHITE);
            g.fillRect(playerx, 560, 80, 10);

            //ball
            g.setColor(Color.YELLOW);
            g.fillOval(ballposx, ballposy, 12, 12);

            if (totalBricks == 0) {
                play = false;
                balldirecx = 0;
                balldirecy = 0;

                g.setColor(Color.YELLOW);
                g.setFont(new Font("serif", Font.BOLD, 30));
                g.drawString("You won.\n Score " + score, 210, 300);

                g.setFont(new Font("serif", Font.BOLD, 20));
                g.drawString("Press Up to go next Level.", 225, 330);

            }
            

            if (ballposy > 570) {
                play = false;
                balldirecx = 0;
                balldirecy = 0;

                g.setColor(Color.YELLOW);
                g.setFont(new Font("serif", Font.BOLD, 30));
                g.drawString("Game Over, Score " + score, 210, 300);

                g.setFont(new Font("serif", Font.BOLD, 25));
                g.drawString("Press Enter to Restart", 218, 330);

            }
        } else if (state == STATE.MENU) {

            manu.render(g);
        }

        g.dispose();

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        time.start();

        if (play) {
            if (new Rectangle(ballposx, ballposy, 20, 20).intersects(new Rectangle(playerx, 560, 80, 10))) {
                balldirecy = -balldirecy;
            }
            A:
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposx, ballposy, 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)) {
                            map.setBrickValue(0, i, j);
                            totalBricks--;
                            score += 5;
                            if(score>highScore){
                                highScore = score; 
                            }

                            if (ballposx + 19 <= brickRect.x || ballposx + 1 >= brickRect.x + brickRect.width) {
                                balldirecx = -balldirecx;
                            } else {
                                balldirecy = -balldirecy;
                            }
                            break A;
                        }

                    }
                }
            }

            ballposx += balldirecx;
            ballposy += balldirecy;
            if (ballposx < 0) {
                balldirecx = -balldirecx;
            }
            if (ballposy < 0) {
                balldirecy = -balldirecy;
            }
            if (ballposx > 670) {
                balldirecx = -balldirecx;
            }

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (state == STATE.GAME) {
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (playerx >= 600) {
                    playerx = 600;
                } else {
                    moveRight();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                if (playerx < 10) {
                    playerx = 10;
                } else {
                    moveLeft();
                }
            }
            //Level-2
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                if (!play) {
                    play = true;
                    ballposx = 310;
                    ballposy = 530;
                    balldirecx = -1;
                    balldirecy = -2;
                    playerx = 310;
                    score = 5*12;
                    totalBricks = 21;
                    map = new MapGenarator(3, 7);

                    repaint();
                }
            }
            //Level-3
            if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                if (!play) {
                    play = true;
                    ballposx = 310;
                    ballposy = 530;
                    balldirecx = -1;
                    balldirecy = -2;
                    playerx = 310;
                    score = (5*12)+(5*7);
                    totalBricks = 35;
                    map = new MapGenarator(5, 7);

                    repaint();
                }
            }

            if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                if (play) {
                    play = false;
                } else if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    play = true;
                }
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!play) {
                    play = true;
                    ballposx = 120;
                    ballposy = 350;
                    balldirecx = -1;
                    balldirecy = -2;
                    playerx = 310;
                    score = 0;
                    totalBricks = 12;
                    map = new MapGenarator(3, 4);

                    repaint();
                }
            }

        }

    }

    public void moveRight() {
        play = true;
        playerx += 15;
    }

    public void moveLeft() {
        play = true;
        playerx -= 15;
    }

}
