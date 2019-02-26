package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Citation;
import model.Source;

/**
 * Servlet implementation class AddCitationServlet
 */
@WebServlet("/AddCitationServlet")
public class AddCitationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCitationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String srcId = request.getParameter("srcId");	
		String body = request.getParameter("refBody");
		String location = request.getParameter("locDetail");
		String source = request.getParameter("source");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),
					Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		SourceHelper sh = new SourceHelper();
		List<Source> sourceList  = sh.showAllSources();
		int temp = 0;
		for(int i = 0; i < sourceList.size(); i++) {
			if(sourceList.get(i).getSrcId() == Integer.parseInt(srcId)) {
				temp = i;			
			}
		}
		
		Citation c = new Citation(srcId, ld, body, sourceList.get(temp));
		CitationHelper dao = new CitationHelper();
		dao.insertCitation(c);
		getServletContext().getRequestDispatcher("/ViewAllCitationsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
