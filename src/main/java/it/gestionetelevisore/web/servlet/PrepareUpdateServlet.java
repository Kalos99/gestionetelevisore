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

@WebServlet("/PrepareUpdateServlet")
public class PrepareUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrepareUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdDelTelevisoreDaAggiornare = request.getParameter("idDaInviareComeParametro");
		Long idPerAggiornamento= Long.parseLong(parametroIdDelTelevisoreDaAggiornare);

		try{
			Televisore televisorePerAggiornamento = MyServiceFactory.getTelevisoreServiceInstance().cercaPerId(idPerAggiornamento);
			request.setAttribute("TelevisoreCheSiVuoleAggiornare", televisorePerAggiornamento);
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
}
