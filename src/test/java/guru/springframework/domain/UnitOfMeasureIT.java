package guru.springframework.domain;

import guru.springframework.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getDescriptionTablespoon() {
        Optional<UnitOfMeasure> optionalTablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        assertEquals("Tablespoon", optionalTablespoon.get().getDescription());
    }

    @Test
    public void getDescriptionOunce() {
        Optional<UnitOfMeasure> optionalTablespoon = unitOfMeasureRepository.findByDescription("Ounce");
        assertEquals("Ounce", optionalTablespoon.get().getDescription());
    }
}