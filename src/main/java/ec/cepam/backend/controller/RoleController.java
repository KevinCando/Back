package ec.cepam.backend.controller;

import ec.cepam.backend.model.Area;
import ec.cepam.backend.model.Role;
import ec.cepam.backend.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
@RequiredArgsConstructor
@CrossOrigin
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/get")
    public ResponseEntity<Role> getRole(@RequestParam Integer id){
        Role role = this.roleService.getRole(id);
        return(role != null) ? ResponseEntity.ok(role) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAreas(){
        List<Role> roles = this.roleService.getAll();
        return (roles !=null) ? ResponseEntity.ok(roles) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Role role){
        try{
            return ResponseEntity.ok(roleService.create(role));
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> update(@RequestBody Role role){
        try{
            return ResponseEntity.ok(roleService.update(role));
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
