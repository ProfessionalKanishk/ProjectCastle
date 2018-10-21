package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class Panel extends JPanel implements KeyListener, Runnable
{
	//Game game = null;
	BufferedImage background;
	Font f= new Font("Times New Roman",Font.BOLD,35);
	private BufferedImage buffer 	= null;
	private int displayWidth=360;
	private int displayHeight=360;
	private int cellWidth = 40;
	private int cellHeight = 40;
	private int playerWidth =40;
	private int playerHeight =40;
	private int worldWidth;
	private int worldHeight;
	private int playerX;
	private int playerY;
	private boolean first;
	private boolean topleft;
	private boolean left;
	private boolean botleft;
	private boolean top;
	private boolean topright;
	private boolean bot;
	private boolean right;
	private boolean botright;
	
	
	public Panel()
	{
		super();
		setSize(360,600);
		addKeyListener(this);
		buffer = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		//game = new Game();
		first=true;
		Thread t = new Thread(this);                                           
		t.start();
		
		try
		{
			//background=ImageIO.read(new File("Images\\background.PNG"));
		}
		catch(Exception e)
		{
			System.out.println("Error loading Images: "+e.getMessage());
		}
	//ackgro  d=ImageTools.fade(background,.9);
		
	}
	
	public void run()
	{
		/*
		try
		{
			while(true)
			{
				Thread.sleep(25); //221857955                 originally 25   good: 90 50
				game.pickUpCheck();
				game.areaCheck();
				game.lineCheck();
				if(first == false)
					game.moveCheck();
				game.gameCheck();
				game.update();
				
				if(this.getGraphics() != null)
					paint(this.getGraphics());
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in Run");
			e.printStackTrace();
		}
		*/
	}

	public void paint(Graphics s)
	{
		/*
		if(game.getGameOver()==false)
		{
			Graphics g = buffer.getGraphics();
			g.setColor(Color.WHITE);
			g.drawRect(0,0,2000,2000);
			Dango thing = game.getPlayer();
		//	g.drawImage(background,0,0,null);
			
			int startx =0;
			int starty =0;
			if(thing.getX()>160&&thing.getX()<=1080)
				startx=thing.getX()-160;
			else if(thing.getX()<=160)
				startx=0;
			else
				startx=920;
				
			if(thing.getY()>160&&thing.getY()<=600)
				starty=thing.getY()-160;
			else if(thing.getY()<=160)
				starty=0;
			else
				starty=440;
			
			g.drawImage(background,0,0,background.getWidth(),background.getHeight(),startx,starty,background.getWidth()+startx,background.getHeight()+starty,null);
		//	System.out.println(startx+" start y: "+starty); 
			 ////////////coordinates 
			if(startx==0&&starty==0) //top left corner
			{
				g.drawImage(thing.getImage(),thing.getX(),thing.getY(),null);
				thing.setDrawX(thing.getX());
				thing.setDrawY(thing.getY());
			}
			else if(thing.getX()<=1080&&thing.getX()>=160&&starty==0)//top middle
			{
				g.drawImage(thing.getImage(),160,thing.getY(),null);
				thing.setDrawX(160);
				thing.setDrawY(thing.getY());
			}
			else if(thing.getX()>1080&&thing.getY()<=160)   //top right corner
			{
				g.drawImage(thing.getImage(),thing.getX()-920,thing.getY(),null);
				thing.setDrawX(thing.getX()-920);
				thing.setDrawY(thing.getY());
			}
			else if(thing.getX()>1080&&thing.getY()>160&&thing.getY()<=600)  //right middle
			{
				g.drawImage(thing.getImage(),thing.getX()-920,160,null);  
				thing.setDrawX(thing.getX()-920);
				thing.setDrawY(160);
			}
			else if(thing.getX()>1080&&thing.getY()>600) //bottom right corner
			{
				g.drawImage(thing.getImage(),thing.getX()-920,thing.getY()-440,null);
				thing.setDrawX(thing.getX()-920);
				thing.setDrawY(thing.getY()-440);
			}
			else if(thing.getX()<=1080&&thing.getX()>=160&&thing.getY()>=600)		//bottom middle 
			{
				g.drawImage(thing.getImage(),160,thing.getY()-440,null);		//left middle 
				thing.setDrawX(160);
				thing.setDrawY(thing.getY()-440);
			}               
			else if(thing.getX()<160&&thing.getY()>160&&thing.getY()<=600)
			{
				g.drawImage(thing.getImage(),thing.getX(),160,null);
				thing.setDrawX(thing.getX());
				thing.setDrawY(160);
			}
			else if(thing.getX()<160&&thing.getY()>600)   //Bot left corner
			{
				g.drawImage(thing.getImage(),thing.getX(),thing.getY()-440,null); 
				thing.setDrawX(thing.getX());
				thing.setDrawY(thing.getY()-440);
			}
			else
			{
				g.drawImage(thing.getImage(),160,160,null);	
				thing.setDrawX(160);
				thing.setDrawY(160);				     
			} 
				
				                                           //1280*800
	
			ArrayList<Dango> line = game.getLine();
			ArrayList<Dango> area = game.getArea();
			if(line.size()>1)
			{
				for(int x = 1;x<line.size();x++)
				{
					int drawX = 0;
					int drawY = 0;
					int playerX = game.getPlayer().getX();
					int playerY = game.getPlayer().getY();
					int dx = line.get(x).getX();
					int dy = line.get(x).getY();
					if(dx>=game.getPlayer().getX()-280&&dx<=game.getPlayer().getX()+280&&dy>=game.getPlayer().getY()-280&&dy<=game.getPlayer().getY()+280)
					{
						drawX = dx - playerX;
						drawY = dy - playerY;
						
						drawX = game.getPlayer().getDrawX() + drawX;
						drawY = game.getPlayer().getDrawY() + drawY;
					}
					g.drawImage(line.get(x).getImage(),drawX,drawY,null);
				}
			}
			
			for(int x = 0;x<area.size();x++)
			{
				Dango dango = area.get(x);
				int dx = dango.getX();
				int dy = dango.getY();
				if(dx>=game.getPlayer().getX()-280&&dx<=game.getPlayer().getX()+280&&dy>=game.getPlayer().getY()-280&&dy<=game.getPlayer().getY()+280)
				{
					int drawX = 0;
					int drawY = 0;
					int playerX = game.getPlayer().getX();
					int playerY = game.getPlayer().getY();
					drawX = dx - playerX;
					drawY = dy - playerY;
					if(playerX<=160&&playerY<=160)//////top left
					{
						drawX = dx;
						drawY = dy;
					}
					else if(playerX<=160&&playerY>=600)////bot left
					{
						drawX = dx;
						drawY = dy-440;
					}
					else if(playerX>=1080&&playerY<=160)/// top right    
					{
						drawY = dy;
						drawX = dx-920;
					}
					else if(playerX>=1080&&playerY>=600)////bot right      wierd
					{
						drawY = dy-440;
						drawX = dx-920;
					}
					else if(playerX>160&&playerX<1080&&playerY<=160)///topv       
					{		
						drawX = 160 + drawX;
						drawY = dy;
					}
					else if(playerX<=160&&playerY>160&&playerY<600)///left
					{
						drawX = dx;
						drawY = 160+drawY;
					}
					else if(playerX>160&&playerX<1080&&playerY>=600)///bot     
					{
						drawY = dy-440;
						drawX = 160+drawX;
					}
					else if(playerX>=1080&&playerY>160&&playerY<600)///right wierd
					{
						drawX = dx-920;
						drawY = 160+drawY;
					}
					else
					{
						drawX = 160 + drawX;
						drawY = 160 + drawY;
					}
					g.drawImage(dango.getImage(),drawX,drawY,null);
				}
			}
			g.fillRect(0,360,360,360);
			g.setColor(Color.BLACK);
			g.drawRect(20,380,320,200);
			for(int x = 0;x<line.size();x++)
			{
				Dango dango = line.get(x);
				int dangoX = dango.getX()/4;
				int dangoY = dango.getY()/4;
				g.setColor(Color.BLACK);
				g.drawRect(20+dangoX,380+dangoY,10,10);
				g.setColor(Color.YELLOW);
				g.fillRect(21+dangoX,381+dangoY,9,9);	
			}
			g.setColor(Color.BLACK);
			int playerX = game.getPlayer().getX()/4;
			int playerY = game.getPlayer().getY()/4;
			g.drawRect(20+playerX,380+playerY,10,10);
			g.setColor(Color.RED);
			g.fillRect(21+playerX,381+playerY,9,9);
			for(int x = 0;x<area.size();x++)
			{
				Dango dango = area.get(x);
				int dangoX = dango.getX()/4;
				int dangoY = dango.getY()/4;
				g.setColor(Color.BLACK);
				g.drawRect(20+dangoX,380+dangoY,10,10);
				g.setColor(Color.BLUE);
				g.fillRect(21+dangoX,381+dangoY,9,9);	
			}
		}
		
		s.drawImage(buffer,0,0,null);
		*/
	}
	
	public void keyPressed(KeyEvent e)
	{
		/*
		game.getPlayer().setMoving(true);
		char c = e.getKeyChar();
		if((c == 'a'))
		{
			if(game.getLine().size()==1||game.getPlayer().getDirection()!=game.getPlayer().RIGHT)
			{
				game.getPlayer().setDirection(game.getPlayer().LEFT);
				first = false;
			}
		}
		if(c == 'w')
		{
			if(game.getLine().size()==1||game.getPlayer().getDirection()!=game.getPlayer().DOWN)
			{
				game.getPlayer().setDirection(game.getPlayer().UP);
				first = false;
			}
		}
		if(c == 's')
		{
			if(game.getLine().size()==1||game.getPlayer().getDirection()!=game.getPlayer().UP)
			{
				game.getPlayer().setDirection(game.getPlayer().DOWN);
				first = false;
			}
		}
		if(c == 'd')
		{
			if(game.getLine().size()==1||game.getPlayer().getDirection()!=game.getPlayer().LEFT)
			{
				game.getPlayer().setDirection(game.getPlayer().RIGHT);
				first = false;
			}
		}
		if(c == 'n'&&game.getGameOver()==true)
		{
			game = new Game();
			game.setGameOver(false);
			first = true;
		}
		System.out.println(game.getPlayer().getX()+" thing y: "+game.getPlayer().getY());
		*/
	}
	
	public void keyReleased(KeyEvent e)
	{
	}
	
	public void keyTyped(KeyEvent e)
	{
	}
	
	public void addNotify()
	{
		super.addNotify();
		requestFocus();
	}

}