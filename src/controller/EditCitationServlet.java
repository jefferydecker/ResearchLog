package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

			String srcId = request.getParameter("srcId");
		
		// date editing under construction
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String year = request.getParameter("year");
		
			LocalDate dateFound;
		try {
					dateFound = LocalDate.of(Integer.parseInt(year),
							Integer.parseInt(month), Integer.parseInt(day));
				} catch(NumberFormatException ex) {
				dateFound = LocalDate.now();
				}
				
				String tempId = request.getParameter("refId");
				String refBody = request.getParameter("refBody");
				String locDetail = request.getParameter("locDetail");

				CitationHelper dao = new CitationHelper();
				SourceHelper sh = new SourceHelper();
				
				Citation citationToEdit = dao.searchForCitationById(Integer.parseInt(tempId));
				citationToEdit.setRefBody(refBody);
				citationToEdit.setLocDetail(locDetail);
				citationToEdit.setDateFound(dateFound);
				citationToEdit.setSrcId(Integer.parseInt(srcId));
			
				dao.updateCitation(citationToEdit);
		
				Integer sourceId = citationToEdit.getSrcId();
				Source sourceToView = sh.searchForSourceById(sourceId);
				
				List<Citation> sourceCitations = sh.viewSourceCitations(sourceToView);
				
				request.setAttribute("citationList", sourceCitations	);
				request.setAttribute("srcTitle", sourceToView.getSrcTitle());
				request.setAttribute("srcId", sourceToView.getSrcId());
				getServletContext().getRequestDispatcher("/CitationList.jsp").forward(request, response);		
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
