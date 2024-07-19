package com.neoteric.javatdd;

import com.neoteric.javatdd.account.AccountEntity;
import com.neoteric.javatdd.account.AccountService;
import com.neoteric.javatdd.account.BankTranferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class AccountServiceTest {


    private AccountEntity accountEntity;

    @Mock
    private BankTranferService bankTranferService;

    @BeforeEach
    public  void  setUp(){
        accountEntity = new AccountEntity("ACC123456","uday",10000.0,25);
    }

   @Test
    public  void  accountCreation(){
        AccountEntity account= Mockito.mock(AccountEntity.class);
        //Arrange
        when(account.getBalance()).thenReturn(10000.0);
        //ACT
      //  AccountEntity account = AccountService.createAccount("ACC123456", "John Doe", 10000.0, 25);
        //Assertion
//    assertNotNull(account);
//    assertEquals("ACC123456",account.getAccountNumber());
//    assertEquals("uday",account.getName());
//       assertEquals(10000.0, account.getBalance());
//       assertEquals(25, account.getAge());


  //  spy()
    //get
       //


}
}
