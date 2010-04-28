package mx.edu.um.dao.ibatis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import mx.edu.um.dao.UserDao;
import mx.edu.um.model.Role;
import mx.edu.um.model.User;
import org.springframework.orm.ObjectRetrievalFailureException;

/**
 * This class interacts with iBatis's SQL Maps to save and retrieve User
 * related objects.
 *
 * <p><a href="UserDaoiBatis.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserDaoiBatis extends BaseDaoiBATIS implements UserDao, UserDetailsService {
    /**
     * Get user by id.
     *
     * @param userId the user's id
     * @return a populated user object
     */
    public User getUser(Long userId) {
        User user = (User) getSqlMapClientTemplate().queryForObject("getUser", userId);

        if (user == null) {
            logger.warn("uh oh, user not found...");
            throw new ObjectRetrievalFailureException(User.class, userId);
        } else {
            List roles = getSqlMapClientTemplate().queryForList("getUserRoles", user);
            user.setRoles(new HashSet(roles));
        }

        return user;
    }

    /**
     * @see mx.edu.um.dao.UserDao#getUsers(mx.edu.um.model.User)
     */
    public List getUsers(User user) {
        List users = getSqlMapClientTemplate().queryForList("getUsers", null);

        // get the roles for each user
        for (int i = 0; i < users.size(); i++) {
            user = (User) users.get(i);

            List roles =  getSqlMapClientTemplate().queryForList("getUserRoles", user);
            user.setRoles(new HashSet(roles));
            users.set(i, user);
        }

        return users;
    }

    /**
     * Convenience method to delete roles
     * @param user
     */
    private void deleteUserRoles(final Long userId) {
        getSqlMapClientTemplate().update("deleteUserRoles", userId);
    }

    private void addUserRoles(final User user) {
        if (user.getRoles() != null) {
            for (Iterator it = user.getRoles().iterator(); it.hasNext();) {
                Role role = (Role) it.next();
                Map newRole = new HashMap();
                newRole.put("userId", user.getId());
                newRole.put("roleId", role.getId());

                List userRoles = getSqlMapClientTemplate().queryForList("getUserRoles", user);

                if (userRoles.isEmpty()) {
                    getSqlMapClientTemplate().update("addUserRole", newRole);
                }
            }
        }
    }

    /**
     * @see mx.edu.um.dao.UserDao#saveUser(mx.edu.um.model.User)
     */
    public void saveUser(final User user) {
        prepareObjectForSaveOrUpdate(user);
        
        if (user.getId() == null) {
            Long id = (Long) getSqlMapClientTemplate().insert("addUser", user);
            user.setId(id);
            addUserRoles(user);
        } else {
            getSqlMapClientTemplate().update("updateUser", user);
            deleteUserRoles(user.getId());
            addUserRoles(user);
        }
    }

    /**
     * @see mx.edu.um.dao.UserDao#removeUser(java.lang.Long)
     */
    public void removeUser(Long userId) {
        deleteUserRoles(userId);
        getSqlMapClientTemplate().update("deleteUser", userId);
    }
    
    /** 
     * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = (User) getSqlMapClientTemplate().queryForObject("getUserByUsername", username);

         if (user == null) {
             logger.warn("uh oh, user not found...");
             throw new UsernameNotFoundException("user '" + username + "' not found...");
         } else {
             List roles = getSqlMapClientTemplate().queryForList("getUserRoles", user);
             user.setRoles(new HashSet(roles));
         }

         return user;
     }
}
