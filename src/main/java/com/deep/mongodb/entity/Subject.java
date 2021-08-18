package com.deep.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "subject")
public class Subject {

    @Id
    private String id;

//    @Field(name = "subjectName")
    private String subjectName;

    @Field(name = "marksObtained")
    private int marksObtained;

}
