package io.choerodon.todo.app.service;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.todo.api.dto.TaskDTO;

public interface TaskService {

    TaskDTO create(TaskDTO taskDTO);

    void deleteById(Long id);

    void deleteByTaskNumber(String taskNumber);

    TaskDTO update(TaskDTO taskDTO);

    TaskDTO queryById(Long id);

    Page<TaskDTO> list(PageRequest pageRequest);
}
