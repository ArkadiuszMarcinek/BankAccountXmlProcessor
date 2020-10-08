package predicates

import com.example.dto.BankAccount
import com.example.predicates.IbanPredicate
import spock.lang.Specification
import spock.lang.Unroll

class IbanPredicateTest extends Specification {
    def sut = new IbanPredicate()

    @Unroll
    def "Metoda test powinna zwrocic #expected gdy iban to #iban"() {

        when:
        def account = createIban(iban)
        def result = sut.test(account)

        then:
        result == expected

        where:
        iban                                  | expected
        null                                  | false
        "pln"                                 | false
        BankAccountsForTest.bankAccount1.iban | false
        "PL33114020040000310246414252"        | true
    }

    static BankAccount createIban(String iban) {
        BankAccount.builder().iban(iban).build()
    }
}