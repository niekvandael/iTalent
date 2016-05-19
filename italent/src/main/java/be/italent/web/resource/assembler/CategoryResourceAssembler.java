package be.italent.web.resource.assembler;

import be.italent.model.Category;
import be.italent.web.resource.CategoryResource;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class CategoryResourceAssembler extends ResourceAssemblerSupport<Category, CategoryResource> {

    public CategoryResourceAssembler() {
        super(Category.class, CategoryResource.class);
    }

    @Override
    public CategoryResource toResource(Category entity) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        CategoryResource resource = null;
        if (entity != null) {
            resource = mapper.map(entity, CategoryResource.class);
        }
        return resource;
    }
}