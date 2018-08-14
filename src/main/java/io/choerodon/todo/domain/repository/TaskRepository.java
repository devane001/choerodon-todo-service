package io.choerodon.todo.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.todo.domain.todo.entity.TaskE;

public interface TaskRepository {
    TaskE create(TaskE taskE);

    void deleteById(Long id);

    void deleteByTaskNumber(String taskNumber);

    TaskE update(TaskE taskE);

    TaskE queryById(Long id);

    Page<TaskE> list(PageRequest pageRequest);
}
