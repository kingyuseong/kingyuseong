package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class BmEditView extends JFrame {

	JPanel contentPane;
	JTextField textField;
	static int pk;
	static String nick;
	static int point;
	JTextField textField_1;
	MarketVO vo;
	MarketDAO dao;

	/**
	 * Create the frame.
	 * 
	 * @param vo
	 */
	public BmEditView(MarketVO vo, int pk, String nick, int point) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BmEditView.class.getResource("/image/\uD638\uBBF8.png")));
		setTitle("\uD310\uB9E4\uAE00 \uC218\uC815");
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
		textField.setText(vo.getBmname());
		textField.setOpaque(false);
		textField.setBorder(new LineBorder(Color.BLACK));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(74, 99, 479, 338);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea);
		textArea.setText(vo.getBmcontent());

		JButton btnNewButton_1 = new JButton("수정 완료");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					vo.setMembercode(pk);
					vo.setBmarketcode(vo.getBmarketcode());
					vo.setBmname(textField.getText());
					vo.setBmprice(textField_1.getText());
					vo.setBmcontent(textArea.getText());

					dao = new MarketDAO();
					dao.bmupdate(vo);
					JOptionPane.showMessageDialog(null, "수정되었습니다.", "수정완료", JOptionPane.PLAIN_MESSAGE);
					dispose();

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "다시 수정해주세요.", "수정실패", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(134, 476, 150, 70);
		contentPane.add(btnNewButton_1);

		JLabel pricelabel = new JLabel("금액 : ");
		pricelabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		pricelabel.setBounds(428, 46, 51, 39);
		contentPane.add(pricelabel);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textField_1.setBounds(480, 46, 75, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(vo.getBmprice());
		textField_1.setOpaque(false);
		textField_1.setBorder(null);
	}
}
