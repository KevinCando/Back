package ec.cepam.backend.service;

import ec.cepam.backend.model.Form;
import ec.cepam.backend.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormService {

    private final FormRepository formRepository;

    public List<Form> getInfo(Integer areaId){
        return formRepository.findByAreaId(areaId);
    }


}
