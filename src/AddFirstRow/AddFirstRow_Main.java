package AddFirstRow;

import org.apache.poi.ss.formula.functions.Value;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by u0139221 on 12/27/2019.
 */
public class AddFirstRow_Main {
    private static String excelFilePath = ("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\SummaryReport.xlsx");
    //private static String[] columns = {"Name", "Email"};
    private static FileInputStream fis1;
    private static Workbook wb1;
    private static int AIndex;
    private static int BIndex;

    public static void main(String[] args) throws Exception {
        AddFirstRow_Main a = new AddFirstRow_Main();

        //AddRow();
        a.readingExcel(excelFilePath);

    }

     // it'w works
    static void AddRow() throws IOException {
        fis1 = new FileInputStream("C:\\Users\\u0139221\\Desktop\\Main\\Rated\\SummaryReport.xlsx");
        wb1 = new XSSFWorkbook(fis1);
        Sheet sheet = wb1.getSheetAt(0);
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Rating_Agency");
        header.createCell(1).setCellValue("Feed_Issue");
        header.createCell(2).setCellValue("Vendor");
        header.createCell(3).setCellValue("Bucket");
        header.createCell(4).setCellValue("CUCIP");
        header.createCell(5).setCellValue("ISIN");
        header.createCell(6).setCellValue("ISIN_Govcorp");
        header.createCell(7).setCellValue("Feed_Details");
        header.createCell(8).setCellValue("QC Comment");
        header.createCell(9).setCellValue("Pass/Fail");
        header.createCell(10).setCellValue("Final Indetifier");
        try {
            FileOutputStream out = new FileOutputStream(new File(excelFilePath));
            wb1.write(out);
            out.close();
            System.out.println("First Row updated");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readingExcel(String fileName) throws Exception {
        int columnIndexAnother = 4;
        int columnIndexCheck = 5;
        try (FileInputStream file = new FileInputStream(new File(fileName))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            int counter = 0;
            for (Row row : sheet) {
                int columnIndex = 10;
                row = CellUtil.getRow(counter, sheet);
                Cell cell = CellUtil.getCell(row, columnIndexCheck);
                Cell Acell = CellUtil.getCell(row, columnIndex);
                Cell Bcell = CellUtil.getCell(row, columnIndexAnother);
                if (cell != null)
                    cell.setCellValue((RichTextString) Acell);

                if (cell == null)
                    cell.setCellValue((RichTextString) Bcell);
                counter++;
            }

            FileOutputStream outFile = new FileOutputStream(new File(fileName));
            workbook.write(outFile);
            outFile.close();
        }
    }
}





