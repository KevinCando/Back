package ec.cepam.backend.controller;


import ec.cepam.backend.model.Area;
import ec.cepam.backend.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/area")
@RequiredArgsConstructor
@CrossOrigin
public class AreaController {
    private final AreaService areaService;

    @GetMapping("/get")
    public ResponseEntity<Area> getArea(@RequestParam Integer id){
        Area area = this.areaService.getArea(id);
        return(area != null) ? ResponseEntity.ok(area) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Area>> getAreas(){
        List<Area> areas = this.areaService.getAll();
        return (areas !=null) ? ResponseEntity.ok(areas) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Area area){
        try{
            return ResponseEntity.ok(areaService.create(area));
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> update(@RequestBody Area area){
        try{
            return ResponseEntity.ok(areaService.update(area));
        } catch (RuntimeException rte){
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
