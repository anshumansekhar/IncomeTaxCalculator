/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudcomputing;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author anshu
 */
@WebService(serviceName = "IncomeTaxCalculatorService")
public class IncomeTaxCalculatorService {


    public String[] tax_1718(int income,String gender,String age){
//        sample calculator
// not exact values
        String[] result=new String[3];
        boolean male=gender.equalsIgnoreCase("M");
        boolean lessThan60=age.equalsIgnoreCase("l1");
        if(lessThan60 && male && income<160000){
            result[0]="0";
            result[1]="0";
            result[2]="0";
        }
        else if(lessThan60 && male && ((income>160000) && (income<=300000))){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=incomeTax+(((income-160000) * 10)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        else if(lessThan60 && male && ((income>300000) && (income<=500000))){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=14000+(((income-300000) * 20)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        else if(lessThan60 && male && income>500000){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=54000+(((income-500000) * 30)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        else if(lessThan60 && !male && (income<190000)){
            result[0]="";
            result[1]="";
            result[2]="";
        }
        else if(lessThan60 && !male && ((income>190000) && (income<=300000))){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=incomeTax+(((income-190000) * 10)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        else if(lessThan60 && !male && ((income>300000) && (income<=500000))){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=11000+(((income-300000) * 20)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        
        else if(lessThan60 && !male && income>500000){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=51000+(((income-500000) * 30)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        else if(!lessThan60 && (income<=240000)){
            result[0]="";
            result[1]="";
            result[2]="";
        }
        else if(!lessThan60 && ((income>240000) && (income<=300000))){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=incomeTax+(((income-240000) * 10)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        else if(lessThan60 && ((income>300000) && (income<=500000))){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=6000+(((income-300000) * 20)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        else if(lessThan60 && ((income>500000))){
            double incomeTax=0,educationCess=0,totalTax=0;
            incomeTax=46000+(((income-500000) * 30)/100);
            educationCess=incomeTax*0.03;
            totalTax=incomeTax+educationCess;
            result[0]=""+incomeTax;
            result[1]=""+educationCess;
            result[2]=""+totalTax;
        }
        return result;
    }
    
//    calculateTax method web service method
//    with paramenter ass_year,income,gender and age
    @WebMethod(operationName = "calculateTax")
    public String[] calculateTax(@WebParam(name = "ass_year") String year
            ,@WebParam(name="income") int income
            ,@WebParam(name="gender") String gender
            ,@WebParam(name="age") String age) {
//        call to tax_1718 function
        return tax_1718(income,gender,age);
//        if(year.equalsIgnoreCase("1718"))
//        {
//            return tax_1718(income,gender,age);
//        }
//        else if(year.equalsIgnoreCase("1819"))
//        {
//            return tax_1819(income,gender,age);
//        }
//        else if(year.equalsIgnoreCase("1920"))
//        {
//            return tax_1920(income,gender,age);
//        }
//        else if(year.equalsIgnoreCase("2021"))
//        {
//            return tax_2021(income,gender,age);
//        }
//        else if(year.equalsIgnoreCase("2122"))
//        {
//            return tax_2122(income,gender,age);
//        }
    }
}
