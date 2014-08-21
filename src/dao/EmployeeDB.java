package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class EmDB {



		public Connection conn;

		public void createConnection()
		{
			try
			{
	            Class.forName("oracle.jdbc.OracleDriver").newInstance();
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				conn = DriverManager.getConnection(url, "system", "system");

				System.out.println("COnnection Successful");
			}
			catch (Exception e)     
			{
				System.err.println(e.getMessage());
			}

		}


		public void closeConnection()
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		
		public boolean isEmployee(String S)
		  {
			  int count=0;
			  PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement("Select * from empweb where Name like ?");
				  
				//Initialize first parameter with email address
				pstmt.setString(1, S);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
				{
					String name = rs.getString("Name");
					String id=rs.getString("ID");
					String sal= rs.getString("Salary");
					String man=rs.getString("Manager");
					count++;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count==0)
				return false;
			else
				return true;
		  }
		
		public void getEmployeeDetails(String S)
		  {
			  PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement("Select * from empweb where Name like ?");
				  
				//Initialize first parameter with email address
				pstmt.setString(1, S);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next())
				{
					
					String id=rs.getString("ID");
					String name = rs.getString("Name");
					String sal= rs.getString("Salary");
					String man=rs.getString("Manager");
					
					System.out.println(name + "   " + id+ "   " +sal+ "   " +man);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		
		
		public void addEmployee(String id, String Nam, String  sal, String manager)
	{
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("Insert into empweb values(?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, Nam);
		    ps.setString(3,sal);
			ps.setString(4, manager);
			ps.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
		
		}

