package timestamp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import timestamp.viewmodel.ViewModelFactory;
//import timestamp.viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
//    private TimestampViewModel viewModel;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
//        this.viewModel = viewModel;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception{
        openView("Timestamp");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource(viewToOpen +"View.fxml"));
        root = loader.load();
        if("Timestamp".equals(viewToOpen)) {
            TimestampController view = loader.getController();
            view.init(viewModelFactory.getTimestampViewModel());
//            timestamp.view.init(viewModel);
            stage.setTitle("Pie Chart");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
