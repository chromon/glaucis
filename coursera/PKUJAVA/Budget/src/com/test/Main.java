package com.test;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.test.ui.Budget;

public class Main {
	public static void main(String[] args) {
		try{
	        BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		Budget budget = new Budget();
		budget.init();
		budget.setVisible(true);
	}
}
