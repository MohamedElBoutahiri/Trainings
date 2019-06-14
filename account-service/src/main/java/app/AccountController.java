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
		// normally we throw an exception
		return accountRepo.findById(id).orElseThrow(null);
	}

	@RequestMapping("/transfer")
	public Account transfer(@RequestParam(required = true) Long idEmisor,
			@RequestParam(required = true) Long idReceptor, @RequestParam(required = true) double money) {

		Account emisor = accountRepo.findById(idEmisor).orElseThrow(null);
		Account receptor = accountRepo.findById(idReceptor).orElseThrow(null);

		receptor.balance += emisor.balance;

		return receptor;
	}
}
