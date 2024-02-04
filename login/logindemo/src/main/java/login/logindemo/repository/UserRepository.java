package login.logindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import login.logindemo.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls,Integer>{

  public boolean existsByEmail(String email);
  
}
