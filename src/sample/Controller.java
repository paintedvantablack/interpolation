package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import org.knowm.xchart.*;

public class Controller
{
    @FXML
    private TextField x_field;
    @FXML
    private TextField y_field;
    @FXML
    private Button add_point;


    @FXML
    private Button interpolate;


    @FXML
    private ListView<String> original_list;
    @FXML
    private Button original_graph;
    @FXML
    private Button save_original;


    @FXML
    private ListView<String> approximated_list;
    @FXML
    private Button approximated_graph;
    @FXML
    private Button save_approximated;



    Values vals = new Values();
    ValuesInterpolated valsint = new ValuesInterpolated(vals);
    ValuesRes valsres = new ValuesRes(vals, valsint);


    ObservableList<String> newOriginal = FXCollections.observableArrayList();
    ObservableList<String> newInterpolated = FXCollections.observableArrayList();

    @FXML
    void initialize()
    {
        original_list.setItems(newOriginal);
        approximated_list.setItems(newInterpolated);

        add_point.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Add Point");

                double x = new Double(x_field.getText());
                double y = new Double(y_field.getText());
                vals.PutIn(x,y);
                System.out.println(vals.getXX()+"\n"+vals.getYY());
                //newOriginal.add(x_field.getText() + "\t|\t" + y_field.getText());
                newOriginal.clear();
                for(int i=0;i<vals.getXX().size();i++)
                {
                    newOriginal.add(""+vals.getXX(i) + "\t|\t" + vals.getYY(i));
                }


            }
        });

        interpolate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                valsint = new ValuesInterpolated(vals);
                System.out.println(valsint.getXXi()+"\n"+valsint.getYYi());
                newInterpolated.clear();
                for(int i=0;i<valsint.getXXi().size();i++)
                {
                    newInterpolated.add(""+valsint.getXXi(i) + "\t|\t" + valsint.getYYi(i));
                }
            }
        });

        original_graph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Original graph");

                XYChart chart = QuickChart.getChart("Original graph", "X", "Y", "y(x)", vals.getXX(), vals.getYY());
                new SwingWrapper(chart).displayChart();
            }
        });

        save_original.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Save original");
                try {
                    XYChart chart = QuickChart.getChart("Original graph", "X", "Y", "y(x)", vals.getXX(), vals.getYY());
// Save it in high-res
                    BitmapEncoder.saveBitmapWithDPI(chart, "./Original graph 400dpi", BitmapEncoder.BitmapFormat.PNG, 400);
                }
                catch(Exception e) { }
            }
        });

        approximated_graph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Approximated graph");

                valsres = new ValuesRes(vals, valsint);

                XYChart chart = QuickChart.getChart("Interpolated graph", "X", "Y", "y(x)", valsres.getXXres(), valsres.getYYres());
                new SwingWrapper(chart).displayChart();
            }
        });

        save_approximated.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Save approximated");

                try {
                    XYChart chart = QuickChart.getChart("Interpolated graph", "X", "Y", "y(x)", valsres.getXXres(), valsres.getYYres());
// Save it in high-res
                    BitmapEncoder.saveBitmapWithDPI(chart, "./Interpolated graph 400dpi", BitmapEncoder.BitmapFormat.PNG, 400);
                }
                catch(Exception e) { }
            }
        });
    }
}
