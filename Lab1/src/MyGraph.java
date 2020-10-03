
import javafx.scene.chart.XYChart;

public class MyGraph {

	private XYChart<Double, Double> graph;
	private double range;

	// coordinates for given triangle
	private double a_x;
	private double a_y;
	private double b_x;
	private double b_y;
	private double c_x;
	private double c_y;

	// parameters for given line
	private double A;
	private double B;
	private double C;


	public MyGraph(final XYChart<Double, Double> graph, final double range) {
		this.graph = graph;
		this.range = range;
	}

	public void plotLine(double A, double B, double C) {
		final XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
		this.A = A;
		this.B = B;
		this.C = C;

		if(A == 0d && B == 0d)
			throw new RuntimeException("illegal equation");
		if(A == 0d)
			for (double x = -range; x <= range; x = x + 0.01)
				plotPoint(x,  -C/B, series);
		else if(B == 0d)
			for (double x = -range; x <= range; x = x + 0.01)
				plotPoint(-C/A,  x, series);
		else
			for (double x = -range; x <= range; x = x + 0.01)
				plotPoint(x, -A/B*x - C/B, series);

		graph.getData().add(series);
	}

	public void plotTriangle(double a_x, double a_y, double b_x, double b_y, double c_x, double c_y){
		this.a_x = a_x;
		this.a_y = a_y;
		this.b_x = b_x;
		this.b_y = b_y;
		this.c_x = c_x;
		this.c_y = c_y;

		XYChart.Series<Double, Double> seriesA = new XYChart.Series<Double, Double>();
		XYChart.Series<Double, Double> seriesB = new XYChart.Series<Double, Double>();
		XYChart.Series<Double, Double> seriesC = new XYChart.Series<Double, Double>();

		seriesA.getData().add(new XYChart.Data<Double, Double>(a_x, a_y));
		seriesA.getData().add(new XYChart.Data<Double, Double>(b_x, b_y));

		seriesB.getData().add(new XYChart.Data<Double, Double>(b_x, b_y));
		seriesB.getData().add(new XYChart.Data<Double, Double>(c_x, c_y));

		seriesC.getData().add(new XYChart.Data<Double, Double>(c_x, c_y));
		seriesC.getData().add(new XYChart.Data<Double, Double>(a_x, a_y));

		graph.setId("chart0");
		graph.getData().add(seriesA);
		graph.getData().add(seriesB);
		graph.getData().add(seriesC);
	}

	public void plotSymmetricalTriangle() {
		double[] A_new = findPoint(a_x, a_y);
		double[] B_new = findPoint(b_x, b_y);
		double[] C_new = findPoint(c_x, c_y);

		System.out.println("1");

		plotTriangle(A_new[0], A_new[1], B_new[0], B_new[1], C_new[0], C_new[1]);
	}


	private double[] findPoint(double x0, double y0){
		double x_middle;
		double y_middle;

		if(B == 0d){
			x_middle = -C/A;
			y_middle = y0;
		} else {
			x_middle = ( A*y0 - B*x0 + A*C/B)/(-B - A * A / B);
			y_middle = - A * x_middle / B - C / B;
		}
		return new double[]{2*x_middle - x0,2*y_middle - y0};
	}


	public void plotPoint(final double x, final double y,
			final XYChart.Series<Double, Double> series) {
		series.getData().add(new XYChart.Data<Double, Double>(x, y));
	}

	public void clear() {
		graph.getData().clear();
	}

}
