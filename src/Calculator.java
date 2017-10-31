import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Calculator extends Application{
	
	Label label1;
	Label label2;
	Button button1;
	int i = 1;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static double doCalculation(String calculation) {
//		Pattern p = Pattern.compile("[0-9\\+\\-\\/\\*\\.]*");
//		Matcher m = p.matcher(calculation);
//		if (m.find()) {
//			System.out.println("Bad string");
//			return 1.10;
//		}
		if(calculation.equals("") || calculation == null) {
			return 0;
		}
		String[] strs = calculation.split("[\\+\\-\\/\\*]");
		char operator = calculation.charAt(strs[0].length());
		double operand1 = Double.parseDouble(strs[0]);
		double operand2 = Double.parseDouble(strs[1]);
		Calculation c = CalculationChooser.choose(operator, operand1, operand2);
		return c.calculate();
		
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Stagey McStage");
		label1 = new Label(" = ");
		label2 = new Label("  ");
		HBox root = new HBox();
		
		Scene scene = new Scene(root,480,120);
		stage.setScene(scene);
		
		TextField tf = new TextField();
		
		button1 = new Button("Calculate");
		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String text = tf.getText();
				double d = Calculator.doCalculation(text);
				System.out.println("I'm in");
				label2.setText(" "+d+" ");
				//label1.setText("Counter: "+i);
				//i++;
			}
		});
		
		root.getChildren().addAll(tf,label1,label2,button1);
		//all.getChildren().addAll(root,next);
		stage.show();
	}
}
