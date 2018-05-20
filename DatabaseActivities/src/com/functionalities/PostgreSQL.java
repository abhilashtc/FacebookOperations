package com.functionalities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.testng.Assert;

import com.opencsv.CSVWriter;

public class PostgreSQL {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:postgresql://localhost/TestDB";
		Properties props = new Properties();
		props.setProperty("user","abhi");
		props.setProperty("password","Krishna9239");
//		props.setProperty("ssl","true");
		Connection conn = DriverManager.getConnection(url, props);
		
		
		System.out.println("Connected to DB");
		Statement st= conn.createStatement();
		ResultSet rs= st.executeQuery("Select id, name, age, email, phone from contacts order by id");
		System.out.println("Executed the Query..");
						// once executeQuery() executes the query and stores the records in to ResultSet object. 		
		
		String  name, email, phone;
		int id, age;
		String file = "C:\\Test\\ExportedQuery.txt";
		FileWriter fstream = new FileWriter(file);
	    BufferedWriter out = new BufferedWriter(fstream);
	    
		while (rs.next())
		{
			id = Integer.parseInt(rs.getString(1));
		    name = rs.getString(2).trim();
		    age = Integer.parseInt(rs.getString(3));
		    email = rs.getString(4).trim();
		    phone = rs.getString(5);
		    
		    out.write(id + "\t" + name + "\t" + age + "\t" + email + "\t" + phone);
		    out.newLine();
		    System.out.println((id + "\t" + name + "\t" + age + "\t" + email + "\t" + phone));
		}
		System.out.println("Completed writing into text file");
		
		out.close();
		conn.close();
		rs.close();
		st.close();
		
		String actualFile = "C:\\Test\\ExportedQuery.txt";
		String expectedFile = "C:\\Test\\ExpectedQuery.txt";
		
		boolean flag = compareFile (actualFile, expectedFile);
		System.out.println("Flag -> " + flag);
		
		if(flag) {
			System.out.println("PASSED");
		}
		else {
			System.out.println("FAILED");
		}
//		Assert.assertTrue(flag);
	}
	
	
	public static boolean compareFile(String fILE_ONE2, String fILE_TWO2)throws Exception 
	{
		File f1 = new File(fILE_ONE2); //OUTFILE
		File f2 = new File(fILE_TWO2); //INPUT
	
		FileReader fR1 = new FileReader(f1);
		FileReader fR2 = new FileReader(f2);
	
		BufferedReader reader1 = new BufferedReader(fR1);
		BufferedReader reader2 = new BufferedReader(fR2);
	
		String line1 = null;
		String line2 = null;
		boolean flag = true;
		while ((flag) &&((line1 = reader1.readLine()) != null)&&((line2 = reader2.readLine()) != null)) 
		{
//		    if (!line1.equalsIgnoreCase(line2))  
			if (!line1.equals(line2))
		        flag=false;
		    else 
		        flag=true;   
		}
		reader1.close();
		reader2.close();
		return flag;
	}

}
