package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Citation;
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
		//----------------


		CitationHelper ch = new CitationHelper();
		List<Citation> abc = ch.showAllCitations();
		request.setAttribute("allItems", abc);

		if(abc.isEmpty()){
			request.setAttribute("allItems", " ");
		}

		getServletContext().getRequestDispatcher("/citation-by-source.jsp").forward(request, response);
		//----------------

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
		Source sourceToUpdate = dao.searchForSourceById(tempId);
		sourceToUpdate.setSrcTitle(sourceTitle);
		sourceToUpdate.setSrcAuthor(sourceAuthor);
		sourceToUpdate.setSrcPublication(sourcePublication);
		sourceToUpdate.setSrcLocation(sourceLocation);
		dao.updateSource(sourceToUpdate);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
