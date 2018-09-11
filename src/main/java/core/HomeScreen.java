package core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class HomeScreen extends Application {
	
	Button solution;
	TextField num1;
	TextField num2;
	TextField answerTB;
	ComboBox<String> operatorDropDown;
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
		
	}
		private void initUI(Stage primaryStage) {
			Pane canvas = new Pane();
			//canvas.setStyle("fx-background-color: red");
			
		addControlToCanvas(canvas);
			
			Scene scene = new Scene(canvas, 320, 200);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calculator");
			primaryStage.show();
		}
		
		
		private void addControlToCanvas(Pane canvas) {
			int row1 = 20;
			int row2 = 60;
			int txt = 50;
			Label label = new Label("Simple Calculator using JavaFX");
			label.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
			label.relocate(20, row1);
			
			num1 = new TextField();
			num1.relocate(20,row2);
			num1.setMaxWidth(txt);
			
			num2 = new TextField();
			num2.relocate(150, row2);
			num2.setMaxWidth(txt);
			
			operatorDropDown = new ComboBox<String>();
			operatorDropDown.getItems().addAll("+","-","/","*","%");
			operatorDropDown.setValue("+");
			operatorDropDown.relocate(80,row2);
			
			solution = new Button("=");
			solution.relocate(210,row2);
			
			
			answerTB = new TextField();
			answerTB.setMaxWidth(txt);
			answerTB.relocate(250,row2);
			answerTB.setEditable(false);
			
			setSolutionButtonHandler();
			
			canvas.getChildren().addAll(label,num1,num2,operatorDropDown,solution,answerTB);
		}
		
		private void setSolutionButtonHandler() {
			solution.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Double value1 = Double.valueOf(num1.getText());
					Double value2 = Double.valueOf(num2.getText());
					String operator = operatorDropDown.getValue();
					
					ArithmeticSolver solver = new ArithmeticSolver();
					String answer = String.valueOf(solver.solve(operator, value1,value2));
					
					//String answer = String.valueOf(value1 + value2);
					
					answerTB.setText(answer);

				}
					
				});
		}
}
