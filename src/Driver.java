import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * LearningGUI -- Homework 1 -- Driver
 * <p>
 * Brief description of the program
 * <p>
 * a list of your sources of help (if any)
 *
 * @author Ayush Anand, lab sec OL1
 * @version April 28, 2021
 */
public class Driver implements Runnable{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Driver());
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", 4242);
            SignUp signUp = new SignUp(socket);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
