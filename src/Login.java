import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * LearningGUI -- Homework 1 -- Login
 * <p>
 * Brief description of the program
 * <p>
 * a list of your sources of help (if any)
 *
 * @author Ayush Anand, lab sec OL1
 * @version April 28, 2021
 */
public class Login extends JFrame {

    JLabel usernameText;
    JLabel passwordText;
    JButton loginButton;
    JTextField username;
    JTextField password;
    public Login() {
        JFrame frame = new JFrame("Social Network");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        JPanel up = new JPanel();
        JLabel LoginMessage = new JLabel("<h1>Login</h1>");
        up.add(LoginMessage);
        content.add(up, BorderLayout.NORTH);


        JPanel center = new JPanel();
        usernameText = new JLabel("Username");
        center.add(usernameText);
        username = new JTextField();
        center.add(username);
        passwordText = new JLabel("Password");
        center.add(passwordText);
        password = new JTextField();
        center.add(password);
        content.add(center, BorderLayout.CENTER);


        JPanel down = new JPanel();
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
                frame.setVisible(false);
//                SignUp signUp = new SignUp();
            }
        });
        down.add(loginButton);
        content.add(down, BorderLayout.SOUTH);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
