package mx.edu.um.miembros.dao;

import java.util.List;

import mx.edu.um.dao.BaseDaoTestCase;
import mx.edu.um.miembros.model.Miembro;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.ObjectRetrievalFailureException;

public class MiembroDaoTest extends BaseDaoTestCase {
    private Integer miembroId = new Integer("1");
    private MiembroDao dao = null;

    public void setMiembroDao(MiembroDao dao) {
        this.dao = dao;
    }

    public void testAddMiembro() throws Exception {
        Miembro miembro = new Miembro();

        // set required fields

        java.lang.String nombre = "FoTrFgOlPtYlNzQqXnQuKhGaIwUzTw";
        miembro.setNombre(nombre);        

        java.lang.String apellidoMaterno = "KoMcTwZaGgXlZmJrJqMsYlHpNuLcFj";
        miembro.setApellidoMaterno(apellidoMaterno);        

        java.lang.String apellidoPaterno = "SvTeGgQqLxEeKyFcBqNpSjVfPqTzPy";
        miembro.setApellidoPaterno(apellidoPaterno);        

        java.lang.String sexo = "A";
        miembro.setSexo(sexo);        

        java.lang.String estadoCivil = "Fq";
        miembro.setEstadoCivil(estadoCivil);        

        java.lang.String modoIngreso = "Rw";
        miembro.setModoIngreso(modoIngreso);        

        java.lang.String status = "Kz";
        miembro.setStatus(status);        

        java.lang.String estudioVeintiochoCreencias = "Q";
        miembro.setEstudioVeintiochoCreencias(estudioVeintiochoCreencias);        

        java.util.Date fechaBautismo = new java.util.Date();
        miembro.setFechaBautismo(fechaBautismo);        

        java.util.Date fechaJuntaAdministrativa = new java.util.Date();
        miembro.setFechaJuntaAdministrativa(fechaJuntaAdministrativa);        

        java.util.Date fechaJuntaDirectiva = new java.util.Date();
        miembro.setFechaJuntaDirectiva(fechaJuntaDirectiva);        

        java.lang.Integer numeroVotosJuntaAdministrativa = new Integer(1084552257);
        miembro.setNumeroVotosJuntaAdministrativa(numeroVotosJuntaAdministrativa);        

        java.lang.Integer numeroVotosJuntaDirectiva = new Integer(466999352);
        miembro.setNumeroVotosJuntaDirectiva(numeroVotosJuntaDirectiva);        

        dao.saveMiembro(miembro);

        // verify a primary key was assigned
        assertNotNull(miembro.getId());

        // verify set fields are same after save
        assertEquals(nombre, miembro.getNombre());
        assertEquals(apellidoMaterno, miembro.getApellidoMaterno());
        assertEquals(apellidoPaterno, miembro.getApellidoPaterno());
        assertEquals(sexo, miembro.getSexo());
        assertEquals(estadoCivil, miembro.getEstadoCivil());
        assertEquals(modoIngreso, miembro.getModoIngreso());
        assertEquals(status, miembro.getStatus());
        assertEquals(estudioVeintiochoCreencias, miembro.getEstudioVeintiochoCreencias());
        assertEquals(fechaBautismo, miembro.getFechaBautismo());
        assertEquals(fechaJuntaAdministrativa, miembro.getFechaJuntaAdministrativa());
        assertEquals(fechaJuntaDirectiva, miembro.getFechaJuntaDirectiva());
        assertEquals(numeroVotosJuntaAdministrativa, miembro.getNumeroVotosJuntaAdministrativa());
        assertEquals(numeroVotosJuntaDirectiva, miembro.getNumeroVotosJuntaDirectiva());
    }

    public void testGetMiembro() throws Exception {
        Miembro miembro = dao.getMiembro(miembroId);
        assertNotNull(miembro);
    }

    public void testGetMiembros() throws Exception {
        Miembro miembro = new Miembro();

        List results = dao.getMiembros(miembro);
        assertTrue(results.size() > 0);
    }

    public void testSaveMiembro() throws Exception {
        Miembro miembro = dao.getMiembro(miembroId);

        // update required fields
        java.lang.String nombre = "YkAwJtKvYoIqZxSdCdKjUbWqHkZdZx";
        miembro.setNombre(nombre);        
        java.lang.String apellidoMaterno = "XaHuIsRePfSrOxEtEaZfXcBxUyKjJn";
        miembro.setApellidoMaterno(apellidoMaterno);        
        java.lang.String apellidoPaterno = "FuUwFkLiPfPhFeCxSjHwKvSlMqUlTo";
        miembro.setApellidoPaterno(apellidoPaterno);        
        java.lang.String sexo = "W";
        miembro.setSexo(sexo);        
        java.lang.String estadoCivil = "Pu";
        miembro.setEstadoCivil(estadoCivil);        
        java.lang.String modoIngreso = "Yc";
        miembro.setModoIngreso(modoIngreso);        
        java.lang.String status = "Ty";
        miembro.setStatus(status);        
        java.lang.String estudioVeintiochoCreencias = "F";
        miembro.setEstudioVeintiochoCreencias(estudioVeintiochoCreencias);        
        java.util.Date fechaBautismo = new java.util.Date();
        miembro.setFechaBautismo(fechaBautismo);        
        java.util.Date fechaJuntaAdministrativa = new java.util.Date();
        miembro.setFechaJuntaAdministrativa(fechaJuntaAdministrativa);        
        java.util.Date fechaJuntaDirectiva = new java.util.Date();
        miembro.setFechaJuntaDirectiva(fechaJuntaDirectiva);        
        java.lang.Integer numeroVotosJuntaAdministrativa = new Integer(1096505980);
        miembro.setNumeroVotosJuntaAdministrativa(numeroVotosJuntaAdministrativa);        
        java.lang.Integer numeroVotosJuntaDirectiva = new Integer(551650787);
        miembro.setNumeroVotosJuntaDirectiva(numeroVotosJuntaDirectiva);        

        dao.saveMiembro(miembro);

        assertEquals(nombre, miembro.getNombre());
        assertEquals(apellidoMaterno, miembro.getApellidoMaterno());
        assertEquals(apellidoPaterno, miembro.getApellidoPaterno());
        assertEquals(sexo, miembro.getSexo());
        assertEquals(estadoCivil, miembro.getEstadoCivil());
        assertEquals(modoIngreso, miembro.getModoIngreso());
        assertEquals(status, miembro.getStatus());
        assertEquals(estudioVeintiochoCreencias, miembro.getEstudioVeintiochoCreencias());
        assertEquals(fechaBautismo, miembro.getFechaBautismo());
        assertEquals(fechaJuntaAdministrativa, miembro.getFechaJuntaAdministrativa());
        assertEquals(fechaJuntaDirectiva, miembro.getFechaJuntaDirectiva());
        assertEquals(numeroVotosJuntaAdministrativa, miembro.getNumeroVotosJuntaAdministrativa());
        assertEquals(numeroVotosJuntaDirectiva, miembro.getNumeroVotosJuntaDirectiva());
    }

    public void testRemoveMiembro() throws Exception {
        Integer removeId = new Integer("3");
        dao.removeMiembro(removeId);
        try {
            dao.getMiembro(removeId);
            fail("miembro found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        } catch (InvalidDataAccessApiUsageException e) { // Spring 2.0 throws this one
            assertNotNull(e.getMessage());        	
        }
    }
}
