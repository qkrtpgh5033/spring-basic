package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Bean 등록 확인")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {

            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " bean = " + bean);
        }

    }

    @Test
    @DisplayName("애플리케이션 빈 확인하기")
    void findApplicaitionBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);


            //ROLE_APPLICATION : 사용자가 직접 등록한 빈
            //ROLE_INFRASTRUCTURE : 스프링 내부에서 등록한 빈
            if(beanDefinition.getRole() == beanDefinition.ROLE_INFRASTRUCTURE)
            {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName+ "object = " + bean);

            }

        }

    }

}
