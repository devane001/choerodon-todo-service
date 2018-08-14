package io.choerodon.todo.domain.todo.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import io.choerodon.core.convertor.ConvertorI;
import io.choerodon.todo.api.dto.TaskDTO;
import io.choerodon.todo.domain.todo.entity.TaskE;
import io.choerodon.todo.infra.dataobject.TaskDO;

@Component
public class TaskConvertor implements ConvertorI<TaskE, TaskDO, TaskDTO> {
    @Override
    public TaskE dtoToEntity(TaskDTO dto) {
        return new TaskE(
                dto.getId(),
                dto.getEmployeeId(),
                dto.getState(),
                dto.getTaskNumber(),
                dto.getTaskDescription(),
                dto.getObjectVersionNumber()
        );
    }

    @Override
    public TaskDTO entityToDto(TaskE entity) {
        TaskDTO taskDTO = new TaskDTO();
        BeanUtils.copyProperties(entity, taskDTO);
        return taskDTO;
    }

    @Override
    public TaskE doToEntity(TaskDO dataObject) {
        return new TaskE(
                dataObject.getId(),
                dataObject.getEmployeeId(),
                dataObject.getState(),
                dataObject.getTaskNumber(),
                dataObject.getTaskDescription(),
                dataObject.getObjectVersionNumber()
        );
    }

    @Override
    public TaskDO entityToDo(TaskE entity) {
        TaskDO taskDO = new TaskDO();
        BeanUtils.copyProperties(entity, taskDO);
        return taskDO;
    }

    @Override
    public TaskDTO doToDto(TaskDO dataObject) {
        TaskDTO taskDTO = new TaskDTO();
        BeanUtils.copyProperties(dataObject, taskDTO);
        return taskDTO;
    }

    public TaskDO dtoToDo(TaskDTO dto) {
        TaskDO taskDO = new TaskDO();
        BeanUtils.copyProperties(dto, taskDO);
        return taskDO;
    }
}
