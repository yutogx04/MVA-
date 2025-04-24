import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adapter implements ActionListener{
    private Model model;
    private View view;

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == view.convertButton) {
            try {
                double amount = Double.parseDouble(view.amountField.getText());
                String fromCurrency = (String) view.fromCurrencySelector.getSelectedItem();
                String toCurrency = (String) view.toCurrencySelector.getSelectedItem();
                double result = model.exchange(fromCurrency, toCurrency, amount);
                view.outputLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
            } catch (NumberFormatException ex) {
                view.outputLabel.setText("Invalid amount");
            }
        }
    }

    public Adapter(View view, Model model) {
        this.model = model;
        this.view = view;
        updateView(model.getCurrencies());
        view.convertButton.addActionListener(this);
        view.setVisible(true);
    }
    public void updateView(String[] currencies) {
        System.out.println("Update called");
        view.fromCurrencySelector.removeAllItems();
        for (String currency : currencies) {
            view.fromCurrencySelector.addItem(currency);
        }
        view.toCurrencySelector.removeAllItems();
        for (String currency : currencies) {
            view.toCurrencySelector.addItem(currency);
        }
    }
    public void setModel(Model model) {
        this.model = model;
    }
}