import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * LearningGUI -- Homework 1 -- SignUp
 * <p>
 * Brief description of the program
 * <p>
 * a list of your sources of help (if any)
 *
 * @author Ayush Anand, lab sec OL1
 * @version April 28, 2021
 */
public class SignUp extends JFrame {
    private Socket socket;
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel usernameLabel;
    private final JTextField usernameText;
    private final JLabel passwordLabel;
    private final JPasswordField passwordText;
    private final JButton signUpButton;

    public SignUp(Socket socket) {
        this.socket = socket;
         frame = new JFrame("Sign Up");
         panel = new JPanel();
         usernameLabel = new JLabel("Username");
        usernameText = new JTextField(20);
        passwordLabel = new JLabel("Password");
        passwordText = new JPasswordField(20);
        signUpButton = new JButton("Sign Up!");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        init(panel);

        // Setting the frame visibility to true
        frame.setVisible(true);
    }

    private void init(JPanel panel) {
        panel.setLayout(null);

        //Enter username
        usernameLabel.setBounds(10,20,80,25);
        panel.add(usernameLabel);

        usernameText.setBounds(90,20,165,25);
        panel.add(usernameText);

        // Same process for password label and text field.
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        //Enter password
        passwordText.setBounds(90,50,165,25);
        panel.add(passwordText);

        // Creating login button
        signUpButton.setBounds(100, 80, 120, 25);
        panel.add(signUpButton);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                        Scanner in = new Scanner(socket.getInputStream());
                        PrintWriter pw = new PrintWriter(socket.getOutputStream());


                        String password = passwordText.getText();
                        String name = usernameText.getText();

                        pw.println("/SignUp");
                        pw.println(name);
                        pw.println(password);
                        pw.flush();

                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        System.out.println(line);;
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JTextField getUsernameText() {
        return usernameText;
    }

    public JPasswordField getPasswordText() {
        return passwordText;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }
}
