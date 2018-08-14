package io.choerodon.todo.infra.repository.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import io.choerodon.core.convertor.ConvertPageHelper;
import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.todo.domain.repository.TaskRepository;
import io.choerodon.todo.domain.todo.convertor.TaskConvertor;
import io.choerodon.todo.domain.todo.entity.TaskE;
import io.choerodon.todo.infra.dataobject.TaskDO;
import io.choerodon.todo.infra.mapper.TaskMapper;

@Component
public class TaskRepositoryImpl implements TaskRepository {
    private TaskMapper taskMapper;

    private TaskConvertor taskConvertor;

    public TaskRepositoryImpl(TaskMapper taskMapper, TaskConvertor taskConvertor) {
        this.taskMapper = taskMapper;
        this.taskConvertor = taskConvertor;
    }

    @Override
    public TaskE create(TaskE taskE) {
        TaskDO taskDO = taskConvertor.entityToDo(taskE);
        List<TaskDO> taskDOList = taskMapper.select(taskDO);
        if (!taskDOList.isEmpty()) {
            throw new CommonException("error.task.exist");
        }
        if (taskMapper.insertSelective(taskDO) != 1) {
            throw new CommonException("error.task.create.failed");
        }
        return new TaskConvertor().doToEntity(taskMapper.selectByPrimaryKey(taskDO.getId()));
    }

    @Override
    public TaskE queryById(Long id) {
        TaskDO taskDO = taskMapper.selectByPrimaryKey(id);
        if (taskDO != null) {
            return taskConvertor.doToEntity(taskDO);
        } else {
            throw new CommonException("error.task.not.exist");
        }
    }

    @Override
    public Page<TaskE> list(PageRequest pageRequest) {
        Page<TaskDO> taskDOPage = PageHelper.doPageAndSort(
                pageRequest, () -> taskMapper.selectAll());
        return ConvertPageHelper.convertPage(
                taskDOPage, TaskE.class);

    }

    @Override
    public void deleteById(Long id) {
        if (taskMapper.selectByPrimaryKey(id) == null) {
            throw new CommonException("error.task.not.exist");
        }
        if (taskMapper.deleteByPrimaryKey(id) != 1) {
            throw new CommonException("error.task.delete.failed");
        }
    }

    @Override
    public void deleteByTaskNumber(String taskNumber) {
        TaskDO taskDO = taskMapper.queryByTaskNumber(taskNumber);
        if (taskDO == null) {
            throw new CommonException("error.task.not.exist");
        }
        if (taskMapper.deleteByPrimaryKey(taskDO.getId()) != 1) {
            throw new CommonException("error.task.delete.failed");
        }
    }

    @Override
    public TaskE update(TaskE taskE) {
        TaskDO taskDO = taskConvertor.entityToDo(taskE);
        if (taskMapper.updateByPrimaryKeySelective(taskDO) != 1) {
            throw new CommonException("error.task.update.failed");
        }
        return taskConvertor.doToEntity(taskMapper.selectByPrimaryKey(taskDO.getId()));
    }
}
