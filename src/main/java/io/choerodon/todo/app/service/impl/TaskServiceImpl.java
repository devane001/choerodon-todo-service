package io.choerodon.todo.app.service.impl;

import org.springframework.stereotype.Service;

import io.choerodon.core.convertor.ConvertPageHelper;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.todo.api.dto.TaskDTO;
import io.choerodon.todo.app.service.TaskService;
import io.choerodon.todo.domain.repository.TaskRepository;
import io.choerodon.todo.domain.todo.convertor.TaskConvertor;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private TaskConvertor taskConvertor;

    public TaskServiceImpl(TaskRepository taskRepository, TaskConvertor taskConvertor) {
        this.taskRepository = taskRepository;
        this.taskConvertor = taskConvertor;
    }

    @Override
    public TaskDTO create(TaskDTO taskDTO) {
        return taskConvertor.entityToDto(
                taskRepository.create(taskConvertor.dtoToEntity(taskDTO)));
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void deleteByTaskNumber(String taskNumber) {
        taskRepository.deleteByTaskNumber(taskNumber);
    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        return taskConvertor.entityToDto(
                taskRepository.update(taskConvertor.dtoToEntity(taskDTO)));
    }

    @Override
    public TaskDTO queryById(Long id) {
        return taskConvertor.entityToDto(taskRepository.queryById(id));
    }

    @Override
    public Page<TaskDTO> list(PageRequest pageRequest) {
        return ConvertPageHelper.convertPage(taskRepository.list(pageRequest), TaskDTO.class);
    }
}
