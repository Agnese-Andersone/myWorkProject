package mywork.controllers.tasks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mywork.controllers.view.ViewLoader;
import mywork.entities.Task;
import mywork.repository.TaskRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class TasksController implements Initializable {

    private final TaskRepository taskRepository = new TaskRepository();

    @FXML private TableView<Task> table;

    @FXML
    private void addBook(ActionEvent event) {
        TaskAddController controller = (TaskAddController) ViewLoader
                .load(getClass().getResource("/ui/task/add_task.fxml"), "Add task");
        controller.addPostOperationCallback(this::populateTable);
    }

    @FXML
    private void editBook(ActionEvent event) {
        Task task = table.getSelectionModel().getSelectedItem();
        if (task == null) {
            return;
        }
        TaskAddController controller = (TaskAddController) ViewLoader.load(getClass()
                .getResource("/ui/task/add_task.fxml"), "Edit task");
        controller.setEditable(task);
        controller.addPostOperationCallback(this::populateTable);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureTable();
        populateTable();
    }

    private void configureTable() {
        TableColumn<Task, Long> column1 = new TableColumn<>("proj_id");
        column1.setCellValueFactory(new PropertyValueFactory<>("proj_id"));

        TableColumn<Task, String> column2 = new TableColumn<>("task_name");
        column2.setCellValueFactory(new PropertyValueFactory<>("task_name"));

        TableColumn<Task, String> column3 = new TableColumn<>("task_description");
        column3.setCellValueFactory(new PropertyValueFactory<>("task_description"));

        TableColumn<Task, String> column4 = new TableColumn<>("proj_title");
        column4.setCellValueFactory(new PropertyValueFactory<>("proj_title"));

        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);
    }

    private void populateTable() {
        ObservableList<Task> list = FXCollections.observableArrayList();
        list.addAll(taskRepository.findAll());
        table.setItems(list);
    }
}
