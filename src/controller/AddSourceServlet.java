package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Source;

/**
 * Servlet implementation class AddSourceServlet
 */
@WebServlet("/AddSourceServlet")
public class AddSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("srcTitle");
		String author = request.getParameter("srcAuthor");
		String publication = request.getParameter("srcPublication");
		String location = request.getParameter("srcLocation");
		Source s = new Source(title, author, publication, location);
		SourceHelper sh = new SourceHelper();
		sh.insertSource(s);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
