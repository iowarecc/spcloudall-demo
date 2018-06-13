package cc.ioware.platform.demo.server.resources;

import cc.ioware.platform.demo.server.repo.entity.PersonEntity;
import cc.ioware.platform.demo.server.services.PersonServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("persons")
@Controller
public class PersonController {

    private PersonServices personServices;

    @Autowired
    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @RequestMapping(value = "find_all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<PersonEntity>> getPersons() {
        List<PersonEntity> persons = personServices.getPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Long> savePerson(@RequestBody PersonEntity personEntity) {
        PersonEntity p = personServices.savePerson(personEntity);
        return new ResponseEntity<>(p.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<PersonEntity> getPerson(@PathVariable("id") Long id) {
        PersonEntity op = personServices.getPerson(id);
        return new ResponseEntity<>(op, HttpStatus.OK);
    }


}
