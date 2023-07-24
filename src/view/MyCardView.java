package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import model.BuyDAO;
import model.CardDAO;
import model.SellDAO;
import model.rec.BuyVO;
import model.rec.CardVO;
import java.awt.Toolkit;

public class MyCardView extends JFrame {

	JPanel myCard;
	JLabel logo;
	JLabel myCardNoLabel;
	JComboBox<String> myCardsName;
	JComboBox<String> myCardsNo;
	JPasswordField passwordField;
	JButton btnNewButton;
	JButton canclebtnNewButton;

	SellDAO sdao;
	BuyDAO bdao;
	BuyVO bvo;
	CardDAO cdao;
	CardVO cvo;
	ArrayList<String> myCardList;
	ArrayList<String> myCardNoList;
	String cname;
	static int pk;
	static String nick;
	static int point;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCardView frame = new MyCardView(pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyCardView(int pk, String nick, int point) {
		setTitle("\uCE74\uB4DC\uACB0\uC81C");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MyCardView.class.getResource("/image/\uD638\uBBF8.png")));
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		myCardList = new ArrayList<>();
		myCardNoList = new ArrayList<>();
		try {
			cdao = new CardDAO();
			cvo = new CardVO();
			bdao = new BuyDAO();
			myCardNoList = cdao.myCardAllCno(cname);
			myCardList = cdao.myCardAllCname(pk);

			System.out.println("DB 연결 성공!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB 연결 실패 : " + e.getMessage());
		}

		addLayout();
	}

	public void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		myCard = new JPanel();
		myCard.setBackground(new Color(220, 240, 217));
		myCard.setBorder(new EmptyBorder(5, 5, 5, 5));
		myCard.setBackground(new Color(196, 224, 135));
		setLocationRelativeTo(null);

		setContentPane(myCard);
		myCard.setLayout(null);

		logo = new JLabel("");
		logo.setIcon(new ImageIcon(MyCardView.class.getResource("")));
		logo.setBounds(200, 25, 55, 55);
		myCard.add(logo);

		myCardNoLabel = new JLabel("내 카드 선택");
		myCardNoLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		myCardNoLabel.setBackground(new Color(89, 159, 121));
		myCardNoLabel.setBounds(162, 160, 114, 23);
		myCard.add(myCardNoLabel);

		myCardsName = new JComboBox<>();
		myCardsName.setBackground(Color.WHITE);
		myCardsName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardName = (String) myCardsName.getSelectedItem();
				try {
					myCardNoList = cdao.myCardAllCno(cardName);
					updateMyCardsNoComboBox(myCardNoList);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			void updateMyCardsNoComboBox(ArrayList<String> myCardNoList) {
				myCardsNo.setModel(new DefaultComboBoxModel<>(myCardNoList.toArray(new String[0])));
			}
		});
		myCardsName.setModel(new DefaultComboBoxModel<>(myCardList.toArray(new String[0])));
		myCardsName.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		myCardsName.setBounds(277, 152, 129, 40);
		myCard.add(myCardsName);

		myCardsNo = new JComboBox<>();
		myCardsNo.setBackground(Color.WHITE);
		myCardsNo.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		myCardsNo.setBounds(277, 206, 258, 42);
		myCard.add(myCardsNo);

		JLabel cpw = new JLabel("카드 비밀번호");
		cpw.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		cpw.setBackground(new Color(89, 159, 121));
		cpw.setBounds(162, 295, 121, 23);
		myCard.add(cpw);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		passwordField.setBounds(277, 287, 129, 40);
		myCard.add(passwordField);

		btnNewButton = new JButton("결제");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardName = (String) myCardsName.getSelectedItem();
				String cardNo = (String) myCardsNo.getSelectedItem();
				String password = new String(passwordField.getPassword());
				// 하는중
				try {
					boolean pwCheck = cdao.myCardCheck(cardName, cardNo, password);
					if (pwCheck) {
						int cardcode = bdao.getCardCode(cardNo);
						bvo = new BuyVO(); // bvo 초기화
						bvo.setCardcode(cardcode);
						bdao.orderInsert(bvo);
						bdao.buyInsert(cardcode, pk);
						sdao = new SellDAO();
						sdao.cartDelete(pk);
						JOptionPane.showMessageDialog(null, "결제가 완료되었습니다");
						dispose();
//                SellView sell = new SellView(pk, nick, point);
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(141, 438, 150, 70);
		myCard.add(btnNewButton);

		canclebtnNewButton = new JButton("취소");
		canclebtnNewButton.setForeground(new Color(255, 255, 255));
		canclebtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CardAddView cardaddview = new CardAddView(pk, nick, point);
				cardaddview.setVisible(false);
			}
		});
		canclebtnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		canclebtnNewButton.setBackground(new Color(0, 0, 0));
		canclebtnNewButton.setBounds(338, 438, 150, 70);
		myCard.add(canclebtnNewButton);
	}
}