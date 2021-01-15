package mywork.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proj_id;

    @Column(name = "proj_title")
    private String proj_title;

    @Column(name = "area")
    private String area;

    @OneToMany(mappedBy = "project")
    private Set<Task> project = new HashSet<>();

    public Project() {
    }

    public Project(String proj_title, String area) {
        this.proj_title = proj_title;
        this.area = area;
    }

    public Long getProj_id() {
        return proj_id;
    }

    public void setProj_id(Long proj_id) {
        this.proj_id = proj_id;
    }

    public String getProj_title() {
        return proj_title;
    }

    public void setProj_title(String proj_title) {
        this.proj_title = proj_title;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Set<Task> getProject() {
        return project;
    }

    public void setProject(Set<Task> project) {
        this.project = project;
    }


}
