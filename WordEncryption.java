public class WordEncryption {
    public static String encryptString(String input, int key) {
        StringBuilder encrypted = new StringBuilder(); 
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) { 
                int base = Character.isLowerCase(c) ? 'a' : 'A'; 
                int characterValue = (c - base + 1); 
                int encryptedValue = (characterValue + key) % 26;
                if (encryptedValue == 0) encryptedValue = 26; 
                char encryptedChar = (char) (base + encryptedValue - 1);
                if (Character.isLowerCase(c)) {
                    encrypted.append(Character.toUpperCase(encryptedChar));
                } else {
                    encrypted.append(Character.toLowerCase(encryptedChar));
                }
            } else {
                encrypted.append(c); 
            }
        }

        return encrypted.toString(); 
    }
    public static void main(String[] args) {
        String input1 = "Wipro Tech";
        int key = 20;
        String encryptedString1 = encryptString(input1, key);

        System.out.println("Encrypted String: " + encryptedString1); 
    }
}
