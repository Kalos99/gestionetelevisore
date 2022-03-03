package it.gestionetelevisore.service.televisore;

import java.util.List;

import it.gestionetelevisore.dao.televisore.TelevisoreDAO;
import it.gestionetelevisore.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService{
	
	private TelevisoreDAO televisoreDAO;

	@Override
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;
		
	}

	@Override
	public Televisore cercaPerId(Long id) throws Exception {
		// televisoreDAO.setConnection(MyConnection.getConnection());
		return televisoreDAO.get(id);
	}

	@Override
	public int inserisciNuovo(Televisore input) throws Exception {
		// televisoreDAO.setConnection(MyConnection.getConnection());
		return televisoreDAO.insert(input);
	}

	@Override
	public List<Televisore> mostraTutti() throws Exception {
	// televisoreDAO.setConnection(MyConnection.getConnection());
		return televisoreDAO.list();
	}

	@Override
	public int elimina(Televisore input) throws Exception {
	// televisoreDAO.setConnection(MyConnection.getConnection());
		return televisoreDAO.delete(input);
	}

	@Override
	public int aggiorna(Televisore input) throws Exception {
	// televisoreDAO.setConnection(MyConnection.getConnection());
		return televisoreDAO.update(input);
	}

	@Override
	public List<Televisore> trovaInBaseAllaRicerca(Televisore input) throws Exception {
		// televisoreDAO.setConnection(MyConnection.getConnection());
		return televisoreDAO.findByExample(input);
	}

}
