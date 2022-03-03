package it.gestionetelevisore.service;

import it.gestionetelevisore.dao.MyDaoFactory;
import it.gestionetelevisore.service.televisore.TelevisoreService;
import it.gestionetelevisore.service.televisore.TelevisoreServiceImpl;

public class MyServiceFactory {
	// rendiamo questo factory SINGLETON
	private static TelevisoreService TELEVISORE_SERVICE_INSTANCE;

	public static TelevisoreService getTelevisoreServiceInstance() {
		if (TELEVISORE_SERVICE_INSTANCE == null)
			TELEVISORE_SERVICE_INSTANCE = new TelevisoreServiceImpl();

		TELEVISORE_SERVICE_INSTANCE.setTelevisoreDAO(MyDaoFactory.getTelevisoreDAOInstance());

		return TELEVISORE_SERVICE_INSTANCE;
	}
}
