package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.MarketDAO;
import model.rec.MarketVO;
import oracle.net.aso.f;
import java.awt.Toolkit;

public class WriteView extends JFrame {

	JPanel contentPane;
	WriteTableModel tmWrite;
	JTable mylisttable;

	static int pk;
	static String nick;
	static int point;
	JComboBox wrcomboBox;
	static MarketVO vo;
	MarketDAO dao;
	ArrayList list;

	/**
	 * Launch the application.
	 */
	public WriteView(MarketVO vo, int pk, String nick, int point) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WriteView.class.getResource("/image/\uD638\uBBF8.png")));
		setTitle("\uC7A5\uD130\uAE00\uBAA9\uB85D");
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.vo = vo;

		newObject();
		addLayout();

		try {
			dao = new MarketDAO();
			System.out.println("연결성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, "연결실패:" + e.getMessage());
		}

	}

	void newObject() {
		String[] wrcomb = { "판매", "구매" };
		wrcomboBox = new JComboBox(wrcomb);

		tmWrite = new WriteTableModel();
		mylisttable = new JTable(tmWrite);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriteView frame = new WriteView(vo, pk, nick, point);
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
	 * @return
	 */
	void addLayout() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 224, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("돌아가기");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();

			}

		});
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton.setBounds(363, 484, 150, 70);
		contentPane.add(btnNewButton);
		JComboBox wrcomboBox = new JComboBox();
		wrcomboBox.setBackground(Color.WHITE);

		wrcomboBox.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		wrcomboBox.setModel(new DefaultComboBoxModel(new String[] { "판매", "구매" }));
		wrcomboBox.setBounds(61, 55, 58, 35);
		contentPane.add(wrcomboBox);
		JButton updatebtn = new JButton("수정하기");
		updatebtn.setForeground(new Color(255, 255, 255));
		updatebtn.setBackground(new Color(0, 0, 0));
		updatebtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = e.getSource();
				if (o == updatebtn) {
					int col = 0;
					int row = mylisttable.getSelectedRow();

					try {
						if (wrcomboBox.getSelectedIndex() == 0) {
							String smname = String.valueOf(mylisttable.getValueAt(row, col));
							vo = dao.smupInfo(smname);
							SmEditView smeditview = new SmEditView(vo, pk, nick, point);
							smeditview.setVisible(true);
						} else if (wrcomboBox.getSelectedIndex() == 1) {
							String bmname = String.valueOf(mylisttable.getValueAt(row, col));
							vo = dao.bmupInfo(bmname);
							BmEditView bmeditview = new BmEditView(vo, pk, nick, point);
							bmeditview.setVisible(true);
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}

				}
			}
		});
		updatebtn.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		updatebtn.setBounds(135, 484, 150, 70);
		contentPane.add(updatebtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(61, 100, 522, 348);
		contentPane.add(scrollPane);

		mylisttable = new JTable();
		mylisttable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
//   
		mylisttable.setModel(tmWrite);
		scrollPane.setViewportView(mylisttable);

		JButton sebtn = new JButton("검색");
		sebtn.setForeground(new Color(0, 0, 0));
		sebtn.setBackground(new Color(255, 255, 255));
		sebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (wrcomboBox.getSelectedIndex() == 0) {
					smselectTable();
				} else {
					bmselectTable();
				}

			}
		});
		sebtn.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		sebtn.setBounds(128, 55, 100, 35);
		contentPane.add(sebtn);
	}

	void smselectTable() {
		int sel = wrcomboBox.getSelectedIndex();
		int code = pk;
		try {
			list = dao.listSelect(sel, code);
			tmWrite.data = list;

			mylisttable.setModel(tmWrite);
			tmWrite.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void bmselectTable() {
		int sel = wrcomboBox.getSelectedIndex();
		int code = pk;
		try {
			list = dao.marketSelect(sel, code);
			tmWrite.data = list;

			mylisttable.setModel(tmWrite);
			tmWrite.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class WriteTableModel extends AbstractTableModel {

	ArrayList data = new ArrayList();
	String[] columnNames = { "제목", "내용", "금액", "게시일" };

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