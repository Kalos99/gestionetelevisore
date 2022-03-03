package it.gestionetelevisore.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.gestionetelevisore.model.Televisore;


public class DB_Mock {
	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_TELEVISORI.add(new Televisore(1l, "Samsung", "Galaxy TV", 250, 42, "codice1"));
		LISTA_TELEVISORI.add(new Televisore(2l, "LG", "LG TV", 300, 38, "codice2"));
		LISTA_TELEVISORI.add(new Televisore(3l, "Telefunken", "TeleCube", 150, 25, "codice3"));
		LISTA_TELEVISORI.add(new Televisore(4l, "Panasonic", "Panoramic", 500, 45, "codice4"));
		LISTA_TELEVISORI.add(new Televisore(5l, "Samsung", "Ultra Galaxy", 800, 52, "codice5"));
		LISTA_TELEVISORI.add(new Televisore(6l, "Apple", "Apple TV", 1000, 64, "codice6"));
		LISTA_TELEVISORI.add(new Televisore(7l, "Panasonic", "Parabolic", 400, 40, "codice7"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId = LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getId)).get().getId();
		return ++resultId;
	}

}
