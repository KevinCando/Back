package ec.cepam.backend.controller;

import ec.cepam.backend.model.Area;
import ec.cepam.backend.model.Worker;
import ec.cepam.backend.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/worker")
@RequiredArgsConstructor
@CrossOrigin
public class WorkerController {
    private final WorkerService workerService;

    @GetMapping("/get")
    public ResponseEntity<Worker> getWorker(@RequestParam Integer id){
        Worker worker = workerService.getWorker(id);
        return(worker != null) ? ResponseEntity.ok(worker) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Worker>> getWorkers(){
        List<Worker> worker = workerService.getAll();
        return (worker !=null) ? ResponseEntity.ok(worker) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Worker worker){
        try{
            return ResponseEntity.ok(workerService.create(worker));
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> update(@RequestBody Worker worker){
        try{
            return ResponseEntity.ok(workerService.update(worker));
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
