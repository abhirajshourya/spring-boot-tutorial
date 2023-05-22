package com.direwxlf.springboot.tutorial.school.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
    @AttributeOverride(name = "name", column = @Column(name = "guardian_name")),
    @AttributeOverride(name = "emailId", column = @Column(name = "guardian_email")),
    @AttributeOverride(name = "contact", column = @Column(name = "guardian_contact"))
})
public class Guardian {
    private String name;
    private String emailId;
    private String contact;
}
