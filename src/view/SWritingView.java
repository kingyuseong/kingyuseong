package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.MarketDAO;
import model.rec.MarketVO;
import java.awt.Color;

public class SWritingView extends JFrame {

	JPanel panel;
	JTextField tftitle;
	JTextField tfprice;
	JTextArea tacontent;

	static int pk;
	static String nick;
	static int point;

	JButton btnNewButton;

	MarketVO vo = null;
	MarketDAO dao = null;

	/**
	 * Launch the application.
	 */
	public SWritingView(int pk, String nick, int point) {
		setTitle("\uAD6C\uB9E4\uAE00 \uC791\uC131");
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		newObject();
		addLayout();

		try {
			dao = new MarketDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					SWritingView frame = new SWritingView(pk, nick, point);
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
	void newObject() {

		tfprice = new JTextField(30);
		tftitle = new JTextField(30);
		tacontent = new JTextArea(15, 3);

		btnNewButton = new JButton("글올리기");

	}

	void addLayout() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(SWritingView.class.getResource("/image/\uD638\uBBF8.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBackground(new Color(196, 224, 135));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("제목 : ");
		lblNewLabel.setBounds(219, 72, 63, 35);
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		panel.add(lblNewLabel);

		tftitle = new JTextField();
		tftitle.setBounds(277, 74, 308, 35);
		panel.add(tftitle);
		tftitle.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 158, 530, 327);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);

		JTextArea areacontent = new JTextArea();
		areacontent.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		scrollPane.setViewportView(areacontent);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(55, 72, 72, 35);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "삽니다", "팝니다" }));
		panel.add(comboBox);

		JComboBox palntcombo = new JComboBox();
		palntcombo.setBounds(143, 72, 64, 35);
		palntcombo.setBackground(new Color(255, 255, 255));
		palntcombo.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		palntcombo.setModel(new DefaultComboBoxModel(new String[] { "식물", "과일", "채소" }));
		panel.add(palntcombo);

		tfprice = new JTextField();
		tfprice.setBounds(281, 119, 163, 35);
		tfprice.setColumns(10);
		panel.add(tfprice);

		JButton btnNewButton = new JButton("글 올리기");
		btnNewButton.setBounds(373, 516, 150, 70);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int membercode = pk;
				String plant = (String) palntcombo.getSelectedItem();
				int plantcode = 0;

				if (comboBox.getSelectedIndex() == 0) {
					String bmname = tftitle.getText();
					String bmprice = tfprice.getText();
					String bmcontent = areacontent.getText();
					vo = new MarketVO();
					vo.setBmname(bmname);
					vo.setBmprice(bmprice);
					vo.setBmcontent(bmcontent);
					vo.setMembercode(membercode);

					if (plant == "식물") {
						plantcode = 2;
						vo.setPlantcode(plantcode);

					} else if (plant == "과일") {
						plantcode = 3;
						vo.setPlantcode(plantcode);
					} else {
						plantcode = 4;
						vo.setPlantcode(plantcode);
					}
					try {
						dao.bmregist(vo);
						JOptionPane.showMessageDialog(null, "구매글이 등록되었습니다.", "게시완료", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "다시 작성해주세요.", "게시실패", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					String smname = tftitle.getText();
					String smprice = tfprice.getText();
					String smcontent = areacontent.getText();
					vo = new MarketVO();
					vo.setSmname(smname);
					vo.setSmprice(smprice);
					vo.setSmcontent(smcontent);
					vo.setMembercode(membercode);
					if (plant == "식물") {
						plantcode = 2;
						vo.setPlantcode(plantcode);
					} else if (plant == "과일") {
						plantcode = 3;
						vo.setPlantcode(plantcode);
					} else {
						plantcode = 4;
						vo.setPlantcode(plantcode);
					}
					try {

						dao.smregist(vo);
						JOptionPane.showMessageDialog(null, "판매글이 등록되었습니다.", "게시완료", JOptionPane.PLAIN_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "다시 작성해주세요.", "게시실패", JOptionPane.WARNING_MESSAGE);
					}
				}

				dispose();
				MarketView marketview = new MarketView(pk, nick, point);
				marketview.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("돌아가기");
		btnNewButton_1.setBounds(111, 516, 150, 70);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MarketView markertview = new MarketView(pk, nick, point);
				markertview.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("금액 : ");
		lblNewLabel_1.setBounds(219, 117, 50, 37);
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
	}

}