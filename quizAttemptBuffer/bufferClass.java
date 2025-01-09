
package quizAttemptBuffer;

import DBConnect.*;
import afterStudentLogin.*;
import java.sql.*;
import java.util.Calendar;

public class bufferClass {

    Integer sno;
    Integer QType;
    Integer TLimit;
    String QName;
    String Op1;
    String Op2;
    String Op3;
    String Op4;
    String cop;
    String cop2;
    String cop3;
    String cop4;
    public Integer marks;
    Integer published;
    public Integer correct = 0;
    
    public Integer calculatedMarks=0;
    
    
    
    public void call(int sno1,int cMarks, int correct,String table,int hour,int minute,int second,Calendar startInstance){
        try{
        this.sno = sno1;
        databaseConnect ob = new databaseConnect();
        Connection con = ob.dbc();
        Statement stmt = con.createStatement();
        String SelectStmt;
        SelectStmt = "SELECT * FROM " + table + " Where sno=" + Integer.toString(sno)+";";
        System.out.println(SelectStmt);
        ResultSet resultSet =stmt.executeQuery(SelectStmt);
        //System.out.println(resultSet);
        resultSet.next();
        QType= resultSet.getInt("qtype");
        QName= resultSet.getString("qname");
        Op1= resultSet.getString("op1");
        Op2= resultSet.getString("op2");
        Op3= resultSet.getString("op3");
        Op4= resultSet.getString("op4");
        cop= resultSet.getString("cop");
        cop2= resultSet.getString("cop2");
        cop3= resultSet.getString("cop3");
        cop4= resultSet.getString("cop4");
        marks= resultSet.getInt("marks");
        
        System.out.println(QName+Op1+Op2+Op3+Op4);
        
        resultSet.close();
        
      
        
        
        if(cop != null){
        switch(QType){
                    case 1 -> {
                        singleChoice ob1 = new singleChoice();
                        ob1.sc(QName, Op1, Op2, Op3, Op4, cop,sno,cMarks,marks,correct,table,hour,minute,second,startInstance);
                    }
                    case 2 -> {
                        multiChoice ob2 = new multiChoice();
                        ob2.sc(QName, Op1, Op2, Op3, Op4, cop, cop2, cop3, cop4, sno, cMarks, marks, correct, table, hour, minute, second, startInstance);
                       
                    }
                    case 3 -> {
                        fillInB ob3 = new fillInB();
                        ob3.fib(sno,QName,cop,cMarks,marks,correct,table,hour,minute,second,startInstance);
                    }
                    case 4 -> {
                    }
                    default -> {
                        System.out.println("ERROR");
                    }
                }
        
        }else{
            studentFinal obj = new studentFinal();
            obj.StudentFinalPage(sno-1, cMarks, correct);
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
