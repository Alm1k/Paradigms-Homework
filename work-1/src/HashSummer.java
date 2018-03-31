import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class HashSummer {
    static String getHash(byte[] bytes, String algorithm, int needLen) {
        StringBuilder hashText = null;
        try {
            MessageDigest m = MessageDigest.getInstance(algorithm);
            m.reset();
            m.update(bytes);

            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            hashText = new StringBuilder(bigInt.toString(16));

            while (hashText.length() < needLen) {
                hashText.insert(0, "0");
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println("I can't work with this algorithm");
        }

        return hashText != null ? hashText.toString().toUpperCase() : null;
    }
}
