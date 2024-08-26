package ats.model;


public class SignUpDTO {

        private Long id;
        private String email;
        private String password;
        private boolean isAlreadyAttempted;

        public SignUpDTO(){

        }
        SignUpDTO(String email, String password ){
            this.email = email;
            this.password = password;
        }

        public Long getId(){
            return id;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public String getEmail(){
            return email;
        }

        public void setPassword(String password){
            this.password = password;
        }

        public String getPassword(){
            return password;
        }

        @Override
        public String toString() {
            return "SignUpDTO{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", isAlreadyAttempted=" + isAlreadyAttempted +
                    '}';
        }
    }
