package �ڹ�24;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class �౸���� {
	public static void main(String[] args) {
		Soccer soccer = new Soccer ();
	}
}

class Soccer extends Frame implements ItemListener, ActionListener {
	
	private Dimension dimen, dimen1 ;
	private int xpos, ypos ;
	Font font15 = new Font("SanSerif", Font.BOLD,15);
	
	//���� ���� Ƚ�� 
	Label lbTotGame = new Label("�� ���� ���� Ƚ�� :");
	Label lbGameCnt = new Label("10ȸ");
	
	Label lbList = new Label("���� ����Ʈ");
	Label lbMan = new Label("�౸���� : ");
	//���� ����
	Label lbResult = new Label("��� : ��� ��...");
	//��� ǥ��
	Label lbTot = new Label("�� ���� :");
	Label lbTotCnt = new Label("0����");
	//���� ǥ��
	Label lbShoot = new Label("�� ���� :");
	Label lbShootCnt = new Label("0ȸ");
	Label lbFail = new Label("�� ���� :");
	Label lbFailCnt = new Label("0ȸ");
	//���� �ʱ�ȭ
	Button btnReset = new Button("���� �ʱ�ȭ");
	//�� ����
	Button btnMd = new Button("�߰Ÿ���");
	Button btnHd = new Button("���");
	Button btnPt = new Button("�г�Ƽ��");
	//�������
	List li = new List(3,false);
	
	//���� ����� ��ư
	Button btnSave = new Button("���� ����");
	Button btnSta = new Button("���� ���");
	
	String ment1[] = {"�߰Ÿ� ���� ����!","�߰Ÿ� �� ����!"};
	String ment2[] = {"��� ���� ����!","��� �� ����!"};
	String ment3[] = {"�г�Ƽ ���� ����!","�г�Ƽ �� ����!"};
	
	int tot=0, ok=0, fail=0 ;
	int md=0, hd=0, pt=0;
	int game=10;
	String name="";
	
	
	
	
	

	
	Soccer(){
		super("�౸����");
		this.setSize(600,400);
		this.center();
		this.init();
		this.list();  //ȭ�� �׸���
		this.start(); //�޼��� ó��
		this.setVisible (true);
	}
	
	void init() {
		this.setLayout(null);
		
		this.add(lbList); lbList.setFont(font15); 
		lbList.setBounds(60,50,100,30);

		
		
		this.add(lbMan); lbMan.setFont(font15); 
		lbMan.setBounds(260,50,200,30);
		
		this.add(lbResult); lbResult.setFont(font15); 
		lbResult.setBounds(260,150,150,30);
		
		this.add(btnMd); btnMd.setFont(font15); 
		btnMd.setBounds(260,90,100,30);
		
		this.add(btnHd); btnHd.setFont(font15); 
		btnHd.setBounds(360,90,100,30);
		
		this.add(btnPt); btnPt.setFont(font15); 
		btnPt.setBounds(460,90,100,30);
		
		this.add(lbTot); lbTot.setFont(font15); 
		lbTot.setBounds(60,200,70,30);
		
		this.add(lbTotCnt); lbTotCnt.setFont(font15); 
		lbTotCnt.setBounds(150,200,50,30);
		
		this.add(lbShootCnt); lbShootCnt.setFont(font15); 
		lbShootCnt.setBounds(150,230,50,30);
		
		this.add(lbShoot); lbShoot.setFont(font15); 
		lbShoot.setBounds(60,230,70,30);
		
		this.add(lbFail); lbFail.setFont(font15); 
		lbFail.setBounds(60,260,90,30);
		
		this.add(lbFailCnt); lbFailCnt.setFont(font15); 
		lbFailCnt.setBounds(150,260,70,30);
		
		this.add(btnReset); btnReset.setFont(font15); 
		btnReset.setBounds(60,300,100,30);
		
		this.add(lbTotGame); lbTotGame.setFont(font15); 
		lbTotGame.setBounds(350,350,150,30);
		
		this.add(lbGameCnt); lbGameCnt.setFont(font15); 
		lbGameCnt.setBounds(500,350,200,30);
	
		//���� ���
		this.add(li); li.setFont(font15); 
		li.setBounds(60,90,100,100);
		li.add("�����");
		li.add("�޽�");
		li.add("������");
		
		//���� ����� ��ư 
		this.add(btnSave); btnSave.setFont(font15);
		btnSave.setBounds(270,300,100,30);
		
		this.add(btnSta); btnSta.setFont(font15);
		btnSta.setBounds(450,300,100,30);
		
	}
	
	
	
	void start() {
		li.addItemListener(this);
		btnMd.addActionListener(this);
		btnHd.addActionListener(this);
		btnPt.addActionListener(this);
		btnReset.addActionListener(this);
		btnSave.addActionListener(this);
		btnSta.addActionListener(this);
	
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);//ȭ�� �ݱ�
			}
		});
	}
	
	
	
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	
	


	@Override
	public void itemStateChanged(ItemEvent e) {
		name = li.getSelectedItem();
		lbMan.setText("�౸���� : "+name);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnReset) {
			tot = 0;
			ok = 0;
			fail = 0;
			name = "";
			game = 10;
			lbTotCnt.setText(tot+"ȸ");
			lbShootCnt.setText(ok+"ȸ");
			lbFailCnt.setText(fail+"ȸ");
			lbMan.setText("�������� �����...");
			lbResult.setText("�ʱ�ȭ �Ǿ����ϴ�.");
			btnMd.setVisible(true);
			btnHd.setVisible(true);
			btnPt.setVisible(true);
			return;
		}
		
		
		if(name.equals(""))
		{
			lbResult.setText("������ ���ÿ�");
			return;
		}
		
		if(e.getSource()==btnMd) {
			tot++;
			md++;
			game--;
			
			int num = (int)(Math.random()*10);
			
			if(num==0 || num==1 || num==2) {
				lbResult.setText(ment1[0]);
				ok++;
				
			}
			else {
				lbResult.setText(ment1[1]);
				fail++;
			}
			if(md == 1) {
				btnMd.setVisible(false);
			}
		}
		else if(e.getSource()==btnHd) {
			tot++;
			hd++;
			game--;
			int num = (int)(Math.random()*10);
			if(num==0 || num==1 || num==2 || num==3 || num==4) {
				lbResult.setText(ment2[0]);
				ok++;
			}
			else {
				lbResult.setText(ment2[1]);
				fail++;
			}
			
			if(hd == 2) {
				btnHd.setVisible(false); //��ư ������� �ϱ�
			}
			
		}
		else if(e.getSource()==btnPt) {
			tot++;
			game--;
			int num = (int)(Math.random()*10);
			if(num==0) {
				lbResult.setText(ment3[1]);
				fail++;
			}
			else {
				lbResult.setText(ment3[0]);
				ok++;
			}
		}
		lbTotCnt.setText(tot+"ȸ");
		lbShootCnt.setText(ok+"ȸ");
		lbFailCnt.setText(fail+"ȸ");
		lbGameCnt.setText(game+"ȸ");
		
		if(game == 0) {
			final Dialog dlg3 = new Dialog(this, "GAME OVER!", true);
			dlg3.setLayout(new BorderLayout());
			String eee = "GAME OVER!";
			dlg3.add("Center", new Label(eee, Label.CENTER));
		
		
			dlg3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg3.setVisible(false);//ȭ�� �ݱ�
				}
					
			});
			dlg3.setSize(300, 100);
			dlg3.setLocation(800, 500);
			dlg3.setVisible(true);
			return;
		}
		
		if(ok == 8) {
			final Dialog dlg = new Dialog(this, "è�Ǿ𸮱� ���!", true);
			dlg.setLayout(new BorderLayout());
			String sss = "è�Ǿ𽺸��� ���! ��ũ�����̼�~!";
			dlg.add("Center", new Label(sss, Label.CENTER));
		
		
			dlg.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dlg.setVisible(false);//ȭ�� �ݱ�
				}
			});
			dlg.setSize(300, 100);
			dlg.setLocation(800, 500);
			dlg.setVisible(true);
		}
		
		if(e.getSource()==btnSave) {
			save();
			reset();
		}
		
		if(e.getSource()==btnSta) {
			final Dialog dlg2 = new Dialog(this, "���� ���", true);
			dlg2.setLayout(new BorderLayout());
			String aa =name + " / " + tot+ "ȸ ���� / �� ���� :" + ok + " / �� ���� :" + fail + "\n" ;
			dlg2.add("Center", new Label(aa, Label.CENTER));
		
		
			dlg2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg2.setVisible(false);//ȭ�� �ݱ�
				}
			});
			dlg2.setSize(300, 100);
			dlg2.setLocation(800, 500);
			dlg2.setVisible(true);
			reset();
			
		}
		
	}
	
	
	void save() {
		name = li.getSelectedItem();
		String aa =name + " / " + tot+ "ȸ ���� / �� ���� :" + ok + " / �� ���� :" + fail + "\n" ;
		System.out.println(aa);
	
	   try{
	            //���� ��ü ����
	            File file = new File("C:\\aaa\\work\\soccer.txt");
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));

	            
	            bufferedWriter.write(aa);	                        	             
	            bufferedWriter.close();   
	            aa="";
	        }catch (IOException e) {
	            System.out.println(e);
	        }
	

	}
	
	
	
	
	
	
	void reset() {
		tot = 0;
		ok = 0;
		fail = 0;
		name = "";
		game = 10;
		lbTotCnt.setText(tot+"ȸ");
		lbShootCnt.setText(ok+"ȸ");
		lbFailCnt.setText(fail+"ȸ");
		lbMan.setText("�������� �����...");
		lbResult.setText("�ʱ�ȭ �Ǿ����ϴ�.");
		btnMd.setVisible(true);
		btnHd.setVisible(true);
		btnPt.setVisible(true);
		return;
	}

	
	
	
}


