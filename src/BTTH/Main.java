package BTTH;

import BTTH.model.PublicUser;
import BTTH.model.User;
import BTTH.service.UserService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("1","user1@gmail.com","123123",true, LocalDate.now()),
                new User("2","user2@gmail.com","123123",false, LocalDate.now()),
                new User("3","user3@gmail.com","123123",false, LocalDate.now()),
                new User("4","user4@gmail.com","123123",true, LocalDate.now()),
                new User("5","user5@gmail.com","123123",true, LocalDate.now())
        );

        List<PublicUser> publicUsers = UserService.getVerifiedUsers(users).stream().map(u -> {
            long months = Period.between(u.createdAt(), LocalDate.now()).toTotalMonths();
            return new PublicUser(u.id(),u.email(),UserService.classifyTier(months));
        }).toList();

        String reportHeader = """
            +------+----------------------+------------+
            | ID   | EMAIL                | TIER       |
            +------+----------------------+------------+
            """;
        System.out.print(reportHeader);
        publicUsers.forEach(u ->
                System.out.printf("| %-4s | %-20s | %-10s |%n", u.id(), u.email(), u.tier())
        );
        System.out.println("+------+----------------------+------------+");

    }
}
