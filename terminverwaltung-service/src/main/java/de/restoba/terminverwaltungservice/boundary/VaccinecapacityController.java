package de.restoba.terminverwaltungservice.boundary;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.restoba.terminverwaltungmodel.generated.rest.model.Vaccinecapacity;
import de.restoba.terminverwaltungmodel.generated.rest.resources.VaccinecapacityApi;
import de.restoba.terminverwaltungservice.control.VaccinecapacityService;
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
@Api(tags = "Vaccinecapacity")
public class VaccinecapacityController implements VaccinecapacityApi {

    @Autowired
    private VaccinecapacityService service;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<List<Vaccinecapacity>> getAllVaccinecapacitys() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(
                service.getAllVaccinecapacitys(), headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> putVaccinecapacityById(Vaccinecapacity body, String vaccinecapacityId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        service.putVaccinecapacity(body, vaccinecapacityId);
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
