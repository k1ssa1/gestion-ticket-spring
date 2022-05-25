package emsi.ssii.devoir.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import emsi.ssii.devoir.models.Admin;
import emsi.ssii.devoir.models.Client;
import emsi.ssii.devoir.models.Dev;
import emsi.ssii.devoir.repo.UserRepo;

@Component
public class DBSeeder implements CommandLineRunner {

    @Autowired
    private UserRepo<Admin> aRepo;
    @Autowired
    private UserRepo<Dev> dRepo;
    @Autowired
    private UserRepo<Client> cRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (aRepo.findAll().isEmpty()) {
            Admin admin = new Admin();
            admin.setDisplayName("Admin");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRole(Constants.getRole("admin"));
            aRepo.save(admin);

            Client client = new Client();
            client.setDisplayName("Sami");
            client.setEmail("sami@gmail.com");
            client.setPassword(passwordEncoder.encode("123456"));
            client.setRole(Constants.getRole("client"));
            cRepo.save(client);
        
            Dev dev = new Dev();
            dev.setDisplayName("John");
            dev.setEmail("doe@gmail.com");
            dev.setPassword(passwordEncoder.encode("123456"));
            dev.setRole(Constants.getRole("dev"));
            dRepo.save(dev);
        }
    }

}

