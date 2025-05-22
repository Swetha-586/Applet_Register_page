import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/* <applet code="Registerex.class" width=500 height=500></applet> */
public class Registerex extends Applet implements ActionListener {
    TextField t1, t2, t3, t4; 
    TextField t5, t6; 
    Button b1, b2, b3, b4, b5;
    Label loginStatus;

    String screen = "register";
    String fullName = "", username = "", password = "", email = "";

    public void init() {
        setLayout(null);
        showRegisterPage();
    }

    void showRegisterPage() {
        removeAll();
        Label l1 = new Label("User Registration");
        l1.setBounds(180, 20, 150, 20);
        add(l1);

        Label l2 = new Label("Full name:");
        l2.setBounds(100, 60, 100, 20);
        add(l2);
        t1 = new TextField();
        t1.setBounds(200, 60, 150, 20);
        add(t1);

        Label l3 = new Label("Username:");
        l3.setBounds(100, 90, 100, 20);
        add(l3);
        t2 = new TextField();
        t2.setBounds(200, 90, 150, 20);
        add(t2);

        Label l4 = new Label("Password:");
        l4.setBounds(100, 120, 100, 20);
        add(l4);
        t3 = new TextField();
        t3.setEchoChar('*');
        t3.setBounds(200, 120, 150, 20);
        add(t3);

        Label l5 = new Label("Email:");
        l5.setBounds(100, 150, 100, 20);
        add(l5);
        t4 = new TextField();
        t4.setBounds(200, 150, 150, 20);
        add(t4);

        b1 = new Button("Register");
        b1.setBounds(150, 200, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new Button("Go to Login");
        b2.setBounds(260, 200, 100, 30);
        b2.addActionListener(this);
        add(b2);

        screen = "register";
        repaint();
    }

    void showLoginPage() {
        removeAll();
        Label l6 = new Label("User Login");
        l6.setBounds(200, 40, 100, 20);
        add(l6);

        Label l7 = new Label("Username:");
        l7.setBounds(100, 80, 100, 20);
        add(l7);
        t5 = new TextField();
        t5.setBounds(200, 80, 150, 20);
        add(t5);

        Label l8 = new Label("Password:");
        l8.setBounds(100, 110, 100, 20);
        add(l8);
        t6 = new TextField();
        t6.setEchoChar('*');
        t6.setBounds(200, 110, 150, 20);
        add(t6);

        b3 = new Button("Login");
        b3.setBounds(150, 160, 80, 30);
        b3.addActionListener(this);
        add(b3);

        b4 = new Button("Back to Register");
        b4.setBounds(240, 160, 120, 30);
        b4.addActionListener(this);
        add(b4);

        loginStatus = new Label("");
        loginStatus.setBounds(150, 200, 250, 20);
        add(loginStatus);

        screen = "login";
        repaint();
    }

    void showProfilePage() {
        removeAll();
        Label l9 = new Label("User Profile");
        l9.setBounds(180, 40, 100, 20);
        add(l9);

        Label l10 = new Label("Full Name: " + fullName);
        l10.setBounds(100, 80, 300, 20);
        add(l10);

        Label l11 = new Label("Username: " + username);
        l11.setBounds(100, 110, 300, 20);
        add(l11);

        Label l12 = new Label("Email: " + email);
        l12.setBounds(100, 140, 300, 20);
        add(l12);

        b5 = new Button("Logout");
        b5.setBounds(200, 180, 80, 30);
        b5.addActionListener(this);
        add(b5);

        screen = "profile";
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (screen.equals("register")) {
            if (e.getSource() == b1) {
                fullName = t1.getText();
                username = t2.getText();
                password = t3.getText();
                email = t4.getText();
                showLoginPage();
            } 
		else if (e.getSource() == b2) {
                showLoginPage();
            	}
        } 
	else if (screen.equals("login")) {
            if (e.getSource() == b3) {
                String uname = t5.getText();
                String passw = t6.getText();
                if (uname.equals(username) && passw.equals(password)) {
                    loginStatus.setText("Login successful");
                    showProfilePage();
                } 
		    else {
                    loginStatus.setText("Invalid username or password");
                }
            } 
            else if (e.getSource() == b4) {
                showRegisterPage();
            }
        } 
	else if (screen.equals("profile")) {
            if (e.getSource() == b5) {
                showLoginPage();
            }
        }
    }
}
