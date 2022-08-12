package 자바24;
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
public class 축구게임 {
	public static void main(String[] args) {
		Soccer soccer = new Soccer ();
	}
}

class Soccer extends Frame implements ItemListener, ActionListener {
	
	private Dimension dimen, dimen1 ;
	private int xpos, ypos ;
	Font font15 = new Font("SanSerif", Font.BOLD,15);
	
	//게임 가능 횟수 
	Label lbTotGame = new Label("총 게임 가능 횟수 :");
	Label lbGameCnt = new Label("10회");
	
	Label lbList = new Label("선수 리스트");
	Label lbMan = new Label("축구선수 : ");
	//현재 상태
	Label lbResult = new Label("결과 : 대기 중...");
	//결과 표시
	Label lbTot = new Label("총 전적 :");
	Label lbTotCnt = new Label("0게임");
	//전적 표시
	Label lbShoot = new Label("슛 성공 :");
	Label lbShootCnt = new Label("0회");
	Label lbFail = new Label("슛 실패 :");
	Label lbFailCnt = new Label("0회");
	//전적 초기화
	Button btnReset = new Button("전적 초기화");
	//슛 형태
	Button btnMd = new Button("중거리슛");
	Button btnHd = new Button("헤딩");
	Button btnPt = new Button("패널티슛");
	//선수명단
	List li = new List(3,false);
	
	//파일 입출력 버튼
	Button btnSave = new Button("파일 저장");
	Button btnSta = new Button("게임 통계");
	
	String ment1[] = {"중거리 슛이 성공!","중거리 슛 실패!"};
	String ment2[] = {"헤딩 슛이 성공!","헤딩 슛 실패!"};
	String ment3[] = {"패널티 슛이 성공!","패널티 슛 실패!"};
	
	int tot=0, ok=0, fail=0 ;
	int md=0, hd=0, pt=0;
	int game=10;
	String name="";
	
	
	
	
	

	
	Soccer(){
		super("축구게임");
		this.setSize(600,400);
		this.center();
		this.init();
		this.list();  //화면 그리기
		this.start(); //메서드 처리
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
	
		//선수 명단
		this.add(li); li.setFont(font15); 
		li.setBounds(60,90,100,100);
		li.add("손흥민");
		li.add("메시");
		li.add("강날두");
		
		//파일 입출력 버튼 
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
				System.exit(0);//화면 닫기
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
		lbMan.setText("축구선수 : "+name);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnReset) {
			tot = 0;
			ok = 0;
			fail = 0;
			name = "";
			game = 10;
			lbTotCnt.setText(tot+"회");
			lbShootCnt.setText(ok+"회");
			lbFailCnt.setText(fail+"회");
			lbMan.setText("선수선택 대기중...");
			lbResult.setText("초기화 되었습니다.");
			btnMd.setVisible(true);
			btnHd.setVisible(true);
			btnPt.setVisible(true);
			return;
		}
		
		
		if(name.equals(""))
		{
			lbResult.setText("선수를 고르시오");
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
				btnHd.setVisible(false); //버튼 사라지게 하기
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
		lbTotCnt.setText(tot+"회");
		lbShootCnt.setText(ok+"회");
		lbFailCnt.setText(fail+"회");
		lbGameCnt.setText(game+"회");
		
		if(game == 0) {
			final Dialog dlg3 = new Dialog(this, "GAME OVER!", true);
			dlg3.setLayout(new BorderLayout());
			String eee = "GAME OVER!";
			dlg3.add("Center", new Label(eee, Label.CENTER));
		
		
			dlg3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg3.setVisible(false);//화면 닫기
				}
					
			});
			dlg3.setSize(300, 100);
			dlg3.setLocation(800, 500);
			dlg3.setVisible(true);
			return;
		}
		
		if(ok == 8) {
			final Dialog dlg = new Dialog(this, "챔피언리그 우승!", true);
			dlg.setLayout(new BorderLayout());
			String sss = "챔피언스리그 우승! 콩크리츄레이션~!";
			dlg.add("Center", new Label(sss, Label.CENTER));
		
		
			dlg.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dlg.setVisible(false);//화면 닫기
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
			final Dialog dlg2 = new Dialog(this, "게임 통계", true);
			dlg2.setLayout(new BorderLayout());
			String aa =name + " / " + tot+ "회 도전 / 슛 성공 :" + ok + " / 슛 실패 :" + fail + "\n" ;
			dlg2.add("Center", new Label(aa, Label.CENTER));
		
		
			dlg2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg2.setVisible(false);//화면 닫기
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
		String aa =name + " / " + tot+ "회 도전 / 슛 성공 :" + ok + " / 슛 실패 :" + fail + "\n" ;
		System.out.println(aa);
	
	   try{
	            //파일 객체 생성
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
		lbTotCnt.setText(tot+"회");
		lbShootCnt.setText(ok+"회");
		lbFailCnt.setText(fail+"회");
		lbMan.setText("선수선택 대기중...");
		lbResult.setText("초기화 되었습니다.");
		btnMd.setVisible(true);
		btnHd.setVisible(true);
		btnPt.setVisible(true);
		return;
	}

	
	
	
}


