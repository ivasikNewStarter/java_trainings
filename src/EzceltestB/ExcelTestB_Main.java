package EzceltestB;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;
import javax.swing.*;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Merge 3 Excel Files with the same headers but it can be in different columns.
 */
public class ExcelTestB_Main {
    private static Workbook wb1, wb2,wb3,book;
    private static FileInputStream fis1, fis2, fis3;

    public static void main(String[] args) {
        Workbook wb1, wb2,wb3,book;
        FileInputStream fis1, fis2, fis3;
        try {
            // get input excel files
            fis1 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\Moody's.xlsx");
            fis2 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\Fitch.xlsx");
            //fis3 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\SnP.xlsx");

            // Create Workbook instance holding reference to .xlsx file
            wb1 = WorkbookFactory.create(fis1);
            wb2 = WorkbookFactory.create(fis2);
           // wb3 = WorkbookFactory.create(fis3);

            // Get first/desired sheet from the workbook
            Sheet mainSheet = wb1.getSheetAt(0);
            Sheet sheet2 = wb2.getSheetAt(0);
         //   Sheet sheet3 = wb3.getSheetAt(0);

            // add sheet2 to mainSheet
            addSheet(mainSheet, sheet2, mapHeaders(sheet2, mainSheet));
            fis1.close();
            fis2.close();

            // add sheet2 to  // add sheet3 to mainSheet
          //  addSheet(mainSheet, sheet3, mapHeaders(sheet3, mainSheet));
          //  fis3.close();

            // save merged file
            File mergedFile = new File("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\SummaryReport.xlsx");
            if (!mergedFile.exists()) {
                mergedFile.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(mergedFile);
            //addFirstRow();
            wb1.write(out);
            out.close();
            System.out.println("Files were merged successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addFirstRow () {

        String excelFilePath = ("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\SummaryReport.xlsx");
        try{
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet mainSheet = workbook.getSheetAt(0);
            Row header = mainSheet.createRow(0);
            header.createCell(4).setCellValue("Header1");
            header.createCell(5).setCellValue("Header2");
            header.createCell(6).setCellValue("Header3");
            header.createCell(7).setCellValue("Header4");

        }catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }
    }

    public static void addSheet(Sheet mainSheet, Sheet sheet, HashMap<Integer, Integer> map) {

        //get column number
        Set<Integer> colNumbs = map.keySet();
        // map for cell styles
        Map<Integer, CellStyle> styleMap = new HashMap<Integer, CellStyle>();

        // This parameter is for appending sheet rows to mergedSheet in the end
        int len = mainSheet.getLastRowNum();
        for (int j = sheet.getFirstRowNum() + 1; j <= sheet.getLastRowNum(); j++) {

            Row row = sheet.getRow(j);

            // Create row in main sheet
            Row mrow = mainSheet.createRow(len + j);

            for (Integer k : colNumbs) {
                Cell cell = row.getCell(k.intValue());

                // Create column in main sheet
                Cell mcell = mrow.createCell(map.get(k).intValue());

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

                switch (cell.getCellType()) {
                    case STRING:
                        mcell.setCellValue(cell.getRichStringCellValue());
                        break;
                    case _NONE:
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
                        mcell.setCellErrorValue(cell.getErrorCellValue());
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

 /*   public static void mergeSelectedFiles(File file) throws IOException {
        book = WorkbookFactory.create(file);
        System.out.println(file.getName());
        String filepath = "C:\\Users\\u0139221\\Desktop\\Merge";
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        // Show the dialog; wait until dialog is closed
        chooser.showOpenDialog(null);

        // Retrieve the selected files.
        File[] fList = chooser.getSelectedFiles();
        //File selectedFile = fc.showOpenDialog(null);
        //File[] fList = chooser.listFiles();
        for (File file1 : fList) {
            if (file1.isFile()) {
                String ParticularFile = file1.getName();
                FileInputStream fin = new FileInputStream(new File(filepath + "\\" + ParticularFile));
                Workbook b = new XSSFWorkbook(fin);
                for (int i = 0; i < b.getNumberOfSheets(); i++) {
                    Sheet sheet = book.createSheet(b.getSheetName(i));
                    copySheets(book, sheet, b.getSheetAt(i));
                    System.out.println("Copying..");
                }
            }
            try {
                writeFile((XSSFWorkbook) book, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    protected static void writeFile(XSSFWorkbook book, File file) throws Exception {
        FileOutputStream out = new FileOutputStream(file);
        book.write(out);
        out.close();
    }
    private static void copySheets(Workbook newWorkbook, Sheet newSheet, Sheet sheet) {
        copySheets(newWorkbook, newSheet, sheet, true);
    }

    private static void copySheets(Workbook newWorkbook, Sheet newSheet, Sheet sheet, boolean copyStyle) {
        int newRownumber = newSheet.getLastRowNum();
        int maxColumnNum = 0;
        Map<Integer, CellStyle> styleMap = (copyStyle) ? new HashMap<>() : null;

        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            Row srcRow = (Row) sheet.getRow(i);
            Row destRow = newSheet.createRow(i + newRownumber);
            if (srcRow != null) {
                copyRow(newWorkbook, sheet, newSheet, srcRow, destRow, styleMap);
                if (srcRow.getLastCellNum() > maxColumnNum) {
                    maxColumnNum = srcRow.getLastCellNum();
                }
            }
        }
        for (int i = 0; i <= maxColumnNum; i++) {
            newSheet.setColumnWidth(i, sheet.getColumnWidth(i));
        }
    }
    public static void copyRow(Workbook newWorkbook, Sheet srcSheet, Sheet destSheet, Row srcRow, Row destRow, Map<Integer, CellStyle> styleMap) {
        destRow.setHeight(srcRow.getHeight());
        for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
            Cell oldCell = srcRow.getCell(j);
            Cell newCell = destRow.getCell(j);
            if (oldCell != null) {
                if (newCell == null) {
                    newCell = destRow.createCell(j);
                }
                copyCell(newWorkbook, oldCell, newCell, styleMap);
            }
        }
    }

    public static void copyCell(Workbook newWorkbook, Cell oldCell, Cell newCell, Map<Integer, CellStyle> styleMap) {
        if (styleMap != null) {
            int stHashCode = oldCell.getCellStyle().hashCode();
            CellStyle newCellStyle = styleMap.get(stHashCode);
            if (newCellStyle == null) {
                newCellStyle = newWorkbook.createCellStyle();
                newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
                styleMap.put(stHashCode, newCellStyle);
            }
            newCell.setCellStyle(newCellStyle);
        }
        switch (oldCell.getCellType()) {
            case STRING:
                newCell.setCellValue(oldCell.getRichStringCellValue());
                break;
            case NUMERIC:
                newCell.setCellValue(oldCell.getNumericCellValue());
                break;

            case BLANK:
                newCell.setCellValue(oldCell.getStringCellValue());
                break;
            case BOOLEAN:
                newCell.setCellValue(oldCell.getBooleanCellValue());
                break;
            case ERROR:
                //newCell.setCellErrorValue(FormulaError._NO_ERROR);
                newCell.setCellErrorValue(oldCell.getErrorCellValue());
                break;
            case FORMULA:
                newCell.setCellFormula(oldCell.getCellFormula());
                break;
            default:
                break;
        }

    }
*/
}


