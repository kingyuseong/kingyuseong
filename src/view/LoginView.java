package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.CustomerDAO;
import model.rec.CustomerVO;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class LoginView extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JPasswordField passwordField;

	CustomerDAO dao;
	CustomerVO vo;
	int point;
	String nick;
	ArrayList list;
	static int pk;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {

		this.nick = nick;
		this.point = point;

		setTitle("\uD648\uD30C\uBC0D \uB9AC\uC6CC\uB4DC \uD50C\uB7AB\uD3FC : Ho me");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);

		try {
			dao = new CustomerDAO(); // CustomerDAO 객체 초기화
		} catch (Exception e) {
			e.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/image/\uD638\uBBF8.png")));
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 224, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("  ID \r\n");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(179, 284, 47, 56);
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		JLabel lblPw = new JLabel("PW \r\n");
		lblPw.setForeground(Color.BLACK);
		lblPw.setBounds(179, 350, 47, 50);
		lblPw.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		contentPane.add(lblPw);

		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(350, 469, 150, 70);
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBounds(155, 469, 150, 70);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));

		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(btnNewButton);

		// 로그인 버튼 액션
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pw = passwordField.getText();

				try {
					// int MEMBERCODE = dao.login(id, pw); // 존재하는 계정인지 확인하여 계정 기본키(코드)를 가져옴
					// vo = new CustomerVO();
					// vo = dao.login(id, pw);
					list = dao.login(id, pw);
					int MEMBERCODE = Integer.parseInt(String.valueOf(list.get(0)));
					nick = String.valueOf(list.get(3));
					int point = Integer.parseInt(String.valueOf(list.get(4)));
					// System.out.println(MEMBERCODE+ " "+ nick+ " "+ point);

					if (MEMBERCODE == 0) { // 아무 값도 가져오지 못했을 경우
						JOptionPane.showMessageDialog(null, "ID, PW를 확인해주세요.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, id + "님 환영합니다. \n♥건강한 하루 보내세요♥", "로그인 성공",
								JOptionPane.PLAIN_MESSAGE);

						MainHomeView plantview = new MainHomeView(MEMBERCODE, nick, point);
						plantview.setVisible(true);
						dispose();

						// frame.setVisible(false); // 현재 창 종료
						// new MainView(acct_code); // Main 창 열기
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ID, PW를 확인해주세요.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		textField = new JTextField();
		textField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textField.setBounds(261, 295, 175, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		passwordField.setBounds(261, 355, 175, 45);
		contentPane.add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/image/찐최종.png")));
		lblNewLabel_1.setBounds(65, 34, 524, 264);
		contentPane.add(lblNewLabel_1);

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpView frame = new SignUpView();
			}
		});

		// 회원가입 버튼 클릭 이벤트 처리
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 화면 닫기
				SignUpView registerView = new SignUpView(); // 회원가입 화면 객체 생성
				registerView.setVisible(true); // 회원가입 화면 보이기
			}
		});

	}
}
