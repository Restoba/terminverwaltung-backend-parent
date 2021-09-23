package de.restoba.terminverwaltungservice.control.mapper;

import de.restoba.terminverwaltungmodel.generated.rest.model.Vaccinecapacity;
import de.restoba.terminverwaltungservice.entity.ImpfkapazitaetEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinecapacityMapper {
    public ImpfkapazitaetEntity modelToEntity(Vaccinecapacity model) {
        ImpfkapazitaetEntity entity = new ImpfkapazitaetEntity();
        entity.setImpfstoffName(model.getName());
        entity.setImpfstoffAnzahl(model.getCapacity().intValue());
        return entity;
    }

    public Vaccinecapacity entityToModel(ImpfkapazitaetEntity entity) {
        Vaccinecapacity model = new Vaccinecapacity();
        model.setVaccinecapacityId(BigDecimal.valueOf(entity.getImpfkapazitaetId()));
        model.setName(entity.getImpfstoffName());
        model.setCapacity(BigDecimal.valueOf(entity.getImpfstoffAnzahl()));
        return model;
    }

    public List<ImpfkapazitaetEntity> modelsToEntities(List<Vaccinecapacity> models) {
        List<ImpfkapazitaetEntity> entities = new ArrayList<>();
        for(Vaccinecapacity model : models){
            entities.add(modelToEntity(model));
        }
        return entities;
    }

    public List<Vaccinecapacity> entitiesToModels(List<ImpfkapazitaetEntity> entities) {
        List<Vaccinecapacity> models = new ArrayList<>();
        for(ImpfkapazitaetEntity entity : entities){
            models.add(entityToModel(entity));
        }
        return models;
    }
}
