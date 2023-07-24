package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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

import model.SellDAO;
import model.rec.SellVO;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class GoodsView extends JFrame {

	JPanel contentPane;
	ReviewTableModel tmReview;
	JTable reviewtable;
	JTextField tfGname, tfGprice, tfGcontent, tfCcount;
	JButton bReviewgo, bBack, bCartin;
	JLabel lbGimage;

	SellDAO dao;
	SellVO vo;
	ArrayList list = null;
	static int pk;
	static String nick;
	static int point;

	public GoodsView(SellVO vo, int pk, String nick, int point) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GoodsView.class.getResource("/image/\uD638\uBBF8.png")));
		setTitle("\uC0C1\uD488\uC0C1\uC138\uC815\uBCF4");
		this.pk = pk;
		this.nick = nick;
		this.point = point;
		this.vo = vo;

		try {
			System.out.println("상품상세 디비 연결 성공");
			dao = new SellDAO();
			reviewtable = new JTable();
			reviewTable();

			// list 초기화
			list = dao.reviewAll();

//            //tmReview 초기화
			tmReview = new ReviewTableModel(list);
			reviewtable.setModel(tmReview);

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

		// 상품명
		JLabel Label_1 = new JLabel("상품명 : ");
		Label_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		Label_1.setBounds(64, 70, 95, 32);
		contentPane.add(Label_1);

		tfGname = new JTextField();
		tfGname.setHorizontalAlignment(SwingConstants.CENTER);
		tfGname.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfGname.setEditable(false);
		tfGname.setBounds(138, 68, 207, 41);
		contentPane.add(tfGname);
		tfGname.setColumns(10);
		tfGname.setOpaque(false);
		tfGname.setBorder(null);
		tfGname.setBorder(new LineBorder(Color.BLACK));
		tfGname.setText(vo.getGname()); // gname가져오기

		// 이미지
		JLabel lbGimage = new JLabel();
		lbGimage.setBounds(64, 119, 250, 300);
		contentPane.add(lbGimage);
//      lbGimage.setText(vo.getGimage());

		String imagePath = vo.getGimage();
		ImageIcon imageIcon = new ImageIcon(imagePath);
		lbGimage.setIcon(imageIcon);

		// 판매가
		JLabel Label_3 = new JLabel("\uD310 \uB9E4 \uAC00 : ");
		Label_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		Label_3.setBounds(443, 71, 191, 32);
		contentPane.add(Label_3);

		tfGprice = new JTextField();
		tfGprice.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfGprice.setEditable(false);
		tfGprice.setColumns(10);
		tfGprice.setBounds(524, 67, 87, 41);
		tfGprice.setOpaque(false);
		tfGprice.setBorder(null);
		contentPane.add(tfGprice);
		tfGprice.setText(vo.getGprice()); // gprice가져오기

		// 구매수량
		JLabel lblNewLabel = new JLabel("\uAD6C\uB9E4\uC218\uB7C9 :            \uAC1C");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		lblNewLabel.setBounds(443, 119, 168, 31);
		contentPane.add(lblNewLabel);

		tfCcount = new JTextField();
		tfCcount.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfCcount.setHorizontalAlignment(SwingConstants.RIGHT);
		tfCcount.setBounds(529, 115, 47, 37);
		contentPane.add(tfCcount);
		tfCcount.setText("1"); // 기본값 설정
		tfCcount.setColumns(10);
		

		// 상품설명
		JLabel Label_2 = new JLabel("상품설명");
		Label_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		Label_2.setBounds(64, 417, 95, 32);
		contentPane.add(Label_2);

		tfGcontent = new JTextField();
		tfGcontent.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		tfGcontent.setEditable(false);
		tfGcontent.setColumns(10);
		tfGcontent.setBounds(64, 459, 343, 124);
		contentPane.add(tfGcontent);
		tfGcontent.setText(vo.getGcontent()); // gcontect가져오기

		// 장바구니담기 버튼
		JButton bCartin = new JButton("장바구니담기");
		bCartin.setForeground(new Color(255, 255, 255));
		bCartin.setBackground(new Color(0, 0, 0));
		bCartin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String ccount = tfCcount.getText();
					int membercode = pk;
					String gname = tfGname.getText(); // 상품명 가져오기
					vo.setCcount(ccount);
					vo.setMembercode(membercode);
					int goodscode = dao.getGoodsCodeByGname(gname); // 상품명으로 상품 코드 가져오기
					dao.cartAdd(vo, goodscode);
					JOptionPane.showMessageDialog(null, "장바구니에 " + gname + " 상품" + ccount + " 개가 담겼습니다.", "담기성공",
							JOptionPane.PLAIN_MESSAGE);
					dispose();
					SellView sell = new SellView(pk, nick, point);
					sell.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		bCartin.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		bCartin.setBounds(458, 191, 150, 70);
		contentPane.add(bCartin);

		JButton bCartgo = new JButton("장바구니가기");
		bCartgo.setForeground(new Color(255, 255, 255));
		bCartgo.setBackground(new Color(0, 0, 0));
		bCartgo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CartView cart = new CartView(pk, nick, point);
				cart.setVisible(true);
			}
		});
		bCartgo.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		bCartgo.setBounds(458, 281, 150, 70);
		contentPane.add(bCartgo);

		// 쇼핑계속하기 버튼
		JButton bBack = new JButton("쇼핑계속하기");
		bBack.setForeground(new Color(255, 255, 255));
		bBack.setBackground(new Color(0, 0, 0));
		bBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				SellView sell = new SellView(pk, nick, point);
				sell.setVisible(true);
			}
		});
		bBack.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		bBack.setBounds(458, 379, 150, 70);
		contentPane.add(bBack);

		// 후기보러가기 버튼
		JButton bReviewgo = new JButton("후기보러가기");
		bReviewgo.setForeground(new Color(255, 255, 255));
		bReviewgo.setBackground(new Color(0, 0, 0));
		bReviewgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReviewView review = new ReviewView(pk, nick, point);
				review.setVisible(true);

			}
		});
		bReviewgo.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		bReviewgo.setBounds(458, 472, 150, 70);
		contentPane.add(bReviewgo);

	}

	void reviewTable() {
		try {
			tmReview = new ReviewTableModel(list);
			reviewtable.setModel(tmReview);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "검색에 실패하였습니다.", "검색실패", JOptionPane.WARNING_MESSAGE);
		}
	}

	class ReviewTableModel extends AbstractTableModel {

		ArrayList data;
		String[] columnNames = { "상품명", "별점", "내용", "작성일" };

		public ReviewTableModel(ArrayList data) {
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
	}
}