package de.restoba.terminverwaltungservice.boundary;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.restoba.terminverwaltungmodel.generated.rest.resources.AuthApi;
import de.restoba.terminverwaltungservice.control.AuthService;
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
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "${client.url}")
@Api(tags = "auth")
public class AuthController implements AuthApi {

    @Autowired
    private AuthService service;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> getAuthentication(String username, String userpassword, String userrolle) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (service.getAuth(username, userpassword, userrolle)) {
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(headers, HttpStatus.UNAUTHORIZED);
        }
    }
}
