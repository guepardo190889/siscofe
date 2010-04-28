
package mx.edu.um.miembros.dao.hibernate;

import java.util.List;

import mx.edu.um.dao.hibernate.BaseDaoHibernate;
import mx.edu.um.miembros.model.MiembroCargoRelacion;
import mx.edu.um.miembros.dao.MiembroCargoRelacionDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class MiembroCargoRelacionDaoHibernate extends BaseDaoHibernate implements MiembroCargoRelacionDao {

    /**
     * @see mx.edu.um.miembros.dao.MiembroCargoRelacionDao#getMiembroCargoRelacions(mx.edu.um.miembros.model.MiembroCargoRelacion)
     */
    public List getMiembroCargoRelacions(final MiembroCargoRelacion miembroCargoRelacion) {
        return getHibernateTemplate().find("from MiembroCargoRelacion");

        /* Remove the line above and uncomment this code block if you want 
           to use Hibernate's Query by Example API.
        if (miembroCargoRelacion == null) {
            return getHibernateTemplate().find("from MiembroCargoRelacion");
        } else {
            // filter on properties set in the miembroCargoRelacion
            HibernateCallback callback = new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException {
                    Example ex = Example.create(miembroCargoRelacion).ignoreCase().enableLike(MatchMode.ANYWHERE);
                    return session.createCriteria(MiembroCargoRelacion.class).add(ex).list();
                }
            };
            return (List) getHibernateTemplate().execute(callback);
        }*/
    }

    /**
     * @see mx.edu.um.miembros.dao.MiembroCargoRelacionDao#getMiembroCargoRelacion(Integer id)
     */
    public MiembroCargoRelacion getMiembroCargoRelacion(final Integer id) {
        MiembroCargoRelacion miembroCargoRelacion = (MiembroCargoRelacion) getHibernateTemplate().get(MiembroCargoRelacion.class, id);
        if (miembroCargoRelacion == null) {
            log.warn("uh oh, miembroCargoRelacion with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(MiembroCargoRelacion.class, id);
        }

        return miembroCargoRelacion;
    }

    /**
     * @see mx.edu.um.miembros.dao.MiembroCargoRelacionDao#saveMiembroCargoRelacion(MiembroCargoRelacion miembroCargoRelacion)
     */    
    public void saveMiembroCargoRelacion(final MiembroCargoRelacion miembroCargoRelacion) {
        getHibernateTemplate().saveOrUpdate(miembroCargoRelacion);
    }

    /**
     * @see mx.edu.um.miembros.dao.MiembroCargoRelacionDao#removeMiembroCargoRelacion(Integer id)
     */
    public void removeMiembroCargoRelacion(final Integer id) {
        getHibernateTemplate().delete(getMiembroCargoRelacion(id));
    }
}
