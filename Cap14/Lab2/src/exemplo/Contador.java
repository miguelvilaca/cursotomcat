package exemplo;

public class Contador implements java.io.Serializable {

  private int contagem = 0;

  public int getProximoValor() {
      return ++contagem;
  }
}
