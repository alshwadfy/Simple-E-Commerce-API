package com.SimpleE_Commerce.Demo.DTO;

public class AuthResponse {

        private String token;
        private String email;
        private String role;

        public AuthResponse(String token,
                            String email,
                            String role) {
            this.token = token;
            this.email = email;
            this.role = role;
        }
    // getters only — no setters needed


    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
