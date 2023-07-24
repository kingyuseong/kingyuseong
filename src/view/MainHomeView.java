package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.MainHomeDAO;
import model.rec.MainHomeVO;
import java.awt.Color;
import java.awt.SystemColor;

public class MainHomeView extends JFrame {

	JPanel contentPane;
	JTextField textField;

	JTable sctable;

	MainHomeDAO dao = null;
	MainHomeVO vo = null;

	JTextField tfHomename, tfHomeavgtime, tflevel, tfcost, tfprice, tfproflt;
	JLabel nicklabel;

	JTextField tfHomeSearch;
	HomeTableModel tmHome;
	JTextArea taHomeContent;
	JComboBox comboBox_1;
	ArrayList list;
	AbstractButton textFieldmem;
	static int pk;
	static String nick;
	static int point;

	/**
	 * Launch the application.
	 */
	public MainHomeView(int pk, String nick, int point) {
		setTitle("\uD648\uD30C\uBC0D \uB9AC\uC6CC\uB4DC \uD50C\uB7AB\uD3FC : Ho me");
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		newObject();
		addLayout(pk, nick, point);

		try {
			dao = new MainHomeDAO();
			System.out.println("비디오연결성공");
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "연결실패:" + e.getMessage());
			// TODO: handle exception
		}
	}

//	public MainHomeView() {
//		newObject();
//		addLayout();
//		this.pk = pk;
//		
//		try {
//			dao = new MainHomeDAO();
//			System.out.println("비디오연결성공");
//		} catch (Exception e) {
//			JOptionPane.showConfirmDialog(null, "연결실패:" + e.getMessage());
//			// TODO: handle exception
//		}
//	}
	void newObject() {
		tfHomename = new JTextField(30);
		tfHomeavgtime = new JTextField(30);
		tflevel = new JTextField(30);
		tfcost = new JTextField(30);
		tfprice = new JTextField(30);
		tfproflt = new JTextField(30);

		taHomeContent = new JTextArea(15, 3);

		tfHomeSearch = new JTextField(30);

		tmHome = new HomeTableModel();
		sctable = new JTable(tmHome);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainHomeView frame = new MainHomeView(pk, nick, point);
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

	void addLayout(int pk, String nick, int point) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainHomeView.class.getResource("/image/\uD638\uBBF8.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 224, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton shoppingbt = new JButton("쇼핑하기");
		shoppingbt.setForeground(new Color(255, 255, 255));
		shoppingbt.setBackground(new Color(0, 0, 0));
		shoppingbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SellView sellview = new SellView(pk, nick, point);
				sellview.setVisible(true);
			}
		});
		shoppingbt.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		shoppingbt.setBounds(49, 462, 167, 72);
		contentPane.add(shoppingbt);

		JButton btnNewButton_1_2 = new JButton("미니 텃밭 예약");
		btnNewButton_1_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2.setBackground(new Color(0, 0, 0));
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GardenView gardenview = new GardenView(pk, nick, point);
				gardenview.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton_1_2.setBounds(49, 569, 168, 72);
		contentPane.add(btnNewButton_1_2);

		JButton jangtbt = new JButton("장터 이용");
		jangtbt.setForeground(new Color(255, 255, 255));
		jangtbt.setBackground(new Color(0, 0, 0));
		jangtbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jangtbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MarketView markertview = new MarketView(pk, nick, point);
				markertview.setVisible(true);

			}

		});

		jangtbt.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		jangtbt.setBounds(49, 359, 167, 72);
		contentPane.add(jangtbt);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AttendView attendview = new AttendView(pk, nick, point);
				attendview.setVisible(true);

			}
		});
		btnNewButton_2.setIcon(new ImageIcon(MainHomeView.class.getResource("/image/\uCD9C\uCCB5.png")));
		btnNewButton_2.setBounds(88, 46, 84, 72);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(MainHomeView.class.getResource("/image/\uB85C\uACE0\uAC80\uC815.png")));
		btnNewButton_5.setBounds(420, 39, 199, 105);
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBorderPainted(false);
		contentPane.add(btnNewButton_5);

		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));

		comboBox_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "\uC2DD\uBB3C", "\uACFC\uC77C", "\uCC44\uC18C" }));
		comboBox_1.setBounds(49, 200, 58, 45);
		contentPane.add(comboBox_1);
		// 무슨기능을 작동시키기 위한 메소드
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainHomeselectTable();
			}
		});
		textField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(115, 200, 101, 45);
		contentPane.add(textField);

		// 검색 마우스 클릭 시 이벤트
		JButton btnNewButton_8 = new JButton("검색");
		btnNewButton_8.setForeground(new Color(0, 0, 0));
		btnNewButton_8.setBackground(new Color(255, 255, 255));
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainHomeselectTable();

			}
		});

		btnNewButton_8.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btnNewButton_8.setBounds(115, 255, 101, 45);
		contentPane.add(btnNewButton_8);

		JLabel lblNewLabel = new JLabel("    출석체크");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(86, 116, 86, 23);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyPageView mypageview = new MyPageView(pk, nick, point);
				mypageview.setVisible(true);

			}
		});
		btnNewButton_2_1
				.setIcon(new ImageIcon(MainHomeView.class.getResource("/image/\uB9C8\uC774\uD398\uC774\uC9C0.png")));
		btnNewButton_2_1.setBounds(849, 46, 84, 72);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.setOpaque(false);
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);

		JScrollPane sc = new JScrollPane();
		sc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sc.setBounds(265, 200, 680, 441);
		contentPane.add(sc);

		sctable = new JTable();
		sctable.setBackground(new Color(255, 255, 255));
		sctable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		sctable.setModel(tmHome);

		sc.setViewportView(sctable);

		JLabel nicklabel = new JLabel(nick + "님");
		nicklabel.setForeground(new Color(0, 0, 0));
		nicklabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));

		nicklabel.setBounds(849, 111, 101, 33);
		contentPane.add(nicklabel);

	}

//	void selectTable() {
//		try {
//			String text = textField.getText();
//			list = dao.homeAll(text);
//			tmHome = new HomeTableModel(list);
//			sctable.setModel(list);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//	}

	// 검색 메소드
	void MainHomeselectTable() {
		int sel = comboBox_1.getSelectedIndex();
		String text = textField.getText();

		try {
			list = dao.homeSearch(sel, text);
			tmHome.data = list;
			sctable.setModel(tmHome);
			tmHome.fireTableDataChanged();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "검색에 실패하였습니다.", "검색실패", JOptionPane.WARNING_MESSAGE);
		}
	}
}

class HomeTableModel extends AbstractTableModel {

	ArrayList data = new ArrayList();
	String[] columnNames = { "식물 이름", "키우는 평균 시간", "난이도", "초기비용", "거래가", "예상수익률" };

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		ArrayList temp = (ArrayList) data.get(row);
		return temp.get(col);
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

}
