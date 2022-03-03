package it.gestionetelevisore.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetelevisore.model.Televisore;
import it.gestionetelevisore.service.MyServiceFactory;

/**
 * Servlet implementation class VisualizzaDettaglioServlet
 */
@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisualizzaDettaglioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdDelTelevisoreDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
		Long idPerDettaglio = Long.parseLong(parametroIdDelTelevisoreDiCuiVoglioIlDettaglio);

		try{
			Televisore televisorePerDattaglio = MyServiceFactory.getTelevisoreServiceInstance().cercaPerId(idPerDettaglio);
			request.setAttribute("TelevisoreDiCuiSiVoglionoConoscereIDettagli", televisorePerDattaglio);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("dettaglio.jsp").forward(request, response);
	}


}