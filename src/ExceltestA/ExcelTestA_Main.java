package ExceltestA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.*;

/**
 * Merge 4 Excel Files with the same headers but it can be in different columns.
 */
public class ExcelTestA_Main {
    private static Workbook wb1, wb2, wb3;
    private static FileInputStream fis1, fis2, fis3;

    public static void main(String[] args) {


        try {
            // get input excel files
            fis1 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\Moody's.xlsx");
            fis2 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\Fitch.xlsx");
            fis3 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\SnP.xlsx");
            //FileInputStream excellFile4 = new FileInputStream(new File(
            //        "C:\\Users\\u0139221\\Desktop\\Merge\\CMO.xlsx"));

            // Create Workbook instance holding reference to .xlsx file
            wb1 = WorkbookFactory.create(fis1);
            wb2 = WorkbookFactory.create(fis2);
            wb3 = WorkbookFactory.create(fis3);
            //wb1 =new XSSFWorkbook(fis1);
            //wb2 = new XSSFWorkbook(fis2);
            //wb3 = new XSSFWorkbook(fis3);
            //XSSFWorkbook workbook4 = new XSSFWorkbook(excellFile4);

            // Get first/desired sheet from the workbook
            XSSFSheet mainSheet = (XSSFSheet) wb1.getSheetAt(0);
            XSSFSheet sheet2 = (XSSFSheet) wb2.getSheetAt(0);
            XSSFSheet sheet3 = (XSSFSheet) wb3.getSheetAt(0);
            // XSSFSheet sheet4 = workbook3.getSheetAt(0);

            // add sheet2 to mainSheet
            addSheet(mainSheet, sheet2, mapHeaders(sheet2, mainSheet));
            fis1.close();
            fis2.close();
            addSheet(mainSheet, sheet3, mapHeaders(sheet3, mainSheet));
            fis3.close();
            // addSheet(mainSheet, sheet4, mapHeaders(sheet4, mainSheet));
            // excellFile4.close();
            // save merged file
            File mergedFile = new File("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\Summary.xlsx");
            if (!mergedFile.exists()) {
                mergedFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(mergedFile);
            wb1.write(out);
            out.close();
            System.out.println("Files were merged successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addSheet(XSSFSheet mainSheet, XSSFSheet sheet, HashMap<Integer, Integer> map) {

        //get column number
        Set<Integer> colNumbs = map.keySet();
        // map for cell styles
        Map<Integer, XSSFCellStyle> styleMap = new HashMap<Integer, XSSFCellStyle>();

        // This parameter is for appending sheet rows to mergedSheet in the end
        int len = mainSheet.getLastRowNum();
        for (int j = sheet.getFirstRowNum() + 1; j <= sheet.getLastRowNum(); j++) {

            XSSFRow row = sheet.getRow(j);

            // Create row in main sheet
            XSSFRow mrow = mainSheet.createRow(len + j);

            for (Integer k : colNumbs) {
                XSSFCell cell = row.getCell(k.intValue());

                // Create column in main sheet
                XSSFCell mcell = mrow.createCell(map.get(k).intValue());

                if (cell.getSheet().getWorkbook() == mcell.getSheet()
                        .getWorkbook()) {
                    mcell.setCellStyle(cell.getCellStyle());
                } else {
                    int stHashCode = cell.getCellStyle().hashCode();
                    XSSFCellStyle newCellStyle = styleMap.get(stHashCode);
                    if (newCellStyle == null) {
                        newCellStyle = mcell.getSheet().getWorkbook()
                                .createCellStyle();
                        newCellStyle.cloneStyleFrom(cell.getCellStyle());
                        styleMap.put(stHashCode, newCellStyle);
                    }
                    mcell.setCellStyle(newCellStyle);
                }

                // set value based on cell type
           /*     switch (cell.getCellType()) {
                    case FORMULA:
                        mcell.setCellFormula(cell.getCellFormula());
                        break;
                    case NUMERIC:
                        mcell.setCellValue(cell.getNumericCellValue());
                        break;
                    case STRING:
                        mcell.setCellValue(cell.getStringCellValue());
                        break;
                    case BLANK:
                        mcell.setCellValue(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        mcell.setCellValue(cell.getBooleanCellValue());
                        break;
                    case ERROR:
                        mcell.setCellErrorValue(cell.getErrorCellValue());
                        break;
                    default:
                        mcell.setCellValue(cell.getStringCellValue());
                        break;*/

                switch (cell.getCellType()) {
                    case STRING:
                        mcell.setCellValue(cell.getRichStringCellValue());
                        break;
                    case NUMERIC:
                        mcell.setCellValue(cell.getNumericCellValue());
                        break;
                    case BLANK:
                        mcell.setCellValue(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        mcell.setCellValue(cell.getBooleanCellValue());
                        break;
                    case ERROR:
                        mcell.setCellErrorValue(FormulaError._NO_ERROR);
                        // newCell.setCellErrorValue(cell.getErrorCellValue());
                        break;
                    case FORMULA:
                        mcell.setCellFormula(cell.getCellFormula());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    // results MAP of <secondary sheet, main sheet>
    public static HashMap<Integer, Integer> mapHeaders(XSSFSheet sheet1,
                                                       XSSFSheet sheet2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        XSSFRow row1 = sheet1.getRow(0);
        XSSFRow row2 = sheet2.getRow(0);
        for (int i = row1.getFirstCellNum(); i < row1.getLastCellNum(); i++) {
            for (int j = row2.getFirstCellNum(); j < row2.getLastCellNum(); j++) {
                if (row1.getCell(i).getStringCellValue()
                        .equals(row2.getCell(j).getStringCellValue())) {
                    map.put(new Integer(i), new Integer(j));
                }
            }
        }
        return map;
    }
}
