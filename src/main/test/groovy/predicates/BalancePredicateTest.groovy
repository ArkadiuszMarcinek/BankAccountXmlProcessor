package predicates

import com.example.dto.BankAccount
import com.example.predicates.BalancePredicate
import spock.lang.Specification
import spock.lang.Unroll

class BalancePredicateTest extends Specification {

    def sut = new BalancePredicate()

    @Unroll
    def "Metoda test powinna zwrocic #expected gdy balance to #balance"() {

        when:
        def account = createBalance(balance)
        def result = sut.test(account)

        then:
        result == expected

        where:
        balance                 | expected
        null                    | false
        BigDecimal.ONE.negate() | false
        BigDecimal.ZERO         | true
        BigDecimal.ONE          | true
    }

    static BankAccount createBalance(BigDecimal balance) {
        BankAccount.builder().balance(balance).build()
    }
}
