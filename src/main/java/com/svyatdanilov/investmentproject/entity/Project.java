package com.svyatdanilov.investmentproject.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name_of_project")
    private String name_of_project;

    @Column(name="date_of_analysis")
    private Date date_of_analysis;

    @Column(name="discount_rate")
    private double discount_rate;

    @Column(name="loan_interest_rate")
    private double loan_interest_rate;

    @Column(name="initial_investment")
    private double initial_investment;

    @Column(name="implementation_period")
    private int implementation_period;

    @Column(name="profit_per_unit_of_the_implementation_period")
    private String profit_per_unit_of_the_implementation_period;

    public Project() {
    }

    public Project(String name_of_project, Date date_of_analysis, double discount_rate,double loan_interest_rate,
                   double initial_investment, int implementation_period,
                   String profit_per_unit_of_the_implementation_period) {
        this.name_of_project = name_of_project;
        this.date_of_analysis = date_of_analysis;
        this.discount_rate = discount_rate;
        this.loan_interest_rate = loan_interest_rate;
        this.initial_investment = initial_investment;
        this.implementation_period = implementation_period;
        this.profit_per_unit_of_the_implementation_period = profit_per_unit_of_the_implementation_period;
    }

    public Project(int id, String name_of_project, Date date_of_analysis, double discount_rate, double loan_interest_rate,
                   double initial_investment, int implementation_period,
                   String profit_per_unit_of_the_implementation_period) {
        this.id = id;
        this.name_of_project = name_of_project;
        this.date_of_analysis = date_of_analysis;
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

    public double getLoan_interest_rate() {
        return loan_interest_rate;
    }

    public void setLoan_interest_rate(double loan_interest_rate) {
        this.loan_interest_rate = loan_interest_rate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name_of_project='" + name_of_project + '\'' +
                ", date_of_analysis=" + date_of_analysis +
                ", discount_rate=" + discount_rate +
                ", loan_interest_rate=" + loan_interest_rate +
                ", initial_investment=" + initial_investment +
                ", implementation_period=" + implementation_period +
                ", profit_per_unit_of_the_implementation_period='" + profit_per_unit_of_the_implementation_period + '\'' +
                '}';
    }
}
