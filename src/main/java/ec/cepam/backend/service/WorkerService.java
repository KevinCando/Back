package ec.cepam.backend.service;

import ec.cepam.backend.model.Area;
import ec.cepam.backend.model.Worker;
import ec.cepam.backend.repository.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;

    public Worker getWorker(Integer id){
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        return optionalWorker.orElse(null);
    }
    public List<Worker> getAll(){return workerRepository.findAll();}

    @Transactional
    public Worker create(Worker workerRQ){
        try{
            Worker worker = workerRepository.findByNamesAndSurnames(workerRQ.getNames(), workerRQ.getSurnames());
            if(worker == null){
                return workerRepository.save(workerRQ);
            }else{
                throw new RuntimeException("El trabajador ya existe");
            }
        }catch (RuntimeException re){
            throw re;
        }
    }

    @Transactional
    public Worker update(Worker workerRQ){
        Optional<Worker> workerOptional = workerRepository.findById(workerRQ.getId());
        if(workerOptional.isPresent()){
            Worker worker = workerOptional.get();
            worker.setNames(workerRQ.getNames());
            worker.setSurnames(workerRQ.getSurnames());
            worker.setAreaId(workerRQ.getAreaId());
            return workerRepository.save(worker);
        }else {
            return null;
        }
    }

}
