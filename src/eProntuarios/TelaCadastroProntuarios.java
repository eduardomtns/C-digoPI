package eProntuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TelaCadastroProntuarios extends JFrame {

    private HashMap<String, String> prontuarios = new HashMap<>();

    public TelaCadastroProntuarios() {
        setTitle("Prontuários - Clínica Médica");
        setSize(800, 700); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBackground(new Color(173, 216, 230));

        JLabel lblTitulo = new JLabel("Cadastro de Prontuários");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(0, 51, 102));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(lblTitulo, BorderLayout.NORTH);

        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridBagLayout());
        painelFormulario.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblCPF = new JLabel("CPF do Paciente:");
        JTextField txtCPF = new JTextField(20);

        JLabel lblNome = new JLabel("Nome Completo:");
        JTextField txtNome = new JTextField(20);

        JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
        JTextField txtDataNascimento = new JTextField(15);

        JLabel lblSexo = new JLabel("Sexo:");
        String[] opcoesSexo = {"Masculino", "Feminino", "Outro"};
        JComboBox<String> cbSexo = new JComboBox<>(opcoesSexo);

        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField(15);

        JLabel lblEmail = new JLabel("E-mail:");
        JTextField txtEmail = new JTextField(20);

        JLabel lblEndereco = new JLabel("Endereço:");
        JTextField txtEndereco = new JTextField(30);

        JLabel lblCidade = new JLabel("Cidade:");
        JTextField txtCidade = new JTextField(15);

        JLabel lblEstado = new JLabel("Estado:");
        String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
        JComboBox<String> cbEstado = new JComboBox<>(estados);

        JLabel lblMotivoConsulta = new JLabel("Motivo da Consulta:");
        JTextField txtMotivoConsulta = new JTextField(30);

        JLabel lblSintomas = new JLabel("Sintomas:");
        JTextField txtSintomas = new JTextField(30);

        JLabel lblDiagnostico = new JLabel("Diagnóstico:");
        JTextField txtDiagnostico = new JTextField(30);

        JLabel lblExamesSolicitados = new JLabel("Exames Solicitados:");
        JTextField txtExamesSolicitados = new JTextField(30);

        JLabel lblProcedimentoRealizado = new JLabel("Procedimento Realizado:");
        JTextField txtProcedimentoRealizado = new JTextField(30);

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelFormulario.add(lblCPF, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtCPF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelFormulario.add(lblNome, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelFormulario.add(lblDataNascimento, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtDataNascimento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painelFormulario.add(lblSexo, gbc);
        gbc.gridx = 1;
        painelFormulario.add(cbSexo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painelFormulario.add(lblTelefone, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtTelefone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        painelFormulario.add(lblEmail, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        painelFormulario.add(lblEndereco, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtEndereco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        painelFormulario.add(lblCidade, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtCidade, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        painelFormulario.add(lblEstado, gbc);
        gbc.gridx = 1;
        painelFormulario.add(cbEstado, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        painelFormulario.add(lblMotivoConsulta, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtMotivoConsulta, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        painelFormulario.add(lblSintomas, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtSintomas, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        painelFormulario.add(lblDiagnostico, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtDiagnostico, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        painelFormulario.add(lblExamesSolicitados, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtExamesSolicitados, gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        painelFormulario.add(lblProcedimentoRealizado, gbc);
        gbc.gridx = 1;
        painelFormulario.add(txtProcedimentoRealizado, gbc);

        painel.add(painelFormulario, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        painelBotoes.setOpaque(false);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = txtCPF.getText().trim();
                String nome = txtNome.getText().trim();
                String dataNascimento = txtDataNascimento.getText().trim();
                String sexo = (String) cbSexo.getSelectedItem();
                String telefone = txtTelefone.getText().trim();
                String email = txtEmail.getText().trim();
                String endereco = txtEndereco.getText().trim();
                String cidade = txtCidade.getText().trim();
                String estado = (String) cbEstado.getSelectedItem();
                String motivoConsulta = txtMotivoConsulta.getText().trim();
                String sintomas = txtSintomas.getText().trim();
                String diagnostico = txtDiagnostico.getText().trim();
                String examesSolicitados = txtExamesSolicitados.getText().trim();
                String procedimentoRealizado = txtProcedimentoRealizado.getText().trim();

                if (cpf.isEmpty() || nome.isEmpty() || dataNascimento.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    prontuarios.put(cpf, nome);
                    JOptionPane.showMessageDialog(null, "Prontuário salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCPF.setText("");
                txtNome.setText("");
                txtDataNascimento.setText("");
                cbSexo.setSelectedIndex(0);
                txtTelefone.setText("");
                txtEmail.setText("");
                txtEndereco.setText("");
                txtCidade.setText("");
                cbEstado.setSelectedIndex(0);
                txtMotivoConsulta.setText("");
                txtSintomas.setText("");
                txtDiagnostico.setText("");
                txtExamesSolicitados.setText("");
                txtProcedimentoRealizado.setText("");
            }
        });

        painel.add(painelBotoes, BorderLayout.SOUTH);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastroProntuarios().setVisible(true);
        });
    }
}
