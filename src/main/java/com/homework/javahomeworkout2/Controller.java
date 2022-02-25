package com.homework.javahomeworkout2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // Коллекция хранит пары из названия продукта и коэфицента перевода из граммов в килокалории
    private static final HashMap<String, Double> products = new HashMap<String, Double>();
    static {
        products.put("Колбаса", 301 / 100.0);
        products.put("Индейка", 198 / 100.0);
        products.put("Омлет", 209 / 100.0);
        products.put("Вафли", 543 / 100.0);
        products.put("Вишня", 52 / 100.0);
        products.put("Огурцы", 13 / 100.0);
    }

    private final ObservableList<String> productObservableList = FXCollections.observableArrayList(new ArrayList<String>(products.keySet()));
    @FXML
    private ComboBox<String> productComboBox;

    @FXML
    private TextField weightInput;

    @FXML
    private Label answer;

    @FXML
    protected void countAnswer() {
        double weight;
        try {
            weight = Double.parseDouble(weightInput.getText());
        } catch (NumberFormatException e) {
            answer.setText("Введеные данные не являются числом");
            return;
        }
        Double coef = products.get(productComboBox.getSelectionModel().getSelectedItem());
        if(weight < 0) {
            answer.setText("Отрицательный вес не поддерживается");
        }
        else {
            if(coef == null) answer.setText("Введен неизвестный продукт");
            else answer.setText("Кол-во килокалорий: " + String.valueOf(weight * coef));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(productComboBox);
        productComboBox.setItems(productObservableList);
        productComboBox.getSelectionModel().selectFirst();
    }
}