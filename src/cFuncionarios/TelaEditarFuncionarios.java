  package cFuncionarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditarFuncionarios extends JFrame {

    public TelaEditarFuncionarios() {
        setTitle("Editar Funcionário - Clínica Médica");
        setSize(800, 700); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBackground(new Color(173, 216, 230)); 

        JPanel painelEspacoTopo = new JPanel();
        painelEspacoTopo.setPreferredSize(new Dimension(800, 50));  
        painelEspacoTopo.setBackground(new Color(173, 216, 230));  
        painel.add(painelEspacoTopo, BorderLayout.NORTH);

        JLabel lblTitulo = new JLabel("Editar Funcionário");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridBagLayout());
        painelFormulario.setBackground(new Color(173, 216, 230)); 
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNome = new JLabel("Selecione o Nome:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelFormulario.add(lblNome, gbc);

        String[] nomesFuncionarios = {"Lucas Rodrigues", "Everton" ,"João Santos", "Ana Lima", "Carlos Silva", "Patrícia Costa", "Fernanda Souza", "Ricardo Pereira", "Juliana Rocha",};
        JComboBox<String> cbNome = new JComboBox<>(nomesFuncionarios);
        gbc.gridx = 1;
        gbc.gridy = 0;
        painelFormulario.add(cbNome, gbc);

        JLabel lblEmail = new JLabel("E-mail:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelFormulario.add(lblEmail, gbc);

        JTextField txtEmail = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        painelFormulario.add(txtEmail, gbc);

        JLabel lblPerfil = new JLabel("Perfil:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelFormulario.add(lblPerfil, gbc);

        String[] perfis = {"ADMINISTRADOR", "ATENDENTE", "MÉDICO"};
        JComboBox<String> cbPerfil = new JComboBox<>(perfis);
        gbc.gridx = 1;
        gbc.gridy = 2;
        painelFormulario.add(cbPerfil, gbc);

        JLabel lblDocIdentificacao = new JLabel("Documento de Identificação:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelFormulario.add(lblDocIdentificacao, gbc);

        JTextField txtDocIdentificacao = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        painelFormulario.add(txtDocIdentificacao, gbc);

        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        painelFormulario.add(lblDataNascimento, gbc);

        JTextField txtDataNascimento = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        painelFormulario.add(txtDataNascimento, gbc);

        JLabel lblSexo = new JLabel("Sexo:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        painelFormulario.add(lblSexo, gbc);

        String[] sexos = {"Masculino", "Feminino", "Outro"};
        JComboBox<String> cbSexo = new JComboBox<>(sexos);
        gbc.gridx = 1;
        gbc.gridy = 5;
        painelFormulario.add(cbSexo, gbc);

        JLabel lblTelefone = new JLabel("Telefone de Contato:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        painelFormulario.add(lblTelefone, gbc);

        JTextField txtTelefone = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        painelFormulario.add(txtTelefone, gbc);

        JLabel lblCidade = new JLabel("Cidade:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        painelFormulario.add(lblCidade, gbc);

        JTextField txtCidade = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 7;
        painelFormulario.add(txtCidade, gbc);

        JLabel lblBairro = new JLabel("Bairro:");
        gbc.gridx = 0;
        gbc.gridy = 8;
        painelFormulario.add(lblBairro, gbc);

        JTextField txtBairro = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 8;
        painelFormulario.add(txtBairro, gbc);

        JLabel lblEstado = new JLabel("Estado:");
        gbc.gridx = 0;
        gbc.gridy = 9;
        painelFormulario.add(lblEstado, gbc);

        JTextField txtEstado = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 9;
        painelFormulario.add(txtEstado, gbc);

        JLabel lblUsuario = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 10;
        painelFormulario.add(lblUsuario, gbc);

        JTextField txtUsuario = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 10;
        painelFormulario.add(txtUsuario, gbc);

        JLabel lblSenha = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 11;
        painelFormulario.add(lblSenha, gbc);

        JPasswordField txtSenha = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 11;
        painelFormulario.add(txtSenha, gbc);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT));
        painelBotoes.setBackground(new Color(173, 216, 230));

        JButton btnSalvar = new JButton("Salvar Alterações");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnSair = new JButton("Sair");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnSair);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeSelecionado = (String) cbNome.getSelectedItem();
                String email = txtEmail.getText().trim();
                String docIdentificacao = txtDocIdentificacao.getText().trim();
                String dataNascimento = txtDataNascimento.getText().trim();
                String telefone = txtTelefone.getText().trim();
                String cidade = txtCidade.getText().trim();
                String bairro = txtBairro.getText().trim();
                String estado = txtEstado.getText().trim();
                String usuario = txtUsuario.getText().trim();
                String senha = new String(txtSenha.getPassword()).trim();

                if (email.isEmpty() || docIdentificacao.isEmpty() || dataNascimento.isEmpty() ||
                        telefone.isEmpty() || cidade.isEmpty() || bairro.isEmpty() || estado.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Alterações salvas para " + nomeSelecionado + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEmail.setText("");
                cbPerfil.setSelectedIndex(0);
                txtDocIdentificacao.setText("");
                txtDataNascimento.setText("");
                cbSexo.setSelectedIndex(0);
                txtTelefone.setText("");
                txtCidade.setText("");
                txtBairro.setText("");
                txtEstado.setText("");
                txtUsuario.setText("");
                txtSenha.setText("");
            }
        });
      
            btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        painel.add(lblTitulo, BorderLayout.NORTH);
        painel.add(painelFormulario, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaEditarFuncionarios tela = new TelaEditarFuncionarios();
                tela.setVisible(true);
            }
        });
    }
}
