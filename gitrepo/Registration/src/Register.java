import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("userName");  
String p=request.getParameter("userPass");  
String e=request.getParameter("userEmail");  
String c=request.getParameter("userCountry");  
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=null;
con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/xe?useSSL=false","root","root");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into registeruser values(?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c);  
          
System.out.println(ps);

int i=ps.executeUpdate();

if(i>0){
	
	out.println("record successfully saved in databse");
}else{
	
	out.println("failed");
}

} catch (ClassNotFoundException | SQLException g) {
	g.printStackTrace();  
}
}  

}