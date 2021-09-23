package de.restoba.terminverwaltungservice.control.mapper;

import de.restoba.terminverwaltungmodel.generated.rest.model.Meeting;
import de.restoba.terminverwaltungservice.entity.TerminEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingMapper {
    public TerminEntity modelToEntity(Meeting model) {
        TerminEntity entity = new TerminEntity();
        entity.setTermindatum(model.getMeetingDateTime());
        entity.setKundenNachname(model.getLastname());
        entity.setKundenVorname(model.getFirstname());
        entity.setStatus(model.getStatus().toString());
        return entity;
    }

    public Meeting entityToModel(TerminEntity entity) {
        Meeting model = new Meeting();
        model.setMeetingId(BigDecimal.valueOf(entity.getTerminId()));
        model.setMeetingDateTime(entity.getTermindatum());
        model.setLastname(entity.getKundenNachname());
        model.setFirstname(entity.getKundenVorname());
        model.setStatus(Meeting.StatusEnum.fromValue(entity.getStatus()));
        return model;
    }

    public List<TerminEntity> modelsToEntities(List<Meeting> models) {
        List<TerminEntity> entities = new ArrayList<>();
        for(Meeting model : models){
            entities.add(modelToEntity(model));
        }
        return entities;
    }

    public List<Meeting> entitiesToModels(List<TerminEntity> entities) {
        List<Meeting> models = new ArrayList<>();
        for(TerminEntity entity : entities){
            models.add(entityToModel(entity));
        }
        return models;
    }
}
