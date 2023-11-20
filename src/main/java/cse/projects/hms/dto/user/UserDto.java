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
//빌더 패턴 사용
@ToString
@Getter
@NoArgsConstructor
public class UserDto {

    private String id;
    private String pw;
    private String usertype;

    public static class UserBuilder {

        private String id;
        private String pw;
        private String usertype;

        public UserBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder pw(String pw) {
            this.pw = pw;
            return this;
        }
        
        public UserBuilder usertype(String usertype) {
            this.usertype = usertype;
            return this;
        }
         public UserDto build() {
            return new UserDto(this);
        }
    }
    
    private UserDto(UserBuilder builder) {
        this.id = builder.id;
        this.pw = builder.pw;
        this.usertype = builder.usertype;
    }
    
    public UserDto(String id,String pw, String usertype){
        this.id = id;
        this.pw = pw;
        this.usertype = usertype;
    }
    
    public String getUsertype() {
        return usertype;
    }
//    public static UserDto createDto(UserDto entity) {
//        return new UserBuilder()
//                .id(entity.getId())
//                .pw(entity.getPw())
//                .usertype (entity.getUsertype())
//                .build();
//    }
    
}
