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
 * Servlet implementation class CitationNavServlet
 */
@WebServlet("/CitationNavServlet")
public class CitationNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CitationNavServlet() {
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
		CitationHelper dao = new CitationHelper();

		String act = request.getParameter("doThisToCitation");
		
			//troubleshooting
			String selectedID = request.getParameter("id");
			System.out.println("selectedID="+selectedID + ", act="+act);
	
		if (act == null) {
		 //no button has been selected
		getServletContext().getRequestDispatcher("/ViewAllServlet").forward(request, response);
		
		} else if (act.equals("delete")) {		
			
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Citation citationToDelete = dao.searchForCitationByRefId(tempId);
			dao.deleteCitation(citationToDelete);
			getServletContext().getRequestDispatcher("/ViewAllServlet").forward(request, response);		
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to click a button.");
			} 
			finally {				
//				getServletContext().getRequestDispatcher("/ViewAllServlet").forward(request, response);
			}
	
		} else if (act.equals("edit")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Citation citationToEdit = dao.searchForCitationByRefId(tempId);
				request.setAttribute("citationToEdit", citationToEdit);
				getServletContext().getRequestDispatcher("/EditCitation.jsp").forward(request, response);
				 } catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllServlet").
				forward(request, response);
				 }
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addSourceForCitationServlet").forward(request, response);
		}
//		else if (act.equals("view source")) {
//			try {
//				Integer tempId = Integer.parseInt(request.getParameter("id"));
//				Source sourceToView = dao.searchForSourceById(tempId);
//				
//				List<Citation> sourceCitations = dao.viewSourceCitations(sourceToView);
//				request.setAttribute("sourceCitations", sourceCitations	);
//				request.setAttribute("bandName", sourceToView);
//				getServletContext().getRequestDispatcher("/CitationListBySource.jsp").forward(request, response);		
//				}
//				catch (NumberFormatException e) {
//					System.out.println("Forgot to click a button.");
//				} 
//		}
	}

}
