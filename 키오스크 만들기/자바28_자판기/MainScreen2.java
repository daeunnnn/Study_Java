package �ڹ�28_���Ǳ�;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MainScreen2 extends Frame implements ActionListener {
	//�ݾװ��� ����
	int coin=0; //�������Աݾ�
	int totCoin=0; //�Ѱ����ݾ�
	int coffeePrice[] = {2001,2002,2003,2004,2005,2006};
	//Ŀ�Ǽ���
	int coffeeCnt[] = {1,2,3,4,5,6}; 
	//Ŀ���̸�
	String coffeeName[] = {"Ŀ���","����������","�ݵ���","�Ƹ޸�ī��","�ٴҶ��","ī���ī"};

	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	Font font50 = new Font("SansSerif", Font.BOLD, 50);
	
	private Image img1;
	private Image img2;
	private Image img3;
	private Image img4;
	private Image img5;
	private Image img6;	
	private Image imgSel;//����������Ŀ��
	
	Label lbTitle = new Label("Ŀ�� - ���Ǳ�");
	Label lbCoffee1Cnt = new Label("���� 1��",Label.CENTER);
	Label lbCoffee2Cnt = new Label("���� 2��",Label.CENTER);
	Label lbCoffee3Cnt = new Label("���� 3��",Label.CENTER);
	Label lbCoffee4Cnt = new Label("���� 4��",Label.CENTER);
	Label lbCoffee5Cnt = new Label("���� 5��",Label.CENTER);
	Label lbCoffee6Cnt = new Label("���� 6��",Label.CENTER);
	Label lbCoffeeSelCnt = new Label("2000��",Label.CENTER);
	Label lbCoffee1Price = new Label("2001��",Label.CENTER);
	Label lbCoffee2Price = new Label("2002��",Label.CENTER);
	Label lbCoffee3Price = new Label("2003��",Label.CENTER);
	Label lbCoffee4Price = new Label("2004��",Label.CENTER);
	Label lbCoffee5Price = new Label("2005��",Label.CENTER);
	Label lbCoffee6Price = new Label("2006��",Label.CENTER);
	Label lbCoffeeSelPrice = new Label("Ŀ�� - ���Ǳ�");
	Label lbSelTitle = new Label("����Ŀ�Ǹ�");
	Label lbJan1 = new Label("�����ܾ�  : ");
	Label lbJan2 = new Label(coin+"��",Label.RIGHT);
	Label lbCoin1 = new Label("��ǰ�ݾ�  : ");
	Label lbCoin2 = new Label("0��",Label.RIGHT);
	
	Label lbCoin = new Label("< ���Աݾ� >");
	Label lbSel = new Label("< ������ ��ǰ >");
	Label lbSelPrice = new Label("���� :    0��");

	Button btnCofee1 = new Button("ī���");
	Button btnCofee2 = new Button("����������");
	Button btnCofee3 = new Button("�ݵ���");
	Button btnCofee4 = new Button("�Ƹ޸�ī��");
	Button btnCofee5 = new Button("�ٴҶ��");
	Button btnCofee6 = new Button("ī���ī");
	Button btn1000 = new Button("1000��");
	Button btn5000 = new Button("5000��");
	Button btn10000 = new Button("10000��");
	Button btnBuy = new Button("�����ϱ�");
	
	
	
	MainScreen2()
	{
		super("Ŀ�� - ���Ǳ�");
		this.setSize(1200,1050);
		this.center();
		this.init();
		this.start();
		this.setVisible(true);
	}
	void init() {	
		//ī���
		img1 = Toolkit.getDefaultToolkit().getImage("img/angel_coffee.png");
		//����������
		img2 = Toolkit.getDefaultToolkit().getImage("img/twosome_coffee.png");
		//�ݵ���
		img3 = Toolkit.getDefaultToolkit().getImage("img/pascucci_coffee.png");
		//�Ƹ޸�ī��
		img4 = Toolkit.getDefaultToolkit().getImage("img/kfc_coffee.png");
		//�ٴҶ��
		img5 = Toolkit.getDefaultToolkit().getImage("img/dunkin_coffee.png");
		//ī���ī
		img6 = Toolkit.getDefaultToolkit().getImage("img/isaac_coffee.png");
		//ī���ī
		imgSel = Toolkit.getDefaultToolkit().getImage("img/default.png");
		
		
		this.setLayout(null);
		this.add(lbTitle);
		this.add(lbCoffee1Cnt);this.add(lbCoffee1Price);this.add(btnCofee1);
		this.add(lbCoffee2Cnt);this.add(lbCoffee2Price);this.add(btnCofee2);
		this.add(lbCoffee3Cnt);this.add(lbCoffee3Price);this.add(btnCofee3);
		this.add(lbCoffee4Cnt);this.add(lbCoffee4Price);this.add(btnCofee4);
		this.add(lbCoffee5Cnt);this.add(lbCoffee5Price);this.add(btnCofee5);
		this.add(lbCoffee6Cnt);this.add(lbCoffee6Price);this.add(btnCofee6);
		this.add(lbCoffeeSelCnt);this.add(lbCoffeeSelPrice);
		this.add(btn1000);this.add(btn5000);this.add(btn10000);
		this.add(btnBuy);
		this.add(lbCoin);
		this.add(lbCoin1);
		this.add(lbCoin2);
		this.add(lbSelTitle);
		this.add(lbJan1);
		this.add(lbJan2);
		this.add(lbSel);
		this.add(lbSelPrice);
		
		
		
		
		lbTitle.setBounds(400, 40, 600, 50);lbTitle.setFont(font50);
		//��ǰ1		
		lbCoffee1Cnt.setBounds(100, 300, 100, 30);lbCoffee1Cnt.setFont(font20);
		lbCoffee1Price.setBounds(100, 330, 100, 30);lbCoffee1Price.setFont(font20);
		btnCofee1.setBounds(50, 360, 200, 50);btnCofee1.setFont(font30);

		//��ǰ2		
		lbCoffee2Cnt.setBounds(400, 300, 100, 30);lbCoffee2Cnt.setFont(font20);
		lbCoffee2Price.setBounds(400, 330, 100, 30);lbCoffee2Price.setFont(font20);
		btnCofee2.setBounds(350, 360, 200, 50);btnCofee2.setFont(font30);

		//��ǰ3		
		lbCoffee3Cnt.setBounds(700, 300, 100, 30);lbCoffee3Cnt.setFont(font20);
		lbCoffee3Price.setBounds(700, 330, 100, 30);lbCoffee3Price.setFont(font20);
		btnCofee3.setBounds(650, 360, 200, 50);btnCofee3.setFont(font30);
		
		//��ǰ4		
		lbCoffee4Cnt.setBounds(100, 650, 100, 30);lbCoffee4Cnt.setFont(font20);
		lbCoffee4Price.setBounds(100, 680, 100, 30);lbCoffee4Price.setFont(font20);
		btnCofee4.setBounds(50, 710, 200, 50);btnCofee4.setFont(font30);

		//��ǰ5		
		lbCoffee5Cnt.setBounds(400, 650, 100, 30);lbCoffee5Cnt.setFont(font20);
		lbCoffee5Price.setBounds(400, 680, 100, 30);lbCoffee5Price.setFont(font20);
		btnCofee5.setBounds(350, 710, 200, 50);btnCofee5.setFont(font30);

		//��ǰ6		
		lbCoffee6Cnt.setBounds(700, 650, 100, 30);lbCoffee6Cnt.setFont(font20);
		lbCoffee6Price.setBounds(700, 680, 100, 30);lbCoffee6Price.setFont(font20);
		btnCofee6.setBounds(650, 710, 200, 50);btnCofee6.setFont(font30);
		
		lbCoin.setBounds(50, 800, 150, 50);lbCoin.setFont(font20);
		btn1000.setBounds(50, 850, 250, 50);btn1000.setFont(font30);
		btn5000.setBounds(350, 850, 250, 50);btn5000.setFont(font30);
		btn10000.setBounds(650, 850, 250, 50);btn10000.setFont(font30);
		
		lbJan1.setBounds(50, 900, 150, 50);lbJan1.setFont(font30);
		lbJan2.setBounds(200, 900, 250, 50);lbJan2.setFont(font30);
		lbCoin1.setBounds(500, 900, 150, 50);lbCoin1.setFont(font30);
		lbCoin2.setBounds(650, 900, 250, 50);lbCoin2.setFont(font30);
		

		lbSel.setBounds(950, 160, 250, 50);lbSel.setFont(font30);
		lbSelTitle.setBounds(950, 460, 250, 50);lbSelTitle.setFont(font30);
		lbSelPrice.setBounds(950, 510, 250, 50);lbSelPrice.setFont(font30);
		btnBuy.setBounds(900, 600, 250, 50);btnBuy.setFont(font30);
		

		
	}	
	public void paint(Graphics g) {	
		
			g.drawImage(img1, 50, 100, 200, 200, this);
			g.drawImage(img2, 350, 100, 200, 200, this);
			g.drawImage(img3, 650, 100, 200, 200, this);
			g.drawImage(img4, 50, 450, 200, 200, this);
			g.drawImage(img5, 350, 450, 200, 200, this);
			g.drawImage(img6, 650, 450, 200, 200, this);
			
			g.drawImage(imgSel, 950, 250, 200, 200, this);
	}
	void start()
	{
		btnCofee1.addActionListener(this);
		btnCofee2.addActionListener(this);
		btnCofee3.addActionListener(this);
		btnCofee4.addActionListener(this);
		btnCofee5.addActionListener(this);
		btnCofee6.addActionListener(this);
		btn1000.addActionListener(this);
		btn5000.addActionListener(this);
		btn10000.addActionListener(this);
		btnBuy.addActionListener(this);
		
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnCofee1)
		{
			imgSel = Toolkit.getDefaultToolkit().getImage("img/angel_coffee.png");
			totCoin = coffeePrice[0];
			lbCoin2.setText(totCoin+"��");	
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[0]);
			this.repaint();
					
		}
		else if(e.getSource() == btnCofee2)
		{
			imgSel = Toolkit.getDefaultToolkit().getImage("img/twosome_coffee.png");
			totCoin = coffeePrice[1];
			lbCoin2.setText(totCoin+"��");
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[1]);
			this.repaint();
		}
		else if(e.getSource() == btnCofee3)
		{
			imgSel = Toolkit.getDefaultToolkit().getImage("img/kfc_coffee.png");
			totCoin = coffeePrice[2];
			lbCoin2.setText(totCoin+"��");
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[2]);
			this.repaint();
		}
		else if(e.getSource() == btnCofee4)
		{
			imgSel = Toolkit.getDefaultToolkit().getImage("img/dunkin_coffee.png");
			totCoin = coffeePrice[3];
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[3]);
			lbCoin2.setText(totCoin+"��");
			
			this.repaint();
		}
		else if(e.getSource() == btnCofee5)
		{
			imgSel = Toolkit.getDefaultToolkit().getImage("img/isaac_coffee.png");
			totCoin = coffeePrice[4];
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[4]);
			lbCoin2.setText(totCoin+"��");
			this.repaint();
		}
		else if(e.getSource() == btnCofee6)
		{
			imgSel = Toolkit.getDefaultToolkit().getImage("img/isaac_coffee.png");
			totCoin = coffeePrice[5];
			lbSelPrice.setText(totCoin+"��");
			lbSelTitle.setText(coffeeName[5]);
			lbCoin2.setText(totCoin+"��");
			this.repaint();
		}
		else if(e.getSource() == btn1000)
		{
			coin+=1000;
			lbJan2.setText(coin+"��");
		}
		else if(e.getSource() == btn5000)
		{
			coin+=5000;
			lbJan2.setText(coin+"��");
		}
		else if(e.getSource() == btn10000)
		{
			coin+=10000;
			lbJan2.setText(coin+"��");
		}
		else if(e.getSource() == btnBuy)
		{
			//�ܾ��� �ּ� 3000���̻� ������쿡�� ����
			if(coin < 3000)
			{
				msg("�ּ�3000���̻� �ݾ��������ϼ���.");
				return;
			}
			//��ǰ���ø޼��� ���
			if(totCoin==0)
			{
				msg("������ Ŀ�Ǹ� �������ּ���.");
				return;
			}
			
			coin-=totCoin;
			lbJan2.setText(coin+"��");
		}
		
		
		
	}
	void msg(String msg)
	{
		final Dialog dlg = new Dialog(this, "�˸� �޼���â", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);	lbMsg.setFont(font20);
		lbMsg.setBounds(100, 100, 450, 30);
		
		dlg.setSize(450, 250);
		dlg.setLocation(700, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
	void search(String name)
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺갡 ����ȵ�.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				if(rs.getString(4).equals(name))
				{

				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	void searchAll()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺갡 ����ȵ�.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result="";
			while (rs.next()) {
				result += rs.getInt(1) + " / " + rs.getString(2)
				+ " / " + rs.getString(3)
				+ " / " + rs.getString(4)
				+ " / " + rs.getString(5)+"\n";			
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}

}









