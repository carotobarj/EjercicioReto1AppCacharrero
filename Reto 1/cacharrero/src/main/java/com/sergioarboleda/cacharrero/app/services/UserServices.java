package com.sergioarboleda.cacharrero.app.services;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carotobarj
 */

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    /**
     *
     * @return
     */
    public List<User> getAll(){
        return repository.getAll();
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user){
        if(user.getName()== null || user.getEmail()==null || user.getPassword()==null){
            return user;
        }else{
            List<User> existUser = repository.getUserByNameOrEmail(user.getName(),user.getEmail());

            if(existUser.isEmpty()){
                if(user.getId()==null){
                    return repository.save(user);

                }else{
                    Optional<User> existUser2 = repository.getUserById(user.getId());
                    if(existUser2.isEmpty()){
                        return repository.save(user);

                    }else{
                        return user;
                    }
                }

            }else{
                return user;
            }

        }

    }
    /**
     *
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }


    public User getByEmailPass(String email, String password){
        Optional<User> userExist = repository.getUserEmailAndPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();

        }else{
            return new User(null, email,password, "NO DEFINIDO");
        }
    }

}