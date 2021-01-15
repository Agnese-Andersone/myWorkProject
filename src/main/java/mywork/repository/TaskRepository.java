package mywork.repository;

import mywork.entities.Task;

import java.util.List;

public class TaskRepository extends CrudRepository<Task> {

    private static final String HIBERNATE_SELECT_QUERY = "from Task";

    public Task findOne(Long task_id) {
        return super.findOne(task_id, Task.class);
    }

    public List<Task> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Task.class);
    }
}
