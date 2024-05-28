import javax.management.BadAttributeValueExpException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaInicial extends JFrame {
    private JPanel Inicial;
    private JTextPane novoNaBLAIDDTextPane;
    private JButton botaoRegistra;
    private JTextArea voceJáPossuiUmaTextArea;
    private JButton botaoLogar;

    public telaInicial() throws HeadlessException{
        super();
        setTitle("Tela Login");
        setContentPane(Inicial);
        setLocationRelativeTo(null);
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        botaoLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaLogin l = new telaLogin();
                dispose();
            }
        });
        botaoRegistra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaRegistrar r = new telaRegistrar();
                dispose();
            }
        });

    }
    public static void main(String []args){
        telaInicial login = new telaInicial();
        login.setVisible(true);
    }
}
