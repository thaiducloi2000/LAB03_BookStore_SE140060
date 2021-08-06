/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.sql.Date;
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


public class BookDTO implements Serializable{
    private String bookID;
    private String title;
    private String image;
    private String description;
    private float price;
    private int quantity;
    private String author;
    private String cateID;
    private boolean status;
    private Date createDate;
}
