package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManageExternalTestData {

	public ArrayList<String> getdata(String testcasename, String sheetname) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		// load and read excel sheet using fileinputstream
		FileInputStream fis = new FileInputStream("C:\\Users\\developer\\eclipse-workspace\\DemoEcommerceAutomation\\src\\main\\java\\resources\\DemoEcommerceAutomation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// fetch the number of sheet present in the excel
		int sheets = workbook.getNumberOfSheets();
		

		for (int i = 0; i < sheets; i++) {

			// Itentifying the sheet name testdata by scanning all sheet present in excel
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetname)) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Identify Testcase column by scanning 1st row
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("Test_case_ID")) {

						coloumn = k;
					}
					k++;
				}

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename)) {

						Iterator<Cell> cellvalue = r.cellIterator();
						while (cellvalue.hasNext()) {

							Cell c = cellvalue.next();
							if (c.getCellType() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

						}
					}

				}

			}

		}
		workbook.close();
		return a;

	}

}
