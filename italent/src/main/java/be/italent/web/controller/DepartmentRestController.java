package be.italent.web.controller;

import be.italent.model.Department;
import be.italent.service.DepartmentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {
    private static final Logger logger = LogManager.getLogger(DepartmentRestController.class.getName());

    @Autowired
    private DepartmentService departmentService;

    /**
     * Retrieve a list with {@link Department}s
     *
     * @return {@link List} containing a list of {@link Department}s
     */
    @Secured({"Docent", "Student"})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

}