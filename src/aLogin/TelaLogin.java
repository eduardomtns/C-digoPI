package aLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Login - Clínica Médica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBackground(new Color(173, 216, 230)); 

        JPanel painelCentralizado = new JPanel();
        painelCentralizado.setLayout(new GridBagLayout());
        painelCentralizado.setOpaque(false);  

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        JLabel lblTitulo = new JLabel("LOGIN");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(0, 51, 102));

        gbc.gridy = 0;
        gbc.insets = new Insets(-100, 10, 10, 10); 
        painelCentralizado.add(lblTitulo, gbc);
        
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10); 
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(2, 2, 10, 10));
        painelFormulario.setOpaque(false);

        JLabel lblUser = new JLabel("Usuário:");
        JTextField txtUser = new JTextField(20);

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(20);

        painelFormulario.add(lblUser);
        painelFormulario.add(txtUser);

        painelFormulario.add(lblSenha);
        painelFormulario.add(txtSenha);

        painelCentralizado.add(painelFormulario, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(15, 10, 0, 10);
        JButton btnEntrar = new JButton("Entrar");
        painelCentralizado.add(btnEntrar, gbc);

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String User = txtUser.getText().trim();
                String senha = new String(txtSenha.getPassword()).trim();

                if (User.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (User.equals("admin") && senha.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Dados incorretos. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        painel.add(painelCentralizado, BorderLayout.CENTER);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}
