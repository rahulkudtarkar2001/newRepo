package login.logindemo.service;

import login.logindemo.model.UserDtls;

public interface UserService {
  
public UserDtls createUser(UserDtls user);

public boolean checkEmail(String email);

}
