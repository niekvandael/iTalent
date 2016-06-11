package be.italent.web.controller;

import java.util.List;

import be.italent.model.Category;
import be.italent.service.CategoryService;
import be.italent.web.resource.CategoryResource;
import be.italent.web.resource.assembler.CategoryResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    private CategoryResourceAssembler categoryResourceAssembler;

    public CategoryRestController() {
        this.categoryResourceAssembler = new CategoryResourceAssembler();
    }

    /**
     * Retrieve a list with {@link Category}s
     *
     * @return {@link ResponseEntity} containing a list of {@link Category}s and a {@link HttpStatus}.OK
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<CategoryResource>> getCategories() {
        return new ResponseEntity<>(categoryResourceAssembler.toResources(categoryService.getAllCategories()), HttpStatus.OK);
    }

    /**
     * Save a specific {@link Category}
     *
     * @param category the {@link Category} to be saved
     * @return the saved {@link Category}
     */
    @Secured("Docent")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<CategoryResource> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryResourceAssembler.toResource(categoryService.createCategory(category)), HttpStatus.OK);
    }

    /**
     * Delete a specific {@link Category}
     *
     * @param id {@link int} The id of the {@link Category} to be deleted
     */
    @Secured("Docent")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public boolean deleteCategory(@PathVariable("id") final int id) {
        return categoryService.deleteCategory(id);
    }
}