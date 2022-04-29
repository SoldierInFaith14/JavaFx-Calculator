package Calculator;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CalculatorController implements Initializable {

    @FXML
    private TextField outputScrn;
    
    @FXML
    private ListView<String> histScrn;

    @FXML
    private Button plusMinus, percent, clearBtn, decimalBtn;

    @FXML
    private Button zero, one, two, three, four, five, six, seven, eight, nine;

    @FXML
    private Button divideBtn, multiplyBtn, subtractBtn, addBtn, equalsBtn;

    @FXML
    private Button exponentBtn, sqRootBtn, moduloBtn, history, clrHistScrn, clrHist;
    
    @FXML
    private AnchorPane screen;

    Calculate calc = new Calculate();
    String operator;
    ObservableList<String> histList = FXCollections.observableArrayList();

    @FXML
    public void getInput(ActionEvent input){

        if(zero.isArmed()){
            outputScrn.appendText(zero.getText());
        }
        else if(one.isArmed()){
            outputScrn.appendText(one.getText());
        }
        else if(two.isArmed()){
            outputScrn.appendText(two.getText());
        }
        else if(three.isArmed()){
            outputScrn.appendText(three.getText());
        }
        else if(four.isArmed()){
            outputScrn.appendText(four.getText());
        }
        else if(five.isArmed()){
            outputScrn.appendText(five.getText());
        }
        else if(six.isArmed()){
            outputScrn.appendText(six.getText());
        }
        else if(seven.isArmed()){
            outputScrn.appendText(seven.getText());
        }
        else if(eight.isArmed()){
            outputScrn.appendText(eight.getText());
        }
        else if(nine.isArmed()){
            outputScrn.appendText(nine.getText());
        }
        else if(decimalBtn.isArmed()){
            outputScrn.appendText(decimalBtn.getText());
        }
        else if(clearBtn.isArmed()){
            outputScrn.clear();
        }
    }

    @FXML
    private void pM(ActionEvent plusMinus){
        double num = Double.parseDouble(String.valueOf(outputScrn.getText()));
        double oppNum= num * (-1);
        outputScrn.setText(String.valueOf(oppNum));
        histList.addAll(num + " x (-1) " + " " + equalsBtn.getText() + " " + oppNum );
    }

    @FXML
    private void percent(ActionEvent per){
        calc.num1 = Double.parseDouble(String.valueOf(outputScrn.getText()));
        calc.percent(calc.num1);
        outputScrn.setText(String.valueOf(calc.result));
        histList.addAll(calc.num1 + "/100 " + " " + equalsBtn.getText() + " " + calc.result + "%");
    }

    @FXML
    private void div(ActionEvent div){
         calc.num1 = Double.parseDouble(outputScrn.getText());
         outputScrn.setPromptText("");
         outputScrn.setText("");
         operator = divideBtn.getText();
    }

    @FXML
    private void mult(ActionEvent mult){
        calc.num1 = Double.parseDouble(outputScrn.getText());
        outputScrn.setPromptText("");
        outputScrn.setText("");
        operator = multiplyBtn.getText();
    }
    @FXML
    private void addition(ActionEvent addition){
        calc.num1 = Double.parseDouble(outputScrn.getText());
        outputScrn.setPromptText("");
        outputScrn.setText("");
        operator = addBtn.getText();
    }

    @FXML
    private void subtraction(ActionEvent subtraction){
        calc.num1 = Double.parseDouble(outputScrn.getText());
        outputScrn.setPromptText("");
        outputScrn.setText("");
        operator = subtractBtn.getText();
    }

    @FXML
    private void findSqrt(ActionEvent sqrt){
        calc.num1 = Double.parseDouble(outputScrn.getText());
        calc.squareRoot(calc.num1);
        outputScrn.setText(String.valueOf(calc.result));
        histList.addAll("√(" + calc.num1 + ")" + " " + equalsBtn.getText() + " " + calc.result);
    }

    @FXML
    private void findPower(ActionEvent exp){
        calc.num1 = Double.parseDouble(outputScrn.getText());
        outputScrn.setPromptText("");
        outputScrn.setText("");
        operator = exponentBtn.getText();
    }

    @FXML
    private void findMod(ActionEvent mod){
        calc.num1 = Double.parseDouble(outputScrn.getText());
        outputScrn.setPromptText("");
        outputScrn.setText("");
        operator = moduloBtn.getText();
    }

    @FXML
    private void calculateResult(ActionEvent calcResult){
         String answer;
         calc.num2 = Double.parseDouble(outputScrn.getText());

         if(operator == divideBtn.getText()){
             if(calc.num2 == 0){
                 outputScrn.setText("Error");
             }
             else{
                calc.divide(calc.num1, calc.num2);
                answer = String.format("%.2f",calc.result);
                outputScrn.setText(answer);
                histList.addAll(String.format("%.2f", calc.num1) + " " + operator + " " + String.format("%.2f", calc.num2) + " " + equalsBtn.getText() + " " + answer);
             }
         }
         else if(operator == multiplyBtn.getText()){
             calc.multiply(calc.num1, calc.num2);
             answer = String.valueOf(calc.result);
             outputScrn.setText(answer);
             histList.addAll(String.format("%.2f", calc.num1) + " " + operator + " " + String.format("%.2f", calc.num2) + " " + equalsBtn.getText() + " " + answer);
         }
         else if(operator == addBtn.getText()){
             calc.add(calc.num1, calc.num2);
             answer = String.valueOf(calc.result);
             outputScrn.setText(answer);
             histList.addAll(String.format("%.2f", calc.num1) + " " + operator + " " + String.format("%.2f", calc.num2) + " " + equalsBtn.getText() + " " + answer);
         }
         else if(operator == subtractBtn.getText()){
             calc.subtract(calc.num1, calc.num2);
             answer = String.valueOf(calc.result);
             outputScrn.setText(answer);
             histList.addAll(String.format("%.2f", calc.num1) + " " + operator + " " + String.format("%.2f", calc.num2) + " " + equalsBtn.getText() + " " + answer);
         }
         else if(operator == exponentBtn.getText()){
             calc.exponential(calc.num1, calc.num2);
             answer = String.valueOf(calc.result);
             outputScrn.setText(answer);
             histList.addAll(String.format("%.2f", calc.num1) + " " + operator + " " + String.format("%.2f", calc.num2) + " " + equalsBtn.getText() + " " + answer);         
         }
         else if(operator == moduloBtn.getText()){
             calc.modulo(calc.num1, calc.num2);
             answer = String.valueOf(calc.result);
             outputScrn.setText(answer);
             histList.addAll(String.format("%.2f", calc.num1) + " mod " + String.format("%.2f", calc.num2) + " " + equalsBtn.getText() + " " + answer);
         }
    }

    @FXML
    public void getHistory(ActionEvent history){ 
        histScrn.getItems().clear();
        histScrn.getItems().addAll(histList);
        histScrn.getItems().addAll("");
    }
    
    @FXML
    public void clearHistory(ActionEvent clrHistory){
        histScrn.getItems().clear();
        histList.clear();
        histScrn.getItems().addAll("");
    }
    
    @FXML
    public void clearHistoryScreen(ActionEvent clrHistoryScrn){
        histScrn.getItems().clear();
        histScrn.getItems().addAll("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        histScrn.getItems().addAll("");
    }
}