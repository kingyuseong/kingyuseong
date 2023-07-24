package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.SellDAO;
import model.rec.SellVO;
import javax.swing.SwingConstants;

public class CartView extends JFrame {

	JPanel contentPane;
	JTable cartTable;
	JTable listtable;
	SellDAO dao = null;
	SellVO vo = null;
	CartTableModel tmCart;
	ArrayList list = null;
	static int pk;
	static String nick;
	static int point;
	private JTextField tfPrice;

	public CartView(int pk, String nick, int point) {
		setTitle("\uC7A5\uBC14\uAD6C\uB2C8");
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		newObject();
		addLayout(pk);
		try {
			dao = new SellDAO();
			listtable = new JTable();
			System.out.println("장바구니 디비 연결 성공");
			cartTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "장바구니 디비 연결 실패 : " + e.getMessage());
		}
	}

	void newObject() {
		tmCart = new CartTableModel();
		listtable = new JTable(tmCart);
	}

	void addLayout(int pk) {

		setIconImage(Toolkit.getDefaultToolkit().getImage(CartView.class.getResource("/image/\uD638\uBBF8.png")));
		setBackground(new Color(255, 255, 255));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(196, 224, 135));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseMotionListener(new MouseMotionAdapter() {
		});

		scrollPane.setBounds(91, 107, 472, 303);
		contentPane.add(scrollPane);
		listtable = new JTable();
		listtable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		listtable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "상품명", "수량", "상품가격" }));
		scrollPane.setViewportView(listtable);

		JButton bCartdel = new JButton("장바구니 비우기");
		bCartdel.setForeground(new Color(255, 255, 255));
		bCartdel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dao.cartDelete(pk);
					JOptionPane.showMessageDialog(null, "장바구니가 비워졌습니다.", "장바구니 비우기 성공", JOptionPane.PLAIN_MESSAGE);
					SellView sell = new SellView(pk, nick, point);
					sell.setVisible(true);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "장바구니가 비워지지 않았습니다.", "장바구니 비우기 실패",
							JOptionPane.WARNING_MESSAGE);
				}
				cartTable();
				dispose();
			}
		});

		bCartdel.setBounds(89, 477, 150, 70);
		bCartdel.setBackground(new Color(0, 0, 0));
		bCartdel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 16));
		contentPane.add(bCartdel);

		JLabel Label_1 = new JLabel("장바구니 목록");
		Label_1.setBounds(91, 58, 245, 39);
		Label_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(Label_1);

		JButton bBack = new JButton("쇼핑 계속하기");
		bBack.setForeground(new Color(255, 255, 255));
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SellView sell = new SellView(pk, nick, point);
				sell.setVisible(true);
			}
		});
		bBack.setBounds(413, 477, 150, 70);
		bBack.setBackground(new Color(0, 0, 0));
		bBack.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(bBack);

		JButton bBuy = new JButton("구매하기");
		bBuy.setForeground(new Color(255, 255, 255));
		bBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyCardView mycard = new MyCardView(pk, nick, point);
				mycard.setVisible(true);
			}
		});
		bBuy.setBounds(251, 477, 150, 70);
		bBuy.setBackground(new Color(0, 0, 0));
		bBuy.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		contentPane.add(bBuy);
		tmCart = new CartTableModel();
		listtable.setModel(tmCart);

		JLabel Label_2 = new JLabel("총계 : ");
		Label_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		Label_2.setBounds(391, 411, 64, 39);
		contentPane.add(Label_2);

		tfPrice = new JTextField();
		tfPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPrice.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfPrice.setEditable(false);
		tfPrice.setBounds(439, 411, 119, 38);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		tfPrice.setOpaque(false);
		tfPrice.setBorder(null);

	}

	void cartTable() {
		try {
			ArrayList<SellVO> cart = dao.cartMain(pk);
			tmCart.data = cart;
			listtable.setModel(tmCart);
			tmCart.fireTableDataChanged();

			int totalPrice = 0; // 총 가격을 저장할 변수 초기화

			// 각 상품의 가격을 더해 총 가격 계산
			for (SellVO vo : cart) {
				totalPrice += Integer.parseInt(vo.getGprice());
			}

			// 총 가격을 tfPrice 텍스트 필드에 표시
			tfPrice.setText(String.valueOf(totalPrice));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "장바구니 불러오기 실패: " + e.getMessage());
		}
	}

	class CartTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "상품명", "수량", "상품가격" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public void removeRow(int i) {
			data.remove(i);
			fireTableRowsDeleted(i, i);
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			SellVO vo = (SellVO) data.get(row);
			if (col == 0) {
				return vo.getGname();
			} else if (col == 1) {
				return vo.getCcount();
			} else if (col == 2) {
				return vo.getGprice();
			}
			return null;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}
}