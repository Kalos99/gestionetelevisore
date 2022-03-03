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

@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idTelevisoreDaRimuovere = request.getParameter("idTelevisore");
		
		try{
			Televisore televisoreDaRimuovere = MyServiceFactory.getTelevisoreServiceInstance().cercaPerId(Long.parseLong(idTelevisoreDaRimuovere));
			MyServiceFactory.getTelevisoreServiceInstance().elimina(televisoreDaRimuovere);
			request.setAttribute("listTelevisori", MyServiceFactory.getTelevisoreServiceInstance().mostraTutti());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
