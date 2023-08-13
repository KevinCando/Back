package ec.cepam.backend.controller;

import ec.cepam.backend.model.Form;
import ec.cepam.backend.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/form")
@RequiredArgsConstructor
@CrossOrigin
public class FormController {
    private final FormService formService;

    @GetMapping("/list")
    public ResponseEntity<List<Form>> getForms(@RequestParam Integer areaId){
        List<Form> forms = this.formService.getInfo(areaId);
        return (forms != null) ? ResponseEntity.ok(forms) : ResponseEntity.badRequest().build();
    }

}
