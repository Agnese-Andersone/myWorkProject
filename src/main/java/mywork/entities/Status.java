package mywork.entities;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long status_id;

    @Column(name = "status_title", columnDefinition="TEXT")
    private String status_title;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public String getStatus_title() {
        return status_title;
    }

    public void setStatus_title(String status_title) {
        this.status_title = status_title;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
