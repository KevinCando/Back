package ec.cepam.backend.controller;

import ec.cepam.backend.controller.dto.LoginRQ;
import ec.cepam.backend.model.Role;
import ec.cepam.backend.model.User;
import ec.cepam.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody LoginRQ loginRQ){
        User user = this.userService.getUser(loginRQ.getName(), loginRQ.getPass());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = this.userService.getAll();
        if(users != null){
            return ResponseEntity.ok(users);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.create(user));
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> update(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.update(user));
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
