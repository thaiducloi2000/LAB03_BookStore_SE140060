/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
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
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDTO implements Serializable{
    private String cateID;
    private String cateName;
}
