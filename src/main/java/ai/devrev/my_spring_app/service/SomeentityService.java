package ai.devrev.my_spring_app.service;

import ai.devrev.my_spring_app.domain.Someentity;
import ai.devrev.my_spring_app.model.SomeentityDTO;
import ai.devrev.my_spring_app.repos.SomeentityRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class SomeentityService {

    private final SomeentityRepository someentityRepository;

    public SomeentityService(final SomeentityRepository someentityRepository) {
        this.someentityRepository = someentityRepository;
    }

    public List<SomeentityDTO> findAll() {
        return someentityRepository.findAll()
                .stream()
                .map(someentity -> mapToDTO(someentity, new SomeentityDTO()))
                .collect(Collectors.toList());
    }

    public SomeentityDTO get(final Long id) {
        return someentityRepository.findById(id)
                .map(someentity -> mapToDTO(someentity, new SomeentityDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final SomeentityDTO someentityDTO) {
        final Someentity someentity = new Someentity();
        mapToEntity(someentityDTO, someentity);
        return someentityRepository.save(someentity).getId();
    }

    public void update(final Long id, final SomeentityDTO someentityDTO) {
        final Someentity someentity = someentityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(someentityDTO, someentity);
        someentityRepository.save(someentity);
    }

    public void delete(final Long id) {
        someentityRepository.deleteById(id);
    }

    private SomeentityDTO mapToDTO(final Someentity someentity, final SomeentityDTO someentityDTO) {
        someentityDTO.setId(someentity.getId());
        someentityDTO.setName(someentity.getName());
        return someentityDTO;
    }

    private Someentity mapToEntity(final SomeentityDTO someentityDTO, final Someentity someentity) {
        someentity.setName(someentityDTO.getName());
        return someentity;
    }

}
