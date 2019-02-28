package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Citation;
import model.Source;

/**
 * Servlet implementation class EditCitationServlet
 */
@WebServlet("/EditCitationServlet")
public class EditCitationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCitationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// not allowing edit of source
//		int srcId = Integer.parseInt(request.getParameter("allSources"));
		
// date editing under construction
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
//		String year = request.getParameter("year");
//
//		LocalDate dateFound;
//		try {
//			dateFound = LocalDate.of(Integer.parseInt(year),
//					Integer.parseInt(month), Integer.parseInt(day));
//		} catch(NumberFormatException ex) {
//			dateFound = LocalDate.now();
//		}

		String refBody = request.getParameter("refBody");
		String locDetail = request.getParameter("locDetail");

		CitationHelper dao = new CitationHelper();
		Integer tempId = Integer.parseInt(request.getParameter("refId"));
		Citation citationToUpdate = dao.searchForCitationByRefId(tempId);
		citationToUpdate.setRefBody(refBody);
		citationToUpdate.setLocDetail(locDetail);
		dao.updateCitation(citationToUpdate);

		getServletContext().getRequestDispatcher("/ViewAllServlet").forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
