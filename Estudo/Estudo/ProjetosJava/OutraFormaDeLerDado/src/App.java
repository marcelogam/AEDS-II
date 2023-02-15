import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String filme = JOptionPane.showInputDialog(null, "Qual o seu filme preferido de 2021 ate o momento? ", "title", JOptionPane.QUESTION_MESSAGE);
        String texto = JOptionPane.showInputDialog(null, "Digite um numero: ");
        int numero = Integer.parseInt(texto);
        numero = numero * 10;
        JOptionPane.showMessageDialog(null, "Filme preferido: "+filme, "Acdemia dos deves", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(filme);
        System.out.println(numero);
    }
}
