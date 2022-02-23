package com.boda.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableJpaAuditing //이걸로 BaseTimeEntity를 상속받는 Entity들을 만들 수 있다.
@SpringBootApplication
public class BodaBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BodaBoardApplication.class, args);
    }

}
