/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 *
 * @author PC
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class UserDTO {
    private String userID;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private String roleID;
}
