package hello.core.discount;

import hello.core.annotation.MainDiscounPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscounPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private final int rate = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP)
            return price * rate / 100;
        else
            return 0;
    }
}
