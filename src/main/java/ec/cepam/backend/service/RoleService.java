package ec.cepam.backend.service;

import ec.cepam.backend.model.Role;
import ec.cepam.backend.model.Worker;
import ec.cepam.backend.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getRole(Integer id){
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole.orElse(null);
    }

    public List<Role> getAll() {return roleRepository.findAll();}

    @Transactional
    public Role create(Role roleRQ){
        try{
            Role role = roleRepository.findByName(roleRQ.getName());
            if(role == null){
                return roleRepository.save(roleRQ);
            }else{
                throw new RuntimeException("El rol ya existe");
            }
        }catch (RuntimeException re){
            throw re;
        }
    }

    @Transactional
    public Role update(Role roleRQ){
        Optional<Role> roleOptional = roleRepository.findById(roleRQ.getId());
        if(roleOptional.isPresent()){
            Role role = roleOptional.get();
            role.setArea(roleRQ.getArea());
            role.setName(roleRQ.getName());
            role.setDescription(roleRQ.getDescription());
            return roleRepository.save(role);
        }else {
            return null;
        }
    }
}
