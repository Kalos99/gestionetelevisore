package it.gestionetelevisore.dao.televisore;

import java.sql.Connection;

import it.gestionetelevisore.dao.IBaseDAO;
import it.gestionetelevisore.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore>{
	public void setConnection(Connection connection);
}
