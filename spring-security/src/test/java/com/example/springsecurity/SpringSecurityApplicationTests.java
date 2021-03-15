package com.example.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Test 
	void testPasswordEncoder() {
		System.out.println("XXXXXXXXXXXXXXXXXXX");
		System.out.println(new BCryptPasswordEncoder().encode("Godlin"));
	}

}
