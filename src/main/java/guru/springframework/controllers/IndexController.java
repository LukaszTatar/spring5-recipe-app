package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryByDescription = categoryRepository.findByDescription("Mexican");
        Optional<UnitOfMeasure> unitOfMeasureByDescription = unitOfMeasureRepository.findByDescription("Tablespoon");

        System.out.println("id of category Mexican is: " + categoryByDescription.get().getId());
        System.out.println("id of unitOfMeasure Tablespoon is: " + unitOfMeasureByDescription.get().getId());

        return "index";
    }
}
