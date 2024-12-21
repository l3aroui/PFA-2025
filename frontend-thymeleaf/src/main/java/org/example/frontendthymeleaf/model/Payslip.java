package org.example.frontendthymeleaf.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payslip {
    private Long id;
    private Long employeeId;
    private String month;
    private double grossSalary;
    private double deductions;
    private double netSalary;
}
