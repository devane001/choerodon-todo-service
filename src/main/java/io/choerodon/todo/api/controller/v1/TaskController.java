package io.choerodon.todo.api.controller.v1;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.choerodon.todo.api.dto.TaskDTO;
import io.choerodon.todo.app.service.TaskService;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "创建task")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.create(taskDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "根据id删除task")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @DeleteMapping("/taskNumber/{taskNumber}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "根据TaskNumber删除task")
    public void deleteByTaskNumber(@PathVariable String taskNumber) {
        taskService.deleteByTaskNumber(taskNumber);
    }

    @PostMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "更新task")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        taskDTO.setId(id);
        return new ResponseEntity<>(taskService.update(taskDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "查询task")
    public ResponseEntity<TaskDTO> query(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.queryById(id), HttpStatus.OK);
    }

    @GetMapping()
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "查询所有的task")
    public ResponseEntity<Page<TaskDTO>> list(@ApiIgnore
                                              @SortDefault(value = "id", direction = Sort.Direction.ASC) PageRequest pageRequest) {
        return new ResponseEntity<Page<TaskDTO>>(taskService.list(pageRequest), HttpStatus.OK);
    }

}
