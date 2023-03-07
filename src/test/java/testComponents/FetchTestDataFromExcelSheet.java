package testComponents;

import java.io.IOException;
import java.util.ArrayList;

public class FetchTestDataFromExcelSheet {

	public String testdata;

	public String fetch_testdata(String tID, String sheetname) throws IOException {

		// Test Data from excel
		ManageExternalTestData tdata = new ManageExternalTestData();

		ArrayList<String> ad = tdata.getdata(tID, sheetname);
		for (int i = 2; i <= 2; i++) {

			Object test_product = ad.get(i);
			testdata = test_product.toString();
		}
		return testdata;

	}
}
