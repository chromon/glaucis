package com.test.utils;

import java.awt.Toolkit;

//获取屏幕宽高工具类
public class ScreenSizeUtils {
	
	private int screenWidth = 0;
	private int screenHeight = 0;
	
	private Toolkit tool = null;
	
	public ScreenSizeUtils(){
		tool =  Toolkit.getDefaultToolkit();
	}
	
	public int getScreenWidth(){
		screenWidth = tool.getScreenSize().width;
		return screenWidth;
	}
	
	public int getScreenHeight(){
		screenHeight = tool.getScreenSize().height;
		return screenHeight;
	}
}
