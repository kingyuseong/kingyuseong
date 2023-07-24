package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.SellDAO;
import model.rec.SellVO;
import javax.swing.ImageIcon;

public class SellView extends JFrame implements ActionListener {
	JTable goodstable;
	JButton bCartin, bCartgo, bMypage, bGohome;
	JTextField tfSearch;
	JComboBox combox;
	JScrollPane Goodspane;

	SellDAO dao = null;
	SellVO vo = null;
	GoodsTableModel tmGoods;
	ArrayList list;
	static int pk;
	static String nick;
	static int point;

	public SellView(int pk, String nick, int point) {
		setTitle("\uC1FC\uD551");
		try {
			System.out.println("상품 디비 연결 성공");
			dao = new SellDAO();
			goodstable = new JTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "상품 디비 연결 실패 : " + e.getMessage());
		}

		// list 초기화
		list = new ArrayList();

		// tmGoods 초기화
		tmGoods = new GoodsTableModel(list);
		goodstable.setModel(tmGoods);
		tfSearch = new JTextField("");

		setIconImage(Toolkit.getDefaultToolkit().getImage(SellView.class.getResource("/image/\uD638\uBBF8.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(196, 224, 135));
		getContentPane().setLayout(null);

		JScrollPane Goodspane = new JScrollPane();
		Goodspane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Goodspane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Goodspane.setBounds(242, 153, 680, 500);

		getContentPane().add(Goodspane);

		goodstable = new JTable();
		goodstable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		goodstable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "카테고리", "상품명", "가격" }));
		Goodspane.setViewportView(goodstable);
		goodstable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				int col = 1;
				int row = goodstable.getSelectedRow();
				String gname = (String) goodstable.getValueAt(row, col);

				try {
					vo = dao.getInfo(gname);
					GoodsView goods = new GoodsView(vo, pk, nick, point);
					goods.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "가져오기 실패: " + e2.getMessage());
				}
			}
		});

		JButton bMypage = new JButton("");
		bMypage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MyPageView mypage = new MyPageView(pk, nick, point);
				mypage.setVisible(true);
			}
		});
		bMypage.setBounds(823, 37, 99, 99);
		bMypage.setOpaque(false);
		bMypage.setContentAreaFilled(false);
		bMypage.setBorderPainted(false);

		bMypage.setIcon(new ImageIcon(SellView.class.getResource("/image/\uB9C8\uC774\uD398\uC774\uC9C0.png")));
		getContentPane().add(bMypage);
		
		JLabel nicklabel = new JLabel(nick + "님");
		nicklabel.setForeground(new Color(0, 0, 0));
		nicklabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));

		nicklabel.setBounds(831, 110, 101, 33);
		getContentPane().add(nicklabel);
		
		

		JButton bGohome = new JButton("");
		bGohome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainHomeView home = new MainHomeView(pk, nick, point);
				home.setVisible(true);
			}
		});
		bGohome.setBounds(377, 10, 254, 118);
		bGohome.setOpaque(false);
		bGohome.setContentAreaFilled(false);
		bGohome.setBorderPainted(false);

		bGohome.setIcon(new ImageIcon(SellView.class.getResource("/image/\uB85C\uACE0\uAC80\uC815.png")));
		getContentPane().add(bGohome);
		selectTable();

		JButton bCartgo = new JButton("장바구니 가기");
		bCartgo.setBackground(new Color(0, 0, 0));
		bCartgo.setForeground(new Color(255, 255, 255));
		bCartgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CartView cart = new CartView(pk, nick, point);
				cart.setVisible(true);
				goodstable.getModel();

			}
		});
		bCartgo.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		bCartgo.setBounds(46, 494, 162, 79);
		getContentPane().add(bCartgo);

		JLabel lblNewLabel_1 = new JLabel("상품 카테고리");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(67, 179, 137, 25);
		getContentPane().add(lblNewLabel_1);

		combox = new JComboBox();
		combox.setBackground(new Color(255, 255, 255));
		combox.setModel(new DefaultComboBoxModel(new String[] { "전체", "씨앗", "비료", "영양제", "재배용품" }));
		combox.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		combox.setBounds(46, 214, 162, 47);
		getContentPane().add(combox);

		JLabel lblNewLabel = new JLabel("상품검색");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		lblNewLabel.setBounds(89, 277, 99, 32);
		getContentPane().add(lblNewLabel);

		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(46, 319, 162, 47);
		getContentPane().add(tfSearch);

		JButton bSearch = new JButton("검색");
		bSearch.setForeground(new Color(0, 0, 0));
		bSearch.setBackground(Color.WHITE);
		bSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedCategory = combox.getSelectedItem().toString();
				String text = tfSearch.getText();
				try {
					ArrayList<SellVO> filteredList = null;
					if (selectedCategory.equals("전체")) {
						filteredList = dao.goodsAllSearch(text);
						tmGoods.fireTableDataChanged();
					} else {
						filteredList = dao.goodsByCategorySearch(selectedCategory, text);
						tmGoods.fireTableDataChanged();
					}
					tmGoods.data = filteredList;
					tmGoods.fireTableDataChanged();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "검색에 실패하였습니다.", "검색실패", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		bSearch.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		bSearch.setBounds(78, 388, 100, 35);
		getContentPane().add(bSearch);

	}

	void eventProc() {
		tfSearch.addActionListener(this);
		combox.addActionListener(this);
		bCartin.addActionListener(this);
	}

	void selectTable() {
		try {
			String text = tfSearch.getText();
			list = dao.goodsAllSearch(text);
			tmGoods = new GoodsTableModel(list);
			goodstable.setModel(tmGoods);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "검색에 실패하였습니다.", "검색실패", JOptionPane.WARNING_MESSAGE);
		}

	}

	class GoodsTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "카테고리", "상품명", "상품가격" };

		public GoodsTableModel(ArrayList data) {
			this.data = data;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}