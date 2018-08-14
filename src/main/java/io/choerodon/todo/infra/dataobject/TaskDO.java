package io.choerodon.todo.infra.dataobject;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;

@ModifyAudit //在类上使用，启用审计字段支持，实体类加上该注解后，插入和更新会启动对creationDate、createdBy、lastUpdateDate、lastUpdatedBy自维护字段支持
@VersionAudit //在类上使用，启用objectVersionNumber自维护支持，插入一条数据objectVersionNumber默认为1，每次update后objectVersionNumber自增1
@Table(name = "todo_task")
public class TaskDO extends AuditDomain { //AuditDomain包含5个自维护字段，使用@ModifyAudit和@VersionAudit的实体类要继承该类
    @Id
    @GeneratedValue //对于自增长、序列（SEQUENCE）类型的主键，需要添加该注解
    private Long id;
    private Long employeeId;
    private String state;
    private String taskNumber;
    private String taskDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}