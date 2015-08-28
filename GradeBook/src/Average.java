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

@WebServlet("/Average")
public class Average extends HttpServlet {

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

		String sql = "select avg(grade) as average from grades";
		int avg=0;
		try {
			ResultSet result = DBQuery.getFromDB(sql);
			if(result.next()){
				avg=result.getInt("average");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	request.setAttribute("average", avg);
	getServletContext().getRequestDispatcher("/average.jsp").forward(
			request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void destroy() {
	}
}

