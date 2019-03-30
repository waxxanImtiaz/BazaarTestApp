package bazaar.services;

import bazaar.api.BaseExecutor;
import bazaar.api.BaseResponse;
import bazaar.entities.User;
import bazaar.repositories.UserRepository;
import bazaar.resources.UserResource;
import bazaar.utils.ResponseRelatedFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public BaseResponse createUser(User user){
        userRepository.save(user);
        BaseResponse baseResponse = BaseExecutor.getBaseResponse(user);

        baseResponse.setMessage(ResponseRelatedFields.SIGNUP_SUCCESS_MESSAGE);
        return baseResponse;
    }
    public BaseResponse getUserByEmailAndPassword(String email, String password){
        UserResource res = new UserResource();
        res.setUser(userRepository.findByEmailAndPassword(email,password));
      return BaseExecutor.getBaseResponse(res);
    }
}
