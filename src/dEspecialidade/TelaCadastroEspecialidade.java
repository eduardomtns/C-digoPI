package dEspecialidade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroEspecialidade extends JFrame {

    public TelaCadastroEspecialidade() {
        setTitle("Cadastro de Especialidades - Clínica Médica");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBackground(new Color(173, 216, 230));

        JPanel painelCentralizado = new JPanel();
        painelCentralizado.setLayout(new GridBagLayout());
        painelCentralizado.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(3, 2, 10, 10));
        painelFormulario.setOpaque(false);

        JLabel lblTitulo = new JLabel("Criar Especialidade");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblNome = new JLabel("Nome da Especialidade:");
        JTextField txtNome = new JTextField(20);

        JLabel lblDescricao = new JLabel("Descrição da Especialidade:");
        JTextArea txtDescricao = new JTextArea(5, 30);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        JScrollPane scrollDescricao = new JScrollPane(txtDescricao);

        JLabel lblMedico = new JLabel("Nome do Médico:");
        JComboBox<String> comboMedico = new JComboBox<>(new String[]{
                "Everton", "João Santos", "Ana Lima", "Carlos Silva"
        });

        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);
        painelFormulario.add(lblDescricao);
        painelFormulario.add(scrollDescricao);
        painelFormulario.add(lblMedico);
        painelFormulario.add(comboMedico);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        painelBotoes.setOpaque(false);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnVoltar = new JButton("Voltar");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnVoltar);

        gbc.gridy++;
        painelCentralizado.add(lblTitulo, gbc);

        gbc.gridy++;
        painelCentralizado.add(painelFormulario, gbc);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String descricao = txtDescricao.getText();
                String medico = (String) comboMedico.getSelectedItem();

                if (nome.isEmpty() || descricao.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Dados faltando! Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Especialidade Salva com Sucesso!\n\n"
                            + "Nome: " + nome + "\n"
                            + "Descrição: " + descricao + "\n"
                            + "Médico: " + medico);
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtDescricao.setText("");
                comboMedico.setSelectedIndex(0);
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Voltando ao Menu Principal!");
            }
        });

        painel.add(painelCentralizado, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastroEspecialidade().setVisible(true);
        });
    }
}
