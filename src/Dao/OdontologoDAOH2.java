package Dao;

import Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO) VALUES (?, ?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    private static final String SQL_SELECT_ONE = "SELECT * FROM ODONTOLOGOS WHERE MATRICULA = ?";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando odontólogo: " + odontologo.getNombre());
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, odontologo.getNombre());
            psInsert.setString(2, odontologo.getApellido());
            psInsert.executeUpdate();
            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()) {
                odontologo.setNumeroMatricula(rs.getInt(1));
            }
            logger.info("Odontólogo guardado exitosamente con matrícula: " + odontologo.getNumeroMatricula());
        } catch (Exception e) {
            logger.error("Error al guardar odontólogo: " + e.getMessage());
        }
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
        logger.info("iniciando las operaciones de : listar");
        Connection connection=null;
        List<Odontologo> odontologoList = new ArrayList<>();
        try{
            connection=BD.getConnection();

            Statement statement= connection.createStatement();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_SELECT_ALL);
            psUpdate.execute();
            ResultSet rs= psUpdate.executeQuery();
            while (rs.next()){
                odontologoList.add(new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            logger.info(odontologoList);
            return odontologoList;
        }catch (Exception e){
            logger.error("problemas con la BD"+e.getMessage());
        }
        return List.of();
    }

    @Override
    public Odontologo buscarporId(Integer id) {
        return null;
    }
}
