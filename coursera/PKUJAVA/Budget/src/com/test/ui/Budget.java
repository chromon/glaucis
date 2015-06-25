package com.test.ui;

import javax.swing.JFrame;

import com.test.utils.ScreenSizeUtils;

@SuppressWarnings("serial")
public class Budget extends JFrame{
	
	//窗口的宽度和窗口的高度
	private int windowWidth = 800;
	private int windowHeight = 600;	
	
	//屏幕的宽度和屏幕的高度
	private int screenWidth = 0;
	private int screenHeight = 0;

	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	
	//基础设置
	public void init() {
		this.setTitle("个人收支管理工具");
		this.setLayout(null);
		this.setScreen();
		System.out.println("sadf;las");
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//获取屏幕高度宽度
	public void setScreen() {
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
	}
}
