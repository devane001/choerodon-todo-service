// todo_user.groovy
package script.db

databaseChangeLog(logicalFilePath: 'todo_user.groovy') {
    changeSet(id: '2017-05-29-todo_user', author: 'your.email@email.com') {
        createTable(tableName: "todo_user") {
            column(name: 'id', type: 'BIGINT UNSIGNED', remarks: 'ID', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'employee_name', type: 'VARCHAR(32)', remarks: '员工名')
            column(name: 'employee_number', type: 'VARCHAR(32)', remarks: '员工号') {
                constraints(unique: true)
            }
            column(name: 'email', type: 'VARCHAR(32)', remarks: '邮箱')

            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue: "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
}