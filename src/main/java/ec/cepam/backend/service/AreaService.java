package ec.cepam.backend.service;

import ec.cepam.backend.model.Area;
import ec.cepam.backend.repository.AreaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;

    public Area getArea(Integer id){
        Optional<Area> optionalArea = areaRepository.findById(id);
        return optionalArea.orElse(null);
    }

    public List<Area> getAll(){
        return areaRepository.findAll();
    }

    @Transactional
    public Area create(Area areaRQ){
        try{
            Area area = areaRepository.findByName(areaRQ.getName());
            if(area == null){
                return areaRepository.save(areaRQ);
            }else{
                throw new RuntimeException("El área ya existe");
            }
        }catch (RuntimeException re){
            throw re;
        }
    }

    @Transactional
    public Area update(Area areaRQ){
        Optional<Area> areaOptional = areaRepository.findById(areaRQ.getId());
        if(areaOptional.isPresent()){
            Area area = areaOptional.get();
            area.setName(areaRQ.getName());
            return areaRepository.save(area);
        }else {
            return null;
        }
    }
}
