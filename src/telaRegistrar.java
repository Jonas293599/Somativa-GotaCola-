import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class telaRegistrar extends JFrame {
    private JPanel Registrar;
    private JTextField textEmail;
    private JTextField textSenha;
    private JCheckBox termosCheckBox;
    private JButton botaoRegistrar;
    private JButton botaoCancelar;
    private JPanel Cancelar;

    telaRegistrar() throws HeadlessException{
        setTitle("Tela de registrar");
        setSize( 450, 250);
        setContentPane(Registrar);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        botaoRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeArquivo = "Usuarios.txt";

                try {
                    FileWriter escritor = new FileWriter(nomeArquivo, true);
                    escritor.write(textEmail.getText() + "|" + textSenha.getText() + "\n");
                    escritor.close();
                    JOptionPane.showMessageDialog(null, "Usuarios criado com sucesso");
                    dispose();
                } catch (IOException ex) {
                    System.out.println("Ocorreu um erro ao criar o arquivo:" + ex.getMessage());
                }
            }
        });
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
