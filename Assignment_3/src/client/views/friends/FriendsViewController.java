package client.views.friends;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferobjects.User;

public class FriendsViewController implements ViewController
{

  private FriendsViewModel viewModel;
  private ViewHandler vh;

  @FXML private Label numberOfFriendsLabel;
  @FXML private TableView<User> friendsTableView;
  @FXML private TableColumn<User, String> usernameColumn;

  @Override public void init(ViewModelFactory vmf, ViewHandler vh)
  {
    this.vh = vh;
    this.viewModel = vmf.getFriendsVM();

    viewModel.noFriendsProperty().bindBidirectional(numberOfFriendsLabel.textProperty());
    viewModel.loadFriends();
    friendsTableView.setItems(viewModel.getFriends());
    usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
  }

  @FXML private void onBackButton()
  {
    vh.openChatView();
  }
}
