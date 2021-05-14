package ai.devrev.my_spring_app.rest;

import ai.devrev.my_spring_app.model.SomeentityDTO;
import ai.devrev.my_spring_app.service.SomeentityService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/someentitys", produces = MediaType.APPLICATION_JSON_VALUE)
public class SomeentityController {

    private final SomeentityService someentityService;

    public SomeentityController(final SomeentityService someentityService) {
        this.someentityService = someentityService;
    }

    @GetMapping
    public ResponseEntity<List<SomeentityDTO>> getAllSomeentitys() {
        return ResponseEntity.ok(someentityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SomeentityDTO> getSomeentity(@PathVariable final Long id) {
        return ResponseEntity.ok(someentityService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createSomeentity(
            @RequestBody @Valid final SomeentityDTO someentityDTO) {
        return new ResponseEntity<>(someentityService.create(someentityDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSomeentity(@PathVariable final Long id,
            @RequestBody @Valid final SomeentityDTO someentityDTO) {
        someentityService.update(id, someentityDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSomeentity(@PathVariable final Long id) {
        someentityService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
