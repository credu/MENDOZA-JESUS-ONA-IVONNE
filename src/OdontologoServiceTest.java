import Dao.BD;
import Dao.OdontologoDAOH2;
import Model.Odontologo;
import Service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OdontologoServiceTest {
    @Test
    public void pruebaInsertarOdontologo() {
        BD.crearTablas();
        OdontologoDAOH2 odontologoDAO = new OdontologoDAOH2();
        OdontologoService odontologoService = new OdontologoService(odontologoDAO);

        Odontologo odontologo1 = new Odontologo("Jesus", "Mendoza");
        Odontologo odontologo2 = new Odontologo("Ivonne", "Oña");

        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);

        List<Odontologo> odontologos = odontologoService.listarTodos();

        Assertions.assertEquals(2, odontologos.size());
    }
}
