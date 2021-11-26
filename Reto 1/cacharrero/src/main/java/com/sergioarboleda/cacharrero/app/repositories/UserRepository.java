package com.sergioarboleda.cacharrero.app.repositories;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repositories.crud.UserCrudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * @author Carotobarj
 */

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repository;

    /**
     *
     * @return
     */

    public List<User> getAll(){
        return (List<User>)repository.findAll();
    }
    /**
     *
     * @param user
     * @return
     */
    public User save(User user){
        return repository.save(user);
    }

    /**
     *
     * @param name
     * @return
     */
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);

    }

    /**
     *
     * @param email
     * @return
     */
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);

    }

    /**
     *
     * @param name
     * @param email
     * @return
     */
    public List<User> getUserByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> getUserEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }


}

