package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
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
	private JTextArea pageView = null;
	
	//右侧显示
	private JTextArea emailView = null;
	
	//状态栏
	private JToolBar toolBar = null;
	private JLabel toolBarMsg = null;
	
	public void init() {
		this.setTitle("Web Page Crawler");
		this.setBounds(300, 200, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//主体布局
		this.setLayout(new BorderLayout());
		
		//菜单
		menuBar = new JMenuBar();
		fileMenu = new JMenu("文件");
		savePageItem = new JMenuItem("保存网页到文件");
		saveEmailItem = new JMenuItem("保存邮件到文件");
		exitItem = new JMenuItem("退出");
		operateMenu = new JMenu("操作");
		downloadItem = new JMenuItem("下载页面");
		crawleItem = new JMenuItem("爬取邮件地址");
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
				
			}
		});
		
		topPanel.add(urlLabel);
		topPanel.add(urlField);
		topPanel.add(downloading);
		topPanel.add(crawling);
		
		//中心Panel
		centerPanel = new JPanel();
		//centerPanel.setBackground(Color.black);
		pageView = new JTextArea(24, 85);
		centerPanel.add(BorderLayout.CENTER, pageView);
		
		//右侧Panel
		rightPanel = new JPanel();
		emailView = new JTextArea(24, 20);
		rightPanel.add(BorderLayout.CENTER, emailView);
		
		//状态栏
		toolBar = new JToolBar();
		toolBarMsg = new JLabel("downloading...");
		toolBar.add(toolBarMsg);
		
		this.setJMenuBar(menuBar);
		this.add(BorderLayout.NORTH, topPanel);
		this.add(BorderLayout.CENTER, centerPanel);
		this.add(BorderLayout.SOUTH, toolBarMsg);
		this.add(BorderLayout.EAST, rightPanel);
		this.setVisible(true);
	}
	
//	public static String download(String url) {
//		new Thread( ()->{
//			String content = getContentFromUrl(url);
//			SwingUtilities.invokeLater(()->{
//				textArea.append( content );
//			});
//		}).start();
//	}

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
