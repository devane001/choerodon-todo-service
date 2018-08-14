package io.choerodon.todo.domain.todo.entity;

public class TaskE {
    private Long id;
    private Long employeeId;
    private String state;
    private String taskNumber;
    private String taskDescription;
    private Long objectVersionNumber;

    public TaskE(Long id, Long employeeId, String state, String taskNumber, String taskDescription, Long objectVersionNumber) {
        this.id = id;
        this.employeeId = employeeId;
        this.state = state;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.objectVersionNumber = objectVersionNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getState() {
        return state;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void updateState(String state) {
        this.state = state;
    }
}
