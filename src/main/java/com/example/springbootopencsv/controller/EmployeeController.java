package com.example.springbootopencsv.controller;

import com.example.springbootopencsv.model.Employee;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.springbootopencsv.service.EmployeeService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/export")
    public void exportCSV(HttpServletResponse response)
            throws Exception {

        // set file name and content type
        String filename = "Employee-List.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        // create a csv writer
        StatefulBeanToCsv<Employee> writer =
                new StatefulBeanToCsvBuilder<Employee>
                        (response.getWriter())
                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                        .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                        .withOrderedResults(false).build();

        // write all employees to csv file
        writer.write(employeeService.fetchAll());

    }
}