package dispatcher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CallServlet
 */
public class CallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd;
		String login=request.getParameter("login");
		String pwd=request.getParameter("pwd");
		if(login.equals("java") && pwd.equals("servlet"))
		{
			rd=request.getRequestDispatcher("FwdDemo");
			rd.forward(request, response);
		}
		else
		{
			out.println("<p><h1>Incorrect Login id/Password </h1></p>");
			rd=request.getRequestDispatcher("/1.html");
			rd.include(request, response);
		}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
