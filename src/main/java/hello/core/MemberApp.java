package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링 컨테이너, 스핑은 ApplicationContext으로 시작
        // @Bean과 같은걸 모두 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// name은 메서드 이름으로 디폴트
        Member member = new Member(1L, "memberA", Grade.VIP);
        Member memberB = new Member(2L, "memberB", Grade.BASIC);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("same = " + member.equals(findmember));



    }
}
