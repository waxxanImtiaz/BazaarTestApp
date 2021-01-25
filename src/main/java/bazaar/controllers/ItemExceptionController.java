package bazaar.controllers;

import bazaar.exceptions.ItemNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemExceptionController {

    @ExceptionHandler(value = ItemNotFoundException.class)
    public String exception(ItemNotFoundException exception){
        return "Product not found";
    }
}
