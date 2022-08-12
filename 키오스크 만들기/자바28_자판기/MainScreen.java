package 자바28_자판기;

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

import 자바26_윈도우프로그래밍_DB연동.SubDel;
import 자바26_윈도우프로그래밍_DB연동.SubJoin;
import 자바26_윈도우프로그래밍_DB연동.SubList;
import 자바26_윈도우프로그래밍_DB연동.SubModi;

public class MainScreen extends Frame implements ActionListener{
	Font font15 = new Font("SanSerif", Font.BOLD,15);
	Font font20 = new Font("SanSerif", Font.BOLD,20);
	Font font25 = new Font("SanSerif", Font.BOLD,25);
	Font font40 = new Font("SanSerif", Font.BOLD,40);
	private Dimension dimen, dimen1 ;
	private int xpos, ypos ;
	int cnt=0;
	int 결제금액=0;
	int 현재잔액=0;
	int 천원 = 1000;
	int 오천원 = 5000;
	int 만원 = 10000;
	

	Label lbTitle = new Label ("BIG COFFEE");
	
	//선택상품
	Label lbChoice = new Label ("CHOICE");
	Label lbChoiceMenu = new Label ("상품을 선택하세요.");
	Label lbChoiceNum = new Label ("수량 0개");
	Label lbChoicePrice = new Label ("0원");
	Button btnReset = new Button ("뒤로가기");
	
	//결제부분
	Button btnPay = new Button ("결제하기");
	Label lbInMoney = new Label ("투입금액");
	Button btn1 = new Button ("1000원");
	Button btn5 = new Button ("5000원");
	Button btn10 = new Button ("10000원");
	Label lbBalance = new Label ("현재 잔액");
	Label lbPrice = new Label (현재잔액+" 원");
	Label lbPayMoney = new Label ("결제 금액");
	Label lbPayMoney2 = new Label (결제금액+" 원");
	
	
	//메뉴 라벨
	Button btnEspresso = new Button ("에스프레소");
	Button btnAmericano = new Button ("아메리카노");
	Button btnLatte = new Button ("바닐라라떼");
	Button btnCappuccino = new Button ("카푸치노");
	Button btnSmoothie = new Button ("딸기스무디");
	Button btnWater = new Button ("물");
	
	//메뉴 사진
	Image imgEspresso;
	Image imgAmericano;
	Image imgLatte;
	Image imgCappuccino;
	Image imgSmoothie;
	Image imgWater;
	Image imgSel;
	
	
	//메뉴 가격
	int Espresso = 1500;
	Label lbEspressoPrice = new Label (Espresso+" 원");
	int Americano = 2000;
	Label lbAmericanoPrice = new Label (Americano+" 원");
	int Latte = 3000;
	Label lbLattePrice = new Label (Latte+" 원");
	int Cappuccino = 3000;
	Label lbCappuccinoPrice = new Label (Cappuccino+" 원");
	int Smoothie = 3500;
	Label lbSmoothiePrice = new Label (Smoothie+" 원");
	int Water = 1000;
	Label lbWaterPrice = new Label (Water+" 원");
	
	//메뉴 수량
	Label lbEspressoNum = new Label ("수량 0개");
	Label lbAmericanoNum = new Label ("수량 0개");
	Label lbLatteNum = new Label ("수량 0개");
	Label lbCappuccinoNum = new Label ("수량 0개");
	Label lbSmoothieNum = new Label ("수량 0개");
	Label lbWaterNum = new Label ("수량 0개");
	
	MainScreen(){
		super("메인화면");
		this.setSize(800,850);
		this.center();
		this.init();
		this.image();
		this.start();
		this.setVisible (true);
	}
	
	void init() {//자리 배치
		this.setLayout(null);
		//타이틀
		this.add(lbTitle); lbTitle.setFont(font40); 
		lbTitle.setBounds(260,50,350,50);
		//선택상품
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
		
		
		//결제부분
		this.add(btnPay); btnPay.setFont(font15); //결제버튼
		btnPay.setBounds(530,640,200,50);
		this.add(lbInMoney); lbInMoney.setFont(font15); 
		lbInMoney.setBounds(50,650,120,50);
		this.add(btn1); btn1.setFont(font15); //천원
		btn1.setBounds(50,700,120,50);
		this.add(btn5); btn5.setFont(font15); //오천원
		btn5.setBounds(180,700,120,50);
		this.add(btn10); btn10.setFont(font15); //만원
		btn10.setBounds(310,700,120,50);
		this.add(lbBalance); lbBalance.setFont(font15); //현재잔액
		lbBalance.setBounds(530,510,120,50);
		this.add(lbPrice); lbPrice.setFont(font20); 
		lbPrice.setBounds(530,550,120,50);
		this.add(lbPayMoney); lbPayMoney.setFont(font15); //결제금액
		lbPayMoney.setBounds(650,510,120,50); 
		this.add(lbPayMoney2); lbPayMoney2.setFont(font20); 
		lbPayMoney2.setBounds(650,550,120,50); 
		
		//메뉴 이름
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
		
		//메뉴 가격
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
		
		//메뉴 수량
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
		imgEspresso = Toolkit.getDefaultToolkit().getImage("img/에스프레소2.jpg");
		imgAmericano = Toolkit.getDefaultToolkit().getImage("img/아메리카노.jpg");
		imgLatte = Toolkit.getDefaultToolkit().getImage("img/바닐라라떼.jpg");
		imgCappuccino = Toolkit.getDefaultToolkit().getImage("img/카푸치노.jpg");
		imgSmoothie = Toolkit.getDefaultToolkit().getImage("img/딸기스무디.jpg");
		imgWater = Toolkit.getDefaultToolkit().getImage("img/물.jpg");
		imgSel = Toolkit.getDefaultToolkit().getImage("img/흰색.jpg");
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
	
	void center() { //가운데 정렬
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	
	void start() {//이벤트 실행
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
			imgSel = Toolkit.getDefaultToolkit().getImage("img/에스프레소2.jpg");
			lbEspressoNum.setText(cnt+1+" 개");
			lbChoiceNum.setText(cnt+1+" 개");
			lbChoiceMenu.setText("에스프레소");
			lbChoicePrice.setText(lbEspressoPrice.getText());
			lbPayMoney2.setText(lbEspressoPrice.getText());
			결제금액 = Espresso;
			this.repaint();
		}
		if(e.getSource()==btnAmericano) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/아메리카노.jpg");
			lbAmericanoNum.setText(cnt+1+" 개");
			lbChoiceNum.setText(cnt+1+" 개");
			lbChoiceMenu.setText("아메리카노");
			lbChoicePrice.setText(lbAmericanoPrice.getText());
			lbPayMoney2.setText(lbAmericanoPrice.getText());
			결제금액 = Americano;
			this.repaint();
		}
		if(e.getSource()==btnLatte) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/바닐라라떼.jpg");
			lbLatteNum.setText(cnt+1+" 개");
			lbChoiceNum.setText(cnt+1+" 개");
			lbChoiceMenu.setText("바닐라라떼");
			lbChoicePrice.setText(lbLattePrice.getText());
			lbPayMoney2.setText(lbLattePrice.getText());
			결제금액 = Latte;
			this.repaint();
		}
		if(e.getSource()==btnCappuccino) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/카푸치노.jpg");
			lbCappuccinoNum.setText(cnt+1+" 개");
			lbChoiceNum.setText(cnt+1+" 개");
			lbChoiceMenu.setText("카푸치노");
			lbChoicePrice.setText(lbCappuccinoPrice.getText());
			lbPayMoney2.setText(lbCappuccinoPrice.getText());
			결제금액 = Cappuccino;
			this.repaint();
		}
		if(e.getSource()==btnSmoothie) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/딸기스무디.jpg");
			lbSmoothieNum.setText(cnt+1+" 개");
			lbChoiceNum.setText(cnt+1+" 개");
			lbChoiceMenu.setText("딸기스무디");
			lbChoicePrice.setText(lbSmoothiePrice.getText());
			lbPayMoney2.setText(lbSmoothiePrice.getText());
			결제금액 = Smoothie;
			this.repaint();
		}
		if(e.getSource()==btnWater) {
			imgSel = Toolkit.getDefaultToolkit().getImage("img/물.jpg");
			lbWaterNum.setText(cnt+1+" 개");
			lbChoiceNum.setText(cnt+1+" 개");
			lbChoiceMenu.setText("물");
			lbChoicePrice.setText(lbWaterPrice.getText());
			lbPayMoney2.setText(lbWaterPrice.getText());
			결제금액 = Water;
			this.repaint();
		}
		
		if(e.getSource()==btn1) {
			현재잔액+= 천원; 
			lbPrice.setText(현재잔액+"  원");
		}
		if(e.getSource()==btn5) {
			현재잔액+= 오천원; 
			lbPrice.setText(현재잔액+"  원");
		}
		if(e.getSource()==btn10) {
			현재잔액+=만원; 
			lbPrice.setText(현재잔액+" 원");
		}
		
		if(e.getSource()==btnPay) {
			if("상품을 선택하세요.".equals(lbChoiceMenu.getText())) {
				msg("메뉴를 선택 하세요."); 
			}
			if(결제금액 > 현재잔액) {
				msg("잔액이 부족합니다.");
			}else if(결제금액 < 현재잔액){
				paynow();
			}
		}
		
		if(e.getSource()==btnReset) {
			reset();
		}
		
		
		
	}
	
	void reset() {
		현재잔액 =0;
		pricereset(lbPayMoney2);
		imgSel = Toolkit.getDefaultToolkit().getImage("img/흰색.jpg"); 
		pricereset(lbChoicePrice);
		numbreset(lbChoiceNum);
		lbPrice.setText(현재잔액+" 원");
		lbChoiceMenu.setText("상품을 선택하세요.");
		this.repaint();
	}
	
	void pricereset(Label lbprice) {
		lbprice.setText("0원");
	}
	


	void numbreset(Label lbnum) {
		lbnum.setText("0개");
	}
	
	void msg(String msg) {
		final Dialog dlg = new Dialog(this, "알림 메세지창", true);
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
		msg("결제 진행 중입니다.");
		msg("음료가 완성 되었습니다.");
	}
	
	


	
	
	
	
	
}
