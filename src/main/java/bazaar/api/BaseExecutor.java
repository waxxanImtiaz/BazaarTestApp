package bazaar.api;

public class BaseExecutor {

    private static BaseResponse baseResponse;



    @SuppressWarnings("unchecked")
    public static BaseResponse getBaseResponse(Object returnObject,String message,String responseCode){
        if (baseResponse == null)
            baseResponse = new BaseResponse();

        baseResponse.setResponseObject(returnObject);
        baseResponse.setMessage(message);
        baseResponse.setResCode(responseCode);
        return baseResponse;
    }

}
