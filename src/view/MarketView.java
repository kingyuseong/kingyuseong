package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.MarketDAO;
import model.rec.MarketVO;
import java.awt.Color;

public class MarketView extends JFrame {

	JPanel contentPane;
	JTextField tfMarket;

	MarketTableModel tmMarket;

	JTextField tvMarketSearch;
	JComboBox cacombobox;

	JTextField tfMarketname, tfMarketprice, tfMarketcontent, tfMarketdate, tfMarketfinish;

	MarketDAO dao = null;
	MarketVO vo = null;

	ArrayList list;
	JTable mrtable;
	static int pk;
	static String nick;
	static int point;

	/**
	 * Launch the application.
	 */

	public MarketView(int pk, String nick, int point) {
		setTitle("\uC7A5\uD130");
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		newObject();
		addLayout();

		try {
			dao = new MarketDAO();
			System.out.println("비디오연결성공");
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "연결실패:" + e.getMessage());
			// TODO: handle exception
		}
	}

	void newObject() {
		String[] cacom = { "삽니다", "팝니다" };
		cacombobox = new JComboBox(cacom);

		tfMarketname = new JTextField(30);
		tfMarketprice = new JTextField(30);
		tfMarketcontent = new JTextField(30);
		tfMarketdate = new JTextField(30);
		tfMarketfinish = new JTextField(30);

		tfMarket = new JTextField(30);
		tmMarket = new MarketTableModel();
		mrtable = new JTable(tmMarket);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketView frame = new MarketView(pk, nick, point);

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

	void addLayout() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(MarketView.class.getResource("/image/\uD638\uBBF8.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 224, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 클릭시 메인화면 넘어가기
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainHomeView plantview = new MainHomeView(pk, nick, point);
				plantview.setVisible(true);

			}
		});
		btnNewButton.setIcon(new ImageIcon(MarketView.class.getResource("/image/\uB85C\uACE0\uAC80\uC815.png")));
		btnNewButton.setBounds(416, 42, 189, 118);
		contentPane.add(btnNewButton);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);

		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MyPageView mypageview = new MyPageView(pk, nick, point);
				mypageview.setVisible(true);
			}
		});
		btnNewButton_2_1
				.setIcon(new ImageIcon(MarketView.class.getResource("/image/\uB9C8\uC774\uD398\uC774\uC9C0.png")));
		btnNewButton_2_1.setBounds(778, 46, 84, 72);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.setOpaque(false);
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);

		JComboBox cacombo = new JComboBox();
		cacombo.setBackground(new Color(255, 255, 255));

		cacombo.setModel(new DefaultComboBoxModel(new String[] { "삽니다", "팝니다" }));
		cacombo.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		cacombo.setBounds(156, 181, 84, 45);
		contentPane.add(cacombo);

		// 텍스트 셀렉트
		tfMarket = new JTextField();
		tfMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cacombo.getSelectedIndex() == 0) {
					bmarketSearch();
				} else {
					smarketSearch();
				}
			}
		});
		tfMarket.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfMarket.setColumns(10);
		tfMarket.setBounds(257, 181, 279, 45);
		contentPane.add(tfMarket);

		JButton btnNewButton_8 = new JButton("검색");
		btnNewButton_8.setForeground(new Color(0, 0, 0));
		btnNewButton_8.setBackground(new Color(255, 255, 255));
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cacombo.getSelectedIndex() == 0) {
					bmarketSearch();
				} else {
					smarketSearch();
				}

			}
		});
		btnNewButton_8.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btnNewButton_8.setBounds(548, 181, 65, 45);
		contentPane.add(btnNewButton_8);

		JButton btnNewButton_1 = new JButton("나의 목록");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WriteView writeview = new WriteView(vo, pk, nick, point);
				writeview.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(502, 612, 150, 70);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("글쓰기");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				SWritingView Writingview = new SWritingView(pk, nick, point);
				Writingview.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(686, 612, 150, 70);
		contentPane.add(btnNewButton_1_1);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(156, 236, 680, 366);
		contentPane.add(scrollPane);

		mrtable = new JTable();
		mrtable.setBackground(new Color(255, 255, 255));
		mrtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cacombo.getSelectedIndex() == 1) {
					int col = 0;
					int row = mrtable.getSelectedRow();
					String smname = (String) mrtable.getValueAt(row, col);

					try {
						vo = dao.smgetInfo(smname);

						SmSangseView smsangseview = new SmSangseView(vo, pk, nick, point);
						smsangseview.setVisible(true);
					} catch (Exception e2) {
						JOptionPane.showConfirmDialog(null, "가져오기 실패: " + e2.getMessage());
						// TODO: handle exception
					}
					dispose();

				} else {
					int col = 0;
					int row = mrtable.getSelectedRow();
					String bmname = (String) mrtable.getValueAt(row, col);
					try {
						vo = dao.bmgetInfo(bmname);
						BmSangseView bmsangseview = new BmSangseView(vo, pk, nick, point);
						bmsangseview.setVisible(true);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					dispose();
				}
			}

		});

		mrtable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		mrtable.setModel(tmMarket);

		scrollPane.setViewportView(mrtable);

		JLabel lblNewLabel = new JLabel(nick + "님");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(778, 118, 97, 29);
		contentPane.add(lblNewLabel);

	}

	void smarketSearch() {
		int sel = cacombobox.getSelectedIndex();
		String text = tfMarket.getText();

		try {
			list = dao.smarketSearch(sel, text);

			tmMarket.data = list;
			mrtable.setModel(tmMarket);
			tmMarket.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "검색에 실패하였습니다.", "검색실패", JOptionPane.WARNING_MESSAGE);
		}
	}

	void bmarketSearch() {
		int sel = cacombobox.getSelectedIndex();
		String text = tfMarket.getText();

		try {
			list = dao.bmarketSearch(text);

			tmMarket.data = list;
			mrtable.setModel(tmMarket);
			tmMarket.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "검색에 실패하였습니다.", "검색실패", JOptionPane.WARNING_MESSAGE);
		}
	}

}

class MarketTableModel extends AbstractTableModel {

	ArrayList data = new ArrayList();
	String[] columnNames = { "제목", "금액", "내용", "작성자", "등록일", "판매여부" };

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
