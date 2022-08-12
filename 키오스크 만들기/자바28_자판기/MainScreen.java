package �ڹ�28_���Ǳ�;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import �ڹ�26_���������α׷���_DB����.SubDel;
import �ڹ�26_���������α׷���_DB����.SubJoin;
import �ڹ�26_���������α׷���_DB����.SubList;
import �ڹ�26_���������α׷���_DB����.SubModi;

public class MainScreen extends Frame implements ActionListener{
	Font font15 = new Font("SanSerif", Font.BOLD,15);
	Font font20 = new Font("SanSerif", Font.BOLD,20);
	Font font25 = new Font("SanSerif", Font.BOLD,25);
	Font font40 = new Font("SanSerif", Font.BOLD,40);
	private Dimension dimen, dimen1 ;
	private int xpos, ypos ;
	int cnt=0;
	int �����ݾ�=0;
	int �����ܾ�=0;
	int õ�� = 1000;
	int ��õ�� = 5000;
	int ���� = 10000;
	

	Label lbTitle = new Label ("BIG COFFEE");
	
	//���û�ǰ
	Label lbChoice = new Label ("CHOICE");
	Label lbChoiceMenu = new Label ("��ǰ�� �����ϼ���.");
	Label lbChoiceNum = new Label ("���� 0��");
	Label lbChoicePrice = new Label ("0��");
	Button btnReset = new Button ("�ڷΰ���");
	
	//�����κ�
	Button btnPay = new Button ("�����ϱ�");
	Label lbInMoney = new Label ("���Աݾ�");
	Button btn1 = new Button ("1000��");
	Button btn5 = new Button ("5000��");
	Button btn10 = new Button ("10000��");
	Label lbBalance = new Label ("���� �ܾ�");
	Label lbPrice = new Label (�����ܾ�+" ��");
	Label lbPayMoney = new Label ("���� �ݾ�");
	Label lbPayMoney2 = new Label (�����ݾ�+" ��");
	
	
	//�޴� ��
	Button btnEspresso = new Button ("����������");
	Button btnAmericano = new Button ("�Ƹ޸�ī��");
	Button btnLatte = new Button ("�ٴҶ��");
	Button btnCappuccino = new Button ("īǪġ��");
	Button btnSmoothie = new Button ("���⽺����");
	Button btnWater = new Button ("��");
	
	//�޴� ����
	Image imgEspresso;
	Image imgAmericano;
	Image imgLatte;
	Image imgCappuccino;
	Image imgSmoothie;
	Image imgWater;
	Image imgSel;
	
	
	//�޴� ����
	int Espresso = 1500;
	Label lbEspressoPrice = new Label (Espresso+" ��");
	int Americano = 2000;
	Label lbAmericanoPrice = new Label (Americano+" ��");
	int Latte = 3000;
	Label lbLattePrice = new Label (Latte+" ��");
	int Cappuccino = 3000;
	Label lbCappuccinoPrice = new Label (Cappuccino+" ��");
	int Smoothie = 3500;
	Label lbSmoothiePrice = new Label (Smoothie+" ��");
	int Water = 1000;
	Label lbWaterPrice = new Label (Water+" ��");
	
	//�޴� ����
	Label lbEspressoNum = new Label ("���� 0��");
	Label lbAmericanoNum = new Label ("���� 0��");
	Label lbLatteNum = new Label ("���� 0��");
	Label lbCappuccinoNum = new Label ("���� 0��");
	Label lbSmoothieNum = new Label ("���� 0��");
	Label lbWaterNum = new Label ("���� 0��");
	
	MainScreen(){
		super("����ȭ��");
		this.setSize(800,850);
		this.center();
		this.init();
		this.image();
		this.start();
		this.setVisible (true);
	}
	
	void init() {//�ڸ� ��ġ
		this.setLayout(null);
		//Ÿ��Ʋ
		this.add(lbTitle); lbTitle.setFont(font40); 
		lbTitle.setBounds(260,50,350,50);
		//���û�ǰ
		this.add(lbChoice); lbChoice.setFont(font20); 
		lbChoice.setBounds(575,150,100,50);
		this.add(lbChoiceMenu); lbChoiceMenu.setFont(font15); 
		lbChoiceMenu.setBounds(560,340,150,30);
		this.add(lbChoiceNum); lbChoiceNum.setFont(font15); 
		lbChoiceNum.setBounds(560,370,120,30);
		this.add(lbChoicePrice); lbChoicePrice.setFont(font20); 
		lbChoicePrice.setBounds(560,400,120,30);
		this.add(btnReset); btnReset.setFont(font15); 
		btnReset.setBounds(530,700,200,50);
		
		
		//�����κ�
		this.add(btnPay); btnPay.setFont(font15); //������ư
		btnPay.setBounds(530,640,200,50);
		this.add(lbInMoney); lbInMoney.setFont(font15); 
		lbInMoney.setBounds(50,650,120,50);
		this.add(btn1); btn1.setFont(font15); //õ��
		btn1.setBounds(50,700,120,50);
		this.add(btn5); btn5.setFont(font15); //��õ��
		btn5.setBounds(180,700,120,50);
		this.add(btn10); btn10.setFont(font15); //����
		btn10.setBounds(310,700,120,50);
		this.add(lbBalance); lbBalance.setFont(font15); //�����ܾ�
		lbBalance.setBounds(530,510,120,50);
		this.add(lbPrice); lbPrice.setFont(font20); 
		lbPrice.setBounds(530,550,120,50);
		this.add(lbPayMoney); lbPayMoney.setFont(font15); //�����ݾ�
		lbPayMoney.setBounds(650,510,120,50); 
		this.add(lbPayMoney2); lbPayMoney2.setFont(font20); 
		lbPayMoney2.setBounds(650,550,120,50); 
		
		//�޴� �̸�
		this.add(btnEspresso); btnEspresso.setFont(font15); 
		btnEspresso.setBounds(50,280,120,30);
		this.add(btnAmericano); btnAmericano.setFont(font15); 
		btnAmericano.setBounds(200,280,120,30);
		this.add(btnLatte); btnLatte.setFont(font15); 
		btnLatte.setBounds(350,280,120,30);
		this.add(btnCappuccino); btnCappuccino.setFont(font15); 
		btnCappuccino.setBounds(50,530,120,30);
		this.add(btnSmoothie); btnSmoothie.setFont(font15); 
		btnSmoothie.setBounds(200,530,120,30);
		this.add(btnWater); btnWater.setFont(font15); 
		btnWater.setBounds(350,530,120,30);
		
		//�޴� ����
		this.add(lbEspressoPrice); lbEspressoPrice.setFont(font20); 
		lbEspressoPrice.setBounds(50,350,100,30);
		this.add(lbAmericanoPrice); lbAmericanoPrice.setFont(font20); 
		lbAmericanoPrice.setBounds(200,350,100,30);
		this.add(lbLattePrice); lbLattePrice.setFont(font20); 
		lbLattePrice.setBounds(350,350,100,30);
		this.add(lbCappuccinoPrice); lbCappuccinoPrice.setFont(font20); 
		lbCappuccinoPrice.setBounds(50,600,100,30);
		this.add(lbSmoothiePrice); lbSmoothiePrice.setFont(font20); 
		lbSmoothiePrice.setBounds(200,600,100,30);
		this.add(lbWaterPrice); lbWaterPrice.setFont(font20); 
		lbWaterPrice.setBounds(350,600,100,30);
		
		//�޴� ����
		this.add(lbEspressoNum); lbEspressoNum.setFont(font15); 
		lbEspressoNum.setBounds(50,320,120,30);
		this.add(lbAmericanoNum); lbAmericanoNum.setFont(font15); 
		lbAmericanoNum.setBounds(200,320,120,30);
		this.add(lbLatteNum); lbLatteNum.setFont(font15); 
		lbLatteNum.setBounds(350,320,120,30);
		this.add(lbCappuccinoNum); lbCappuccinoNum.setFont(font15); 
		lbCappuccinoNum.setBounds(50,570,120,30);
		this.add(lbSmoothieNum); lbSmoothieNum.setFont(font15); 
		lbSmoothieNum.setBounds(200,570,120,30);
		this.add(lbWaterNum); lbWaterNum.setFont(font15); 
		lbWaterNum.setBounds(350,570,120,30);
	}
	
	void image() {
		imgEspresso = Toolkit.getDefaultToolkit().getImage("img/����������2.jpg");
		imgAmericano = Toolkit.getDefaultToolkit().getImage("img/�Ƹ޸�ī��.jpg");
		imgLatte = Toolkit.getDefaultToolkit().getImage("img/�ٴҶ��.jpg");
		imgCappuccino = Toolkit.getDefaultToolkit().getImage("img/īǪġ��.jpg");
		imgSmoothie = Toolkit.getDefaultToolkit().getImage("img/���⽺����.jpg");
		imgWater = Toolkit.getDefaultToolkit().getImage("img/��.jpg");
		imgSel = Toolkit.getDefaultToolkit().getImage("img/���.jpg");
	}
	
	public void paint(Graphics g) {
		g.drawImage(imgEspresso, 50, 150, 120, 120, this);
		g.drawImage(imgAmericano, 200, 150, 120, 120, this);
		g.drawImage(imgLatte, 350, 150, 150, 120, this);
		g.drawImage(imgCappuccino, 50, 400, 120, 120, this);
		g.drawImage(imgSmoothie, 200, 400, 120, 120, this);
		g.drawImage(imgWater, 350, 400, 120, 120, this);
		g.drawImage(imgSel, 560, 200, 120, 120, this);
		
	}
	
	void center() { //��� ����
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	
	void start() {//�̺�Ʈ ����
		btnEspresso.addActionListener(this);
		btnAmericano.addActionListener(this);
		btnLatte.addActionListener(this);
		btnCappuccino.addActionListener(this);
		btnSmoothie.addActionListener(this);
		btnWater.addActionListener(this);
		btn1.addActionListener(this);
		btn5.addActionListener(this);
		btn10.addActionListener(this);
		btnPay.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==btnEspresso) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/����������2.jpg");
			lbEspressoNum.setText(cnt+1+" ��");
			lbChoiceNum.setText(cnt+1+" ��");
			lbChoiceMenu.setText("����������");
			lbChoicePrice.setText(lbEspressoPrice.getText());
			lbPayMoney2.setText(lbEspressoPrice.getText());
			�����ݾ� = Espresso;
			this.repaint();
		}
		if(e.getSource()==btnAmericano) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/�Ƹ޸�ī��.jpg");
			lbAmericanoNum.setText(cnt+1+" ��");
			lbChoiceNum.setText(cnt+1+" ��");
			lbChoiceMenu.setText("�Ƹ޸�ī��");
			lbChoicePrice.setText(lbAmericanoPrice.getText());
			lbPayMoney2.setText(lbAmericanoPrice.getText());
			�����ݾ� = Americano;
			this.repaint();
		}
		if(e.getSource()==btnLatte) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/�ٴҶ��.jpg");
			lbLatteNum.setText(cnt+1+" ��");
			lbChoiceNum.setText(cnt+1+" ��");
			lbChoiceMenu.setText("�ٴҶ��");
			lbChoicePrice.setText(lbLattePrice.getText());
			lbPayMoney2.setText(lbLattePrice.getText());
			�����ݾ� = Latte;
			this.repaint();
		}
		if(e.getSource()==btnCappuccino) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/īǪġ��.jpg");
			lbCappuccinoNum.setText(cnt+1+" ��");
			lbChoiceNum.setText(cnt+1+" ��");
			lbChoiceMenu.setText("īǪġ��");
			lbChoicePrice.setText(lbCappuccinoPrice.getText());
			lbPayMoney2.setText(lbCappuccinoPrice.getText());
			�����ݾ� = Cappuccino;
			this.repaint();
		}
		if(e.getSource()==btnSmoothie) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/���⽺����.jpg");
			lbSmoothieNum.setText(cnt+1+" ��");
			lbChoiceNum.setText(cnt+1+" ��");
			lbChoiceMenu.setText("���⽺����");
			lbChoicePrice.setText(lbSmoothiePrice.getText());
			lbPayMoney2.setText(lbSmoothiePrice.getText());
			�����ݾ� = Smoothie;
			this.repaint();
		}
		if(e.getSource()==btnWater) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/��.jpg");
			lbWaterNum.setText(cnt+1+" ��");
			lbChoiceNum.setText(cnt+1+" ��");
			lbChoiceMenu.setText("��");
			lbChoicePrice.setText(lbWaterPrice.getText());
			lbPayMoney2.setText(lbWaterPrice.getText());
			�����ݾ� = Water;
			this.repaint();
		}
		
		if(e.getSource()==btn1) {
			�����ܾ�+= õ��; 
			lbPrice.setText(�����ܾ�+"  ��");
		}
		if(e.getSource()==btn5) {
			�����ܾ�+= ��õ��; 
			lbPrice.setText(�����ܾ�+"  ��");
		}
		if(e.getSource()==btn10) {
			�����ܾ�+=����; 
			lbPrice.setText(�����ܾ�+" ��");
		}
		
		if(e.getSource()==btnPay) {
			if("��ǰ�� �����ϼ���.".equals(lbChoiceMenu.getText())) {
				msg("�޴��� ���� �ϼ���."); 
			}
			if(�����ݾ� > �����ܾ�) {
				msg("�ܾ��� �����մϴ�.");
			}else if(�����ݾ� < �����ܾ�){
				paynow();
			}
		}
		
		if(e.getSource()==btnReset) {
			reset();
		}
		
		
		
	}
	
	void reset() {
		�����ܾ� =0;
		pricereset(lbPayMoney2);
		imgSel = Toolkit.getDefaultToolkit().getImage("img/���.jpg"); 
		pricereset(lbChoicePrice);
		numbreset(lbChoiceNum);
		lbPrice.setText(�����ܾ�+" ��");
		lbChoiceMenu.setText("��ǰ�� �����ϼ���.");
		this.repaint();
	}
	
	void pricereset(Label lbprice) {
		lbprice.setText("0��");
	}
	


	void numbreset(Label lbnum) {
		lbnum.setText("0��");
	}
	
	void msg(String msg) {
		final Dialog dlg = new Dialog(this, "�˸� �޼���â", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);	lbMsg.setFont(font15);
		lbMsg.setBounds(50, 65, 450, 30);
		
		
		dlg.setSize(260, 150);
		dlg.setLocation(850, 450);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		
		
		dlg.setVisible(true);
	}
	
	void paynow() {
		msg("���� ���� ���Դϴ�.");
		msg("���ᰡ �ϼ� �Ǿ����ϴ�.");
	}
	
	


	
	
	
	
	
}
