package test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class WebCrawler extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//窗口的宽度和窗口的高度
	private int windowWidth = 800;
	private int windowHeight = 600;
	
	//菜单
	private JMenuBar menuBar = null;
	private JMenu fileMenu = null;
	private JMenuItem savePageItem = null;
	private JMenuItem saveEmailItem = null;
	private JMenuItem exitItem = null;
	private JMenu operateMenu = null;
	private JMenuItem downloadItem = null;
	private JMenuItem crawleItem = null;
	private JMenu helpMenu = null;
	private JMenuItem aboutItem = null;
	
	//顶部、中心及右侧Panel
	private JPanel topPanel = null;
	private JPanel centerPanel = null;
	private JPanel rightPanel = null;
	
	//顶部输入框、下载按钮及爬取按钮
	private JLabel urlLabel = null;
	private JTextField urlField = null;
	private JButton downloading = null;
	private JButton crawling = null;
	
	//中心显示
	private static JTextArea pageView = null;
	
	//右侧显示
	private static JTextArea emailView = null;
	
	//状态栏
	private JToolBar toolBar = null;
	private static JLabel toolBarMsg = null;
	
	//保存文件
	private JFileChooser chooser = null;
	
	//页面正文
	static String content = "";
	
	public void init() {
		this.setTitle("Web Page Crawler");
		this.setBounds(300, 200, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		//主体布局
		this.setLayout(new BorderLayout());
		
		//菜单
		menuBar = new JMenuBar();
		
		//文件Menu
		fileMenu = new JMenu("文件");
		savePageItem = new JMenuItem("保存网页到文件");
		saveEmailItem = new JMenuItem("保存邮件到文件");
		exitItem = new JMenuItem("退出");
		exitItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Component cmp= e.getComponent();
            	while(!(cmp instanceof JFrame ) || cmp.getParent() !=null ){
            		cmp = cmp.getParent();
            	}
            	((JFrame)cmp).dispose();
			}
		});
		//保存对话框
		chooser = new JFileChooser();
	    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    savePageItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
//				File file = new File("mongrove.tiff");
//	            chooser.setSelectedFile(file);//设置默认文件名
//	            int retval = chooser.showSaveDialog(this);//显示“保存文件”对话框
//	            if(retval == JFileChooser.APPROVE_OPTION) {
//	                file = chooser.getSelectedFile();
//	                System.out.println("File to save " + file);
//	            }
			}
		});
		
		//操作Menu
		operateMenu = new JMenu("操作");
		downloadItem = new JMenuItem("下载页面");
		crawleItem = new JMenuItem("爬取邮件地址");
		downloadItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				WebCrawler.download(urlField.getText());
			}
		});
		crawleItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				WebCrawler.crawlingEmail();
			}
		});
		
		//帮助Menu
		helpMenu = new JMenu("帮助");
		aboutItem = new JMenuItem("关于");
		
		fileMenu.add(savePageItem);
		fileMenu.add(saveEmailItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		operateMenu.add(downloadItem);
		operateMenu.add(crawleItem);
		menuBar.add(operateMenu);
		helpMenu.add(aboutItem);
		menuBar.add(helpMenu);
		
		//顶部Panel
		topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		urlLabel = new JLabel("地址：");
		urlField = new JTextField(100);
		downloading = new JButton("下载");
		crawling = new JButton("爬取");
		downloading.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WebCrawler.download(urlField.getText());
			}
		});
		crawling.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WebCrawler.crawlingEmail();
			}
		});
		
		topPanel.add(urlLabel);
		topPanel.add(urlField);
		topPanel.add(downloading);
		topPanel.add(crawling);
		
		//中心Panel
		centerPanel = new JPanel();
		pageView = new JTextArea(26, 71);
		pageView.setLineWrap(true);
		pageView.setWrapStyleWord(true);
		centerPanel.add(BorderLayout.CENTER, new JScrollPane(pageView));
		
		//右侧Panel
		rightPanel = new JPanel();
		emailView = new JTextArea(26, 21);
		emailView.setLineWrap(true);
		emailView.setWrapStyleWord(true);
		rightPanel.add(BorderLayout.CENTER, new JScrollPane(emailView));
		
		//状态栏
		toolBar = new JToolBar();
		toolBarMsg = new JLabel();
		toolBar.add(toolBarMsg);
		
		this.setJMenuBar(menuBar);
		this.add(BorderLayout.NORTH, topPanel);
		this.add(BorderLayout.CENTER, centerPanel);
		this.add(BorderLayout.SOUTH, toolBarMsg);
		this.add(BorderLayout.EAST, rightPanel);
		this.setVisible(true);
	}
	
	public static void download(String strUrl) {
		new Thread( ()->{
			try {
				//设置底部状态栏
				toolBarMsg.setText(" 开始下载...");
				
				//获取文件类型及字符编码
				URL url = new URL(strUrl);  
		        URLConnection urlConn = url.openConnection();  
				String[] type = urlConn.getContentType().split(";");
				String[] charset = urlConn.getContentType().split("=");
				
				String msg = "";
				if(charset.length > 1) {
					msg = "当前文件类型："+type[0]+ "\n当前字符编码：" +charset[1];
				}else {
					msg = "当前文件类型："+type[0]+ "\n当前字符编码：编码类型未知";
				}
				
				//显示文件类型及字符编码
				JOptionPane.showMessageDialog(null, msg);
				
				//下载文件
				InputStream stream = url.openStream();
				BufferedReader reader = null;
				if(charset.length > 1) {
					reader = new BufferedReader(new InputStreamReader(stream, charset[1]));
				}else {
					reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
				}
				StringBuilder sb = new StringBuilder();
				String line; 
				while ((line = reader.readLine()) != null) { 
					//parse(line);
					sb.append(line+"\n"); 
				}

				content = sb.toString();
				//parse(content);
				SwingUtilities.invokeLater(()->{
					pageView.append(content);
					toolBarMsg.setText(" 下载完成!");
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	public static void crawlingEmail() {
		new Thread( ()->{
			try {
				//设置底部状态栏
				toolBarMsg.setText(" 开始爬取邮件地址...");
				
				parse(content);
				
				SwingUtilities.invokeLater(()->{
					toolBarMsg.setText(" 邮件地址爬取完成!");
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	public static void parse(String line) {  
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(line);  
		while(m.find()) {  
			emailView.append(m.group() + "\n");  
		}  
	}  

	public static void main(String[] args) {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		new WebCrawler().init();
	}

}
