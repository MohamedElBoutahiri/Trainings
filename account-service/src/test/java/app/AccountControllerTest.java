package app;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccountRepository accountRepo;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void testGetAll_thenReturnJsonArray() throws Exception {
		Account account = new Account();
		account.setBalance(200);
		account.setCurrency("Eur");
		account.setName("Mohamed");
		account.setTreasury(false);

		List<Account> accounts = Arrays.asList(account);

		given(accountRepo.findAll()).willReturn(accounts);

		mvc.perform(get("/accounts").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is(account.getName())));

	}

	@Test
	public void testCreate_thenReturnJsonArray() throws Exception {
		Account account = new Account();
		account.setBalance(200);
		account.setCurrency("Eur");
		account.setName("Mohamed");
		account.setTreasury(false);

		given(accountRepo.save(any())).willReturn(account);

		mvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(account))).andExpect(status().isOk())
				.andExpect(jsonPath("name", is(account.getName())));

	}

	@Test
	public void testFindById_thenReturnJsonArray() throws Exception {
		Account account = new Account();
		account.setBalance(200);
		account.setCurrency("Eur");
		account.setName("Mohamed");
		account.setTreasury(false);
		account.setId(1L);

		given(accountRepo.findById(1L)).willReturn(Optional.of(account));

		mvc.perform(get("/account/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("name", is(account.getName())));

	}

	@Test
	public void testTransfer_thenReturnOkMessage() throws Exception {
		Account account = new Account();
		account.setBalance(200);
		account.setCurrency("Eur");
		account.setName("Mohamed");
		account.setTreasury(false);
		account.setId(1L);

		Account account2 = new Account();
		account.setBalance(200);
		account.setCurrency("Eur");
		account.setName("Jhon");
		account.setTreasury(false);
		account.setId(2L);

		given(accountRepo.findById(1L)).willReturn(Optional.of(account));
		given(accountRepo.findById(2L)).willReturn(Optional.of(account2));

		mvc.perform(get("/transfer?idEmisor=1&idReceptor=2&money=200").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString()
				.contains("The transfer has been done correctly");
	}
}