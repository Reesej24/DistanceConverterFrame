import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Activity 10-11.2
public class DistanceConverterFrame extends JFrame implements ActionListener {
    private JButton calcButton;              // Triggers time calculation
    private JButton resetButton;             // Resets input and output values
    private JLabel mileLabel;                // Label for miles (input)
    private JLabel kmLabel;                  // Label for kilometers
    private JLabel mLabel;                   // Label for meters
    private JLabel ftLabel;                  // Label for feet
    private JFormattedTextField mileField;   // Text field for miles
    private JFormattedTextField kmField;     // Text field for kilometers
    private JFormattedTextField mField;      // Text field for meters
    private JFormattedTextField ftField;     // Text field for feet

    DistanceConverterFrame() {
        // Specify GUI component layout
        GridBagConstraints layoutConst = null;

        // Set frame's title
        setTitle("Distance Converter");

        // Create labels
        mileLabel = new JLabel("Miles (mi):");
        kmLabel = new JLabel("Kilometers (km):");
        mLabel = new JLabel("Meters (m):");
        ftLabel = new JLabel("Feet (ft):");

        // Create buttons and action listeners
        calcButton = new JButton("Calculate");
        resetButton = new JButton("Reset");
        calcButton.addActionListener(this);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mileField.setText("0");
                kmField.setText("0");
                mField.setText("0");
                ftField.setText("0");
            }
        });

        // Create mile text field
        mileField = new JFormattedTextField(NumberFormat.getNumberInstance());
        mileField.setEditable(true);
        mileField.setText("0");
        mileField.setColumns(15);

        // Create kilometer text field
        kmField = new JFormattedTextField(NumberFormat.getNumberInstance());
        kmField.setEditable(false);
        kmField.setText("0");
        kmField.setColumns(15);

        // Create meter text field
        mField = new JFormattedTextField(NumberFormat.getNumberInstance());
        mField.setEditable(false);
        mField.setText("0");
        mField.setColumns(15);

        // Create feet text field
        ftField = new JFormattedTextField(NumberFormat.getNumberInstance());
        ftField.setEditable(false);
        ftField.setText("0");
        ftField.setColumns(15);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());

        // Specify component's grid location
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(mileLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(mileField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(kmLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(kmField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        add(mLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        add(mField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        add(ftLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        add(ftField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        add(calcButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        add(resetButton, layoutConst);
    }
    /* Method is automatically called when an event occurs, in this
       case, the "Calculate" is pressed. */

    @Override
    public void actionPerformed(ActionEvent event) {
        double totMiles;        // Distance in miles entered by user
        double totKmeters;      // Distance in kilometers
        double totMeters;       // Distance in meters
        double totFeet;         // Distance in feet

        // Get value from mile field
        totMiles = ((Number) mileField.getValue()).doubleValue();

        // Check if miles input is positive
        if (totMiles >= 0.0) {
            totKmeters = totMiles * 1.60934;
            totMeters = totMiles * 1609.34;
            totFeet = totMiles * 5280.0;

            kmField.setText(Double.toString(totKmeters));
            mField.setText(Double.toString(totMeters));
            ftField.setText(Double.toString(totFeet));
        }
        else {
            JOptionPane.showMessageDialog(this, "Enter a positive distance value!");
        }
    }

    // Creates a DistanceConverterFrame and makes it visible
    public static void main(String[] args) {
        // Creates DistanceConverterFrame and its components
        DistanceConverterFrame myFrame = new DistanceConverterFrame();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
