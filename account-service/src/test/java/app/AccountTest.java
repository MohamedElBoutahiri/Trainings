package app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	private Account account1;
	private Account account2;

	@Before
	public void init() {

		account1 = new Account();
		account1.setBalance(200);
		account1.setCurrency("Eur");
		account1.setName("Jhon");
		account1.setTreasury(true);
		account1.setId(1L);

		account2 = new Account();
		account2.setBalance(200);
		account2.setCurrency("Eur");
		account2.setName("Mohamed");
		account2.setTreasury(true);
		account2.setId(1L);

	}

	@Test
	public void testTransfer_Treasury_NoEnoughMoney_OK() {
		assertTrue(account1.transfer(account2, 500));
	}

	@Test
	public void testTransfer_Treasury_EnoughMoney_OK() {
		assertTrue(account1.transfer(account2, 200));
	}

	@Test
	public void testTransfer_NoTreasury_NoEnoughMoney_KO() {
		account1.setTreasury(false);
		assertFalse(account1.transfer(account2, 1000));
	}

	@Test
	public void testTransfer_NoTreasury_EnoughMoney_OK() {
		account1.setTreasury(false);
		assertTrue(account1.transfer(account2,100 ));
	}

	@Test
	public void testEqualsObject_KO() {
		assertFalse(account1.equals(account2));
	}

	@Test
	public void testToString_NotNull() {
		assertNotNull(account1.toString());
	}

}
