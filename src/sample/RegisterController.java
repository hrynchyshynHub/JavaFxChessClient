package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.config.MainConfig;
import sample.controller_elements.Util;
import sample.controller_elements.ViewLoader;
import sample.network.model.Client;
import sample.network.model.OperationType;
import sample.network.model.RequestCode;
import sample.network.model.Response;
import sample.network.model.model.Player;

import java.io.IOException;

/**
 * Created by ivan.hrynchyshyn on 22.11.2017.
 */
public class RegisterController {
    @FXML
    private Button cancelButton;
    @FXML
    private TextField username;
    @FXML
    private TextField firstName;
    @FXML
    private TextField secondName;
    @FXML
    private TextField password;
    @FXML
    private TextField color;


    public void signUp(ActionEvent event){
        String username = this.username.getText();
        String firstName = this.firstName.getText();
        String secondName = this.secondName.getText();
        String password = this.password.getText();
        String color = this.color.getText();

        if (username.isEmpty() || password.isEmpty() ||
            firstName.isEmpty() || secondName.isEmpty()
            || color.isEmpty() ) {
            Util.showAlert("Incorrect inputs",
                "Some fields is empty",
                "Fields can't be empty");
            return;
        }

        Player player = new Player(null, username, firstName, secondName, password, color);

        Response response = Client.getInstance().send(OperationType.REGISTER_USER, player);

        if(response.getRequestCode().equals(RequestCode.ERROR)){
            Util.showAlert("error", response.getData().toString(), "");
        }else if(response.getRequestCode().equals(RequestCode.OK)){
            player = (Player) response.getData();
            MainConfig.setUser(player);
            ViewLoader viewLoader = new ViewLoader(this.cancelButton);
            viewLoader.loadScene("view/Menu.fxml", "Menu");
        }
     }

    public void back(ActionEvent event) throws IOException {
        ViewLoader viewLoader = new ViewLoader((Node) event.getSource());
        viewLoader.loadScene("view/Main.fxml", "Main");
    }
}
