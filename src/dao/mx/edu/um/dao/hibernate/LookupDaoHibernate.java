package mx.edu.um.dao.hibernate;

import java.util.List;

import mx.edu.um.dao.LookupDao;


/**
 * Hibernate implementation of LookupDao.
 *
 * <p><a href="LookupDaoHibernate.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class LookupDaoHibernate extends BaseDaoHibernate implements LookupDao {

    /**
     * @see mx.edu.um.dao.LookupDao#getRoles()
     */
    public List getRoles() {
        log.debug("retrieving all role names...");

        return getHibernateTemplate().find("from Role order by name");
    }
}
