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

@WebServlet("/ExecuteUpdateServlet")
public class ExecuteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExecuteUpdateServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloDaPagina = request.getParameter("modelloInput");
		String prezzoDaPagina = request.getParameter("prezzoInput");
		String numeroPolliciDaPagina = request.getParameter("numeroPolliciInput");
		String codiceDaPagina = request.getParameter("codiceInput");
		String idTelevisoreDaAggiornare = request.getParameter("idTelevisore");
		
		if(marcaDaPagina.isBlank() || modelloDaPagina.isBlank() 
				|| UtilityNumber.parseFromStringToInt(prezzoDaPagina) == 0 
				|| UtilityNumber.parseFromStringToInt(numeroPolliciDaPagina) == 0
				|| codiceDaPagina.isBlank()) {
			
			String messaggioDaInviareAPagina = "Campi non compilati o non validi";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}
		
		try {
			Televisore televisorePerAggiornamento = MyServiceFactory.getTelevisoreServiceInstance().cercaPerId(Long.parseLong(idTelevisoreDaAggiornare));
			televisorePerAggiornamento.setMarca(marcaDaPagina);
			televisorePerAggiornamento.setModello(modelloDaPagina);
			televisorePerAggiornamento.setPrezzo(UtilityNumber.parseFromStringToInt(prezzoDaPagina));
			televisorePerAggiornamento.setNumeroPollici(UtilityNumber.parseFromStringToInt(numeroPolliciDaPagina));
			televisorePerAggiornamento.setCodice(codiceDaPagina);

			MyServiceFactory.getTelevisoreServiceInstance().aggiorna(televisorePerAggiornamento);
			request.setAttribute("listTelevisori",
					MyServiceFactory.getTelevisoreServiceInstance().mostraTutti());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
