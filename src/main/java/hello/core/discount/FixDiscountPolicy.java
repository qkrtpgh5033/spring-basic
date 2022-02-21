package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        // enum 타입은 equal이 아닌 == 쓰는게 맞음
        return (member.getGrade() == Grade.VIP) ? discountFixAmount : 0;


    }

}
