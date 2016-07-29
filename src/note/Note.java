package note;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

/*��ǰ���Ǵ�����(��Frame����),
 ʵ��ActionListener,��ActionEvent������*/
public class Note extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	MenuBar mb;
	Menu menuFile, menuEdit;
	MenuItem itemNew, itemOpen, itemSave, itemExit;
	MenuItem itemCopy, itemCut, itemPaste, itemDelete;
	TextArea ta;
	// ���嵯���˵��Ͳ˵���
	PopupMenu pm;
	Menu menuBg;
	MenuItem itemFont, itemRed, itemGreen;

	// ���幹�췽������ʼ���������ӵ����壬���ô����С�Ϳɼ���
	public Note() {
		// ���ø���Frame�Ĺ��췽�������ñ���
		super("���±�");
		// ��ʼ���˵���
		mb = new MenuBar();
		// �Ѳ˵�����ӵ�����
		this.setMenuBar(mb);
		// ��ʼ���ļ��˵�
		menuFile = new Menu("�ļ�");
		// ��ʼ���ļ��˵��еĲ˵���
		MenuShortcut msNew = new MenuShortcut(KeyEvent.VK_N);
		itemNew = new MenuItem("�½�", msNew);
		itemOpen = new MenuItem("��", new MenuShortcut(KeyEvent.VK_O));
		itemSave = new MenuItem("����", new MenuShortcut(KeyEvent.VK_S));
		itemExit = new MenuItem("�˳�");

		// Ϊ�˵���ע�����
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);
		// �Ѳ˵�����ӵ��˵�
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.addSeparator();
		menuFile.add(itemExit);
		// ���ļ��˵���ӵ��˵���
		mb.add(menuFile);
		// ��ʼ���ı��������ӵ�����
		ta = new TextArea();
		this.add(ta, BorderLayout.CENTER);
		// ��ʼ�������˵����Ӳ˵����˵���
		pm = new PopupMenu();
		menuBg = new Menu("����");
		itemFont = new MenuItem("����");
		itemRed = new MenuItem("��ɫ");
		itemGreen = new MenuItem("��ɫ");
		// �ѵ����˵���ӵ��ı����
		ta.add(pm);
		// �ڵ����˵�����Ӳ˵���
		pm.add(itemFont);
		// �ڵ����˵�������Ӳ˵�
		pm.add(menuBg);
		// ���Ӳ˵�����Ӳ˵���
		menuBg.add(itemRed);
		menuBg.add(itemGreen);
		// �ڵ����˵��˵�����ע�����
		itemFont.addActionListener(this);
		itemRed.addActionListener(this);
		itemGreen.addActionListener(this);
		// ���ı������ע��������
		ta.addMouseListener(new MouseListen());
		// ע��������رմ���
		/*
		 * this.addWindowListener(new WindowAdapter(){ public void
		 * windowClosing(WindowEvent e) { System.exit(0); } });
		 */
		// ���ô����С�Ϳɼ���
		this.setSize(600, 500);
		this.setVisible(true);
		this.setLocation(700, 300);
	}

	public static void main(String[] args) {
		new Note();
	}

	// ��д��ActionListener�̳еĳ��󷽷�(�¼�������)
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("�½�")) {
			new Note();
		}
		if (command.equals("��")) {

		}
		if (command.equals("����")) {

		}
		if (command.equals("�˳�")) {
			// System.exit(0);
			this.dispose();
			/* this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */
		}
		if (command.equals("����")) {
			ta.setFont(new Font("����", Font.BOLD, 26));
		}
		if (command.equals("��ɫ")) {
			ta.setBackground(Color.red);
		}
		if (command.equals("��ɫ")) {
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
