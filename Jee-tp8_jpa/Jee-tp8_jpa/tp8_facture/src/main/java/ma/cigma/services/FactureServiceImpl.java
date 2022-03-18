package ma.cigma.services;

import java.util.List;

import ma.cigma.dao.IFactureDao;
import ma.cigma.models.Facture;

public class FactureServiceImpl implements IFactureService{
	
	IFactureDao dao;

    public void setDao(IFactureDao dao) {
        this.dao = dao;
    }

    public IFactureDao getDao() {
        return dao;
    }

    @Override
    public boolean save(Facture c) {
        return dao.save(c);
    }

    

	@Override
	public Facture modify(Facture c) {
		return dao.update(c);
	}

	@Override
	public boolean deleteById(long id) {
		return dao.deleteById(id);
	}

	



}
