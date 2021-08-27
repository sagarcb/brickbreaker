
/*package brickbreaker17;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class MapGenarator1 {
    public int map1[][];
    public int brickWidth1;
    public int brickHeight1;
    int brickHeight;
    public MapGenarator1(int row1,int col1){
        map1 = new int[row1][col1];
        for (int[] map11 : map1) {
            for (int j = 0; j<map1[0].length; j++) {
                map11[j] = 1;
            }
        }
        brickWidth1=540/col1;
        brickHeight1=150/row1;
    }
    public void draw(Graphics2D g){
        for(int i=0;i<map1.length;i++){
            for(int j=0;j<map1[0].length;j++){
                if(map1[i][j]>0){
                    g.setColor(java.awt.Color.WHITE);
                    g.fillOval(j*brickWidth1+80, i*brickHeight1+50, brickWidth1, brickHeight1);
                    
                    g.setStroke(new BasicStroke(3));
                    g.setColor(java.awt.Color.black);
                    g.drawRect(j*brickWidth1+80, i*brickHeight1+50, brickWidth1, brickHeight1);
                }
            }
        }
    }
    public void setBrickValue(int value,int row1,int col1){
        map1[row1][col1] =value;
    }
   
}*/