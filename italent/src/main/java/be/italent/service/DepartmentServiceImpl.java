package be.italent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.italent.model.Department;
import be.italent.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;

	@Override
	public List<Department> getDepartments() {
		return departmentRepo.findAll();
	}
    
}
