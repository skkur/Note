package note;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

/*当前类是窗体类(从Frame派生),
 实现ActionListener,做ActionEvent监听器*/
public class Note extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	MenuBar mb;
	Menu menuFile, menuEdit;
	MenuItem itemNew, itemOpen, itemSave, itemExit;
	MenuItem itemCopy, itemCut, itemPaste, itemDelete;
	TextArea ta;
	// 定义弹出菜单和菜单项
	PopupMenu pm;
	Menu menuBg;
	MenuItem itemFont, itemRed, itemGreen;

	// 定义构造方法，初始化组件，添加到窗体，设置窗体大小和可见性
	public Note() {
		// 调用父类Frame的构造方法，设置标题
		super("记事本");
		// 初始化菜单条
		mb = new MenuBar();
		// 把菜单条添加到窗体
		this.setMenuBar(mb);
		// 初始化文件菜单
		menuFile = new Menu("文件");
		// 初始化文件菜单中的菜单项
		MenuShortcut msNew = new MenuShortcut(KeyEvent.VK_N);
		itemNew = new MenuItem("新建", msNew);
		itemOpen = new MenuItem("打开", new MenuShortcut(KeyEvent.VK_O));
		itemSave = new MenuItem("保存", new MenuShortcut(KeyEvent.VK_S));
		itemExit = new MenuItem("退出");

		// 为菜单项注册监听
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);
		// 把菜单项添加到菜单
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.addSeparator();
		menuFile.add(itemExit);
		// 把文件菜单添加到菜单条
		mb.add(menuFile);
		// 初始化文本组件，添加到窗体
		ta = new TextArea();
		this.add(ta, BorderLayout.CENTER);
		// 初始化弹出菜单、子菜单、菜单项
		pm = new PopupMenu();
		menuBg = new Menu("背景");
		itemFont = new MenuItem("字体");
		itemRed = new MenuItem("红色");
		itemGreen = new MenuItem("绿色");
		// 把弹出菜单添加到文本组件
		ta.add(pm);
		// 在弹出菜单中添加菜单项
		pm.add(itemFont);
		// 在弹出菜单中添加子菜单
		pm.add(menuBg);
		// 在子菜单中添加菜单项
		menuBg.add(itemRed);
		menuBg.add(itemGreen);
		// 在弹出菜单菜单项上注册监听
		itemFont.addActionListener(this);
		itemRed.addActionListener(this);
		itemGreen.addActionListener(this);
		// 在文本组件上注册鼠标监听
		ta.addMouseListener(new MouseListen());
		// 注册监听，关闭窗口
		/*
		 * this.addWindowListener(new WindowAdapter(){ public void
		 * windowClosing(WindowEvent e) { System.exit(0); } });
		 */
		// 设置窗体大小和可见性
		this.setSize(600, 500);
		this.setVisible(true);
		this.setLocation(700, 300);
	}

	public static void main(String[] args) {
		new Note();
	}

	// 重写从ActionListener继承的抽象方法(事件处理方法)
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("新建")) {
			new Note();
		}
		if (command.equals("打开")) {

		}
		if (command.equals("保存")) {

		}
		if (command.equals("退出")) {
			// System.exit(0);
			this.dispose();
			/* this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
		}
		if (command.equals("字体")) {
			ta.setFont(new Font("宋体", Font.BOLD, 26));
		}
		if (command.equals("红色")) {
			ta.setBackground(Color.red);
		}
		if (command.equals("绿色")) {
			ta.setBackground(Color.green);
		}
	}

	class MouseListen extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
				pm.show(ta, e.getX(), e.getY());
			}
		}

	}
}
