package mywork.controllers.tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mywork.entities.Project;
import mywork.entities.Task;
import mywork.repository.ProjectRepository;
import mywork.repository.TaskRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskAddController implements Initializable {

    private final ProjectRepository projectRepository = new ProjectRepository();
    private final TaskRepository taskRepository = new TaskRepository();

    @FXML private TextField proj_id;
    @FXML private TextField proj_title;
    @FXML private TextField task_name;
    @FXML private TextField task_description;



    @FXML private StackPane rootPane;

    private Task editable;

    private Runnable closeDialogCallback;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void addPostOperationCallback(Runnable callback) {
        this.closeDialogCallback = callback;
    }

    public void setEditable(Task task) {
        this.editable = task;
        this.task_name.setText(task.getTask_name());
        this.task_description.setText(task.getTask_description());
        this.proj_id.setText(task.getProject().getProj_id().toString());
        this.proj_title.setText(task.getProject().getProj_title().toString());
    }

    @FXML
    private void addTask(ActionEvent event) {
        String taskTitle = task_name.getText();
        String taskDescription = task_description.getText();
        String taskProjectId = proj_id.getText();


        if (taskTitle.isEmpty() || taskDescription.isEmpty() || taskProjectId.isEmpty()) {
            System.out.println("Please, fill in all fields!");
            return;
        }

        Long proj_id = Long.parseLong(taskProjectId);
        Project project = projectRepository.findOne(proj_id);
        if (project == null) {
            System.out.println("Project with such id doesn't exist!");
            return;
        }

        if (editable == null) {
            taskRepository.save(new Task(taskTitle, taskDescription, project));
        } else {
            Task task = taskRepository.findOne(editable.getTask_id());
            task.setTask_name(taskTitle);
            task.setTask_description(taskDescription);
            task.setProject(project);
            taskRepository.merge(task);
        }
        clearEntries();
        closeStage();
        closeDialogCallback.run();
    }

    @FXML
    private void cancel(ActionEvent event) {
        closeStage();
    }

    private void clearEntries() {
        editable = null;
        task_name.clear();
        task_description.clear();
        proj_id.clear();
    }

    private void closeStage() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}
