package Dao;

import Model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOArrayList implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOArrayList.class);
    private final List<Odontologo> odontologos = new ArrayList<>();
    private int proximaMatricula = 1;

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando odontólogo en ArrayList: " + odontologo.getNombre());
        odontologo.setNumeroMatricula(proximaMatricula++);
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado en ArrayList exitosamente con matrícula: " + odontologo.getNumeroMatricula());
        return odontologo;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Listando todos los odontólogos en ArrayList");
        logger.info(odontologos);
        return odontologos;
    }

    @Override
    public Odontologo buscarporId(Integer id) {
        // Implementación de buscar por ID si fuera necesario
        return null;
    }
}
