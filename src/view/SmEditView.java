package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.MarketDAO;
import model.rec.MarketVO;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class SmEditView extends JFrame {

	JPanel contentPane;
	JTextField textField;
	static int pk;
	static String nick;
	static int point;
	JTextField textField_1;
	JTextArea textArea;
	MarketVO vo;
	MarketDAO dao;

	/**
	 * Create the frame.
	 * 
	 * @param vo
	 */
	public SmEditView(MarketVO vo, int pk, String nick, int point) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SmEditView.class.getResource("/image/\uD638\uBBF8.png")));
		setTitle("\uAD6C\uB9E4\uAE00 \uC218\uC815");
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.vo = vo;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(196, 224, 135));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("돌아가기");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(313, 114, 271, 312);
		contentPane.add(textArea_1);
		textArea_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textArea_1.setText(vo.getSmcontent());
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton.setBounds(358, 476, 150, 70);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("제목 : ");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		lblNewLabel.setBounds(63, 46, 51, 39);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textField.setBounds(119, 46, 289, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(vo.getSmname());
		textField.setOpaque(false);
		textField.setBorder(new LineBorder(Color.BLACK));

		JButton btnNewButton_1 = new JButton("수정 완료");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					vo.setMembercode(pk);
					vo.setSmarketcode(vo.getSmarketcode());
					vo.setSmname(textField.getText());
					vo.setSmprice(textField_1.getText());
					vo.setSmcontent(textArea_1.getText());

					dao = new MarketDAO();
					dao.smupdate(vo);
					JOptionPane.showMessageDialog(null, "수정되었습니다.", "수정완료", JOptionPane.PLAIN_MESSAGE);
					dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "다시 수정해주세요.", "수정실패", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(134, 476, 150, 70);
		contentPane.add(btnNewButton_1);

		JLabel pricelabel = new JLabel("금액 : ");
		pricelabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		pricelabel.setBounds(420, 46, 59, 39);
		contentPane.add(pricelabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(313, 114, 289, 312);
		contentPane.add(scrollPane);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textField_1.setBounds(480, 46, 122, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(vo.getSmprice());
		textField_1.setOpaque(false);
		textField_1.setBorder(null);

		JLabel smiamge = new JLabel("이미지 자리");
		smiamge.setBounds(63, 126, 250, 286);
		contentPane.add(smiamge);
		String imagePath = vo.getSmimage();
		ImageIcon imageIcon = new ImageIcon(imagePath);
		smiamge.setIcon(imageIcon);

	}

}
