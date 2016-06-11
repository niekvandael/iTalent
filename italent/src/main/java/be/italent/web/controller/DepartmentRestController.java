package be.italent.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.italent.model.Department;
import be.italent.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * Retrieve a list with {@link Department}s
	 *
	 * @return {@link List} containing a list of {@link Department}s
     */
	@Secured({"Docent", "Student"})
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public List<Department> getDepartments(){
		return departmentService.getDepartments();
	}
	
}