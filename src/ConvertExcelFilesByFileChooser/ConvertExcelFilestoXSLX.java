package ConvertExcelFilesByFileChooser;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by u0139221 on 12/23/2019.
 */
public class ConvertExcelFilestoXSLX {



    public String convertXLS(String xlsFilePath) {
        Map cellStyleMap = new HashMap();
        String xlsxFilePath =null;
        Workbook workbookIn = null;
        File xlsxFile;
        Workbook workbookOut = null;
        OutputStream out = null;
        String XLSX = ".xlsx";

        try {
            InputStream inputStream = new FileInputStream(xlsFilePath);
            xlsxFilePath = xlsFilePath.substring(0, xlsFilePath.lastIndexOf('.')) + XLSX;
            workbookIn = new HSSFWorkbook(inputStream);
            xlsxFile = new File(xlsxFilePath);
            if (xlsxFile.exists())
                xlsxFile.delete();
            workbookOut = new XSSFWorkbook();
            int sheetCnt = workbookIn.getNumberOfSheets();

            for (int i = 0; i < sheetCnt; i++) {
                Sheet sheetIn = workbookIn.getSheetAt(i);
                Sheet sheetOut = workbookOut.createSheet(sheetIn.getSheetName());
                Iterator rowIt = sheetIn.rowIterator();
                while (rowIt.hasNext()) {
                    Row rowIn = (Row) rowIt.next();
                    Row rowOut = sheetOut.createRow(rowIn.getRowNum());
                    copyRowProperties(rowOut, rowIn,cellStyleMap);
                }
            }
            out = new BufferedOutputStream(new FileOutputStream(xlsxFile));
            workbookOut.write(out);
        } catch (Exception ex) {
            System.err.println("Exception Occurred inside transFormXLS2XLSX :: file Name :: " + xlsFilePath
                    + ":: reason ::" + ex.getMessage());
            ex.printStackTrace();
            xlsxFilePath = null;
        } finally {
            try {
                if (workbookOut != null)
                    workbookOut.close();
                if (workbookIn != null)
                    workbookIn.close();
                if (out != null)
                    out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return xlsxFilePath;
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            ConvertExcelFilestoXSLX f = new ConvertExcelFilestoXSLX();
            String xlsF1 = "C:\\Users\\u0139221\\Desktop\\Main\\Rated\\Moody's.xls";//Source File Path
            String xlsF2 = "C:\\Users\\u0139221\\Desktop\\Main\\Rated\\Fitch.xls";
            String xlsF3 = "C:\\Users\\u0139221\\Desktop\\Main\\Rated\\SnP.xls";
            f.convertXLS(xlsF1); // Destination/Converted XLSX file Path
            f.convertXLS(xlsF2);
            f.convertXLS(xlsF3);
            f.deleteFiles(xlsF1);
            f.deleteFiles(xlsF2);
            f.deleteFiles(xlsF3);

            System.out.println("Files updated");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFiles (String xlsFilePath) {
        try
        {
            Files.deleteIfExists(Paths.get(xlsFilePath));
        } catch(IOException e) {
        }
    }


    private void copyRowProperties(Row rowOut, Row rowIn, Map cellStyleMap) {
        rowOut.setRowNum(rowIn.getRowNum());
        rowOut.setHeight(rowIn.getHeight());
        rowOut.setHeightInPoints(rowIn.getHeightInPoints());
        rowOut.setZeroHeight(rowIn.getZeroHeight());
        Iterator cellIt = rowIn.cellIterator();
        while (cellIt.hasNext()) {
            Cell cellIn = (Cell) cellIt.next();
            Cell cellOut = rowOut.createCell(cellIn.getColumnIndex(), cellIn.getCellType());
            rowOut.getSheet().setColumnWidth(cellOut.getColumnIndex(),
                    rowIn.getSheet().getColumnWidth(cellIn.getColumnIndex()));
            copyCellProperties(cellOut, cellIn, cellStyleMap);
        }

    }

    private void copyCellProperties(Cell cellOut, Cell cellIn, Map cellStyleMap) {

        Workbook wbOut = cellOut.getSheet().getWorkbook();
        HSSFPalette hssfPalette = ((HSSFWorkbook) cellIn.getSheet().getWorkbook()).getCustomPalette();
        switch (cellIn.getCellType()) {
            case BLANK:
                break;

            case BOOLEAN:
                cellOut.setCellValue(cellIn.getBooleanCellValue());
                break;

            case ERROR:
                cellOut.setCellValue(cellIn.getErrorCellValue());
                break;

            case FORMULA:
                cellOut.setCellFormula(cellIn.getCellFormula());
                break;

            case NUMERIC:
                cellOut.setCellValue(cellIn.getNumericCellValue());
                break;

            case STRING:
                cellOut.setCellValue(cellIn.getStringCellValue());
                break;
        }

        HSSFCellStyle styleIn = (HSSFCellStyle) cellIn.getCellStyle();
        XSSFCellStyle styleOut;


        if (cellStyleMap.get(styleIn.getIndex()) != null) {
            styleOut = (XSSFCellStyle) cellStyleMap.get(styleIn.getIndex());
        } else {
            styleOut = (XSSFCellStyle) wbOut.createCellStyle();
            styleOut.setAlignment(styleIn.getAlignment());
            DataFormat format = wbOut.createDataFormat();
            styleOut.setDataFormat(format.getFormat(styleIn.getDataFormatString()));
            HSSFColor forgroundColor = styleIn.getFillForegroundColorColor();
            if (forgroundColor != null) {
                short[] foregroundColorValues = forgroundColor.getTriplet();


                styleOut.setFillForegroundColor(new XSSFColor(new java.awt.Color(foregroundColorValues[0],
                        foregroundColorValues[1], foregroundColorValues[2])));
                styleOut.setFillPattern(styleIn.getFillPattern());
            }
            styleOut.setFillPattern(styleIn.getFillPattern());
            styleOut.setBorderBottom(styleIn.getBorderBottom());
            styleOut.setBorderLeft(styleIn.getBorderLeft());
            styleOut.setBorderRight(styleIn.getBorderRight());
            styleOut.setBorderTop(styleIn.getBorderTop());

             // bottom

            HSSFColor bottom = hssfPalette.getColor(styleIn.getBottomBorderColor());
            if (bottom != null) {
                short[] bottomColorArray = bottom.getTriplet();
                styleOut.setBottomBorderColor(new XSSFColor(new java.awt.Color(bottomColorArray[0],
                        bottomColorArray[1], bottomColorArray[2])));
            }
            HSSFColor top = hssfPalette.getColor(styleIn.getTopBorderColor());
            if (top != null) {
                short[] topColorArray = top.getTriplet();
                styleOut.setTopBorderColor(new XSSFColor(new java.awt.Color(topColorArray[0], topColorArray[1],
                        topColorArray[2])));
            }
            HSSFColor left = hssfPalette.getColor(styleIn.getLeftBorderColor());
            if (left != null) {
                short[] leftColorArray = left.getTriplet();
                styleOut.setLeftBorderColor(new XSSFColor(new java.awt.Color(leftColorArray[0], leftColorArray[1],
                        leftColorArray[2])));
            }
            HSSFColor right = hssfPalette.getColor(styleIn.getRightBorderColor());
            if (right != null) {
                short[] rightColorArray = right.getTriplet();
                styleOut.setRightBorderColor(new XSSFColor(new java.awt.Color(rightColorArray[0], rightColorArray[1],
                        rightColorArray[2])));
            }
            styleOut.setVerticalAlignment(styleIn.getVerticalAlignment());
            styleOut.setHidden(styleIn.getHidden());
            styleOut.setIndention(styleIn.getIndention());
            styleOut.setLocked(styleIn.getLocked());
            styleOut.setRotation(styleIn.getRotation());
            styleOut.setShrinkToFit(styleIn.getShrinkToFit());
            styleOut.setVerticalAlignment(styleIn.getVerticalAlignment());
            styleOut.setWrapText(styleIn.getWrapText());
            cellOut.setCellComment(cellIn.getCellComment());
            cellStyleMap.put(styleIn.getIndex(), styleOut);
        }
        cellOut.setCellStyle(styleOut);
    }
}
