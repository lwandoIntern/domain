package za.ac.cput.controller.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.books.Category;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.service.books.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/domain/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;


    @PostMapping("/create")
    public ResponseEntity createCategory(@RequestBody Category theCategory){
        System.out.println(theCategory);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Category created!");
        if (theCategory.getCategoryName() == null){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide a category name");
        }else {

            if (theCategory == null){
                responseObject.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
                String msg = theCategory == null ? "Category not found": "";
                responseObject.setResponseDescription(msg);
            }else {
                Category saveCateg = saveCategory(theCategory);
                responseObject.setResponse(saveCateg);
            }
        }
        return ResponseEntity.ok(responseObject);
    }
    private Category saveCategory(Category category){
        return categoryService.create(category);
    }
}
