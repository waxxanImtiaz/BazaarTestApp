package bazaar.exceptions;

import bazaar.api.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemExceptionsHandler {

    @ExceptionHandler(value = ItemNotFoundException.class)
    public BaseResponse exception(ItemNotFoundException e){
        BaseResponse baseRes = new BaseResponse();
        baseRes.setMessage("Excetpion occured while fetching record");
        return baseRes;
    }

}
