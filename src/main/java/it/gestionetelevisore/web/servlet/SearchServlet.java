package it.gestionetelevisore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetelevisore.model.Televisore;
import it.gestionetelevisore.service.MyServiceFactory;
import it.gestionetelevisore.utility.UtilityNumber;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloDaPagina = request.getParameter("modelloInput");
		String prezzoDaPagina = request.getParameter("prezzoInput");
		String numeroPolliciDaPagina = request.getParameter("numeroPolliciInput");
		String codiceDaPagina = request.getParameter("codiceInput");

		try {
			Televisore modelloPerRicerca = new Televisore(marcaDaPagina, modelloDaPagina, UtilityNumber.parseFromStringToInt(prezzoDaPagina), UtilityNumber.parseFromStringToInt(numeroPolliciDaPagina), codiceDaPagina);
			request.setAttribute("listTelevisoriCheSoddisfanoICriteriDiRicerca",
					MyServiceFactory.getTelevisoreServiceInstance().trovaInBaseAllaRicerca(modelloPerRicerca));
			} catch (Exception e) {
				e.printStackTrace();
			}

		request.getRequestDispatcher("results.jsp").forward(request, response);
	}
}