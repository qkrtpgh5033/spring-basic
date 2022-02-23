package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(// 스프링 빈을 자동으로 등록

        // 탐색 할 위치를 지정, 존재 이유 : 이 기능이 없으면 자바 코드를 전부 다 살펴야 됨
        // 디폴트 값은 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치
        // ★권장 : 설정 정보의 클래스 위치를 프로젝트 최상단에 위치 -> hello.core
        basePackages = "hello.core",

        // 뺄거를 지정 ( 실무에서 잘 사용은 안함, 기존 예제코드를 살리기 위해 사용 )
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {

//    @Bean("memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
