package it.gestionetelevisore.dao.televisore;

import java.sql.Connection;
import java.util.List;

import it.gestionetelevisore.dao.IBaseDAO;
import it.gestionetelevisore.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore>{
	public void setConnection(Connection connection);
	public List<Televisore> findByExample(Televisore input) throws Exception;
}
