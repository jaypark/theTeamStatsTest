package utils;

import org.testng.annotations.DataProvider;
import java.io.IOException;

/**
 * This Excel DataProviders will provide access to a specific Excel file.
 * Used for data-driven tests.
 */
public class DataProviders {
    private final String sheetName = "TeamNames";

    @DataProvider(name = "TeamNames")
    public String[] getTeamNames() throws IOException {
        String path = System.getProperty("user.dir") + "/resources/testData/Userdata.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowNum = xl.getRowCount(sheetName);
        String[] testData = new String[rowNum];
        for (int i = 1; i <= rowNum; i++) {
            testData[i - 1] = xl.getCellData(sheetName, i, 0);
        }

        return testData;
    }
}
