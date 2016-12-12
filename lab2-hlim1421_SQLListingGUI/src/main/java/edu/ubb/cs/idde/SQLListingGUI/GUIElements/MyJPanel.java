package edu.ubb.cs.idde.SQLListingGUI.GUIElements;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class MyJPanel extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int x;
	protected int y;
	protected int szel;
	protected int mag;
	protected int szin;
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		if(szin == 1){
			g.setColor(Color.BLUE);
		}
		if(szin == 2){
			g.setColor(Color.GREEN);
		}
		if(szin == 3){
			g.setColor(Color.RED);
		}
		if(szin == 4){
			g.setColor(Color.WHITE);
		}
		if(szin == 5){
			g.setColor(Color.ORANGE);
		}
		
		//System.out.println("asdasd");
		g.fillRect(x, y, szel, mag);
	}

	
	
	
	public MyJPanel(int x, int y, int szel,int mag,int szin){
		super();
		this.x=x;
		this.y=y;
		this.szel = szel;
		this.mag = mag;
		this.szin = szin;
	}
	
}
