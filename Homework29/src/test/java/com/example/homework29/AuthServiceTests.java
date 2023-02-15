package com.example.homework29;


import com.example.homework29.model.MyUser;
import com.example.homework29.repository.AuthRepository;
import com.example.homework29.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTests {

    @InjectMocks
    AuthService authService;

    @Mock
    AuthRepository authRepository;

    MyUser myUser;
    @BeforeEach
    void setUp() {
        myUser=new MyUser(1,"Rahaf" , "1234" , "ADMIN" , null);

    }

    @Test
    void getUserByIdTest(){
        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);

        MyUser myUser1 =authService.getUserById(myUser.getId());

        Assertions.assertEquals(myUser,myUser1);
        verify(authRepository,times(1)).findMyUserById(myUser.getId());
    }

    @Test
    void registerTest(){
        authService.register(myUser);
        verify(authRepository,times(1)).save(myUser);
    }

}
