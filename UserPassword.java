import java.util.Scanner;

public class UserPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many random passwords do you want to generated?");
        int total_password = scanner.nextInt();
        System.out.println("How many length of password do you want to generated? ");
        int total_length = scanner.nextInt();
        securityLength(total_length);
        String[] passwordArray = new String[total_password];
        //Loop through total number of passwords
        for (int i = 0; i < total_password; i++) {
            //Generate one random password
            String random_Password = "";
            for (int j = 0; j < total_length; j++) {
                random_Password = random_Password + randomCharacter();
            }
            passwordArray[i] = random_Password;
        }
        printPassword(passwordArray);
    }
    public static void securityLength(int security_length) throws ArrayIndexOutOfBoundsException {
        if (security_length < 5) {
            throw new ArrayIndexOutOfBoundsException("Bad Security");
        }
    }
    public static void printPassword(String[] arr) {
        for (String str : arr) {
            System.out.println(str);
        }
    }
    // '0'-'9' => 48-57 in ASCII
    // 'A' - 'Z' => 65-90 in ASCII
    // 'a' - 'z' => 97 - 122 in ASCII
    public static char randomCharacter() {

        //Generate a random number that represents all possible characters in our password
        //10digits + 26 uppercase letters + 26 lowercase letters = 62 possible characters

        int rand = (int) (Math.random() * 62);

        // Break up rand into intervals to represent numbers,uppercase letters
        // rand is between 0-61 inclusive
        //if rand is between 0-9 => number
        //if rand is between 10-35 => uppercase
        // if rand is between 36-61 => lowercase

        if (rand <= 9) {
            int ascii_value = rand + 48;
            return (char) (ascii_value);
        } else if (rand <= 35) {
            int ascii_value2 = rand + 55;
            return (char) (ascii_value2);
        } else {
            int ascii_value3 = rand + 61;
            return (char) (ascii_value3);
        }
    }
}