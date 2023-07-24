package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.AttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import model.SignUpDAO;
import model.rec.SignUpVO;
import javax.swing.SwingConstants;

public class SignUpView extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_7;
	JPasswordField passwordField;
	JPasswordField passwordField_1;
	JPasswordField juminbunho;
	JButton idgood;
	JButton nickgood;
	SignUpDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public SignUpView() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");

		// DB연결
		try {
			dao = new SignUpDAO();
			System.out.println("[!] DB 연결 성공!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[!] DB 연결 실패 : " + e.getMessage());
			System.out.println(e.getMessage());
		}

		initialize();
	}

	public void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpView.class.getResource("/image/\uD638\uBBF8.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 224, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel.setBounds(89, 25, 41, 65);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PW :");
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(89, 85, 57, 53);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uB2C9\uB124\uC784 :");
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(89, 193, 78, 65);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("이름 :");
		lblNewLabel_2_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(89, 250, 57, 65);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("\uC8FC\uBBFC\uBC88\uD638 :");
		lblNewLabel_2_1_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(89, 312, 100, 65);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("주소 :");
		lblNewLabel_2_1_1_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1.setBounds(89, 371, 57, 65);
		contentPane.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("전화번호 :");
		lblNewLabel_2_1_1_1_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1_1.setBounds(89, 434, 100, 65);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		textField = new JTextField();
		textField.setDocument(new JTextFieldLimit(14));
		textField.setBounds(196, 34, 288, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setDocument(new JTextFieldLimit(12));
		textField_2.setColumns(10);
		textField_2.setBounds(196, 205, 288, 47);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(196, 262, 288, 47);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setDocument(new JTextFieldLimit(9));
		textField_4.setBounds(258, 446, 226, 47);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setDocument(new JTextFieldLimit(6));
		textField_5.setColumns(10);
		textField_5.setBounds(196, 324, 124, 47);
		contentPane.add(textField_5);

		passwordField = new JPasswordField();
		passwordField.setDocument(new JTextFieldLimit(15));
		passwordField.setBounds(196, 91, 288, 47);
		contentPane.add(passwordField);

		JButton btnga = new JButton("회원 가입");
		btnga.setForeground(new Color(255, 255, 255));
		btnga.setBackground(new Color(0, 0, 0));
		btnga.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnga.setBounds(241, 517, 150, 70);
		contentPane.add(btnga);
		btnga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String password = new String(passwordField.getPassword());
				String nickname = textField_2.getText();
				String name = textField_3.getText();
				String jumin = textField_5.getText() + "-" + juminbunho.getText();
				String tel = textField_4.getText();
				String addr = textField_7.getText();

				// 회원 가입 로직 호출
				registerCustomer(id, password, nickname, name, jumin, tel, addr);

				// 회원 가입 후 필드 초기화
				textField.setText("");
				passwordField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_4.setText("");
//                textField_6.setText("");
			}

			private void registerCustomer(String id, String password, String nickname, String name, String jumin,
					String tel, String addr) {
				// TODO Auto-generated method stub

			}
		});

		// ...

		JLabel lblNewLabel_3 = new JLabel("PW 확인 :");
		lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(89, 136, 100, 65);
		contentPane.add(lblNewLabel_3);

		passwordField_1 = new JPasswordField();
		passwordField_1.setDocument(new JTextFieldLimit(15));
		passwordField_1.setBounds(196, 148, 288, 47);
		contentPane.add(passwordField_1);

		textField_7 = new JTextField();
		textField_7.setBounds(196, 383, 288, 47);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("-");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(321, 337, 23, 24);
		contentPane.add(lblNewLabel_5);

		juminbunho = new JPasswordField();
		juminbunho.setDocument((new JTextFieldLimit(7)));
		juminbunho.setBounds(342, 324, 142, 47);
		contentPane.add(juminbunho);

		JLabel lblNewLabel_6 = new JLabel("010 -");
		lblNewLabel_6.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(201, 462, 57, 15);
		contentPane.add(lblNewLabel_6);

		JButton idgood = new JButton("\uC911\uBCF5\uD655\uC778");
		idgood.setBackground(new Color(255, 255, 255));
		idgood.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		idgood.setBounds(496, 36, 100, 47);
		contentPane.add(idgood);

		JButton nickgood = new JButton("\uC911\uBCF5\uD655\uC778");
		nickgood.setBackground(new Color(255, 255, 255));
		nickgood.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		nickgood.setBounds(496, 205, 100, 47);
		contentPane.add(nickgood);

		// 아이디 중복확인 버튼 이벤트 발생
		idgood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();

				try {
					String memId = dao.checkId(id);
					if (textField.getText().length() < 4) {
						JOptionPane.showMessageDialog(null, "아이디는 최소 4자 이상 입력하세요.", "ID사용불가",
								JOptionPane.WARNING_MESSAGE);
					} else {
						if (memId == null) {
							JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.", "ID사용가능", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.", "ID사용불가",
									JOptionPane.WARNING_MESSAGE);
							textField.setText("");
						}
					}
				} catch (Exception e1) {
				}
				// dispose();
			}
		});

		// 닉네임 중복확인 버튼 이벤트 발생
		nickgood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nick = textField_2.getText();

				try {
					String memnick = dao.checkNick(nick);
					if (textField_2.getText().length() < 2) {
						JOptionPane.showMessageDialog(null, "닉네임은 최소 2자 이상 입력하세요.", "닉네임사용불가",
								JOptionPane.WARNING_MESSAGE);
					} else {
						if (memnick == null) {
							JOptionPane.showMessageDialog(null, "사용 가능한 닉네임입니다.", "닉네임사용가능", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "이미 사용중인 닉네임입니다.", "닉네임사용불가",
									JOptionPane.WARNING_MESSAGE);
							textField_2.setText("");
						}
					}
				} catch (Exception e1) {
				}
				// dispose();
			}
		});

		// 비밀번호 확인 버튼 이벤트 발생
		nickgood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = passwordField_1.getText();

				try {
					String memnick = dao.checkPass(pass);
					if (passwordField_1.getText().equals(passwordField)) {
						JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.", "비밀번호확인", JOptionPane.PLAIN_MESSAGE);
					} else {
						if (pass == null) {
							JOptionPane.showMessageDialog(null, "비밀번호기 일치하지 않습니다.", "비밀번호 불일치",
									JOptionPane.WARNING_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "비밀번호기 일치하지 않습니다.", "비밀번호 불일치",
									JOptionPane.WARNING_MESSAGE);
							passwordField_1.setText("");
						}
					}
				} catch (Exception e1) {
				}
				// dispose();
			}
		});

		// 회원가입 버튼을 눌렀을 때 이벤트 발생 + 중복시 가입 불가능 기능
		btnga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpVO vo = new SignUpVO();

				String id = textField.getText();
				String pw = passwordField.getText();
				String nickname = textField_2.getText();
				String name = textField_3.getText();
				String idnum = textField_5.getText() + "-" + juminbunho.getText();
				String tel = "010-" + textField_4.getText();
				String addr = textField_7.getText();

				vo.setId(id);
				vo.setPw(pw);
				vo.setNick(nickname);
				vo.setName(name);
				vo.setJumin(idnum);
				vo.setTel(tel);
				vo.setAddr(addr);

				while (true) {

					if (textField.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "아이디를 입력하세요.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (passwordField.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (textField_2.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "닉네임을 입력하세요.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (textField_3.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "이름을 입력하세요.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (textField_5.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "주민번호를 입력하세요.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (juminbunho.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "주민번호를 입력하세요.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (textField_4.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "주소를 입력하세요.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (textField_7.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "연락처를 입력하세요.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);
						break;
					}
					try {
						String memnick = dao.checkNick(nickname);
						String memId = dao.checkId(id);
						if (memId != null) {
							JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.", "ID사용불가",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
						if (memnick == null) {
							dao.join(vo);
							JOptionPane.showMessageDialog(null, "회원가입 되었습니다. 환영합니다!", "가입 성공",
									JOptionPane.PLAIN_MESSAGE);
							clearScreen();

							break;
						} else {
							JOptionPane.showMessageDialog(null, "이미 사용중인 닉네임입니다.", "ID사용불가",
									JOptionPane.WARNING_MESSAGE);
							break;
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "다시 회원가입을 시도해주세요.", "가입 실패", JOptionPane.WARNING_MESSAGE);
						System.out.println(e1.getMessage());
					}

					// dispose();
					break;

				}
			}

		});

		// 회원가입을 성공하면 로그인 창으로 이동
		btnga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 화면 닫기
				LoginView LoginView = new LoginView(); // 회원가입 화면 객체 생성
				LoginView.setVisible(true); // 로그인창 화면 보이기

			}
		});

	}

	// 클리어 스크린 메소드
	public void clearScreen() {
		textField.setText("");
		passwordField.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_5.setText("");
		juminbunho.setText("");
		textField_4.setText("");
		textField_7.setText("");
	}

	class JTextFieldLimit extends PlainDocument {
		private int limit;
		private boolean toUppercase = false;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
			this.toUppercase = upper;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null) {
				return;
			}

			if ((getLength() + str.length()) <= limit) {
				if (toUppercase) {
					str = str.toUpperCase();
				}
				super.insertString(offset, str, (javax.swing.text.AttributeSet) attr);
			}
		}
	}
}
