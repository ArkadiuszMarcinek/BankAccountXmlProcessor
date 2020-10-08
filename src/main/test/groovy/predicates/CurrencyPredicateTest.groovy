package predicates

import com.example.dto.BankAccount
import com.example.predicates.CurrencyPredicate
import spock.lang.Specification
import spock.lang.Unroll

class CurrencyPredicateTest extends Specification {
    def sut = new CurrencyPredicate()

    @Unroll
    def "Metoda test powinna zwrocic #expected gdy balance to #currency"() {

        when:
        def account = createCurrency(currency)
        def result = sut.test(account)

        then:
        result == expected

        where:
        currency | expected
        null     | false
        "pln"    | false
        "USD"    | false
        "PLN"    | true
    }

    static BankAccount createCurrency(String currency) {
        BankAccount.builder().currency(currency).build()
    }
}
