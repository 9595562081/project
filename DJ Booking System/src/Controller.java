

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.DB;
import bean.AddEvents;
import bean.Band;
import bean.Book;
import bean.Branches;
import bean.Music;
import bean.Night;

@WebServlet("/Controller/*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		doProcess(request,response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestURI=request.getRequestURI();
		Book b=new Book();
		Band b1=new Band();
		Night n=new Night();
		Music m=new Music();
		Branches br=new Branches();
		AddEvents e=new AddEvents();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(requestURI.endsWith("book")) {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String pno=request.getParameter("pno");
			String edate=request.getParameter("edate");
			String start=request.getParameter("start");
			String end=request.getParameter("end");
			String info=request.getParameter("info");
			String venue=request.getParameter("venue");
			String event=request.getParameter("event");
			b.setName(name);
			b.setEmail(email);
			b.setPhone(pno);
			b.setEventDate(edate);
			b.seteStart(start);
			b.seteEnd(end);
			b.setAdditionalInfo(info);
			b.setVenue(venue);
			b.setCost(0);
			b.setEvent(event);
			int i=DB.save(b);
			if(i>0) {
				out.println("<center><h1>Inserted</h1><center>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
			}
			else {
				out.println("failed");
			}
			
			
			
		}
		if(requestURI.endsWith("band")) {
			String name=request.getParameter("name");
			String Phone=request.getParameter("pno");
			String date=request.getParameter("date");
			int cost;
			int days=Integer.parseInt(request.getParameter("days"));
			cost=days*5000;
			b1.setName(name);
			b1.setPno(Phone);
			b1.setCost(cost);
			b1.setDate(date);
			int i=0;
			try {
				i = DB.save(b1);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(i>0) {
				out.println("<center><h1>Inserted</h1><center>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
			}
			else {
				out.println("failed");
			}
			
		}
		if(requestURI.endsWith("Night")) {
			String name=request.getParameter("name");
			String Phone=request.getParameter("pno");
			String date=request.getParameter("date");
			int cost;
			int days=Integer.parseInt(request.getParameter("days"));
			cost=days*10000;
			n.setName(name);
			n.setPno(Phone);
			n.setCost(cost);
			n.setDate(date);
			int i=0;
			try {
				i = DB.save(n);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(i>0) {

				out.println("<center><h1>Inserted</h1><center>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
			}
			else {
				out.println("failed");
			}
			
		}
		if(requestURI.endsWith("Music")) {
			String name=request.getParameter("name");
			String Phone=request.getParameter("pno");
			String date=request.getParameter("date");
			int cost;
			int days=Integer.parseInt(request.getParameter("days"));
			cost=days*10000;
			m.setName(name);
			m.setPno(Phone);
			m.setCost(cost);
			m.setDate(date);
			int i=0;
			try {
				i = DB.save(m);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(i>0) {
				out.println("<center><h1>Inserted</h1><center>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
			}
			else {
				out.println("failed");
			}
			
		}
		if(requestURI.endsWith("select")) {
			String event=request.getParameter("event");
			String date=request.getParameter("date");
			if(event.contentEquals("Booking")) {
				b.setEventDate(date);
				List<Book> al=DB.getAllRecords(b);
				out.println("<html><head><style>table th,td{color:white;}</style></head><body bgcolor='red'>");
				out.println("<table align='center' border='2'>");
				out.println("<h2>");
				for(Book i:al) {
			
					out.println("<tr><th> Name</th><td>"+i.getName()+"</td><th>Email</th><td>"+i.getEmail()+"</td><th>Phone</th><td>"+i.getPhone()+"</td><th>Event Date</th><td>"+i.getEventDate()+"</td><th>Event Time</th><td>"+i.geteStart()+"</td><th>Event End Time</th><td>"+i.geteEnd()+"</td><th>Event</th><td>"+i.getEvent()+"</td><th>Venue</th><td>"+i.getVenue()+"<th>Additional Information</th><td>"+i.getAdditionalInfo()+"</td><th>Cost</th><td>"+i.getCost()+"</td></tr>");
				}
				out.println("</table>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
				
				out.println("</body></html>");
				
			}
		    else if(event.contentEquals("Band")) {
		    	b1.setDate(date);
				List<Band> al=DB.getAllRecords(b1);
				out.println("<html><head><style>table th,td{color:white;}</style></head><body bgcolor='red'>");
				out.println("<table align='center' border='2'>");
				out.println("<h2>");
				for(Band i:al) {
					out.println("<tr>");
					out.println("<th>Name</th><td>"+i.getName()+"</td><th>Phone no</th><td>"+i.getPno()+"</td><th>Cost</th><td>"+i.getCost()+"</td><th>Date</th><td>"+i.getDate()+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
				
				out.println("</body></html>");
		    	
				
			}
		    else if(event.contentEquals("Night")) {
		    	n.setDate(date);
				List<Night> al=DB.getAllRecords(n);
				out.println("<html><head><style>table th,td{color:white;}</style></head><body bgcolor='red'>");
				out.println("<table align='center' border='2'>");
				out.println("<h2>");
				for(Night i:al) {
					out.println("<tr>");
					out.println("<th>Name</th><td>"+i.getName()+"</td><th>Phone no</th><td>"+i.getPno()+"</td><th>Cost</th><td>"+i.getCost()+"</td><th>Date</th><td>"+i.getDate()+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
				
				out.println("</body></html>");
		    	
		    }
		    else if(event.contentEquals("Music")) {
		    	n.setDate(date);
				List<Night> al=DB.getAllRecords(n);
				out.println("<html><head><style>table th,td{color:white;}</style></head><body bgcolor='red'>");
				out.println("<table align='center' border='2'>");
				out.println("<h2>");
				for(Night i:al) {
					out.println("<tr>");
					out.println("<th>Name</th><td>"+i.getName()+"</td><th>Phone no</th><td>"+i.getPno()+"</td><th>Cost</th><td>"+i.getCost()+"</td><th>Date</th><td>"+i.getDate()+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
				
				out.println("</body></html>");
		    	
		    }
		}
		if(requestURI.endsWith("addEvents")) {
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String date=request.getParameter("date");
			e.setEventName(name);
			e.setEventDate(date);
			e.setEventCity(city);
			int i=0;
			try {
				 i=DB.saveEvents(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(i>0) {
				out.println("<center><h1>Inserted</h1><center>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
			}
			else {
				out.println("failed");
			}
		}
		
		if(requestURI.endsWith("br")) {
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String pn=request.getParameter("pno");
			br.setBranchName(name);
			br.setBranchCity(city);
			br.setBranchPh(pn);
			int i=0;
			try {
				i=DB.save(br);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(i>0) {
				out.println("<center><h1>Inserted</h1><center>");
				out.println("<center><h1><a href='../Index.html'>Home</a></h1></center>");
			}
			else {
				out.println("failed");
			}
			
			
		}
		if(requestURI.endsWith("cBranches")) {
			List<Branches> list=DB.getAllRecords(br);
			out.println("<html><head><style>table th,td{color:white;}</style></head><body bgcolor='red'>");
			out.println("<table align='center' border='2'>");
			out.println("<h2>");
			for(Branches i:list) {
		
				out.println("<tr><th>Branch Name</th><td>"+i.getBranchName()+"</td><th>City</th><td>"+i.getBranchCity()+"</td><th>Phone</th><td>"+i.getBranchPh()+"</tr>");
			}
			out.println("</table>");
			out.println("<center><h1><a href='../Index.html' style='color:white';>Home</a></h1></center>");
			out.println("</h2>");
			out.println("</body></html>");
			
		}
		if(requestURI.endsWith("oEvents")) {
			List<AddEvents> list=DB.getAllRecords(e);
			out.println("<html><head><style>table th,td{color:white;}</style></head><body bgcolor='red'>");
			out.println("<table align='center' border='2'>");
			out.println("<h2>");
			for(AddEvents i:list) {
		
				out.println("<tr><th>Event Name</th><td>"+i.getEventName()+"</td><th>City</th><td>"+i.getEventCity()+"</td><th>Event Date</th><td>"+i.getEventDate()+"</tr>");
			}
			out.println("</table>");
			out.println("<center><h1><a href='../Index.html' style='color:white';>Home</a></h1></center>");
			out.println("</h2>");
			out.println("</body></html>");
			
		}
		
		
		
	}

}
