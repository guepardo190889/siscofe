
package mx.edu.um.miembros.dao.hibernate;

import java.util.List;

import mx.edu.um.dao.hibernate.BaseDaoHibernate;
import mx.edu.um.miembros.model.Miembro;
import mx.edu.um.miembros.dao.MiembroDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class MiembroDaoHibernate extends BaseDaoHibernate implements MiembroDao {

    /**
     * @see mx.edu.um.miembros.dao.MiembroDao#getMiembros(mx.edu.um.miembros.model.Miembro)
     */
    public List getMiembros(final Miembro miembro) {
        return getHibernateTemplate().find("from Miembro");

        /* Remove the line above and uncomment this code block if you want 
           to use Hibernate's Query by Example API.
        if (miembro == null) {
            return getHibernateTemplate().find("from Miembro");
        } else {
            // filter on properties set in the miembro
            HibernateCallback callback = new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException {
                    Example ex = Example.create(miembro).ignoreCase().enableLike(MatchMode.ANYWHERE);
                    return session.createCriteria(Miembro.class).add(ex).list();
                }
            };
            return (List) getHibernateTemplate().execute(callback);
        }*/
    }

    /**
     * @see mx.edu.um.miembros.dao.MiembroDao#getMiembro(Integer id)
     */
    public Miembro getMiembro(final Integer id) {
        Miembro miembro = (Miembro) getHibernateTemplate().get(Miembro.class, id);
        if (miembro == null) {
            log.warn("uh oh, miembro with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(Miembro.class, id);
        }

        return miembro;
    }

    /**
     * @see mx.edu.um.miembros.dao.MiembroDao#saveMiembro(Miembro miembro)
     */    
    public void saveMiembro(final Miembro miembro) {
        getHibernateTemplate().saveOrUpdate(miembro);
    }

    /**
     * @see mx.edu.um.miembros.dao.MiembroDao#removeMiembro(Integer id)
     */
    public void removeMiembro(final Integer id) {
        getHibernateTemplate().delete(getMiembro(id));
    }
}
