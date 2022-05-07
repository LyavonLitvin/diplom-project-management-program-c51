package com.example.diplomprojectmanagementprogramc51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
public class DiplomProjectManagementProgramC51Application {

    public static void main(String[] args) {
        SpringApplication.run(DiplomProjectManagementProgramC51Application.class, args);

    }

}
