package ExcelMergeFiles;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class MergeExcelsFilesRated {

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
            //wb1 = new XSSFWorkbook(fis1);
            //wb2 = new XSSFWorkbook(fis2);
            //wb3 = new XSSFWorkbook(fis3);
            //XSSFWorkbook workbook4 = new XSSFWorkbook(excellFile4);

            // Get first/desired sheet from the workbook
            Sheet mainSheet = wb1.getSheetAt(0);
            Sheet sheet2 = wb2.getSheetAt(0);
            Sheet sheet3 = wb3.getSheetAt(0);
            // XSSFSheet sheet4 = workbook3.getSheetAt(0);

            // add sheet2 to mainSheet

            addSheet(mainSheet, sheet2, mapHeaders(sheet2, mainSheet));
            fis1.close();
            fis2.close();
            addSheet(mainSheet, sheet3, mapHeaders(sheet3, mainSheet));
            fis3.close();
            // addSheet(mainSheet, sheet4, mapHeaders(sheet4, mainSheet));
            // excellFile4.close();
            //addFirstRow();
            // save merged file
            File mergedFile = new File("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\SummaryReport.xlsx");
            if (!mergedFile.exists()) {
                mergedFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(mergedFile);
            //addFirstRow ();
            wb1.write(out);
            out.close();
            System.out.println("Files were merged successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public static void addFirstRow () {

       String excelFilePath = ("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\Moody's.xlsx");
        try{
            OutputStream fileOut = new FileOutputStream(excelFilePath);
            Workbook workbook = WorkbookFactory.create(fileOut);
            Sheet mainSheet = workbook.getSheetAt(0);
            //Header header = mainSheet.getHeader();
            Row headerN = mainSheet.createRow(7);
            headerN.createCell(7).setCellValue("Header1");


        }catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }
    }

    public static void addSheet(Sheet mainSheet, Sheet sheet, HashMap<Integer, Integer> map) {

        //get column number
        Set<Integer> colNumbs = map.keySet();
        // map for cell styles
        Map<Integer, CellStyle> styleMap = new HashMap<>();

        // This parameter is for appending sheet rows to mergedSheet in the end
        int len = mainSheet.getLastRowNum();
        for (int j = sheet.getFirstRowNum() + 1; j <= sheet.getLastRowNum(); j++) {

            Row row = sheet.getRow(j);
            if (row == null) {
                continue;
            }
            // Create row in main sheet

                Row mrow = mainSheet.createRow(len + j);

            for (Integer k : colNumbs) {
                Cell cell = row.getCell(k.intValue());

                // Create column in main sheet
                Cell mcell = mrow.createCell(map.get(k).intValue());


                if (cell == null) {
                    continue;
                }
                if (cell.getSheet().getWorkbook() == mcell.getSheet()
                        .getWorkbook()) {
                    mcell.setCellStyle(cell.getCellStyle());
                } else {
                    int stHashCode = cell.getCellStyle().hashCode();
                    CellStyle newCellStyle = styleMap.get(stHashCode);
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
                        //mcell.setCellErrorValue(FormulaError._NO_ERROR);
                        mcell.setCellErrorValue(cell.getErrorCellValue());
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
    public static HashMap<Integer, Integer> mapHeaders(Sheet sheet1,
                                                       Sheet sheet2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Row row1 = sheet1.getRow(0);
        Row row2 = sheet2.getRow(0);
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
