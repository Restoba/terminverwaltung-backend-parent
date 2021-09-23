package de.restoba.terminverwaltungservice.control;

import de.restoba.terminverwaltungmodel.generated.rest.model.Vaccinecapacity;
import de.restoba.terminverwaltungservice.control.mapper.VaccinecapacityMapper;
import de.restoba.terminverwaltungservice.entity.ImpfkapazitaetEntity;
import de.restoba.terminverwaltungservice.entity.repository.ImpfkapazitaetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinecapacityService {

    @Autowired
    private ImpfkapazitaetRepository impfkapazitaetRepo;
    @Autowired
    private VaccinecapacityMapper vaccinecapacityMapper;

    public List<Vaccinecapacity> getAllVaccinecapacitys() {
        return vaccinecapacityMapper.entitiesToModels(new ArrayList<>(impfkapazitaetRepo.findAll()));
    }

    public void putVaccinecapacity(Vaccinecapacity body, String vaccinecapacityId) {
        if (impfkapazitaetRepo.findById(Integer.parseInt(vaccinecapacityId)).isPresent()) {
            ImpfkapazitaetEntity entity = impfkapazitaetRepo.findById(Integer.parseInt(vaccinecapacityId)).get();
            entity.setImpfstoffAnzahl(body.getCapacity().intValue());
            impfkapazitaetRepo.save(entity);
        }
    }
}
