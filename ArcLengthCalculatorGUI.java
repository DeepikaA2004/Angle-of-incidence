import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArcLengthCalculatorGUI {
    private JFrame frame;
    private JTextField radiusTextField;
    private JTextField angleTextField;
    private JLabel resultLabel;

    public ArcLengthCalculatorGUI() {
        frame = new JFrame("Arc Length Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 1));

        JLabel radiusLabel = new JLabel("Enter the radius (r) in units:");
        radiusTextField = new JTextField();

        JLabel angleLabel = new JLabel("Enter the central angle (θ) in degrees:");
        angleTextField = new JTextField();

        JButton calculateButton = new JButton("Calculate Arc Length");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateArcLength();
            }
        });

        resultLabel = new JLabel("Arc Length will be displayed here.");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.add(radiusLabel);
        frame.add(radiusTextField);
        frame.add(angleLabel);
        frame.add(angleTextField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    private void calculateArcLength() {
        try {
            double radius = Double.parseDouble(radiusTextField.getText());
            double angle = Double.parseDouble(angleTextField.getText());

            double arcLength = (2 * Math.PI * radius * (angle / 360.0));
            resultLabel.setText("Arc Length: " + arcLength + " units");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ArcLengthCalculatorGUI();
            }
        });
    }
}
