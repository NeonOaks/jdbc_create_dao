package application;

import java.sql.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: Seller FindByid ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: Seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
			}
			
		System.out.println("\n=== TEST 3: Seller FindAll ===");
		list = sellerDao.findAll();
		for(Seller obj1 : list) {
			System.out.println(obj1);
			}
		
		System.out.println("\n=== TEST 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Jack", "jack@gmail.com", new Date(0),7800.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
  }
}
