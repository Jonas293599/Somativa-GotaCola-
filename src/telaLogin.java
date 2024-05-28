import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class telaLogin extends JFrame {
    private JPanel Login;
    private JTextField textEmail;
    private JCheckBox termos;
    private JButton botaoLogar;
    private JButton botaoCancelar;
    private JTextField textSenha;

    public telaLogin() throws HeadlessException {
        super();
        setTitle("Tela Login");
        setLocationRelativeTo(null);
        setSize(450, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(Login);
        Login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                telaRegistrar cadastro = new telaRegistrar();
                cadastro.setVisible(true);
            }
        });
        botaoLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomearquivo = "Usuarios.txt";

                try {
                    BufferedReader leitor = new BufferedReader(new FileReader(nomearquivo));
                    String linha;
                    boolean usu = false;
                    do{
                        linha = leitor.readLine();
                        if(linha != null){
                            String[] u = linha.split("\\|");
                            if(u[0].equals(textEmail.getText()) && u[1].equals(textSenha.getText())){
                                usu = true;
                                break;
                            }
                        }
                    }while(linha != null);
                    leitor.close();
                    if (usu){
                        JOptionPane.showMessageDialog(null,"Usuario encontrado.");
                        setVisible(true);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Não foi possivel encontrar usuario.");
                }
            }
        });
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaInicial l = new telaInicial();
                dispose();
            }
        });

    }
}
