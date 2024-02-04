package login.logindemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.logindemo.model.UserDtls;
import login.logindemo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepo;

  @Override
  public UserDtls createUser(UserDtls user) {
    return userRepo.save(user);
  }

  @Override
  public boolean checkEmail(String email) {
      
    return userRepo.existsByEmail(email);
  }
    
  

}
