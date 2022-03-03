package it.gestionetelevisore.service.televisore;

import java.util.List;

import it.gestionetelevisore.dao.televisore.TelevisoreDAO;
import it.gestionetelevisore.model.Televisore;

public interface TelevisoreService {
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO);

	public Televisore cercaPerId(Long id) throws Exception;
	public int inserisciNuovo(Televisore input) throws Exception;
	public List<Televisore> mostraTutti() throws Exception;
	public int elimina(Televisore input) throws Exception;
	public int aggiorna(Televisore input) throws Exception;

}
