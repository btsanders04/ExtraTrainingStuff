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

@WebServlet("/EnterGrades")
public class EnterGrades extends HttpServlet {

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

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String submit = request.getParameter("submit");
		response.setContentType("text/html");
		if (submit == null) {
		} else if (submit.equals("submit")) {
			int grade = Integer.parseInt(request.getParameter("grade"));
			String assign = "";
			assign = request.getParameter("assignment");
			String sql = "insert into grades (assignment,grade)" + "values('"
					+ assign + "'," + grade + ")";
			try {
				DBQuery.updateDB(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher("/FormPage.jsp").forward(
				request, response);
	}

	public void destroy() {
	}
}
