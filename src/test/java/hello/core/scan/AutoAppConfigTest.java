package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basic() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        OrderService orderService = ac.getBean(OrderService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);
    }

}
