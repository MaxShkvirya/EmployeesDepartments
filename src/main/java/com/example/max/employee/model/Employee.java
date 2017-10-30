package com.example.max.employee.model;

import net.sf.oval.constraint.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    Integer id;

    @NotNull(message = "field must be not null")
    @NotEmpty(message = "name must  be not empty")
    @Length(min = 0, max = 45, message = "Max length 45 min 1 char")
    @ValidateWithMethod(methodName = "validateEmail", parameterType = String.class, message = "wrong email or email already exist")

   // @ValidateWithMethod(methodName = "ValidateWithMethod", parameterType = String.class, message = "exist")
    public final ThreadLocal<String> email = new ThreadLocal<>();

    protected Integer age;


    @NotNull(message = "Date is Empty or you insert incorrect date format" + " , " + "format date is YYYY-MM-DD")
    @NotEmpty(message = "field is empty" + " , " + "format date is YYYY-MM-DD")
    @DateRange(message = "You insert incorrect date format , correct format - yyyy-mm-dd")
    private Date date;

    Integer idDepartment;

    public Employee(String email, Integer age, Date date, Integer idDepartment) {
        this.email.set(email);
        this.age = age;
        this.date = date;
        this.idDepartment = idDepartment;
    }

    public Employee(Integer id, String email, Integer age, Date date, Integer idDepartment) {
        this.id = id;
        this.email.set(email);
        this.age = age;
        this.date = date;
        this.idDepartment = idDepartment;
    }

    public Employee() {
    }


    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

//    public boolean equels(Object obj) {
//
//        String a = this.getClass().toString();
//        String b = obj.getClass().toString();
//
//        if (!a.equals(b)) {
//            return false;
//        }
//
//        Employee employee = (Employee) obj;
//
//        if (this == employee) {
//            return true;
//        }
//
//        if (this.getEmail().equals(employee.getEmail())) {
//            return true;
//        }
//
//        if (this.getAge().equals(employee.getAge())) {
//            return true;
//        }
//
//        return false;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email.get() + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", idDepartment=" + idDepartment +
                '}';
    }


    public boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if(matcher.find()!=true){

            ///

        }
        return matcher.find();
    }


    public boolean equels(Object b) {
        if (this == b) {
            return true;
        }

        // b instanceof Employee

        if (b.getClass().toString().equals(this.getClass().toString())) {

            Employee emp = (Employee) b;

            if (emp.getAge().equals(this.getAge())) {
                return true;
            }
        }
        return false;
    }

        int[] cats = new int[10];

        List a = new ArrayList<>();

        Map map = new HashMap<>();


    @Override
    public int hashCode() {

        final int PRIME = 31;

        int b = getAge().hashCode();

        int c = b * PRIME + getAge();

        return c;
    }
}
