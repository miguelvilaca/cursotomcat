import java.security.MessageDigest;

class CriptografaSenha
{
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Uso: java CriptografaSenha <algoritmo> <senha>");
            System.err.println("OBS: Os únicos algoritmos garantidos são MD5 e SHA1");
            System.exit(1);
        }
        MessageDigest md = MessageDigest.getInstance(args[0]);
        byte[] hash = md.digest(args[1].getBytes());
        // exibe a senha criptografada como uma string em hexadecimal
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i]);
            int len = hex.length();
            if (len == 1)
                System.out.print("0" + hex);
            else
                System.out.print(hex.substring(len - 2, len));
        }
        System.out.println();
    }  
}
