package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class View extends JFrame {

    private JPanel contentPane;
    private JLabel titleLabel;
    private JLabel firstPolLabel;
    private JTextField firstPolTextField;
    private JTextField secondPolTextField;
    private JLabel secondPolLabel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton divideButton;
    private JButton derivateButton;
    private JButton multiplicateButton;
    private JButton integralButton;
    private JLabel resultTextLabel;
    private JTextField resultTextField;


    public View() {
        setTitle("Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        titleLabel.setBounds(130, 10, 150, 19);
        contentPane.add(titleLabel);

        firstPolLabel = new JLabel("First Polynomial = ");
        firstPolLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        firstPolLabel.setBounds(10, 40, 130, 13);
        contentPane.add(firstPolLabel);

        secondPolLabel = new JLabel("Second Polynomial =");
        secondPolLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        secondPolLabel.setBounds(10, 70, 130, 13);
        contentPane.add(secondPolLabel);

        firstPolTextField = new JTextField();
        firstPolTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        firstPolTextField.setBounds(185, 40, 190, 19);
        contentPane.add(firstPolTextField);
        firstPolTextField.setColumns(10);

        secondPolTextField = new JTextField();
        secondPolTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        secondPolTextField.setBounds(185, 70, 190, 19);
        contentPane.add(secondPolTextField);
        secondPolTextField.setColumns(10);

        addButton = new JButton("Add");
        addButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        addButton.setBounds(10, 150, 120, 20);
        contentPane.add(addButton);

        subtractButton = new JButton("Subtract");
        subtractButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        subtractButton.setBounds(10, 185, 120, 20);
        contentPane.add(subtractButton);

        multiplicateButton = new JButton("Multiply");
        multiplicateButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        multiplicateButton.setBounds(185, 150, 120, 20);
        contentPane.add(multiplicateButton);

        divideButton = new JButton("Division");
        divideButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        divideButton.setBounds(185, 185, 120, 20);
        contentPane.add(divideButton);

        integralButton = new JButton("Integrate");
        integralButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        integralButton.setBounds(10, 220, 120, 20);
        contentPane.add(integralButton);

        derivateButton = new JButton("Derivate");
        derivateButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        derivateButton.setBounds(185, 220, 120, 20);
        contentPane.add(derivateButton);

        resultTextLabel = new JLabel("Result =");
        resultTextLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        resultTextLabel.setBounds(10, 100, 130, 13);
        contentPane.add(resultTextLabel);

        resultTextField = new JTextField();
        resultTextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        resultTextField.setColumns(10);
        resultTextField.setBounds(185, 100, 190, 19);
        contentPane.add(resultTextField);
    }

    public void addAddListener(ActionListener actionListener) {
        this.addButton.addActionListener(actionListener);
    }

    public void addSubtractListener(ActionListener actionListener) {
        this.subtractButton.addActionListener(actionListener);
    }

    public void addMultiplicateListener(ActionListener actionListener) {
        this.multiplicateButton.addActionListener(actionListener);
    }

    public void addDivideListener(ActionListener actionListener) {
        this.divideButton.addActionListener(actionListener);
    }

    public void addIntegralListener(ActionListener actionListener) {
        this.integralButton.addActionListener(actionListener);
    }

    public void addDerivateListener(ActionListener actionListener) {
        this.derivateButton.addActionListener(actionListener);
    }

    public String getTextFirstPol() {
        return this.firstPolTextField.getText();
    }

    public String getTextSecondPol() {
        return this.secondPolTextField.getText();
    }

    public String getTextResult() {
        return this.resultTextField.getText();
    }

    public void setTextFirstPol(String msg) {
        this.firstPolTextField.setText(msg);
    }

    public void setTextSecondPol(String msg) {
        this.secondPolTextField.setText(msg);
    }

    public void setTextResult(String msg) {
        this.resultTextField.setText(msg);
    }

}
