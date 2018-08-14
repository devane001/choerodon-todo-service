package io.choerodon.todo.api.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;

/**
 * @author dongfan117@gmail.com
 */
@RestController
@RequestMapping("/v1/test")
public class TestController {

    public TestController() {
    }

    @GetMapping("/projects/{project_id}")
    @Permission(level = ResourceLevel.PROJECT)
    public String testProject(@PathVariable(name = "project_id") Long projectId) {
        return "ok";
    }

    @GetMapping("/organization/{organization_id}")
    @Permission(level = ResourceLevel.ORGANIZATION)
    public String testOrg(@PathVariable(name = "organization_id") Long organizationId) {
        return "ok";
    }

    @GetMapping("/site")
    @Permission(level = ResourceLevel.SITE)
    public String testSite() {
        return "ok";
    }

    @GetMapping("/login")
    @Permission(level = ResourceLevel.SITE, permissionLogin = true)
    public String testLogin() {
        return "ok";
    }

    @GetMapping("/public")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    public String testPublic() {
        return "ok";
    }
}
