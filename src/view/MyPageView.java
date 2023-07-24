package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.CardDAO;
import model.CustomerDAO;
import model.DeliveryDAO;
import model.MissionDAO;
import model.RefundDAO;
import model.SellDAO;
import model.SignUpDAO;
import model.rec.CardVO;
import model.rec.CustomerVO;
import model.rec.DeliveryVO;
import model.rec.MissionVO;
import model.rec.RefundVO;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MyPageView extends JFrame {

	private JFrame frame;
	JPanel myPageMain;
	JPanel cardInfoJPanel;
	JTable cardInfotable;
	// 정보수정
	JPasswordField passwordField;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JLabel lb010;
	JButton btnmodify;
	JPanel modifypanel;
	JLabel lbnick = new JLabel("닉네임");
	JLabel lbtel = new JLabel("전화번호");
	JLabel lbaddr = new JLabel("주소");;
	JLabel lbpw = new JLabel("비밀번호");;
	// 미션
	JTable missiontable;
	JPanel missionpanel;
	JComboBox missioncomboBox = new JComboBox<>();

	JScrollPane missionscrollPane;
	MissionTableModel tmmission;
	JTextField tfMissionSearch;

	ArrayList list;

	SignUpDAO sdao = null;
	CustomerDAO csdao = null;
	CustomerVO csvo = null;
	MissionDAO mdao = null;
	MissionVO mvo = null;
	CardVO cvo;
	CardDAO cdao;
	DeliveryVO dvo;
	DeliveryDAO ddao;
	RefundVO rvo;
	RefundDAO rdao;
	RefundView rview;
	DeliveryDetailView dview;
	MyPageView mview;
	RefundView refund;
	ArrayList cardList;
	ArrayList deliList;
	String orderNo;
	String RefundNo;

	JPanel deliveryInfoPanel;
	JTable deliveryInfotable;
	JTextField ordernocode;
	JTextField ordernocode2;

	static int pk;
	static String nick;
	static int point;
	JButton btnback;
	SellDAO dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageView frame = new MyPageView(pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// DB 연결
	public MyPageView(int pk, String nick, int point) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MyPageView.class.getResource("/image/\uD638\uBBF8.png")));
		setTitle("\uB9C8\uC774\uD398\uC774\uC9C0");
		this.pk = pk;
		this.nick = nick;
		this.point = point;

//      CustomerDAO cdao = new CustomerDAO();
//      CustomerVO cvo = cdao.info(pk);

		addLayout();

//      CustomerDAO cdao = new CustomerDAO();
//      CustomerVO vo = cdao.info(pk, nick, point);

		cardInfo();
		deliveryInfo();
		// modifyInfo();
		missionInfo();

		offSwitchDeli();
		offSwitchCard();
		offSwitchmodify();
		offSwitchmission();

		try {
			csvo = new CustomerVO();
			csdao = new CustomerDAO();
			list = csdao.custAll();
			mdao = new MissionDAO();
			cdao = new CardDAO();
			cvo = new CardVO();
			cardList = cdao.cardAll(pk);
			ddao = new DeliveryDAO();
			dvo = new DeliveryVO();
			deliList = ddao.deliveryAll(pk);
			rdao = new RefundDAO();
			rvo = new RefundVO();

			System.out.println("고객DB 연결 성공!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "고객DB 연결 실패 : " + e.getMessage());
		}

	}

	public void addLayout() {
		tmmission = new MissionTableModel();
		missiontable = new JTable(tmmission);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		setLocationRelativeTo(null);
		myPageMain = new JPanel();
		myPageMain.setBackground(new Color(196, 224, 135));
		myPageMain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(myPageMain);
		myPageMain.setLayout(null);

		btnback = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnback.setForeground(new Color(255, 255, 255));
		btnback.setBackground(new Color(0, 0, 0));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainHomeView plantview = new MainHomeView(pk, nick, point);
				plantview.setVisible(true);

			}
		});

		modifypanel = new JPanel();
		modifypanel.setBounds(202, 142, 757, 540);
		modifypanel.setBackground(new Color(196, 224, 135));
		myPageMain.add(modifypanel);
		modifypanel.setLayout(null);

		lbnick = new JLabel("\uB2C9\uB124\uC784");
		lbnick.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		lbnick.setBounds(171, 173, 65, 24);
		modifypanel.add(lbnick);

		lbtel = new JLabel("\uC804\uD654\uBC88\uD638");
		lbtel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		lbtel.setBounds(157, 251, 74, 24);
		modifypanel.add(lbtel);

		lbaddr = new JLabel("\uC8FC\uC18C");
		lbaddr.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		lbaddr.setBounds(180, 332, 35, 24);
		modifypanel.add(lbaddr);

		passwordField = new JPasswordField();
		passwordField.setBounds(252, 76, 239, 40);
		modifypanel.add(passwordField);

		textField = new JTextField();
		textField.setBounds(252, 168, 239, 40);
		modifypanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(252, 327, 239, 40);
		modifypanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(316, 246, 175, 40);
		modifypanel.add(textField_2);

		lb010 = new JLabel("010 -");
		lb010.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 17));
		lb010.setBounds(255, 243, 49, 40);
		modifypanel.add(lb010);

		JLabel lbpw_1 = new JLabel("비밀번호");
		lbpw_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		lbpw_1.setBounds(171, 79, 65, 29);
		modifypanel.add(lbpw_1);

		btnmodify = new JButton("\uC218\uC815");
		btnmodify.setBounds(316, 438, 111, 40);
		modifypanel.add(btnmodify);
		btnmodify.setBackground(new Color(255, 255, 255));
		btnmodify.setForeground(new Color(0, 0, 0));
		btnmodify.setFont(new Font("나눔고딕", Font.PLAIN, 16));

		// 회원 정보수정 하는 코드
		btnmodify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				csvo = new CustomerVO();
				try {
					csvo.setMembercode(pk);
					csvo.setPw(passwordField.getText());
					csvo.setNick(textField.getText());
					csvo.setTel("010 -" + textField_2.getText());
					csvo.setAddr(textField_1.getText());

					csdao = new CustomerDAO();
					csdao.updateInfo(csvo);
					JOptionPane.showMessageDialog(null, "회정정보가 변경되었습니다.", "변경성공", JOptionPane.PLAIN_MESSAGE);
					System.out.println("수정성공");

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "수정에 실패하였습니다.", "수정실패", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		cardInfoJPanel = new JPanel();
		cardInfoJPanel.setBounds(202, 142, 770, 540);
		cardInfoJPanel.setBackground(new Color(196, 224, 135));
		myPageMain.add(cardInfoJPanel);
		cardInfoJPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 29, 701, 428);
		cardInfoJPanel.add(scrollPane);

		cardInfotable = new JTable();
		cardInfotable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cardInfotable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "카드사", "카드번호", "유효기간" }));
		cardInfotable.getColumnModel().getColumn(1).setMinWidth(75);
		scrollPane.setViewportView(cardInfotable);

		JButton attend_2 = new JButton("추가");
		attend_2.setForeground(new Color(0, 0, 0));
		attend_2.setBackground(new Color(255, 255, 255));
		attend_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				CardAddView cardAdd = new CardAddView(pk, nick, point);
				cardAdd.setVisible(true);
			}
		});

		attend_2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		attend_2.setBounds(180, 475, 150, 40);
		cardInfoJPanel.add(attend_2);

		JButton attend_1 = new JButton("삭제");
		attend_1.setForeground(new Color(0, 0, 0));
		attend_1.setBackground(new Color(255, 255, 255));
		attend_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = cardInfotable.getSelectedRow(); // 선택된 row의 인덱스 가져오기

				if (selectedRow != -1) { // 선택된 row가 있는 경우
					DefaultTableModel model = (DefaultTableModel) cardInfotable.getModel();
					String cNumString = (String) model.getValueAt(selectedRow, 1); // 선택된 row의 카드번호 값 가져오기

					try {
						model.removeRow(selectedRow);
						cdao.deleteCard(cNumString); // 카드번호를 사용하여 카드 정보 삭제
						JOptionPane.showMessageDialog(null, "선택된 카드가 삭제되었습니다.", "삭제성공", JOptionPane.PLAIN_MESSAGE);

					} catch (Exception ev) {
						JOptionPane.showMessageDialog(null, "삭제에 실패하였습니다.", "삭제실패", JOptionPane.WARNING_MESSAGE);
					}

				}
			}
		});
		attend_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		attend_1.setBounds(400, 475, 150, 40);
		cardInfoJPanel.add(attend_1);

		// 주문 정보
		deliveryInfoPanel = new JPanel();
		deliveryInfoPanel.setBounds(202, 142, 757, 540);
		deliveryInfoPanel.setBackground(new Color(196, 224, 135));
		myPageMain.add(deliveryInfoPanel);
		deliveryInfoPanel.setLayout(null);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(30, 31, 702, 428);
		deliveryInfoPanel.add(scrollPane2);

		deliveryInfotable = new JTable();
		deliveryInfotable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 클릭할때 구매아이템번호 가져오기 -- 환불
				int col2 = 2;
				int row2 = deliveryInfotable.getSelectedRow();
				String ordernocode2 = String.valueOf(deliveryInfotable.getValueAt(row2, col2));
				MyPageView.this.ordernocode2.setText(ordernocode2);
				// 클릭할때 배송번호 가져오기 -- 배송상세
				int col = 6;
				int row = deliveryInfotable.getSelectedRow();
				String ordernocode = String.valueOf(deliveryInfotable.getValueAt(row, col));
				MyPageView.this.ordernocode.setText(ordernocode);
			}
		});

		deliveryInfotable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		deliveryInfotable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "주문번호", "주문날짜", "구매아이템번호", "상품명", "상품수량", "상품 총 가격", "배송번호", "배송예정일", "배송상태" }));
		deliveryInfotable.getColumnModel().getColumn(1).setMinWidth(75);
		scrollPane2.setViewportView(deliveryInfotable);

		// 배송상세뷰로 넘어가기
		JButton detailbtn = new JButton("배송상세 조회");
		detailbtn.setForeground(new Color(0, 0, 0));
		detailbtn.setBackground(new Color(255, 255, 255));
		detailbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String orderNo = (String) deliveryInfotable.getValueAt(deliveryInfotable.getSelectedRow(), 6);
					DeliveryDetailView DeliveryDetail = new DeliveryDetailView(dvo, orderNo, pk, nick, point);
					DeliveryDetail.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "주문건을 선택하세요.", "검색실패", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		detailbtn.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		detailbtn.setBounds(184, 476, 121, 36);
		deliveryInfoPanel.add(detailbtn);

		ordernocode = new JTextField();
		ordernocode.setEditable(false);
		ordernocode.setHorizontalAlignment(SwingConstants.CENTER);
		ordernocode.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernocode.setBounds(100, 476, 72, 36);
		deliveryInfoPanel.add(ordernocode);
		ordernocode.setColumns(10);

		JLabel lblNewLabel = new JLabel("배송번호");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(30, 479, 63, 33);
		deliveryInfoPanel.add(lblNewLabel);

		JLabel lblNewLabel2 = new JLabel("구매아이템번호");
		lblNewLabel2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel2.setBounds(337, 479, 113, 33);
		deliveryInfoPanel.add(lblNewLabel2);

		ordernocode2 = new JTextField();
		ordernocode2.setEditable(false);
		ordernocode2.setHorizontalAlignment(SwingConstants.CENTER);
		ordernocode2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernocode2.setColumns(10);
		ordernocode2.setBounds(450, 476, 80, 36);
		deliveryInfoPanel.add(ordernocode2);

		JButton refundbtn = new JButton("\uD658\uBD88\uC2E0\uCCAD");
		refundbtn.setBackground(new Color(255, 255, 255));
		refundbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//                   int col3 = 7;
//                   int row3 = deliveryInfotable.getSelectedRow();
//                   String deliverynow = (String) deliveryInfotable.getValueAt(row3, col3);
				String deliverynow = (String) deliveryInfotable.getValueAt(deliveryInfotable.getSelectedRow(), 8);
				if (deliverynow.equals("배송준비중")) {
					// 환불 절차 진행
//                      int col4 = 2;
//                      int row4 = deliveryInfotable.getSelectedRow();
//                      String refundNo = (String) deliveryInfotable.getValueAt(row4, col4);
					String refundNo = (String) deliveryInfotable.getValueAt(deliveryInfotable.getSelectedRow(), 2);
					RefundView refund = new RefundView(refundNo, pk, nick, point);
					refund.setVisible(true);
				} else {
					// 에러 메시지 표시
					JOptionPane.showMessageDialog(null, "배송중 또는 배송완료된 상품은 환불이 불가능합니다.", "신청실패",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		refundbtn.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		refundbtn.setBounds(643, 476, 89, 36);
		deliveryInfoPanel.add(refundbtn);

		JButton refundbtn_1 = new JButton("\uD6C4\uAE30\uC791\uC131");
		refundbtn_1.setForeground(new Color(0, 0, 0));
		refundbtn_1.setBackground(new Color(255, 255, 255));
		refundbtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao = new SellDAO();
					String buycode = (String) deliveryInfotable.getValueAt(deliveryInfotable.getSelectedRow(), 2);
					String gname = (String) deliveryInfotable.getValueAt(deliveryInfotable.getSelectedRow(), 3);
					ReviewWriteView reviewWrite = new ReviewWriteView(buycode, gname, pk, nick, point);

					// 후기 작성 여부 확인
					boolean hasReview = dao.hasReview(buycode);
					if (hasReview) {
						JOptionPane.showMessageDialog(null, "이미 후기가 작성된 건입니다.", "작성실패", JOptionPane.WARNING_MESSAGE);

						return; // 후기 작성 중지
					}
					reviewWrite.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		refundbtn_1.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		refundbtn_1.setBounds(542, 476, 89, 36);
		deliveryInfoPanel.add(refundbtn_1);
		missionpanel = new JPanel();
		missionpanel.setBounds(202, 142, 757, 540);
		missionpanel.setBackground(new Color(196, 224, 135));
		myPageMain.add(missionpanel);
		missionpanel.setLayout(null);

		missioncomboBox = new JComboBox();
		missioncomboBox.setBackground(new Color(255, 255, 255));
		missioncomboBox.setFont(new Font("나눔고딕", Font.PLAIN, 15));

		missioncomboBox.setModel(new DefaultComboBoxModel(new String[] { "완료", "미완료" }));
		missioncomboBox.setBounds(34, 31, 107, 34);
		missionpanel.add(missioncomboBox);

		missionscrollPane = new JScrollPane();
		missionscrollPane.setBounds(34, 75, 699, 437);
		missionpanel.add(missionscrollPane);

		missiontable = new JTable();
		missiontable.setModel(tmmission);
		missionscrollPane.setViewportView(missiontable);

		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (missioncomboBox.getSelectedIndex() == 0) {
					missionSearch();
				} else {
					missionmiSearch();
				}
			}
		});

		btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btnNewButton.setBounds(150, 31, 84, 34);
		missionpanel.add(btnNewButton);
//      missioncomboBox.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            
//               
//         }
//      });

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				missionSearch();
			}
		});

		btnback.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnback.setBounds(36, 585, 142, 50);
		myPageMain.add(btnback);

		JLabel mypage = new JLabel("My Page");
		mypage.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 28));
		mypage.setBounds(36, 63, 121, 30);
		myPageMain.add(mypage);

		JButton orderlist = new JButton("주문내역");
		orderlist.setForeground(new Color(255, 255, 255));
		orderlist.setBackground(new Color(0, 0, 0));
		orderlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deliveryInfoPanel.setVisible(true);
				deliveryInfotable.setVisible(true);
				cardInfoJPanel.setVisible(false);
				cardInfotable.setVisible(false);
				modifypanel.setVisible(false);
				lbpw_1.setVisible(false);
				lbnick.setVisible(false);
				lbtel.setVisible(false);
				lbaddr.setVisible(false);
				passwordField.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lb010.setVisible(false);
				btnmodify.setVisible(false);
				missionpanel.setVisible(false);
				missioncomboBox.setVisible(false);
				missionscrollPane.setVisible(false);
				missiontable.setVisible(false);

				try {
					ArrayList<ArrayList<String>> deliList = ddao.deliveryAll(pk);

					DefaultTableModel model = (DefaultTableModel) deliveryInfotable.getModel();
					model.setRowCount(0); // 테이블 초기화

					for (ArrayList<String> deli : deliList) {
						model.addRow(deli.toArray());
					}
				} catch (SQLException ev) {
					ev.printStackTrace();
				}
			}
		});
		orderlist.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		orderlist.setBounds(36, 221, 142, 50);
		myPageMain.add(orderlist);

		JButton cardinfo = new JButton("카드정보");
		cardinfo.setBackground(new Color(0, 0, 0));
		cardinfo.setForeground(new Color(255, 255, 255));
		cardinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardInfoJPanel.setVisible(true);
				cardInfotable.setVisible(true);
				modifypanel.setVisible(false);
				lbpw_1.setVisible(false);
				lbnick.setVisible(false);
				lbtel.setVisible(false);
				lbaddr.setVisible(false);
				passwordField.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lb010.setVisible(false);
				btnmodify.setVisible(false);
				missionpanel.setVisible(false);
				missioncomboBox.setVisible(false);
				missionscrollPane.setVisible(false);
				missiontable.setVisible(false);
				deliveryInfoPanel.setVisible(false);
				deliveryInfotable.setVisible(false);
				try {
					ArrayList<ArrayList<String>> cardList = cdao.cardAll(pk);

					DefaultTableModel model = (DefaultTableModel) cardInfotable.getModel();
					model.setRowCount(0); // 테이블 초기화

					for (ArrayList<String> card : cardList) {
						model.addRow(card.toArray());
					}
				} catch (SQLException ev) {
					ev.printStackTrace();
				}
			}
		});

		cardinfo.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		cardinfo.setBounds(36, 298, 142, 50);
		myPageMain.add(cardinfo);

		JButton editinfo = new JButton("정보수정");
		editinfo.setForeground(new Color(255, 255, 255));
		editinfo.setBackground(new Color(0, 0, 0));
		editinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifypanel.setVisible(true);
				lbpw_1.setVisible(true);
				lbnick.setVisible(true);
				lbtel.setVisible(true);
				lbaddr.setVisible(true);
				passwordField.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				lb010.setVisible(true);
				btnmodify.setVisible(true);
				cardInfoJPanel.setVisible(false);
				cardInfotable.setVisible(false);
				missionpanel.setVisible(false);
				missioncomboBox.setVisible(false);
				missionscrollPane.setVisible(false);
				missiontable.setVisible(false);
				deliveryInfoPanel.setVisible(false);
				deliveryInfotable.setVisible(false);
			}
		});

		editinfo.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		editinfo.setBounds(36, 369, 142, 50);
		myPageMain.add(editinfo);

		JButton mission = new JButton("미션");
		mission.setForeground(new Color(255, 255, 255));
		mission.setBackground(new Color(0, 0, 0));
		mission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				missionpanel.setVisible(true);
				missioncomboBox.setVisible(true);
				missionscrollPane.setVisible(true);
				missiontable.setVisible(true);
				cardInfoJPanel.setVisible(false);
				cardInfotable.setVisible(false);
				modifypanel.setVisible(false);
				lbpw_1.setVisible(false);
				lbnick.setVisible(false);
				lbtel.setVisible(false);
				lbaddr.setVisible(false);
				passwordField.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lb010.setVisible(false);
				btnmodify.setVisible(false);
				deliveryInfoPanel.setVisible(false);
				deliveryInfotable.setVisible(false);

			}
		});

		mission.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		mission.setBounds(36, 438, 142, 50);
		myPageMain.add(mission);

		JButton attend = new JButton("출석체크현황");
		attend.setForeground(new Color(255, 255, 255));
		attend.setBackground(new Color(0, 0, 0));
		attend.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		attend.setBounds(36, 512, 142, 50);
		myPageMain.add(attend);

		attend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		attend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AttendView AttendView = new AttendView(pk, nick, point);
				AttendView.setVisible(true);

			}
		});

		JButton logo = new JButton("");
		logo.setIcon(new ImageIcon(MyPageView.class.getResource("/image/\uB85C\uACE0\uAC80\uC815.png")));
		logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainHomeView plantview = new MainHomeView(pk, nick, point);
				plantview.setVisible(true);

			}
		});
		logo.setBounds(432, 21, 188, 97);
		logo.setOpaque(false);
		logo.setContentAreaFilled(false);
		logo.setBorderPainted(false);

		myPageMain.add(logo);

	}

	// 주문 정보
	void deliveryInfo() {

	}

	// 카드 정보
	void cardInfo() {

		JLabel lblNewLabel_1 = new JLabel(nick + " 님");
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(36, 117, 140, 43);
		myPageMain.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(point + " 앗");
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(36, 158, 137, 31);
		myPageMain.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MyPageView.class.getResource("/image/ㅓㅇㄴㅁ러ㅜㅎㄹ어ㅏjpg.jpg")));
		lblNewLabel_3.setBounds(252, 134, 707, 517);
		myPageMain.add(lblNewLabel_3);

	}

	// 미션
	void missionInfo() {
	}

	void offSwitchDeli() {
		deliveryInfoPanel.setVisible(false);
		deliveryInfotable.setVisible(false);
	}

	void offSwitchmission() {
		missionpanel.setVisible(false);
		missioncomboBox.setVisible(false);
		missionscrollPane.setVisible(false);
		missiontable.setVisible(false);
	}

	void offSwitchmodify() {
		modifypanel.setVisible(false);
		lbnick.setVisible(false);
		lbtel.setVisible(false);
		lbaddr.setVisible(false);
		passwordField.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		lb010.setVisible(false);
		btnmodify.setVisible(false);
	}

	void offSwitchCard() {
		cardInfoJPanel.setVisible(false);
	}

	// 미션 완료 메소드
	void missionSearch() {
		int sel = missioncomboBox.getSelectedIndex();
		int code = pk;

		// String text = textField.getText();
		try {

			list = mdao.missionSearch(sel, code);
			tmmission.data = list;
			missiontable.setModel(tmmission);
			tmmission.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "검색에 실패하였습니다.", "검색실패", JOptionPane.WARNING_MESSAGE);
		}

	}

	// 미션 미완료 메소드
	void missionmiSearch() {
		int sel = missioncomboBox.getSelectedIndex();
		int code = pk;

		try {
			list = mdao.missionmiSearch(sel, code);
			tmmission.data = list;
			missiontable.setModel(tmmission);
			tmmission.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "검색에 실패하였습니다.", "검색실패", JOptionPane.WARNING_MESSAGE);
		}
	}

	class MissionTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "미션명", "미션 포인트" };

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}

}