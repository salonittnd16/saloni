package com.im.test

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TransactionSpec extends Specification {

//    @Shared
//            transaction = new Transaction()

//    void "Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
//        setup:
//        Product product = new Product(price: 100)
//        User user = new User(balance: 200)
//
//        when:
//        transaction.sell(product, user)
//
//        then:
//        user.balance ==  100.toBigDecimal()



//    }

    def"sell product"()
    {
        given:
        Transaction transaction=new Transaction()
        User user=new User(balance:bal)
        Product product=new Product(price:p)


        when:
        transaction.sell(product,user)


        then:
        user.balance==(bal-p).toBigDecimal()

        where:
        bal | p
        200 | 150


    }



    def"cancel sale"()
    {
        given:
        Transaction transaction=new Transaction()
        User user=new User(balance:bal)
        Product product=new Product(name:"abcd",price:p)

        and:
        def mockedEmailService = Mock(EmailService)
        transaction.emailService = mockedEmailService


        when:
        transaction.cancelSale(product,user)


        then:
        1 * mockedEmailService.sendCancellationEmail(user, _ as String)

        where:
        bal | p
        200 | 150
        300 | 200

    }



    def"calculate discount"()
    {
        given:
        Transaction transaction=new Transaction()
        User user=new User(balance:b,isPrivellegedCustomer:true)
        Product product=new Product(name:"abcd",price:p,discountType:"PRIVELLEGE_ONLY")

        when:
        BigDecimal discount=transaction.calculateDiscount(product,user)

        then:
        discount==expectedDiscount

        where:

        b | p | expectedDiscount
        1000| 500| 150



    }



//    def"get all popular products"()
//    {   given:
//      def l=["handbag"]
//
//        Transaction transaction=new Transaction()
//        Product product=new Product(name:"handbag",price:1000,isPopular:true)
//        product.metaClass.getCurrentProducts={ return l }
//        //List<Product>p=new Product()
//        //p.add(product)
//
//
//
//        when:
//        List l1=transaction.getAllPopularProducts()
//
//        then:
//        l1.contains("handbag")==true
//
//
//
//
//
//
//
//
//
//
//    }
//



//

//
//    void "Improvement #1 Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
//        given:
//        Product product = new Product(price: 100)
//
//        and:
//        User user = new User(balance: 200)
//
//        when:
//        transaction.sell(product, user)
//
//        then:
//        user.balance ==  100.toBigDecimal()
//    }
//
//
//    void "Improved #2 Sell subtracts the balance of a user by the price of the product and adds product to the purchased products"(){
//        given:
//        Product product = new Product(price: 100)
//
//        and:
//        User user = new User(balance: 200)
//
//        expect:
//        !user.isPrivellegedCustomer
//        product.discountType == DiscountType.NONE
//
//        when:
//        transaction.sell(product, user)
//
//        then:
//        user.balance ==  100.toBigDecimal()
//    }
//
//
//    void "An exception is thrown if user's balance is not enough"(){
//        given:
//        Product product = new Product(price: 100)
//
//        and:
//        User user = new User(balance: 50)
//
//        when:
//        transaction.sell(product, user)
//
//        then:
//        def e =thrown(SaleException)
//        e.message == "Not enough account balance"
//    }
//
//    void "Improvement #1 An exception is thrown if user's balance is not enough"(){
//        given:
//        Product product = new Product(price: 100)
//
//        and:
//        User user = new User(balance: balance)
//
//        when:
//        transaction.sell(product, user)
//
//        then:
//        def e =thrown(SaleException)
//        e.message == "Not enough account balance"
//
//        where:
//        balance << [50, 0]
//    }
//
//    @Unroll("An exception is thrown when #description")
//    void "Improvement #2 An exception is thrown if user's balance is not enough"(){
//        given:
//        Product product = new Product(price: 100)
//
//        and:
//        User user = new User(balance: balance)
//
//        when:
//        transaction.sell(product, user)
//
//        then:
//        def e =thrown(SaleException)
//        e.message == "Not enough account balance"
//
//        where:
//        balance << [50, 0]
//
//        description = balance==50?'less than product cost': 'user has no balance'
//    }
//}
}