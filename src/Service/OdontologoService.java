package Service;

import Dao.OdontologoDAOH2;
import Dao.iDao;
import Model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoService() {
        odontologoiDao = new OdontologoDAOH2();
    }

    public OdontologoService(iDao<Odontologo> odontologoiDao) {
        this.odontologoiDao = odontologoiDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }

    public Odontologo buscarPorID(Integer id){
        return odontologoiDao.buscarporId(id);
    }

    public List<Odontologo> listarTodos() {
        return odontologoiDao.listarTodos();
    }
}
