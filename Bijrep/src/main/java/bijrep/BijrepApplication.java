package bijrep;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.poi.ss.usermodel.*;

import bijrep.repo.CustomerRepository;
import bijrep.repo.OrderRepository;
import bijrep.repo.ProductRepository;
import java.util.*;

import bijrep.model.Customer;
import bijrep.model.Product;
import bijrep.model.Orders;
import org.apache.commons.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SpringBootApplication
public class BijrepApplication implements ApplicationRunner {
	
	@Autowired
	private CustomerRepository crepo;
	
	@Autowired
	private OrderRepository orepo;
	
	@Autowired
	private ProductRepository prepo;
	
	private List<String> customers = new ArrayList<>();
	private List<String> products = new ArrayList<>();
	private List<String> orders = new ArrayList<>();

	private List<Customer> cArr = new ArrayList<>();
	private List<Product> pArr = new ArrayList<>();
	private List<Orders> oArr = new ArrayList<>();
	
	public static void main(String[] args) {
		SpringApplication.run(BijrepApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		DataFormatter formatter = new DataFormatter();

		// find file
		FileInputStream inp = new FileInputStream("C:\\Users\\Bill Malemba\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\Bijrep\\Blue sales report1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inp);
        int cnum = 1;
        int pnum = 1;
        int onum = 7;
        //// travel to various worksheets and store info.
        
        /// start with customers worksheet
        
        XSSFSheet worksheet = workbook.getSheetAt(2);
        
        for (int i = 4; i < 13; i++) { 
            XSSFRow row = worksheet.getRow(i);
            
            XSSFCell cell = row.getCell(cnum);

            String cellvalue = formatter.formatCellValue(cell);
            
            /// store customer NAMES
             if (!cellvalue.equals(null)) {
             String customer = cellvalue;
         	 customers.add(customer); 
         	 
         	 cnum++;
         	     }               
             }        
         
        
        /// travel to products worksheets
        
        XSSFSheet worksheet1 = workbook.getSheetAt(1);
        
        
        for (int i = 4; i < 14; i++) { 
            XSSFRow row = worksheet.getRow(i);

             XSSFCell cell = row.getCell(pnum);
             String cellvalue = formatter.formatCellValue(cell);
             //// STORE product NAMES     
             if (!cellvalue.equals(null)) { 
             String product = cellvalue;
         	 products.add(product);  
         	 
         	 pnum++;
         	 
             }
        }
   
        
        
        /// travel to orders
        
        XSSFSheet worksheet2 = workbook.getSheetAt(0);
        
        for (int i = 2; i < 12; i++) { 
            XSSFRow row = worksheet.getRow(i);            

             XSSFCell cell = row.getCell(onum);
             String cellvalue = formatter.formatCellValue(cell);
        
             String order = cellvalue;
         	 orders.add(order);     
         	 onum++;
        
        }        
        
                
        /// iterate through arrays, and initialize objects which will then be saved and sit in repo.
        
        for (String order : orders) {
        	Orders o1 = new Orders();
        	o1.setAmount(order.valueOf(order));
        	
        	for (String customer : customers) {
            	Customer c1 = new Customer();
            	c1.setName(customer.valueOf(customer));
            	
    //        	c1.setOrders(new ArrayList<>());
    //        	c1.getOrders().add(o1);
            	
            	o1.setCustomer(c1);
            	
            	c1.setTotal(o1.getTotal());
            	            	
            	cArr.add(c1);

                c1 = crepo.save(c1);

            	o1 = orepo.save(o1);

            	
            	
                
                
            	
///            	for(Customer custs : cArr) {
///            		if (custs.getId() == c1.getId()) {
///            			c1.setId(custs.getId() + 1);
///            			cArr.add(c1);
///            		}
///            		else {
///            			cArr.add(c1);
///            		}
///            	}
            	
        ///    	cArr.add(c1);
        	}
            
        	for (String product : products) {
            		Product p1 = new Product();
            		p1.setName(product.valueOf(product));
 //           		p1.setOrders(new ArrayList<>());
 //           		p1.getOrders().add(o1);
            		
            		o1.setProducts(new ArrayList<>());
            		o1.getProducts().add(p1);
            		
            	    p1 = prepo.save(p1);
            	        
            	    o1 = orepo.save(o1);
            	    
///            		for (Product prods : pArr) {
///            			if (prods.getId() == p1.getId()) {
///            				p1.setId(prods.getId() + 1);
///            				pArr.add(p1);
///            			}
            			
///            			else {
///            				pArr.add(p1);
//            			}
            		 
///            		}
    ////        		pArr.add(p1);
            		
            		
        	     } // close products for loop
        		
        	    oArr.add(o1);
                o1 = orepo.save(o1);
                
///        	for (Orders ords : oArr) {
///        		if (ords.getId() == o1.getId()) {
///        			o1.setId(ords.getId() + 1);
///        			oArr.add(o1);
///        		}
///        		else {
///        			oArr.add(o1);
///        		}
///        	}
         /////   	oArr.add(o1);
            	
            
        	
//        for (Customer c : cArr) {
//        	c = crepo.save(c);
//        }
        
//        for (Product p : pArr) {
//        	p = prepo.save(p);
//        }
        
//        for (Orders o : oArr) {
//        	o = orepo.save(o);
//        }
        
		
        }
		 ///// process information
	
	}

}
