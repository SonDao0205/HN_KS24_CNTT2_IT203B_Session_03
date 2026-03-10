package BTTH.service;

import BTTH.model.*;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<User> getVerifiedUsers(List<User> users){
        return users.stream().filter(User::verified).toList();
    }

    public static Tier classifyTier(long months) {
        return switch ((Long) months) {
            case Long m when m > 24 -> new Gold();
            case Long m when m > 12 -> new Silver();
            default -> new Bronze();
        };
    }
}
