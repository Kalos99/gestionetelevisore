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

@WebServlet("/PrepareDeleteServlet")
public class PrepareDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrepareDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdDelTelevisoreDaEliminare = request.getParameter("idDaInviareComeParametro");
		Long idPerEliminazione = Long.parseLong(parametroIdDelTelevisoreDaEliminare);

		try{
			Televisore televisorePerEliminazione = MyServiceFactory.getTelevisoreServiceInstance().cercaPerId(idPerEliminazione);
			request.setAttribute("TelevisoreCheSiVuoleEliminare", televisorePerEliminazione);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("delete.jsp").forward(request, response);
	}

}
