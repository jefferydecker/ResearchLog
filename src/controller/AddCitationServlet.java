package controller;

import java.io.IOException;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String srcId = request.getParameter("srcId");
		String date = request.getParameter("dateFound");
		String body = request.getParameter("refBody");
		String location = request.getParameter("locDetail");
		String source = request.getParameter("source");
		
		SourceHelper sh = new SourceHelper();
		List<Source> sourceList  = sh.showAllSources();
		int temp = 0;
		for(int i = 0; i < sourceList.size(); i++) {
			if(sourceList.get(i).getSrcId() == Integer.parseInt(srcId)) {
				temp = i;			
			}
		}
		
		Citation c = new Citation(srcId, date, body, sourceList.get(temp));
		MusicianHelper dao = new MusicianHelper();
		dao.insertMusician(m);
		getServletContext().getRequestDispatcher("/ViewAllMusiciansServlet").forward(request, response);
	}


}
