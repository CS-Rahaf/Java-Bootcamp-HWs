package com.example.homework29;


import com.example.homework29.model.MyUser;
import com.example.homework29.repository.AuthRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthRepositoryTests {

    @Autowired
    AuthRepository authRepository;

    MyUser myUser;

    @BeforeEach
    void setUp() {

        myUser=new MyUser(1,"Rahaf" , "12345" , "ADMIN" , null);
    }

    @Test
    public void findMyUserByIdTesting(){
        authRepository.save(myUser);
        MyUser myUser1= authRepository.findMyUserById(myUser.getId());

        Assertions.assertThat(myUser).isEqualTo(myUser1);
    }

    @Test
    public void findMyUserByUsernameTesting(){
        authRepository.save(myUser);
        MyUser myUser1= authRepository.findMyUserByUsername("Rahaf");

        Assertions.assertThat(myUser).isEqualTo(myUser1);
    }

}
