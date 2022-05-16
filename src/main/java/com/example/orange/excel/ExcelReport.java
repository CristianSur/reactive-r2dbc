package com.example.orange.excel;

import com.example.orange.controllers.ExchangerController;
import com.example.orange.util.PropertyReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;

public class ExcelReport {

    private static final String DB_URL = PropertyReader.JDBC_URL;
    private static final String POSTGRE_DRIVER = PropertyReader.POSTGRE_DRIVER;
    private static final String DB_USERNAME = PropertyReader.DATABASE_USERNAME;
    private static final String DB_PASSWORD = PropertyReader.DATABASE_PASSWORD;
    private static final String EXCEL_PATH = PropertyReader.EXCEL_PATH;

    private ExcelReport() { }

    static Logger log = LoggerFactory.getLogger(ExcelReport.class);

    public static void createExcel(String data) throws Exception {

        Class.forName(POSTGRE_DRIVER);
        Connection connection = DriverManager.getConnection(
                DB_URL, DB_USERNAME, DB_PASSWORD);

        Statement statement = connection.createStatement();

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM exchanger WHERE date = CURRENT_TIMESTAMP");;
        } catch (Exception e) {
        }

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet spreadsheet1
                = workbook.createSheet("test_data");
        XSSFRow row = spreadsheet1.createRow(0);
        XSSFCell cell;

        cell = row.createCell(0);
        cell.setCellValue("id");

        cell = row.createCell(1);
        cell.setCellValue("Operatorul");

       cell = row.createCell(2);
        cell.setCellValue("Valuta primita");

       cell = row.createCell(3);
        cell.setCellValue("Cursul");

       cell = row.createCell(4);
        cell.setCellValue("Cantitatea de valuta primitat");

        cell = row.createCell(5);
        cell.setCellValue("Valuta inmanata");

       cell = row.createCell(6);
        cell.setCellValue("Cantitatea de valuta ce a fost inmanata");

       cell = row.createCell(7);
        cell.setCellValue("Data");

        // 1'st row
        int i = 1;

        while (resultSet.next()) {
            row = spreadsheet1.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(resultSet.getLong("id"));

            ResultSet resultSet1 = connection.createStatement().executeQuery("SELECT first_name FROM operator WHERE id =" + resultSet.getLong("operator_id"));
            while (resultSet1.next()) {
                row.createCell(1).setCellValue(resultSet1.getString("first_name"));
            }

            ResultSet resultSet2 = connection.createStatement().executeQuery("SELECT name FROM currency WHERE id =" + resultSet.getLong("currency_id_received"));
            while (resultSet2.next()) {
                row.createCell(2).setCellValue(resultSet2.getString("name"));
            }

            cell = row.createCell(3);
            cell.setCellValue(resultSet.getLong("rate"));


            cell = row.createCell(4);
            cell.setCellValue(resultSet.getLong("received"));


            ResultSet resultSet3 = connection.createStatement().executeQuery("SELECT name FROM currency WHERE id =" + resultSet.getLong("currency_id_withdrawn"));
            while (resultSet3.next()) {
                row.createCell(5).setCellValue(resultSet3.getString("name"));
            }

            cell = row.createCell(6);
            cell.setCellValue(resultSet.getLong("withdrawn"));

            cell = row.createCell(7);
            cell.setCellValue(resultSet.getString("date"));

            i++;
        }

        String excelName = "Report_" + java.time.LocalDate.now()+ ".xlsx";
        FileOutputStream output = new FileOutputStream(new File(
                EXCEL_PATH + excelName));

        // write
        workbook.write(output);
        output.close();

        log.info(excelName + " file was created");
    }
}

