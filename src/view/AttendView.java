package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import model.AttendDAO;
import model.CustomerDAO;
import model.rec.AttendVO;
import model.rec.CustomerVO;

public class AttendView extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JPasswordField passwordField;

	private JButton attendanceButton;
	private JLabel statusLabel;
	private JCalendar calendar;

	private int attendanceCount;
	private LocalDate lastCheckedDate;
	private JButton btnmypageback;

	CustomerDAO dao;
	CustomerVO vo;
	AttendDAO adao;
	AttendVO avo;

	ArrayList list;

	static int pk;
	static String nick;
	static int point;

	private boolean isAttendanceChecked;

	AttendView(int pk, String nick, int point) {
		this.pk = pk;
		this.nick = nick;
		this.point = point;

		setIconImage(Toolkit.getDefaultToolkit().getImage(AttendView.class.getResource("/image/\uD638\uBBF8.png")));
		attendanceCount = 0;
		lastCheckedDate = LocalDate.now(ZoneId.of("Asia/Seoul"));

		attendanceButton = new JButton("출석체크");
		attendanceButton.setForeground(new Color(255, 255, 255));
		attendanceButton.setBackground(new Color(0, 0, 0));
		attendanceButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		attendanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttendVO avo = new AttendVO();
				CustomerVO vo = new CustomerVO();

				String att = attendanceButton.getToolTipText();

				avo.setApoint(point);

				// vo.setPoint(btnmypageback.getIconTextGap());

				LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
				LocalDate currentDate = currentDateTime.toLocalDate();
				LocalDate selectedDate = LocalDate.of(calendar.getYearChooser().getYear(),
						calendar.getMonthChooser().getMonth() + 1, calendar.getDayChooser().getDay());
				if (selectedDate.equals(currentDate)) {
					if (currentDateTime.getHour() >= 0 && currentDateTime.getHour() < 24) {
						if (!isAttendanceChecked) {
							try {

								dao = new CustomerDAO();
								adao = new AttendDAO();

								int earnedPoint = generateRandomPoint(); // 랜덤 포인트 생성
								avo.setApoint(earnedPoint);
								int membercode = pk;

								avo.setMembercode(pk);
								adao.attcheck(avo);
								JOptionPane.showMessageDialog(null, "출석이 완료되었습니다. 포인트 " + earnedPoint + "앗을 획득하셨습니다.",
										"알림", JOptionPane.PLAIN_MESSAGE);

								attendanceCount++;
								statusLabel.setText("출석 완료! 출석 횟수: " + attendanceCount);
								markCheckedDate(currentDate);
								lastCheckedDate = currentDate; // 출석체크한 날짜 갱신
								isAttendanceChecked = true;

								int totalPoint = vo.getPoint() + earnedPoint;
								vo.setPoint(totalPoint);

								adao.updateInfo(avo);

							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} else {
							JOptionPane.showMessageDialog(null, "이미 출석체크를 하셨습니다.", "알림",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "출석체크 가능한 시간이 아닙니다.", "알림",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "오늘 날짜만 출석체크 가능합니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		statusLabel = new JLabel("\t\t\t\t\t\t\t\t출석 횟수: 0");
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));

		calendar = new JCalendar();
		calendar.getDayChooser().setDay(0);
		calendar.getDayChooser().setDecorationBackgroundColor(new Color(255, 255, 255));
		calendar.getDayChooser().setAlwaysFireDayProperty(true);
		calendar.getDayChooser().getDayPanel().setBackground(new Color(255, 255, 255));
		calendar.getMonthChooser().getComboBox().setFont(new Font("나눔고딕", Font.PLAIN, 15));
		calendar.getYearChooser().getSpinner().setFont(new Font("나눔고딕", Font.PLAIN, 15));
		calendar.setPreferredSize(new Dimension(500, 500)); // 달력 크기 조정
		calendar.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent e) {
				if ("day".equals(e.getPropertyName())) {
					LocalDate selectedDate = LocalDate.of(calendar.getYearChooser().getYear(),
							calendar.getMonthChooser().getMonth() + 1, (int) e.getNewValue());
					LocalDateTime selectedDateTime = LocalDateTime.of(selectedDate,
							LocalTime.now(ZoneId.of("Asia/Seoul")));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					if (selectedDateTime.isBefore(LocalDateTime.now(ZoneId.of("Asia/Seoul")))) {
						JOptionPane.showMessageDialog(null, "이전 날짜는 선택할 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
						calendar.getDayChooser().setDay(lastCheckedDate.getDayOfMonth());
					} else if (selectedDateTime.isAfter(LocalDateTime.now(ZoneId.of("Asia/Seoul")))) {
						JOptionPane.showMessageDialog(null, "선택한 날짜로 출석체크를 할 수 없습니다.", "알림",
								JOptionPane.INFORMATION_MESSAGE);
						calendar.getDayChooser().setDay(lastCheckedDate.getDayOfMonth());
					}
				}
			}
		});

		markCheckedDate(lastCheckedDate); // 이미 출석체크한 날짜에 동그라미 표시

		JPanel contentPane = (JPanel) getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(attendanceButton, BorderLayout.NORTH);

		btnmypageback = new JButton("마이페이지");
		btnmypageback.setForeground(new Color(0, 0, 0));
		btnmypageback.setBackground(new Color(255, 255, 255));
		btnmypageback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnmypageback.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btnmypageback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MyPageView MyPageView = new MyPageView(pk, nick, point);
				MyPageView.setVisible(true);

			}
		});

		JButton additionalButton = new JButton("홈");
		additionalButton.setForeground(new Color(0, 0, 0));
		additionalButton.setBackground(new Color(255, 255, 255));
		additionalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		additionalButton.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		additionalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼 클릭 이벤트 처리
				dispose();
				MainHomeView MainHomeView = new MainHomeView(pk, nick, point);
				MainHomeView.setVisible(true);
			}
		});

		contentPane.add(additionalButton, BorderLayout.WEST);

		getContentPane().add(btnmypageback, BorderLayout.EAST);
		contentPane.add(statusLabel, BorderLayout.CENTER);
		contentPane.add(calendar, BorderLayout.SOUTH);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\uCD9C\uC11D\uCCB4\uD06C");
		pack();
		setLocationRelativeTo(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void markCheckedDate(LocalDate date) {
		JDayChooser dayChooser = calendar.getDayChooser();
		YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonthValue());
		int daysInMonth = yearMonth.lengthOfMonth();
		for (int i = 1; i <= daysInMonth; i++) {
			if (i == date.getDayOfMonth()) {
				dayChooser.setDay(i);
				break;
			}
		}
	}

	private int generateRandomPoint() {
		Random rand = new Random();
		int earnedPoint = rand.nextInt(11) + 10; // 10~20 사이의 랜덤 포인트 생성
		return earnedPoint;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendView frame = new AttendView(pk, nick, point);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
