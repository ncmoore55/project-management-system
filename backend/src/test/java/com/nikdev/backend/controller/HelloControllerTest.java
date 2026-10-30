package com.nikdev.backend.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {
    @Test
    void shouldReturnGreeting() {
        HelloController controller = new HelloController();

        String result = controller.sayHello();
        assertEquals("Hello from my Project Management System!", result);
    }
}
