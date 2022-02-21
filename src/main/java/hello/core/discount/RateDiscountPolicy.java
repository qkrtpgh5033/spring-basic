package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

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
