import java.sql.*;
import java.lang.*;
public class Student_Details {
	public static void main(String[] args) {
		Connection con;
		Statement st;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			st=con.createStatement();
			rs=st.executeQuery("select * from student");
			while(rs.next())
			{
				//System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			//System.out.println(e);
	
			e.printStackTrace();
		}
		
	}

}
