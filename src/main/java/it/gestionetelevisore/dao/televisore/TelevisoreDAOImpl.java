package it.gestionetelevisore.dao.televisore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.gestionetelevisore.dao.DB_Mock;
import it.gestionetelevisore.model.Televisore;

public class TelevisoreDAOImpl implements TelevisoreDAO{
	
	private Connection connection;

	@Override
	public List<Televisore> list() throws Exception {
		List<Televisore> result = new ArrayList<>();
		
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			result.add(televisoreItem);
		}
		return result;
	}

	@Override
	public Televisore get(Long id) throws Exception {
		Televisore result = null;
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if(televisoreItem.getId().equals(id))
				result = televisoreItem;
		}
		return result;
	}

	@Override
	public int update(Televisore input) throws Exception {
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if(televisoreItem.getId().equals(input.getId())){
				televisoreItem.setMarca(input.getMarca());
				televisoreItem.setModello(input.getModello());
				televisoreItem.setPrezzo(input.getPrezzo());
				televisoreItem.setNumeroPollici(input.getNumeroPollici());
				televisoreItem.setCodice(input.getCodice());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		input.setId(DB_Mock.getNexIdAvailable());
		return DB_Mock.LISTA_TELEVISORI.add(input)?1:0;
	}

	@Override
	public int delete(Televisore input) throws Exception {
		return DB_Mock.LISTA_TELEVISORI.remove(input)?1:0;
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;	
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		if(input == null) {
			throw new Exception("Valore di input non ammesso");
		}
		List<Televisore> result = new ArrayList<>();
		List<Televisore> listaDiTuttiITelevisori = this.list();		
		for (Televisore televisoreItem : listaDiTuttiITelevisori) {
			if(televisoreItem.getMarca().startsWith(input.getMarca()) 
					&& televisoreItem.getModello().startsWith(input.getModello()) 
					&& televisoreItem.getPrezzo() >= input.getPrezzo() 
					&& televisoreItem.getNumeroPollici() >= input.getNumeroPollici() 
					&& televisoreItem.getCodice().startsWith(input.getCodice())) {
			
				result.add(televisoreItem);
			}
		}
		return result;
	}
}
