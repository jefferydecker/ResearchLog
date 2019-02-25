package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Source;

/**
 * Servlet implementation class EditSourceServlet
 */
@WebServlet("/EditSourceServlet")
public class EditSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSourceServlet() {
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
		SourceHelper dao = new SourceHelper();
		String sourceTitle = request.getParameter("srcTitle");
		String sourceAuthor = request.getParameter("srcAuthor");
		String sourcePublication = request.getParameter("srcPublication");
		String sourceLocation = request.getParameter("srcLocation");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Source bandToUpdate = dao.searchForSourceById(tempId);
		sourceToUpdate.setSourceTitle(sourceTitle);
		sourceToUpdate.setSourceAuthor(sourceAuthor);
		sourceToUpdate.setSourcePublication(sourcePublication);
		sourceToUpdate.setSourceLocation(sourceLocation);
		dao.updateSource(sourceToUpdate);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
