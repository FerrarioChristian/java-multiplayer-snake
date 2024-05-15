package snakemultiplayerjav;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class snakeMP extends JPanel implements KeyListener, ActionListener{
    
    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];
    
    private int[] snakexlength2 = new int[750];
    private int[] snakeylength2 = new int[750];
    
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    
    private boolean left2 = false;
    private boolean right2 = false;
    private boolean up2 = false;
    private boolean down2 = false;
    
    private boolean gameover = false;
    private boolean gameover2 = false;
    
    private ImageIcon dx;
    private ImageIcon sx;
    private ImageIcon su;
    private ImageIcon giu;
    
    private ImageIcon dx2;
    private ImageIcon sx2;
    private ImageIcon su2;
    private ImageIcon giu2;
    
    private int lengthofsnake = 3;
    private int lengthofsnake2 = 3;
    
    private Timer timer;
    private int delay = 70;
    private ImageIcon corpo;
    private ImageIcon corpo2;
    
    private int[] enemyxpos = {25,50,75,100,125,150,175,200,225,250,275,
    300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,
    725,750,775,800,825,850};
    
    private int[] enemyypos = {100,125,150,175,200,225,250,275,
    300,325,350,375,400,425,450,475,500,525,550,575,600,625};
    
    private ImageIcon punto;
    
    private Random random = new Random();
    
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(20);
    
    private int score = 0;
    private int score2 = 0;
    
    private int moves = 0;
    private int moves2 = 0;
    
    private ImageIcon titleImage;
    
    public snakeMP()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }
    
    public void paint(Graphics g)
    {
        if(moves == 0)
        {
            snakexlength[2] = 50;
            snakexlength[1] = 75;
            snakexlength[0] = 100;
            
            snakeylength[2] = 100;
            snakeylength[1] = 100;
            snakeylength[0] = 100;
            
            snakexlength2[2] = 50;
            snakexlength2[1] = 75;
            snakexlength2[0] = 100;
            
            snakeylength2[2] = 550;
            snakeylength2[1] = 550;
            snakeylength2[0] = 550;
            
        }
        
        //disegno il bordo del titolo
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        //disegno il titolo
        titleImage = new ImageIcon("images/titolo.jpg");
        titleImage.paintIcon(this, g, 25, 11);
        
        //disegno il bordo del gioco
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        
        //disegno lo sfondo del gioco
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        
        //scrivo il punteggio a schermo
        g.setColor(Color.red);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        String giocatore1 = FXMLDocumentController.getNome();
        if(giocatore1==null)
            g.drawString("Ospite: " +score, 780,30);
        else
            g.drawString(giocatore1+": " +score, 780,30);
        
        //scrivo il punteggio a schermo
        g.setColor(Color.red);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Ospite: " +score2, 780,50);
        
        
        dx = new ImageIcon("images/dx.png");
        dx.paintIcon(this, g, snakexlength[0], snakeylength[0]);
        
        dx2 = new ImageIcon("images/dx2.png");
        dx2.paintIcon(this, g, snakexlength2[0], snakeylength2[0]);
        
        for(int a = 0; a<lengthofsnake; a++)
        {
            if(a==0  && right)
            {
                dx = new ImageIcon("images/dx.png");
                dx.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            
            if(a==0  && left)
            {
                sx = new ImageIcon("images/sx.png");
                sx.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            
            if(a==0  && up)
            {
                su = new ImageIcon("images/su.png");
                su.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            
            if(a==0  && down)
            {
                giu = new ImageIcon("images/giu.png");
                giu.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            
            if(a!=0)
            {
                corpo = new ImageIcon("images/corpo.png");
                corpo.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            
        }
        
        for(int a = 0; a<lengthofsnake2; a++)
        {
            if(a==0  && right2)
            {
                dx2 = new ImageIcon("images/dx2.png");
                dx2.paintIcon(this, g, snakexlength2[a], snakeylength2[a]);
            }
            
            if(a==0  && left2)
            {
                sx2 = new ImageIcon("images/sx2.png");
                sx2.paintIcon(this, g, snakexlength2[a], snakeylength2[a]);
            }
            
            if(a==0  && up2)
            {
                su2 = new ImageIcon("images/su2.png");
                su2.paintIcon(this, g, snakexlength2[a], snakeylength2[a]);
            }
            
            if(a==0  && down2)
            {
                giu2 = new ImageIcon("images/giu2.png");
                giu2.paintIcon(this, g, snakexlength2[a], snakeylength2[a]);
            }
            
            if(a!=0)
            {
                corpo2 = new ImageIcon("images/corpo2.png");
                corpo2.paintIcon(this, g, snakexlength2[a], snakeylength2[a]);
            }
            
        }
        
        punto = new ImageIcon("images/punto.png");
        
        if((enemyxpos[xpos] == snakexlength[0]) && enemyypos[ypos] == snakeylength[0])
        {
            lengthofsnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(20);
            score= score+1;
        }
        
        if((enemyxpos[xpos] == snakexlength2[0]) && enemyypos[ypos] == snakeylength2[0])
        {
            lengthofsnake2++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(20);
            score2= score2+1;
        }
        
        punto.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
        
        for(int b=1; b<lengthofsnake; b++)
        {
            if((snakexlength[0] == snakexlength[b]) && (snakeylength[0] == snakeylength[b]))
            {
                left = false;
                right = false;
                up = false;
                down = false;
                
                gameover = true;
                Color viola = new Color(102, 0, 204);
                g.setColor(viola);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Giocatore2 ha vinto!!", 250, 300);
                
                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Spazio per ricominciare.", 320, 340);
            }
        }
        
        for(int b=1; b<lengthofsnake2; b++)
        {
            if((snakexlength2[0] == snakexlength2[b]) && (snakeylength2[0] == snakeylength2[b]))
            {
                left2 = false;
                right2 = false;
                up2 = false;
                down2 = false;
                
                gameover2 = true;
                Color viola = new Color(102, 0, 204);
                g.setColor(viola);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Giocatore1 ha vinto!!", 250, 300);
                
                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Spazio per ricominciare.", 320, 340);
            }
        }
        
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
   
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            moves = 0;
            score = 0;
            lengthofsnake = 3;
            left = false;
            right = true;
            up = false;
            down = false;
            
            gameover = false;
            
            moves2 = 0;
            score2 = 0;
            lengthofsnake2 = 3;
            left2 = false;
            right2 = true;
            up2 = false;
            down2 = false;
            
            gameover2 = false;
        }
        if(!gameover && !gameover2)
        {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            moves++;
            if(!left)
            {
                right = true;
            }
            else
            {
                right = false;
                left = true;
                
            }
            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            moves++;
            if(!right)
            {
                left = true;
            }
            else
            {
                left = false;
                right = true;
                
            }
            up = false;
            down = false;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            moves++;
            if(!down)
            {
                up = true;
            }
            else
            {
                up = false;
                down = true;
                
            }
            left = false;
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            moves++;
            if(!up)
            {
                down = true;
            }
            else
            {
                down = false;
                up = true;
                
            }
            left = false;
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            moves2++;
            if(!left2)
            {
                right2 = true;
            }
            else
            {
                right2 = false;
                left2 = true;
                
            }
            up2 = false;
            down2 = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            moves2++;
            if(!right2)
            {
                left2 = true;
            }
            else
            {
                left2 = false;
                right2 = true;
                
            }
            up2 = false;
            down2 = false;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            moves2++;
            if(!down2)
            {
                up2 = true;
            }
            else
            {
                up2 = false;
                down2 = true;
                
            }
            left2 = false;
            right2 = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            moves2++;
            if(!up2)
            {
                down2 = true;
            }
            else
            {
                down2 = false;
                up2 = true;
                
            }
            left2 = false;
            right2 = false;
        }
    }}

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(right)
        {
            for(int r = lengthofsnake-1; r>=0; r--)
            {
                snakeylength[r+1] = snakeylength[r];
            }
              for(int r = lengthofsnake; r>=0; r--)
            {
                if(r==0)
                {
                    snakexlength[r] = snakexlength[r] + 25;
                }
                else
                {
                    snakexlength[r] = snakexlength[r-1] ;
                }
                if(snakexlength[r] > 850)
                {
                    snakexlength[r] = 25;
                }
                
            }
              repaint();
        }
        
        if(left)
        {
              for(int r = lengthofsnake-1; r>=0; r--)
            {
                snakeylength[r+1] = snakeylength[r];
            }
              for(int r = lengthofsnake; r>=0; r--)
            {
                if(r==0)
                {
                    snakexlength[r] = snakexlength[r] - 25;
                }
                else
                {
                    snakexlength[r] = snakexlength[r-1] ;
                }
                if(snakexlength[r] < 25)
                {
                    snakexlength[r] = 850;
                }
                
            }
              repaint();
        }
        
        if(up)
        {
              for(int r = lengthofsnake-1; r>=0; r--)
            {
                snakexlength[r+1] = snakexlength[r];
            }
              for(int r = lengthofsnake; r>=0; r--)
            {
                if(r==0)
                {
                    snakeylength[r] = snakeylength[r] - 25;
                }
                else
                {
                    snakeylength[r] = snakeylength[r-1] ;
                }
                if(snakeylength[r] < 75)
                {
                    snakeylength[r] = 625;
                }
                
            }
              repaint();
        }
        
        if(down)
        {
              for(int r = lengthofsnake-1; r>=0; r--)
            {
                snakexlength[r+1] = snakexlength[r];
            }
              for(int r = lengthofsnake; r>=0; r--)
            {
                if(r==0)
                {
                    snakeylength[r] = snakeylength[r] + 25;
                }
                else
                {
                    snakeylength[r] = snakeylength[r-1] ;
                }
                if(snakeylength[r] > 625)
                {
                    snakeylength[r] = 75;
                }
                
            }
              repaint();
              
              
        }
        
        if(right2)
        {
            for(int r = lengthofsnake2-1; r>=0; r--)
            {
                snakeylength2[r+1] = snakeylength2[r];
            }
              for(int r = lengthofsnake2; r>=0; r--)
            {
                if(r==0)
                {
                    snakexlength2[r] = snakexlength2[r] + 25;
                }
                else
                {
                    snakexlength2[r] = snakexlength2[r-1] ;
                }
                if(snakexlength2[r] > 850)
                {
                    snakexlength2[r] = 25;
                }
                
            }
              repaint();
        }
        
        if(left2)
        {
              for(int r = lengthofsnake2-1; r>=0; r--)
            {
                snakeylength2[r+1] = snakeylength2[r];
            }
              for(int r = lengthofsnake2; r>=0; r--)
            {
                if(r==0)
                {
                    snakexlength2[r] = snakexlength2[r] - 25;
                }
                else
                {
                    snakexlength2[r] = snakexlength2[r-1] ;
                }
                if(snakexlength2[r] < 25)
                {
                    snakexlength2[r] = 850;
                }
                
            }
              repaint();
        }
        
        if(up2)
        {
              for(int r = lengthofsnake2-1; r>=0; r--)
            {
                snakexlength2[r+1] = snakexlength2[r];
            }
              for(int r = lengthofsnake2; r>=0; r--)
            {
                if(r==0)
                {
                    snakeylength2[r] = snakeylength2[r] - 25;
                }
                else
                {
                    snakeylength2[r] = snakeylength2[r-1] ;
                }
                if(snakeylength2[r] < 75)
                {
                    snakeylength2[r] = 625;
                }
                
            }
              repaint();
        }
        
        if(down2)
        {
              for(int r = lengthofsnake2-1; r>=0; r--)
            {
                snakexlength2[r+1] = snakexlength2[r];
            }
              for(int r = lengthofsnake2; r>=0; r--)
            {
                if(r==0)
                {
                    snakeylength2[r] = snakeylength2[r] + 25;
                }
                else
                {
                    snakeylength2[r] = snakeylength2[r-1] ;
                }
                if(snakeylength2[r] > 625)
                {
                    snakeylength2[r] = 75;
                }
                
            }
              repaint();
              
              
        }
    }
    
}

