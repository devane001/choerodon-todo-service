// todo_task.groovy
package script.db

databaseChangeLog(logicalFilePath: 'todo_task.groovy') {
    changeSet(id: '2017-05-29-todo_task', author: 'your.email@email.com') {
        createTable(tableName: "todo_task") {
            column(name: 'id', type: 'BIGINT UNSIGNED', remarks: 'ID', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'employee_id', type: 'BIGINT', remarks: '员工ID')
            column(name: 'state', type: 'VARCHAR(36)', remarks: '状态')
            column(name: 'task_number', type: 'VARCHAR(64)', remarks: '任务编号') {
                constraints(unique: true)
            }
            column(name: 'task_description', type: 'VARCHAR(256)', remarks: '任务描述')

            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue : "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue : "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed : "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue : "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed : "CURRENT_TIMESTAMP")
        }
    }
}