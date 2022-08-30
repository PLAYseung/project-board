package project.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan // ThymleafConfig와 연관 있는 부분
@SpringBootApplication
public class ProjectBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectBoardApplication.class, args);
    }

}
