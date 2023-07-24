package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.GardenbookingDAO;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;

public class GardenbookingView extends JFrame {

	JPanel contentPane;
	JTable bookingtable;
	JComboBox<String> comboBox; // JComboBox 제네릭 타입 지정
	JScrollPane scrollPane;
	JPanel panel;

	// GardenbookingDAO 객체 선언
	GardenbookingDAO dao;

	// 예약 테이블 모델
	BookingTableModel bookingModel;
	static int pk;
	static String nick;
	static int point;

	final int MAX_CANCEL_COUNT = 3;
	final AtomicInteger cancelCount = new AtomicInteger(0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GardenbookingView frame = new GardenbookingView(pk, nick, point);
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
	public GardenbookingView(int pk, String nick, int point) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(GardenbookingView.class.getResource("/image/\uD638\uBBF8.png")));
		setTitle("\uD143\uBC2D\uC608\uC57D\uCDE8\uC18C");
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(196, 224, 135));

		comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int selectedIndex = comboBox.getSelectedIndex();
				if (selectedIndex == 0) {
					// 예약 내역 조회
					try {
						ArrayList<ArrayList<String>> data = dao.bookingSearch();
						bookingModel.setData(data);
						bookingModel.setColumnNames(new String[] { "텃밭명", "예약날짜", "시작일자", "종료일자", "총대여료" });
						bookingModel.fireTableStructureChanged();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					// bookingtable을 표시
					scrollPane.setViewportView(bookingtable);
					bookingtable.setVisible(true);
				}
			}
		});
		comboBox.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "텃밭예약" }));
		comboBox.setBounds(33, 69, 86, 40);
		contentPane.add(comboBox);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(33, 109, 562, 372);
		contentPane.add(scrollPane);

		bookingtable = new JTable();
		bookingtable.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(bookingtable);

		JLabel remainingCancelLabel;
		remainingCancelLabel = new JLabel();
		remainingCancelLabel.setFont(new Font("나눔고딕", Font.BOLD, 17));
		remainingCancelLabel.setBounds(379, 75, 135, 27);
		contentPane.add(remainingCancelLabel);
		remainingCancelLabel.setText("\uB0A8\uC740 \uCDE8\uC18C \uD69F\uC218 : 3");

		JButton searchButton = new JButton("검색");
		searchButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		searchButton.setForeground(new Color(0, 0, 0));
		searchButton.setBackground(new Color(255, 255, 255));
		searchButton.setBounds(528, 69, 67, 40);
		contentPane.add(searchButton);
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 예약 내역 검색
				try {
					ArrayList<ArrayList<String>> data = dao.bookingSearch();
					bookingModel.setData(data);
					bookingModel.setColumnNames(new String[] { "텃밭명", "예약날짜", "시작일자", "종료일자", "총대여료" });
					bookingModel.fireTableStructureChanged();
					// bookingtable을 표시
					scrollPane.setViewportView(bookingtable);
					bookingtable.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton btnNewButton = new JButton("예약취소");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton.setBounds(141, 501, 150, 70);
		contentPane.add(btnNewButton);
		// 예약취소 버튼 이벤트 핸들러 수정
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedIndex = bookingtable.convertRowIndexToModel(bookingtable.getSelectedRow());
				if (selectedIndex != -1) {
					// 선택된 내역이 있는 경우
					try {
						// 예약 취소 주의사항 표시
						String cautionMessage = "※ 주의 ※\n" + "예약 취소는 3회까지만 가능합니다.";
						JOptionPane.showMessageDialog(null, cautionMessage, "주의사항", JOptionPane.WARNING_MESSAGE);

						// 예약 취소 확인 메시지 표시
						int confirm = JOptionPane.showConfirmDialog(null, "예약을 취소하시겠습니까?", "예약 취소 확인",
								JOptionPane.YES_NO_OPTION);
						if (confirm == JOptionPane.YES_OPTION) {
							synchronized (cancelCount) {
								if (cancelCount.get() < MAX_CANCEL_COUNT) {
									dao.cancelBooking(selectedIndex);
									// 예약 내역 다시 조회
									ArrayList<ArrayList<String>> data = dao.bookingSearch();
									bookingModel.setData(data);
									bookingModel.fireTableDataChanged(); // 데이터 변경 알림 추가
									// 메시지 표시
									JOptionPane.showMessageDialog(null, "예약이 취소되었습니다.");
									cancelCount.incrementAndGet(); // 취소 횟수 증가
									remainingCancelLabel.setText("남은 취소 횟수: " + (MAX_CANCEL_COUNT - cancelCount.get()));
								} else {
									JOptionPane.showMessageDialog(null, "더 이상 취소할 수 없습니다.");
								}
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "예약 취소 중 오류가 발생했습니다.");
					}
				} else {
					// 선택된 내역이 없는 경우
					JOptionPane.showMessageDialog(null, "취소할 예약을 선택해주세요.");
				}
			}
		});

		JButton btnNewButton_1 = new JButton("종료");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 18));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dispose();
					GardenView garden = new GardenView(pk, nick, point);
					garden.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(346, 501, 150, 70);
		contentPane.add(btnNewButton_1);

		panel = new JPanel();
		panel.setBounds(32, 109, 546, 339);
		contentPane.add(panel);
		panel.setLayout(null);

		// GardenbookingDAO 객체 생성
		try {
			dao = new GardenbookingDAO();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "데이터베이스 연결에 실패했습니다.");
			e.printStackTrace();
		}
		// 예약 테이블 모델 초기화
		bookingModel = new BookingTableModel();
		bookingtable.setModel(bookingModel);

		// 초기 상태에서는 bookingtable을 표시
		scrollPane.setViewportView(bookingtable);
		bookingtable.setVisible(true);
	}

	// 예약 테이블 모델 클래스
	class BookingTableModel extends AbstractTableModel {
		private ArrayList<ArrayList<String>> data = new ArrayList<>();
		private String[] columnNames = { "텃밭명", "예약날짜", "시작일자", "종료일자", "총대여료" };

		public void setData(ArrayList<ArrayList<String>> data) {
			this.data = data;
			fireTableDataChanged(); // 데이터 변경 알림 추가
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			ArrayList<String> rowData = data.get(row);
			return rowData.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public void setColumnNames(String[] columnNames) {
			this.columnNames = columnNames;
		}
	}
}
