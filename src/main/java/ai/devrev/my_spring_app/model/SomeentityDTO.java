package ai.devrev.my_spring_app.model;

import javax.validation.constraints.Size;


public class SomeentityDTO {

    private Long id;

    @Size(max = 255)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
