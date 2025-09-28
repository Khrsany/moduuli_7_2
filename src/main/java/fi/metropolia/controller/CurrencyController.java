package fi.metropolia.controller;

import fi.metropolia.dao.CurrencyDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CurrencyController {

    @FXML
    private TextField amountField;

    @FXML
    private ComboBox<String> fromCurrency;

    @FXML
    private ComboBox<String> toCurrency;

    @FXML
    private TextField resultField;

    private final CurrencyDao currencyDao = new CurrencyDao();

    @FXML
    private void initialize() {
        fromCurrency.getItems().addAll("EUR", "USD", "SEK", "GBP");
        toCurrency.getItems().addAll("EUR", "USD", "SEK", "GBP");
    }

    @FXML
    private void convert() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = fromCurrency.getValue();
            String to = toCurrency.getValue();

            double fromRate = currencyDao.getCurrencyByCode(from).getRate();
            double toRate = currencyDao.getCurrencyByCode(to).getRate();

            double result = amount * (toRate / fromRate);
            resultField.setText(String.format("%.2f", result));

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Conversion failed");
            alert.setContentText("Please check your input and database connection.");
            alert.showAndWait();
        }
    }
}
