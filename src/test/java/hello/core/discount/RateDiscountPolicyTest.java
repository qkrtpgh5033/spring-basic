package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("10% 할인(Vip)")
    void vip_o()
    {
        Member memberVip = new Member(1L, "memberVip", Grade.VIP);
        int discount = rateDiscountPolicy.discount(memberVip, 10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("10% 할인(Basic)")
    void vip_x()
    {
        Member memberVip = new Member(1L, "memberBasic", Grade.BASIC);
        int discount = rateDiscountPolicy.discount(memberVip, 10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }


}