package homework;

import pojo.Department;

import java.util.List;

public interface DepartmentInterface {
    Integer insertDepartment(Department dept);

    Integer updateDepartment(Department dept);

    Integer deleteDepartment(Department dept);

    List<Department> selectDepartment(Department dept);
}
