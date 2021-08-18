package com.deep.mongodb;
//This class is used to remove _class from MongoDB

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import javax.annotation.PostConstruct;

@Configuration
public class AppMongoConfig {


        @Autowired 
        private MappingMongoConverter mappingMongoConverter;

        @PostConstruct
        public void setUpMongoEscapeCharacterConversion() {
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        }


}
