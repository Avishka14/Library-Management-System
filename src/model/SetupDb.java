package model;

import java.util.logging.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Avishka Chamod
 */
public class SetupDb {

    public SetupDb() {
        setupLogger();
    }

  

    static double StuRegFee = 150.00;
    static double EmpRegFee = 250.00;
    static double lateReturnFee = 50.00;
    static String StuReg = "Student-Reg-Fee";
    static String EmpReg = "Emp-Reg-Fee";
    static String lateRe = "Late-Return-Fee";
    static String bookAvailableTrue = "Available";
    static String bookAvailableFalse = "NotAvailable";
    static String MemberStatusTrue = "Active";
    static String MemberStatusFalse = "Deactive";
    
    public Integer softwareKey = 0000;

    public Integer getSoftwareKey() {
        return softwareKey;
    }

    public void setSoftwareKey(Integer softwareKey) {
        this.softwareKey = softwareKey;
    }
    
      public static double getStuRegFee() {
        return StuRegFee;
    }

    public static void setStuRegFee(double StuRegFee) {
        SetupDb.StuRegFee = StuRegFee;
    }

    public static double getEmpRegFee() {
        return EmpRegFee;
    }

    public static void setEmpRegFee(double EmpRegFee) {
        SetupDb.EmpRegFee = EmpRegFee;
    }

    public static double getLateReturnFee() {
        return lateReturnFee;
    }

    public static void setLateReturnFee(double lateReturnFee) {
        SetupDb.lateReturnFee = lateReturnFee;
    }

    private final static Logger logger = Logger.getLogger(SetupDb.class.getName());

    private void setupLogger() {
        try {

            Handler fileHandler = new FileHandler("Logfiles/login.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, "Database Setup Logger  Success");

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Database Setup Logger Failed" + e);
        }
    }

    public String initializeDb() {
        String status = "Wait for the Database Initialize Process ";

        try {

           ResultSet feeSearch = MySQL.exeSearch("SELECT `note` FROM `libraryfees`");
           ArrayList<String> list = new ArrayList<>();
      
            while(feeSearch.next()){                             
              list.add(feeSearch.getString("note"));
            }
            
            if(list.contains("Student-Reg-Fee")){
                status = "Student Registration Fee Available";
            }else{
               MySQL.exeUpdate("INSERT INTO `libraryfees` (`note`,`amount`) VALUES ('"+StuReg+"','"+StuRegFee+"')");
               status = "Student Registration Fee Added Success";
            }
            
            if(list.contains("Emp-Reg-Fee")){
                status = "Employee Registration Fee Available";
            }else{
                MySQL.exeUpdate("INSERT INTO `libraryfees` (`note`,`amount`) VALUES ('"+EmpReg+"','"+EmpRegFee+"')");
                status = "Employee Registration Fee Added Success";
            }
            
            if(list.contains("Late-Return-Fee")){
                status = "Late Return Fee Available";
            }else{
                MySQL.exeUpdate("INSERT INTO `libraryfees` (`note`,`amount`) VALUES ('"+lateRe+"','"+lateReturnFee+"')");
                status = "Late Return Fee Added Success ";
            }
            
            status = "Library Fee's Added Success";
            feeSearch.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Employee Registration Fee Adding Failed " + e);
        }
        
        try {
            
            ResultSet search = MySQL.exeSearch("SELECT * FROM `bookavailability`");
            ArrayList<String> list = new ArrayList();
            while(search.next()){
                list.add(search.getString("status"));
            }
            
            if(list.contains(bookAvailableTrue)){
                 status = "Book Status True Available";
            }else{
                MySQL.exeUpdate("INSERT INTO `bookavailability` (`status`) VALUES ('"+bookAvailableTrue+"')");
                status = "Book Status True Added Success";
            }
            
            if(list.contains(bookAvailableFalse)){
                 status = "Book Status False Available";
            }else{
                MySQL.exeUpdate("INSERT INTO `bookavailability` (`status`) VALUES ('"+bookAvailableFalse+"')");
                status = "Book Status False Added Success";
            }
            
             status = "Book Availability Status Adding Success";
             search.close();
            
            
        } catch (Exception e) {
         e.printStackTrace();
         logger.severe("Book Availability Status Adding Failed"+e);
        }
        
        
        try {
            
            ResultSet search = MySQL.exeSearch("SELECT * FROM `memberstatus`");
            ArrayList<String> list = new ArrayList();
            while(search.next()){
                list.add(search.getString("status"));
            }
            
            if(list.contains(MemberStatusTrue)){
                  status = "Member Status True Available";
            }else{
                MySQL.exeUpdate("INSERT INTO `memberstatus` (`status`) VALUES ('"+MemberStatusTrue+"')");
                status = "Member Status True Added Success";
            }
            
            if(list.contains(MemberStatusFalse)){
                  status = "Member Status False Available";
            }else{
                MySQL.exeUpdate("INSERT INTO `memberstatus` (`status`) VALUES ('"+MemberStatusFalse+"')");
                status = "Member Status False Added Success";
            }
            
            status = "Member Status Adding Success";
            search.close();
            
        } catch (Exception e) {
         e.printStackTrace();
         logger.severe("Member Status Adding Failed " + e);
        }
        
        status = "DataBase Initialize Success - Ready to Use";
        

        return status;
    }
    
    

}
