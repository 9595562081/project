package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AddEvents;
import bean.Band;
import bean.Book;
import bean.Branches;
import bean.Music;
import bean.Night;

public class DB {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/likith","root","deepak");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}
	public static int save(Book b ){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into Booking values(?,?,?,?,?,?,?,?,?,?)");
	        ps.setString(1, b.getName());
	        ps.setString(2, b.getEmail());
	        ps.setString(3, b.getPhone());
	        ps.setString(4,b.getEventDate());
	        ps.setString(5, b.geteStart());
	        ps.setString(6,b.geteEnd());
	        ps.setString(7, b.getEvent());
	        ps.setString(8, b.getVenue());
	        ps.setString(9, b.getAdditionalInfo());
	        ps.setInt(10,b.getCost());
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}
	public static int save(Band b1) throws SQLException {
		int status=0;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Band values(?,?,?,?)");
		ps.setString(1, b1.getName());
		ps.setString(2, b1.getPno());
		ps.setInt(3, b1.getCost());
		ps.setString(4, b1.getDate());
		status=ps.executeUpdate();
		return status;
		
		
		
	}
	public static int save(Night b1) throws SQLException {
		int status=0;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Night values(?,?,?,?)");
		ps.setString(1, b1.getName());
		ps.setString(2, b1.getPno());
		ps.setInt(3, b1.getCost());
		ps.setString(4, b1.getDate());
		status=ps.executeUpdate();
		return status;
		
		
		
	}
	public static int save(Music b1) throws SQLException {
		int status=0;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Night values(?,?,?,?)");
		ps.setString(1, b1.getName());
		ps.setString(2, b1.getPno());
		ps.setInt(3, b1.getCost());
		ps.setString(4, b1.getDate());
		status=ps.executeUpdate();
		return status;
		
		
		
	}
	public static List<Book> getAllRecords(Book b){  
	    List<Book> list=new ArrayList<>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from Booking where eventDate=?");
	        ps.setString(1,b.getEventDate() ); 
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){
	        	Book book=new Book();
	        	book.setName(rs.getString(1));
	        	book.setEmail(rs.getString(2));
	        	book.setPhone(rs.getString(3));
	        	book.setEventDate(rs.getString(4));
	        	book.seteStart(rs.getString(5));
	        	book.seteEnd(rs.getString(6));
	        	book.setEvent(rs.getString(7));
	        	book.setVenue(rs.getString(8));
	        	book.setAdditionalInfo(rs.getString(9));
	        	book.setCost(rs.getInt(10));
	            
	           
	            
	            
	              
	            list.add(book);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	public static int saveEvents(AddEvents e) throws SQLException {
		int status=0;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into organised values(?,?,?)");
		ps.setString(1, e.getEventName());
		ps.setString(2, e.getEventCity());
		ps.setString(3, e.getEventDate());
		
		status=ps.executeUpdate();
		return status;
		
		
		
	}
	public static int save(Branches br) throws SQLException {
		int status=0;
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into company values(?,?,?)");
		ps.setString(1, br.getBranchName());
		ps.setString(2, br.getBranchCity());
		ps.setString(3, br.getBranchPh());
		
		status=ps.executeUpdate();
		return status;
		
		
		
	}
	public static List<Branches> getAllRecords(Branches b){  
	    List<Branches> list=new ArrayList<>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from company ");
	         
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){
	        	Branches br=new Branches();
	        	br.setBranchName(rs.getString(1));
	        	br.setBranchCity(rs.getString(2));
	        	br.setBranchPh(rs.getString(3)); 
	            list.add(br);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	public static List<AddEvents> getAllRecords(AddEvents b){  
	    List<AddEvents> list=new ArrayList<>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from organised ");
	         
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){
	        	AddEvents event=new AddEvents();
	        	event.setEventName(rs.getString(1));
	        	event.setEventCity(rs.getString(2));
	        	event.setEventDate(rs.getString(3));
	        	list.add(event);
	        	  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	public static List<Band> getAllRecords(Band b){  
	    List<Band> list=new ArrayList<>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from Band where date=?");
	        ps.setString(1, b.getDate());
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){
	        	Band band=new Band();
	        	band.setName(rs.getString(1));
	        	band.setPno(rs.getString(2));
	        	band.setCost(rs.getInt(3));
	        	band.setDate(rs.getString(4));
	            
	           
	            
	            
	              
	            list.add(band);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	public static List<Night> getAllRecords(Night b){  
	    List<Night> list=new ArrayList<>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from night where date=?");
	        ps.setString(1, b.getDate());
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){
	        	Night night=new Night();
	        	night.setName(rs.getString(1));
	        	night.setPno(rs.getString(2));
	        	night.setCost(rs.getInt(3));
	        	night.setDate(rs.getString(4));
	            
	           
	            
	            
	              
	            list.add(night);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	
	
	

}
