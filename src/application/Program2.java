package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
 	    System.out.println("=== TEST 1: department findById ==="); 
 	    Department department = departmentDao.findById(1); 
	    System.out.println(department);
		
		System.out.println("\n=== TEST 2: deparment findByAll ===");
		List<Department> list = departmentDao.findAll();		
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDepartment = new Department(null, "Toys");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());

		System.out.println("\n=== TEST 4: department update ===");
		newDepartment = departmentDao.findById(1);
		newDepartment.setName("Brazilian Tools");
		departmentDao.update(newDepartment);
		System.out.println("Updated completed");
		
		System.out.println("\n=== TEST 5: department delete ===");
		System.out.println("Enter id for delete test:");
		int id = sc.nextInt();
		departmentDao.deleteById(5);
		System.out.println("Delete completed");		
	}
}
