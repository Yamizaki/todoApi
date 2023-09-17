package com.rest.rest.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;

import java.util.Date;
import lombok.Data;




@Data
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
   
    private String description;
    
    private boolean status;
    
    private boolean hidden;
    
    private Date createdAt;
    
    
    public Task() {
           this.createdAt = new Date();
           this.hidden = false;
           this.status = false;
       }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
