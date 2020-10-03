
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainAppController implements Initializable {

	private MyGraph mathsGraph;

	@FXML
	private LineChart<Double, Double> lineGraph;
	@FXML
	private Button clearButton;

	@FXML
	private Button Test1;
	@FXML
	private Button Test2;
	@FXML
	private Button Test3;
	@FXML
	private Button Test4;

	@FXML
	private TextField A;
	@FXML
	private TextField B;
	@FXML
	private TextField C;
	@FXML
	private Button drawALine;

	@FXML
	private TextField A_x;
	@FXML
	private TextField A_y;
	@FXML
	private TextField B_x;
	@FXML
	private TextField B_y;
	@FXML
	private TextField C_x;
	@FXML
	private TextField C_y;

	@FXML
	private Button drawATriangle;

	@FXML
	private Button plotSymmetricalTriangle;

	@Override
	public void initialize(final URL url, final ResourceBundle rb) {
		mathsGraph = new MyGraph(lineGraph, 10);

		clearButton.setOnAction(event -> {
			mathsGraph.clear();
		});

		drawALine.setOnAction(event -> {
			mathsGraph.plotLine(Double.parseDouble(A.getText()),
				Double.parseDouble(B.getText()),
				Double.parseDouble(C.getText()));

		});

		drawATriangle.setOnAction(event -> {
			mathsGraph.plotTriangle(Double.parseDouble(A_x.getText()),
				Double.parseDouble(A_y.getText()),
				Double.parseDouble(B_x.getText()),
				Double.parseDouble(B_y.getText()),
				Double.parseDouble(C_x.getText()),
				Double.parseDouble(C_y.getText()));
		});

		plotSymmetricalTriangle.setOnAction(event -> {
			mathsGraph.plotSymmetricalTriangle();
		});

		Test1.setOnAction(event -> {
			mathsGraph.plotLine(-1,1,0);
			mathsGraph.plotTriangle(2,3,2,6,5,6);
		});

		Test2.setOnAction(event -> {
			mathsGraph.plotLine(0,1,1);
			mathsGraph.plotTriangle(2,3,2,6,5,6);
		});

		Test3.setOnAction(event -> {
			mathsGraph.plotLine(1,0,1);
			mathsGraph.plotTriangle(2,3,2,6,5,6);
		});

		Test4.setOnAction(event -> {
			mathsGraph.plotLine(1,1,1);
			mathsGraph.plotTriangle(3,3,4,2,5,6);
		});
	}

}
