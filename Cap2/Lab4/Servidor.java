import java.io.*;
import java.net.*;

public class Servidor
{

    public static void main(String[] args) throws Exception {

        ServerSocket servidor = null;
        Socket cliente = null;

        servidor = new ServerSocket(8080);
        int n = 1;
        while (true) {
            cliente = servidor.accept();
            System.out.println("*** conexão no. " + n);
            Worker thread = new Worker(cliente, n++);
            thread.start();
        }
    }
    
    private static class Worker extends Thread
    {
        int n;
        Socket cliente;
        
        public Worker(Socket cliente, int n) throws Exception {
            this.cliente = cliente;
            this.n = n;
        }
        
        public void run() {
            System.out.println("*** início do thread no. " + n);
            PrintWriter out = null;
            BufferedReader in = null;
            
            try {
                out = new PrintWriter(
                    cliente.getOutputStream(), true);
                in = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));
                String linha;
                while ((linha = in.readLine()) != null) {
                    out.println(linha);
                    System.out.println(n + ": " + linha);
                }
            }
            catch (Exception e) {
                System.err.println("Erro no thread" + n + ": "
                    + e.getMessage());
            }
            finally {
                try {
                    if (out != null) out.close();
                    if (in != null) in.close();
                    cliente.close();
                }
                catch (Exception e) {}
            }
            System.out.println("*** fim do thread no. " + n);
        }
    }
}
