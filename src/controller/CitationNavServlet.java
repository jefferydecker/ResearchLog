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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("doThisToCitation");
		CitationHelper dao = new CitationHelper();

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		} else if (act.equals("delete")) {

			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Citation citationToDelete = dao.searchForCitationById(tempId);
				dao.deleteCitation(citationToDelete);
				getServletContext().getRequestDispatcher("/viewAllSourcesServlet").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button.");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllSourcesServlet").forward(request, response);

			}

		} else if (act.equals("edit")) {

			try {
				String tempId = request.getParameter("id");
				String tempSource = request.getParameter("srcId");

				Citation citationToEdit = dao.searchForCitationById(Integer.parseInt(tempId));

				request.setAttribute("citationToEdit", citationToEdit);
				request.setAttribute("refId", citationToEdit.getRefId());
				request.setAttribute("refBody", citationToEdit.getRefBody());
				request.setAttribute("month", citationToEdit.getDateFound().getMonthValue());
				request.setAttribute("day", citationToEdit.getDateFound().getDayOfMonth());
				request.setAttribute("year", citationToEdit.getDateFound().getYear());
				request.setAttribute("locDetail", citationToEdit.getLocDetail());
				
				getServletContext().getRequestDispatcher("/EditCitation.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllSourcesServlet").forward(request, response);
			}

		} else if (act.equals("add")) {
			SourceHelper sh = new SourceHelper();
			request.setAttribute("allSources", sh.showAllSources());

			getServletContext().getRequestDispatcher("/AddCitation.jsp").forward(request, response);

		}

	}
}
