package ec.cepam.backend.service;

import ec.cepam.backend.model.Role;
import ec.cepam.backend.model.User;
import ec.cepam.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(String name, String pass){
        return userRepository.findByNameAndPass(name, pass);
    }

    public List<User> getAll() { return userRepository.findAll(); }

    @Transactional
    public User create(User userRQ){
        try{
            User user = userRepository.findByNameAndPass(userRQ.getName(), userRQ.getPass());
            if(user == null){
                userRQ.setDateCreate(new Date());
                return userRepository.save(userRQ);
            }else{
                throw new RuntimeException("El Usuario ya existe");
            }
        }catch (RuntimeException re){
            throw re;
        }
    }

    @Transactional
    public User update(User userRQ){
        Optional<User> userOptional = userRepository.findById(userRQ.getId());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(userRQ.getName());
            user.setPass(userRQ.getPass());
            return userRepository.save(user);
        }else {
            return null;
        }
    }
}

