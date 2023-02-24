package com.canddella.utility;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Owner;
import com.canddella.entity.Visits;
import com.canddella.service.OwnerServiceImpl;
import com.canddella.service.VisitsServiceImpl;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class BillPdfGenerator {
	public static void main(String[] args) {
		GenerateBill();
		}
		
		public static void GenerateBill(){
		Scanner in= new Scanner(System.in);
		System.out.println("Enter the bill id");
		int id = in.nextInt();

	String query = "select bill.bill_id,visits.pet_id,visits.owner_id,bill.total_amount,bill.payment_mode,bill.payment_date  from bill join visits on bill.visit_id=visits.visit_id where bill.bill_id="+id;
	
    try {  
    	Connection connection = null;
		PreparedStatement prepStmt = null;  
        // Connect to the database
         DataSource ds = DBConnectionPool.getDataSource();
		connection = ds.getConnection();
		prepStmt = connection.prepareStatement(query);
		ResultSet resultSet = prepStmt.executeQuery();

        // Create a new PDF document
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\USER\\AAB\\eclipse-workspace\\VETERINARY_CLINIC_MANAGEMENT_SYSTEM\\pdf\\demo.pdf"));
        document.open();
        
        //Create a new Image document
        document.add(Image.getInstance("C:\\Users\\USER\\AAB\\eclipse-workspace\\VETERINARY_CLINIC_MANAGEMENT_SYSTEM\\loggggo.png"));
		document.add(new Paragraph(" "));
        
    
		//VisitsServiceImpl VisitsServiceImpl=new VisitsServiceImpl();
		//Visits visits=VisitsServiceImpl.visitId(id);
		
		
		
        // Add the recipt data
        while (resultSet.next()) {
        	
        	
        	    Paragraph para1 = new Paragraph("*************************************BILL************************************");
        	    document.add(para1);
        	    Paragraph para2 = new Paragraph("BILL ID:"+resultSet.getInt("bill_id"));
        	    document.add(para2);
        	    OwnerServiceImpl OwnerServiceImpl=new OwnerServiceImpl();
        		Owner owner=OwnerServiceImpl.ownerId(resultSet.getInt(3));
        	    Paragraph para3=new Paragraph("OWNER NAME:"+owner.getOwnerName()+"\n");
        	    document.add(para3);
                Paragraph para4 = new Paragraph("PET ID:"+resultSet.getInt("pet_id")+"\n"+"TOTAL AMOUNT:"+resultSet.getDouble("total_amount")+"\n"+"PAYMENT MODE:"+resultSet.getString("payment_mode")+"\n"+"PAYMENT DATE:"+resultSet.getString("payment_date"));
                document.add(para4);
                Paragraph para5 = new Paragraph("*****************************************************************************");
                document.add(para5);
                System.out.println("Bill generated successfully");
            }
        
        
        // Close the document and the database connection
        document.close();
        
    } catch (Exception e) {
        e.printStackTrace();
	
	
	
	
    }
    
	}
	
}
	


