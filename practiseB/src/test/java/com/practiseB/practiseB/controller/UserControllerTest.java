package com.practiseB.practiseB.controller;

import com.practiseB.practiseB.entity.User;
import com.practiseB.practiseB.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    void shouldCreateUser() {
        User request = new User("Mesud", "Mujanovic");

        User savedUser = new User("Mesud", "Mujanovic");
        savedUser.setId(1L);

        when(userRepository.save(request)).thenReturn(savedUser);

        User result = userController.createUser(request);

        assertEquals(Long.valueOf(1L), result.getId());
        assertEquals("Mesud", result.getName());
        assertEquals("Mujanovic", result.getLastName());

        verify(userRepository).save(request);
    }
}