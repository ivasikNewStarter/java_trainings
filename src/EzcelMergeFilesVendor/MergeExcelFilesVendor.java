package EzcelMergeFilesVendor;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * merge 13 files xlsx
 */
public class MergeExcelFilesVendor {
    private static Workbook wb1,wb2,wb3,wb4,wb5,wb6,wb7,wb8,wb9,wb10,wb11;
    private static FileInputStream fis1,fis2,fis3,fis4,fis5,fis6,fis7,fis8,fis9,fis10,fis11;

    public static void main(String[] args) {


        try {
            // get input excel files
            fis1 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\WM.xlsx");
            fis2 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\AIAF.xlsx");
            fis3 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\CDS.xlsx");
            fis4 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\STAMDATA.xlsx");
            fis5 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\KOSCOM.xlsx");
            fis6 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\OEKB.xlsx");
            fis7 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\ICMA.xlsx");
            fis8 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\PROPRIS.xlsx");
            fis9 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\MILSE.xlsx");
            fis10 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\CIBS.xlsx");
            fis11 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\AIAF BOND.xlsx");

            //FileInputStream excellFile4 = new FileInputStream(new File(
            //        "C:\\Users\\u0139221\\Desktop\\Merge\\CMO.xlsx"));

            // Create Workbook instance holding reference to .xlsx file
            wb1 = WorkbookFactory.create(fis1);
            wb2 = WorkbookFactory.create(fis2);
            wb3 = WorkbookFactory.create(fis3);
            wb4 = WorkbookFactory.create(fis4);
            wb5 = WorkbookFactory.create(fis5);
            wb6 = WorkbookFactory.create(fis6);
            wb7 = WorkbookFactory.create(fis7);
            wb8 = WorkbookFactory.create(fis8);
            wb9 = WorkbookFactory.create(fis9);
            wb10 = WorkbookFactory.create(fis10);
            wb11 = WorkbookFactory.create(fis11);

            // Get first/desired sheet from the workbook
            Sheet mainSheet = wb1.getSheetAt(0);
            Sheet sheet2 = wb2.getSheetAt(0);
            Sheet sheet3 = wb3.getSheetAt(0);
            Sheet sheet4 = wb4.getSheetAt(0);
            Sheet sheet5 = wb5.getSheetAt(0);
            Sheet sheet6 = wb6.getSheetAt(0);
            Sheet sheet7 = wb7.getSheetAt(0);
            Sheet sheet8 = wb8.getSheetAt(0);
            Sheet sheet9 = wb9.getSheetAt(0);
            Sheet sheet10 = wb10.getSheetAt(0);
            Sheet sheet11 = wb11.getSheetAt(0);

            // XSSFSheet sheet4 = workbook3.getSheetAt(0);

            // add sheet2 to mainSheet
            addSheet(mainSheet, sheet2, mapHeaders(sheet2, mainSheet));
            fis1.close();
            fis2.close();
            addSheet(mainSheet, sheet3, mapHeaders(sheet3, mainSheet));
            fis3.close();
            addSheet(mainSheet, sheet4, mapHeaders(sheet4, mainSheet));
            fis4.close();
            addSheet(mainSheet, sheet5, mapHeaders(sheet5, mainSheet));
            fis5.close();
            addSheet(mainSheet, sheet6, mapHeaders(sheet6, mainSheet));
            fis6.close();
            addSheet(mainSheet, sheet7, mapHeaders(sheet7, mainSheet));
            fis7.close();
            addSheet(mainSheet, sheet8, mapHeaders(sheet8, mainSheet));
            fis8.close();
            addSheet(mainSheet, sheet9, mapHeaders(sheet9, mainSheet));
            fis9.close();
            addSheet(mainSheet, sheet10, mapHeaders(sheet10, mainSheet));
            fis10.close();
            addSheet(mainSheet, sheet11, mapHeaders(sheet11, mainSheet));
            fis11.close();


            // save merged file
            File mergedFile = new File("C:\\Users\\u0139221\\Desktop\\Main\\Vendor\\SummaryReport.xlsx");
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
