package de.restoba.terminverwaltungservice.control;

import de.restoba.terminverwaltungmodel.generated.rest.model.Meeting;
import de.restoba.terminverwaltungservice.control.mapper.MeetingMapper;
import de.restoba.terminverwaltungservice.entity.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MeetingService {

    @Autowired
    private TerminRepository terminRepo;
    @Autowired
    private MeetingMapper meetingMapper;

    public List<Meeting> getAllMeetings() {
        return meetingMapper.entitiesToModels(new ArrayList<>(terminRepo.findAll()));
    }

    public void deleteMeetingById(String meetingId) {
        try {
            terminRepo.deleteById(Integer.parseInt(meetingId));
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("Zu löschende Element nicht vorhanden");
        }
    }

    public void addNewMeeting(Meeting body) {
        terminRepo.save(meetingMapper.modelToEntity(body));
    }

}
