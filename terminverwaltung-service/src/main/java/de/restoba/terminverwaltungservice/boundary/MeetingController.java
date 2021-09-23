package de.restoba.terminverwaltungservice.boundary;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.restoba.terminverwaltungmodel.generated.rest.model.Meeting;
import de.restoba.terminverwaltungmodel.generated.rest.resources.MeetingApi;
import de.restoba.terminverwaltungservice.control.MeetingService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "${client.url}")
@Api(tags = "meeting")
public class MeetingController implements MeetingApi {

    @Autowired
    private MeetingService service;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> addMeeting(Meeting body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        service.addNewMeeting(body);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteMeetingById(String meetingId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        service.deleteMeetingById(meetingId);
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Meeting>> getAllMeetings() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(
                service.getAllMeetings(), headers, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Meeting> getReceiptById(String meetingId) {
        return null;
    }

}
