package com.svyatdanilov.investmentproject.dto;

import com.svyatdanilov.investmentproject.annotation.CsvValidation;
import jakarta.validation.constraints.*;
import java.sql.Date;

@CsvValidation
public class ProjectDto {

    private int id;

    @NotEmpty(message = "Project's name cannot be empty")
    @Size(min = 5, max = 45, message = "Project's name must be between 5 and 45 characters")
    private String name_of_project;

    private Date date_of_analysis;

    @Positive(message = "Discount rate must be positive")
    @Digits(integer=1, fraction=2, message = "Discount rate must match the patterns: *.* or *.**")
    private double discount_rate;

    @Positive(message = "Loan interest rate must be positive")
    @Digits(integer=1, fraction=2, message = "Loan interest rate must match the patterns: *.* or *.**")
    private double loan_interest_rate;

    @Positive(message = "Initial investment must be positive")
    @Digits(integer=8, fraction=2, message = "Initial investment must match the pattern *(1-8).*(0-2)")
    private double initial_investment;

    @Min(value = 1, message = "Implementation period must be minimum one period (month or year)")
    @Digits(integer=7, fraction=0, message = "Implementation period must be integer number")
    private int implementation_period;

    private String profit_per_unit_of_the_implementation_period;
    private String conclusion;


    public ProjectDto() {
        this.date_of_analysis = new Date(System.currentTimeMillis());
    }

    public ProjectDto(int id, String name_of_project, Date date_of_analysis, double discount_rate, double loan_interest_rate,
                      double initial_investment, int implementation_period, String profit_per_unit_of_the_implementation_period, String conclusion) {
        this.id = id;
        this.name_of_project = name_of_project;
        this.date_of_analysis = date_of_analysis;
        this.discount_rate = discount_rate;
        this.loan_interest_rate = loan_interest_rate;
        this.initial_investment = initial_investment;
        this.implementation_period = implementation_period;
        this.profit_per_unit_of_the_implementation_period = profit_per_unit_of_the_implementation_period;
        this.conclusion = conclusion;
    }

    public ProjectDto(String name_of_project, double discount_rate, double loan_interest_rate,
                      double initial_investment, int implementation_period,
                      String profit_per_unit_of_the_implementation_period) {
        this.name_of_project = name_of_project;
        this.discount_rate = discount_rate;
        this.loan_interest_rate = loan_interest_rate;
        this.initial_investment = initial_investment;
        this.implementation_period = implementation_period;
        this.profit_per_unit_of_the_implementation_period = profit_per_unit_of_the_implementation_period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_of_project() {
        return name_of_project;
    }

    public void setName_of_project(String name_of_project) {
        this.name_of_project = name_of_project;
    }

    public Date getDate_of_analysis() {
        return date_of_analysis;
    }

    public void setDate_of_analysis(Date date_of_analysis) {
        this.date_of_analysis = date_of_analysis;
    }

    public double getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(double discount_rate) {
        this.discount_rate = discount_rate;
    }

    public double getInitial_investment() {
        return initial_investment;
    }

    public void setInitial_investment(double initial_investment) {
        this.initial_investment = initial_investment;
    }

    public int getImplementation_period() {
        return implementation_period;
    }

    public void setImplementation_period(int implementation_period) {
        this.implementation_period = implementation_period;
    }

    public String getProfit_per_unit_of_the_implementation_period() {
        return profit_per_unit_of_the_implementation_period;
    }

    public void setProfit_per_unit_of_the_implementation_period(String profit_per_unit_of_the_implementation_period) {
        this.profit_per_unit_of_the_implementation_period = profit_per_unit_of_the_implementation_period;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public double getLoan_interest_rate() {
        return loan_interest_rate;
    }

    public void setLoan_interest_rate(double loan_interest_rate) {
        this.loan_interest_rate = loan_interest_rate;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "id=" + id +
                ", name_of_project='" + name_of_project + '\'' +
                ", date_of_analysis=" + date_of_analysis +
                ", discount_rate=" + discount_rate +
                ", loan_interest_rate=" + loan_interest_rate +
                ", initial_investment=" + initial_investment +
                ", implementation_period=" + implementation_period +
                ", profit_per_unit_of_the_implementation_period='" + profit_per_unit_of_the_implementation_period + '\'' +
                ", conclusion='" + conclusion + '\'' +
                '}';
    }
}
