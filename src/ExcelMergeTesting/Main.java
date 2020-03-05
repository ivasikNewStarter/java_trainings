package ExcelMergeTesting;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.xssf.usermodel.*;
import javax.swing.*;
/**
 * Created by u0139221 on 12/13/2019.
 */
public class Main {

    public static void main(String[] args) {

        try {
            // excel files
            FileInputStream excellFile1 = new FileInputStream(new File(
                    "C:\\Users\\u0139221\\Desktop\\Merge\\Fitch.xlsx"));
            FileInputStream excellFile2 = new FileInputStream(new File(
                    "C:\\Users\\u0139221\\Desktop\\Merge\\Moody's.xlsx"));
           // FileInputStream excellFile3 = new FileInputStream(new File(
            //        "C:\\Users\\u0139221\\Desktop\\Merge\\SnP.xlsx"));


            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook1 = new XSSFWorkbook(excellFile1);
            XSSFWorkbook workbook2 = new XSSFWorkbook(excellFile2);
           // XSSFWorkbook workbook3 = new XSSFWorkbook(excellFile3);


            // Get first/desired sheet from the workbook
            XSSFSheet mainSheet = workbook1.getSheetAt(0);
            XSSFSheet sheet2 = workbook2.getSheetAt(0);
           // XSSFSheet sheet3 = workbook3.getSheetAt(0);


            // sheet2 to mainSheet
            addSheetDifferentHeaders(mainSheet, sheet2, mapHeaders(sheet2, mainSheet));

            // error java.lang.NullPointerException
            // sheet3 to mainSheet
            //addSheetDifferentHeaders(mainSheet, sheet3, mapHeaders(sheet3, mainSheet));

            // end of add

            excellFile1.close();
            excellFile2.close();
            //excellFile3.close();


            // save merged file
            File mergedFile = new File("C:\\Users\\u0139221\\Desktop\\Merge\\Summary.xlsx");
            if (!mergedFile.exists()) {
                mergedFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(mergedFile);
            workbook1.write(out);
            out.close();
            System.out.println("Files were merged successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addSheetDifferentHeaders(XSSFSheet mainSheet, XSSFSheet sheet, HashMap<Integer, Integer> map) {

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
                switch (cell.getCellType()) {
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
                        break;
                }
            }
        }
    }

    // results MAP of <secondary sheet, main sheet>``````
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
