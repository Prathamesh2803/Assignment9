import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductsDemo2 {
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//serverhost = localhost, port=3306, username=root, password=123
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DXC","dxc");

			Statement smt=cn.createStatement();

			DataInputStream KB=new DataInputStream(System.in);

			//input a particular employee id of which we want to display record
			System.out.print("Enter Prod_Code:");
			String prod=KB.readLine();

			//query to display a particular record from table employee where empid(employee id) is equals to eid
			String q="Select * from products where prod_code='"+prod+"'";

			//to execute query
			ResultSet rs=smt.executeQuery(q);

			//to print the resultset on console
			if(rs.next())
			{
				System.out.println(rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
			}
			else
			{
				System.out.println("Record Not Found...!");
			}
			cn.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}