package mywork.repository;

import mywork.entities.Project;

import java.util.List;

public class ProjectRepository extends CrudRepository<Project> {

    private static final String HIBERNATE_SELECT_QUERY = "from Project";

    public Project findOne(Long proj_id) {
        return super.findOne(proj_id, Project.class);
    }

    public List<Project> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Project.class);
    }
}
