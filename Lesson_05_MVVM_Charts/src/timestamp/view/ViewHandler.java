package timestamp.view;

import timestamp.view.barchart.BarChartController;
import timestamp.view.piechart.PieChartController;
import timestamp.view.textchart.TextViewController;
import timestamp.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception{
        openView("PieChart");
        openView("Text");
        openView("BarChart");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        if("PieChart".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("piechart/PieChartView.fxml"));
            root = loader.load();
            PieChartController view = loader.getController();
            view.init(viewModelFactory.getPieChartViewModel());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Pie Chart");
        } else if("Text".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("textchart/TextView.fxml"));
            root = loader.load();
            TextViewController view = loader.getController();
            view.init(viewModelFactory.getTextViewModel());
            Stage localStage1 = new Stage();
            scene = new Scene(root);
            localStage1.setScene(scene);
            localStage1.show();
            localStage1.setTitle("Text View");
        } else if("BarChart".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("barchart/BarChartView.fxml"));
            root = loader.load();
            BarChartController view = loader.getController();
            view.init(viewModelFactory.getBarChartViewModel());
            Stage localStage2 = new Stage();
            scene = new Scene(root);
            localStage2.setScene(scene);
            localStage2.show();
            localStage2.setTitle("Bar Chart");
        }
    }
}
