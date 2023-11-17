/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.projects.hms.dto.user;

import lombok.*;

/**
 *
 * @author 재진
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {

    private String id;
    private String pw;

    public static class UserLoginDtoBuilder {

        private String id;
        private String pw;

        public UserLoginDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserLoginDtoBuilder pw(String pw) {
            this.pw = pw;
            return this;
        }
        
        public UserLoginDto build() {
            return new UserLoginDto(this);
        }
    }
    
    private UserLoginDto(UserLoginDtoBuilder builder) {
        this.id = builder.id;
        this.pw = builder.pw;
    }
}
