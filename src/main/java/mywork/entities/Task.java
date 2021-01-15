package mywork.entities;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    @Column
    private String task_name;

    @Column
    private String task_description;

    @ManyToOne
    @JoinColumn(name = "proj_id")
    private Project project;

    public Task() {
    }

    public Task(String task_name, String task_description, Project project) {
        this.task_name = task_name;
        this.task_description = task_description;
        this.project = project;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
