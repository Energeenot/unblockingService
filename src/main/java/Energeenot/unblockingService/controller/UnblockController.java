package Energeenot.unblockingService.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Slf4j
public class UnblockController {

    private final Random random = new Random();

    @GetMapping("/unlock-account")
    public ResponseEntity<String> unlockAccount(@RequestParam String accountId) {
        System.out.println("unlock account " + accountId);
//        log.info("Unlocking account {}", accountId);
        boolean unlocked = random.nextBoolean();
        return unlocked
                ? ResponseEntity.ok("Account with id: "+ accountId + " liberate")
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account with id: " + accountId + " remains arrested");
    }

    @GetMapping("unlock-client")
    public ResponseEntity<String> unlockClient(@RequestParam String clientId) {
        System.out.println("unlock client " + clientId);
//        log.info("Unlocking client {}", clientId);
        boolean unlocked = random.nextBoolean();
        return unlocked
                ? ResponseEntity.ok("Client with id: " + clientId + " unblocked")
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Client with id: " + clientId + " remains blocked");
    }

}
