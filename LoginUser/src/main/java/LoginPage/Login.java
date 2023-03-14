package LoginPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static String defaultname = "Sivapriya";
	static String defaultPassword = "Siva@123";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter output = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == "" || password == "") {
			output.println("<script type=\"text/javascript\">");
			output.println("alert('The username or the password field cannot be empty');");
			output.println("</script>");
		} else if (username.equals(defaultname) && password.equals(defaultPassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("Welcome");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			output.println("<script type=\"text/javascript\">");
			output.println("alert('User or password incorrect');");
			output.println("</script>");
//			output.println("Login failed");
			response.sendRedirect("index.html");
		}

	}
}
