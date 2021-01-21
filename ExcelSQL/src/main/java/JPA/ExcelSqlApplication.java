package JPA;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import JPA.model.Orders;
import JPA.repos.OrdersRepository;

@SpringBootApplication
public class ExcelSqlApplication implements ApplicationRunner{
	
	@Autowired
	private OrdersRepository orepo;
	public static List<String> amountArr = new ArrayList<>();
	public static List<String> prodArr = new ArrayList<>();
	
	public static void main(String[] args) {
		SpringApplication.run(ExcelSqlApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		DataFormatter formatter = new DataFormatter();
		
		FileInputStream inp = new FileInputStream("C:\\Users\\Bill Malemba\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\ExcelSQL\\Blue sales report1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inp);
		XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        XSSFSheet worksheet = workbook.getSheetAt(0);
    //    XSSFRow row = worksheet.getRow(7);
  //      Iterator<Row> rows = worksheet.iterator();
                 
        
        for (int i = 2; i<33; i++) {
        	/// set row to 2, and increment within loop
           XSSFRow row = worksheet.getRow(i);
                     
        	   XSSFCell prodcell = row.getCell(1);
        	   XSSFCell ordCell = row.getCell(7);
           	
                String products = formatter.formatCellValue(prodcell);
                
                /// initialise within the loop so that we can see all the rows
                ///i.e. initialise a new object to represent each row in excel sheet. 
        		Orders orders = new Orders();
           		orders.setProducts(products);
           			
           		/// find a way to format formula value
           		
           		// in case you get a FormulaParseException, "convert to range" in Excel File
           	    String amounts = formatter.formatCellValue(ordCell, evaluator);
           			
           		orders.setAmount(amounts);
        
           		orders = orepo.save(orders);
  //         		amountArr.add(amounts);
        }
	}  	
}
      
// }
