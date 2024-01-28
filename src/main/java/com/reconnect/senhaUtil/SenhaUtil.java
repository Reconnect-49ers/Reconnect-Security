package com.reconnect.senhaUtil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtil {
	
//	public String cripto(String senha) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		
//		return encoder.encode(senha);
//	}

    public static boolean matches(String senha, String hash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
 
        return encoder.matches(senha, hash);
    }
    
}
