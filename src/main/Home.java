package main;

import javax.swing.JFrame;

import view.LoginView;
import view.MainHomeView;
import view.MarketView;
import view.SWritingView;

public class Home extends JFrame {
	MainHomeView plant;
	MarketView market;
	SWritingView vplant;

	public Home() {

		LoginView login = new LoginView();
		login.setVisible(true);

	}

	public static void main(String[] args) {
		new Home();
	}

}
