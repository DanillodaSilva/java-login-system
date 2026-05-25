import Domain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static  Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        while (true){
            System.out.println("=========MENU=========");
            System.out.println("1-register");
            System.out.println("2-login");
            System.out.println("3-exit");
            int op = sc.nextInt();
            switch (op){
                case 1 -> registerUser(userMap);
                case 2 -> loginUser(userMap);
                case 3 -> {
                    return;
                }
                default -> {
                        System.out.println("opção invalida");
                        continue;
                }

            }
        }
    }
    public static void registerUser(Map<Integer, User> userMap){
        boolean runin = true;
        while (runin) {
            System.out.println("=========REGISTERED=========\n");
            System.out.println("Enter the user name");
            String name = sc.next();
            System.out.println("Enter the user password");
            String password = sc.next();
            System.out.println("Enter the user id");
            int id = sc.nextInt();
            if (userMap.containsKey(id)) {
                System.out.println("This ID is already registered");
            }else {
                userMap.put(id, (new User(id, name, password)));
            }
            System.out.println("Do you want to register a new user");
            System.out.println("1-Yes");
            System.out.println("2-No");
            int op = sc.nextInt();
            if (op == 1){
                System.out.println("======REGISTERING NEW USER======");
                continue;
            } else if (op ==2) {

                break;
            }else {
                System.out.println("Invalid option");
                runin = false;
            }

        }
    }
    public static void loginUser(Map<Integer, User> userMap){
        System.out.println("=========LOGIN=========\n");
        System.out.println("Enter the user name");
        String name = sc.next();
        System.out.println("Enter the user password");
        String password = sc.next();
        System.out.println("Enter the user id");
        int id = sc.nextInt();
        Optional<User> user = Optional.ofNullable(userMap.get(id));
        if (user.isPresent()){
            User usuarioEncontrado = user.get();
            if(usuarioEncontrado.getPassword().equals(password) && usuarioEncontrado.getName().equals(name)){
                System.out.println("Login successful");
            }else {
                System.out.println("Incorrect username or password");
            }
        }else {
            System.out.println("User not found");
        }
    }
}