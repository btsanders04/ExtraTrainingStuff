import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/History")
public class History extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			DBQuery.openConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String sql = "select * from grades order by grade desc";
			String history="";
			try {
				ResultSet result = DBQuery.getFromDB(sql);
				while(result.next()){
					String assignment = result.getString("assignment");
					
					int grade= result.getInt("grade");
					if(grade>=80){
						history+="<tr class = \"success\"><td>"+assignment+"</td><td>"+grade+"</td></tr>";
					}
					else if(grade>50){
						history+="<tr class = \"warning\"><td>"+assignment+"</td><td>"+grade+"</td></tr>";
					}
					else{
						history+="<tr class = \"danger\"><td>"+assignment+"</td><td>"+grade+"</td></tr>";
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("history", history);
		getServletContext().getRequestDispatcher("/history.jsp").forward(
				request, response);
	}

	public void destroy() {
	}
	
}
