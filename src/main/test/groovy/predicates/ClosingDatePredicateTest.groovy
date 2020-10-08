package predicates

import com.example.dto.BankAccount
import com.example.predicates.ClosingDatePredicate
import spock.lang.Specification
import spock.lang.Unroll

class ClosingDatePredicateTest extends Specification {
    def sut = new ClosingDatePredicate()

    @Unroll
    def "Metoda test powinna zwrocic #expected gdy closingDate to #closingDate"() {

        when:
        def account = createClosingDate(closingDate)
        def result = sut.test(account)

        then:
        result == expected

        where:
        closingDate  | expected
        null         | false
        "2010-01-01" | false
        "2029-10-11" | true

    }

    static BankAccount createClosingDate(String closingDate) {
        BankAccount.builder().closingDate(closingDate).build()
    }
}
