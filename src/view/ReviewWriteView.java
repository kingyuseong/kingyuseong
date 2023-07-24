package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.SellDAO;
import model.rec.SellVO;
import java.awt.Toolkit;

public class ReviewWriteView extends JFrame {

	JPanel contentPane;
	JTextField tfRcontent, tfRdate;
	JComboBox comBuycode, comGname, comRstar;

	SellDAO dao = null;
	SellVO vo = null;
	static int pk;
	static String nick;
	static String gname;
	static int point;
	static String reviewItem;
	JTextField tfBuycode;
	JTextField tfGname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageView mview = new MyPageView(pk, nick, point);
					ReviewWriteView frame = new ReviewWriteView(reviewItem, gname, pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param gname
	 */
	public ReviewWriteView(String reviewItem, String gname, int pk, String nick, int point) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ReviewWriteView.class.getResource("/image/\uD638\uBBF8.png")));
		setTitle("\uD6C4\uAE30\uC791\uC131");
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.gname = gname;
		this.reviewItem = reviewItem;

		try {
			System.out.println("DB 연결 성공!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB 연결 실패 : " + e.getMessage());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(196, 224, 135));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 구매아이템번호
		JLabel Label_1 = new JLabel("구매건 : ");
		Label_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		Label_1.setBounds(170, 80, 67, 44);
		contentPane.add(Label_1);

		tfBuycode = new JTextField();
		tfBuycode.setBackground(new Color(255, 255, 255));
		tfBuycode.setHorizontalAlignment(SwingConstants.CENTER);
		tfBuycode.setEditable(false);
		tfBuycode.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfBuycode.setColumns(10);
		tfBuycode.setBounds(268, 81, 126, 44);
		contentPane.add(tfBuycode);
		tfBuycode.setText(reviewItem);
		try {
			dao = new SellDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 구매상품명
		JLabel Label_2 = new JLabel("상품명 : ");
		Label_2.setBounds(168, 133, 78, 44);
		Label_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(Label_2);

		tfGname = new JTextField();
		tfGname.setBackground(new Color(255, 255, 255));
		tfGname.setHorizontalAlignment(SwingConstants.CENTER);
		tfGname.setEditable(false);
		tfGname.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfGname.setColumns(10);
		tfGname.setBounds(268, 135, 126, 44);
		contentPane.add(tfGname);
		tfGname.setText(gname);
		try {
			dao = new SellDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 작성일
		JLabel Label_3 = new JLabel("작성일 : ");
		Label_3.setBounds(168, 187, 78, 44);
		Label_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(Label_3);

		tfRdate = new JTextField();
		tfRdate.setBackground(new Color(255, 255, 255));
		tfRdate.setHorizontalAlignment(SwingConstants.CENTER);
		tfRdate.setEditable(false);
		tfRdate.setBounds(268, 189, 126, 44);
		tfRdate.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfRdate.setColumns(10);
		contentPane.add(tfRdate);
		setCurrentDate();

		// 별점
		JLabel Label_4 = new JLabel("별점 : ");
		Label_4.setBounds(190, 241, 56, 44);
		Label_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(Label_4);

		JComboBox comRstar = new JComboBox();
		comRstar.setBackground(new Color(255, 255, 255));
		comRstar.setBounds(268, 247, 126, 38);
		comRstar.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		comRstar.setModel(new DefaultComboBoxModel(new String[] { "★★★★★", "★★★★", "★★★", "★★", "★" }));
		contentPane.add(comRstar);

		// 후기등록버튼

		JButton btnNewButton = new JButton("후기등록");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(228, 467, 150, 70);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String rstar = (String) comRstar.getSelectedItem();
					String rcontent = tfRcontent.getText();
					String rdate = tfRdate.getText();
					String buycode = tfBuycode.getText();

					vo = new SellVO();
					vo.setRstar(rstar);
					vo.setRcontent(rcontent);
					vo.setRdate(rdate);
					vo.setBuycode(buycode);

					dao.reviewAdd(vo);

					JOptionPane.showMessageDialog(null, "후기가 등록되었습니다.");
					dispose();
					ReviewView review = new ReviewView(pk, nick, point);
					review.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(btnNewButton);

		JLabel Label_5 = new JLabel("후기내용 : ");
		Label_5.setBounds(158, 299, 88, 44);
		Label_5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(Label_5);

		tfRcontent = new JTextField();
		tfRcontent.setBounds(266, 302, 241, 129);
		tfRcontent.setColumns(10);
		contentPane.add(tfRcontent);

	}

	// 현재날짜 받아오는 매소드
	void setCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		tfRdate.setText(currentDate.format(formatter));
	}

}