package io.choerodon.todo.infra.mapper;


import org.apache.ibatis.annotations.Param;

import io.choerodon.mybatis.common.BaseMapper;
import io.choerodon.todo.infra.dataobject.TaskDO;

public interface TaskMapper extends BaseMapper<TaskDO> {
    TaskDO queryByTaskNumber(@Param("taskNumber") String taskNumber);
}
