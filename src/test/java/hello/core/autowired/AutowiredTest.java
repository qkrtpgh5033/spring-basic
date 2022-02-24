package hello.core.autowired;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }


    static class TestBean{

        @Autowired(required = false) // 자동 주입할 대상이 없으면 호출도 안됨.
        public void setNoBean1(Member member)
        {
            System.out.println("mebmer = " + member);
        }

        @Autowired  // 자동 주입할 대상이 없으면 null 값이 입렵됨
        public void setNoBean2(@Nullable Member member)
        {
            System.out.println("member = " + member);
        }

        @Autowired // 자동 주입할 대상이 없으면 Optional.empty가 입력됨
        public void setNoBean3(Optional<Member> member)
        {
            System.out.println("member = " + member);
        }
    }
}
