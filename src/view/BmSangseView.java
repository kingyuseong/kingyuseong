package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import model.MarketDAO;
import model.rec.MarketVO;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class BmSangseView extends JFrame {

	JPanel contentPane;
//	ReviewTableModel tmReview;
	JTable reviewtable;
	JTextField tfGname, tfGprice, tfGcontent;
	JButton bReviewgo, bBack, bCartin;
	JLabel lbGimage;

	MarketDAO dao;
	MarketVO vo;
	ArrayList list = null;
	static int pk;
	static String nick;
	static int point;

	public BmSangseView(MarketVO vo, int pk, String nick, int point) {
		setTitle("\uD310\uB9E4\uAE00 \uC0C1\uC138\uC815\uBCF4");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BmSangseView.class.getResource("/image/\uD638\uBBF8.png")));
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.vo = vo;

		try {
			System.out.println("상품상세 디비 연결 성공");
			dao = new MarketDAO();
			reviewtable = new JTable();
//			reviewTable();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "상품상세 디비 연결 실패 : " + e.getMessage());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 224, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton bReviewgo = new JButton("뒤로가기");
		bReviewgo.setBackground(new Color(0, 0, 0));
		bReviewgo.setForeground(new Color(255, 255, 255));
		bReviewgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarketView marketview = new MarketView(pk, nick, point);
				marketview.setVisible(true);
				dispose();
			}
		});
		bReviewgo.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		bReviewgo.setBounds(430, 469, 150, 70);
		contentPane.add(bReviewgo);

		JLabel Label_1 = new JLabel("상품명 : ");
		Label_1.setForeground(new Color(0, 0, 0));
		Label_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		Label_1.setBounds(64, 70, 95, 32);
		contentPane.add(Label_1);

		tfGname = new JTextField();
		tfGname.setHorizontalAlignment(SwingConstants.CENTER);
		tfGname.setForeground(new Color(0, 0, 0));
		tfGname.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfGname.setEditable(false);
		tfGname.setOpaque(false);
		tfGname.setBorder(new LineBorder(Color.BLACK));
		tfGname.setBounds(138, 68, 207, 41);
		contentPane.add(tfGname);
		tfGname.setColumns(10);
		tfGname.setText(vo.getBmname());

		tfGprice = new JTextField();
		tfGprice.setHorizontalAlignment(SwingConstants.CENTER);
		tfGprice.setForeground(new Color(0, 0, 0));
		tfGprice.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfGprice.setEditable(false);
		tfGprice.setOpaque(false);
		tfGprice.setBorder(null);

		tfGprice.setBounds(138, 453, 108, 41);
		contentPane.add(tfGprice);
		tfGprice.setText(vo.getBmprice());

		JLabel Label_2 = new JLabel("상품설명");
		Label_2.setForeground(new Color(0, 0, 0));
		Label_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		Label_2.setBounds(64, 153, 95, 32);
		contentPane.add(Label_2);

		tfGcontent = new JTextField();
		tfGcontent.setForeground(new Color(0, 0, 0));
		tfGcontent.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfGcontent.setEditable(false);
		tfGcontent.setOpaque(false);
		tfGcontent.setBorder(null);
		tfGcontent.setColumns(10);
		tfGcontent.setBounds(64, 183, 212, 209);
		contentPane.add(tfGcontent);
		tfGcontent.setText(vo.getBmcontent());

		JLabel Label_3 = new JLabel("\uD310\uB9E4\uAC00 :");
		Label_3.setForeground(new Color(0, 0, 0));
		Label_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		Label_3.setBounds(65, 456, 229, 32);
		contentPane.add(Label_3);
	}

}