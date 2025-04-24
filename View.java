import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View extends JFrame {
    public JTextField amountField;
    public JComboBox<String> fromCurrencySelector,toCurrencySelector;
    public JLabel outputLabel;
    public JButton convertButton;

    public View() {
        initializeUI();
    }

    private void initializeUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 550);
        this.setMinimumSize(new Dimension(600, 550));
        this.setLocationRelativeTo(null);

        // color palette
        Color backgroundColor = new Color(245, 245, 245);
        Color primaryColor = new Color(30, 136, 229);
        Color textColor = new Color(33, 33, 33);

        // Main
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(backgroundColor);
        this.setContentPane(mainPanel);

        // Title
        JLabel titleLabel = new JLabel("Currency Exchange", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(primaryColor);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(0, 0, 15, 0));

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(3,1));
        inputPanel.setBackground(backgroundColor);

        JPanel amountPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        amountPanel.setBackground(backgroundColor);

        JPanel currencySelectorPanel = new JPanel(new GridLayout(2,2));
        currencySelectorPanel.setBackground(backgroundColor);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        amountField = new JTextField(15);
        amountField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        amountField.setPreferredSize(new Dimension(150, 30));
        amountField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        JLabel fromLabel = new JLabel("From:", SwingConstants.CENTER);
        amountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel toLabel = new JLabel("To:", SwingConstants.CENTER);
        amountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        fromCurrencySelector = new JComboBox<>();
        fromCurrencySelector.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fromCurrencySelector.setPreferredSize(new Dimension(150, 30));
        fromCurrencySelector.setBackground(Color.WHITE);
        fromCurrencySelector.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        toCurrencySelector = new JComboBox<>();
        toCurrencySelector.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        toCurrencySelector.setPreferredSize(new Dimension(150, 30));
        toCurrencySelector.setBackground(Color.WHITE);
        toCurrencySelector.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        amountPanel.add(amountLabel);
        amountPanel.add(amountField);

        currencySelectorPanel.add(fromLabel);
        currencySelectorPanel.add(toLabel);

        currencySelectorPanel.add(fromCurrencySelector);
        currencySelectorPanel.add(toCurrencySelector);

        inputPanel.add(amountPanel);
        inputPanel.add(currencySelectorPanel);
        currencySelectorPanel.setSize(new Dimension(300,100));

        // Convert button
        convertButton = new JButton("Convert");
        styleButton(convertButton);
        convertButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Result panel
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.setBackground(backgroundColor);
        resultPanel.setBorder(new EmptyBorder(15, 0, 0, 0));

        Font resultFont = new Font("Segoe UI", Font.PLAIN, 15);
        Color resultBg = Color.WHITE;

        outputLabel = createResultLabel("     ", resultFont, resultBg, textColor);
        resultPanel.add(outputLabel);

        // Add components to main panel
        mainPanel.add(titleLabel);
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(convertButton);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(resultPanel);

        this.setVisible(true);
    }


    private void styleButton(JButton button) {
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(157, 67, 67, 241));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(157, 67, 67, 115)),
                BorderFactory.createEmptyBorder(8, 25, 8, 25)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Force custom background painting
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(157, 67, 67, 83));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(157, 67, 67, 241));
            }
        });
    }


    private JLabel createResultLabel(String text, Font font, Color bg, Color fg) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setOpaque(true);
        label.setBackground(bg);
        label.setForeground(fg);
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return label;
    }

}