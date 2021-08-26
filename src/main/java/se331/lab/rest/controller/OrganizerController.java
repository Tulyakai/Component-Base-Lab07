package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;

import java.util.List;

@Controller
public class OrganizerController {
    @Autowired
    OrganizerService orgService;

    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerLists(@RequestParam(value = "_limit", required = false) Integer perPage, @RequestParam(value = "_page", required = false) Integer page) {
        List<Organizer> output = null;
        Integer eventSize = orgService.GetOrgSize();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(eventSize));
        try {
            output = orgService.getOrgs(perPage, page);
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException err) {
            return new ResponseEntity<>(output, responseHeader, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getOrg(@PathVariable("id") Long id){
        Organizer output = orgService.getOrg(id);
        if (output != null){
            return ResponseEntity.ok(output);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
