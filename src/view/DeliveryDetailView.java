package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DeliveryDAO;
import model.rec.DeliveryVO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class DeliveryDetailView extends JFrame {

	JPanel deliveryDetail;
	JTable deliveryDetailtable;
	JTable deliveryDetailtable2;
	DeliveryVO dvo;
	DeliveryDAO ddao;
	MyPageView mview;
	static String orderNo;
	ArrayList list;
	ArrayList row;
	static int pk;
	static String nick;
	static int point;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryVO dvo = new DeliveryVO();
					DeliveryDetailView frame = new DeliveryDetailView(dvo, orderNo, pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeliveryDetailView(DeliveryVO dvo, String orderNo, int pk, String nick, int point) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(DeliveryDetailView.class.getResource("/image/\uD638\uBBF8.png")));
		setTitle("\uBC30\uC1A1\uC0C1\uD0DC\uC870\uD68C");
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.dvo = dvo;
		this.orderNo = orderNo;
		this.ddao = ddao;
		addLayout();

		try {
			ddao = new DeliveryDAO();
			System.out.println("DB 연결 성공!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB 연결 실패 : " + e.getMessage());
		}

	}

	// layout
	public void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);
		deliveryDetail = new JPanel();
		deliveryDetail.setBorder(new EmptyBorder(10, 10, 10, 10));
		deliveryDetail.setBackground(new Color(196, 224, 135));

		setContentPane(deliveryDetail);
		deliveryDetail.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(CardAddView.class.getResource("")));
		logo.setBounds(192, 43, 50, 36);
		deliveryDetail.add(logo);

		JButton canclebtnNewButton = new JButton("닫기");
		canclebtnNewButton.setForeground(new Color(255, 255, 255));
		canclebtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeliveryDetailView deliveryDetail = new DeliveryDetailView(dvo, orderNo, pk, nick, point);
				deliveryDetail.setVisible(false);
			}
		});
		canclebtnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		canclebtnNewButton.setBackground(new Color(0, 0, 0));
		canclebtnNewButton.setBounds(243, 490, 150, 70);
		deliveryDetail.add(canclebtnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 89, 515, 367);
		deliveryDetail.add(scrollPane);

		deliveryDetailtable2 = new JTable();
		deliveryDetailtable2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		deliveryDetailtable2
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "배송업체명", "배송기사명", "기사연락처" }));

		scrollPane.setViewportView(deliveryDetailtable2);
		try {
			try {
				ddao = new DeliveryDAO();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// DeliveryDAO의 deliveryDetail() 메서드 호출하여 데이터 가져오기
			ArrayList<ArrayList<String>> list = ddao.deliveryDetail(orderNo);

			// 가져온 데이터를 JTable에 추가하기
			DefaultTableModel tableModel = (DefaultTableModel) deliveryDetailtable2.getModel();
			for (ArrayList<String> row : list) {
				Object[] rowData = row.toArray();
				tableModel.addRow(rowData);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}
}
