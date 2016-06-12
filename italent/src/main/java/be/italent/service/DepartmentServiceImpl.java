package be.italent.service;

import be.italent.model.Department;
import be.italent.repository.DepartmentRepo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class.getName());

    @Autowired
    private DepartmentRepo departmentRepo;

    /**
     * Retrieve a list with {@link Department}s
     *
     * @return {@link List} containing a list of {@link Department}s
     */
    @Override
    public List<Department> getDepartments() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        return departmentRepo.findAll();
    }

}
