
package mx.edu.um.cargos.dao.hibernate;

import java.util.List;

import mx.edu.um.dao.hibernate.BaseDaoHibernate;
import mx.edu.um.cargos.model.Cargo;
import mx.edu.um.cargos.dao.CargoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CargoDaoHibernate extends BaseDaoHibernate implements CargoDao {

    /**
     * @see mx.edu.um.cargos.dao.CargoDao#getCargos(mx.edu.um.cargos.model.Cargo)
     */
    public List getCargos(final Cargo cargo) {
        return getHibernateTemplate().find("from Cargo");

        /* Remove the line above and uncomment this code block if you want 
           to use Hibernate's Query by Example API.
        if (cargo == null) {
            return getHibernateTemplate().find("from Cargo");
        } else {
            // filter on properties set in the cargo
            HibernateCallback callback = new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException {
                    Example ex = Example.create(cargo).ignoreCase().enableLike(MatchMode.ANYWHERE);
                    return session.createCriteria(Cargo.class).add(ex).list();
                }
            };
            return (List) getHibernateTemplate().execute(callback);
        }*/
    }

    /**
     * @see mx.edu.um.cargos.dao.CargoDao#getCargo(Integer id)
     */
    public Cargo getCargo(final Integer id) {
        Cargo cargo = (Cargo) getHibernateTemplate().get(Cargo.class, id);
        if (cargo == null) {
            log.warn("uh oh, cargo with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(Cargo.class, id);
        }

        return cargo;
    }

    /**
     * @see mx.edu.um.cargos.dao.CargoDao#saveCargo(Cargo cargo)
     */    
    public void saveCargo(final Cargo cargo) {
        getHibernateTemplate().saveOrUpdate(cargo);
    }

    /**
     * @see mx.edu.um.cargos.dao.CargoDao#removeCargo(Integer id)
     */
    public void removeCargo(final Integer id) {
        getHibernateTemplate().delete(getCargo(id));
    }
}
