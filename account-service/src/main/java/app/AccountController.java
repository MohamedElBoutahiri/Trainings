package app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepo;

	@GetMapping("/accounts")
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

	@PostMapping("/account")
	public Account create(@RequestBody Account newAccount) {
		return accountRepo.save(newAccount);
	}

	@GetMapping("/account/{id}")
	public Account findById(@PathVariable Long id) {
		// normally we throw a custom exception
		return accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
	}

	@RequestMapping("/transfer")
	public String transfer(@RequestParam(required = true) Long idEmisor, @RequestParam(required = true) Long idReceptor,
			@RequestParam(required = true) double money) {

		Account emisor = accountRepo.findById(idEmisor)
				.orElseThrow(() -> new RuntimeException("Account with id" + idEmisor + " not found"));
		Account receptor = accountRepo.findById(idReceptor)
				.orElseThrow(() -> new RuntimeException("Account with id" + idReceptor + " not found"));

		String message = "";

		if (emisor.transfer(receptor, money)) {
			message = "The transfer has been done correctly";
		} else {
			message = "Ooops! The account has not enough money. The transfer is not possible. Get some cash ;)";
		}

		accountRepo.flush();

		return message;
	}
}
