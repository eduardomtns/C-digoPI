package bConsultas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TelaCadastroConsultas extends JFrame {
    
    public TelaCadastroConsultas() {
        setTitle("Cadastro de Consultas - Clínica Médica");
        setSize(700, 600);
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
        painelFormulario.setLayout(new GridLayout(8, 2, 10, 10));
        painelFormulario.setOpaque(false);

        JLabel lblTitulo = new JLabel("Criar Consulta");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblNomePaciente = new JLabel("Nome do Paciente:");
        JTextField txtNomePaciente = new JTextField(20);

        JLabel lblCpfPaciente = new JLabel("CPF do Paciente:");
        JTextField txtCpfPaciente = new JTextField(20);

        JLabel lblDataConsulta = new JLabel("Data da Consulta (DD-MM-AAAA):");
        JTextField txtDataConsulta = new JTextField(20);

        JLabel lblHorarioConsulta = new JLabel("Horário da Consulta (HH:MM):");
        JTextField txtHorarioConsulta = new JTextField(20);

        JLabel lblMedico = new JLabel("Nome do Médico:");
        JTextField txtMedico = new JTextField(20);

        JLabel lblSintomas = new JLabel("Sintomas:");
        JTextField txtSintomas = new JTextField(20);

        JLabel lblRetorno = new JLabel("É Retorno (Sim/Não):");
        JComboBox<String> cbRetorno = new JComboBox<>(new String[]{"Sim", "Não"});

        JLabel lblConvenio = new JLabel("Convênio:");
        JComboBox<String> cbConvenio = new JComboBox<>(new String[]{"Unimed", "Bradesco Saúde", "Amil", "Sem Convênio"});

        painelFormulario.add(lblNomePaciente);
        painelFormulario.add(txtNomePaciente);

        painelFormulario.add(lblCpfPaciente);
        painelFormulario.add(txtCpfPaciente);

        painelFormulario.add(lblDataConsulta);
        painelFormulario.add(txtDataConsulta);

        painelFormulario.add(lblHorarioConsulta);
        painelFormulario.add(txtHorarioConsulta);

        painelFormulario.add(lblMedico);
        painelFormulario.add(txtMedico);

        painelFormulario.add(lblSintomas);
        painelFormulario.add(txtSintomas);

        painelFormulario.add(lblRetorno);
        painelFormulario.add(cbRetorno);

        painelFormulario.add(lblConvenio);
        painelFormulario.add(cbConvenio);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        painelBotoes.setOpaque(false);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnVisualizar = new JButton("Visualizar Consultas");
        JButton btnVoltar = new JButton("Voltar");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnVisualizar);
        painelBotoes.add(btnVoltar);

        gbc.gridy++;
        painelCentralizado.add(lblTitulo, gbc);

        gbc.gridy++;
        painelCentralizado.add(painelFormulario, gbc);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePaciente = txtNomePaciente.getText();
                String cpfPaciente = txtCpfPaciente.getText();
                String dataConsulta = txtDataConsulta.getText();
                String horarioConsulta = txtHorarioConsulta.getText();
                String medico = txtMedico.getText();
                String sintomas = txtSintomas.getText();
                String retorno = (String) cbRetorno.getSelectedItem();
                String convenio = (String) cbConvenio.getSelectedItem();

                if (nomePaciente.isEmpty() || cpfPaciente.isEmpty() || dataConsulta.isEmpty() ||
                    horarioConsulta.isEmpty() || medico.isEmpty() || sintomas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Dados faltando! Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String consultaID = gerarIDConsulta();
                    JOptionPane.showMessageDialog(null, "Consulta Salva com Sucesso!\n\n"
                            + "Paciente: " + nomePaciente + "\n"
                            + "CPF: " + cpfPaciente + "\n"
                            + "Data: " + dataConsulta + "\n"
                            + "Horário: " + horarioConsulta + "\n"
                            + "Médico: " + medico + "\n"
                            + "Sintomas: " + sintomas + "\n"
                            + "Retorno: " + retorno + "\n"
                            + "Convênio: " + convenio + "\n\n"
                            + "ID da Consulta: " + consultaID);
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNomePaciente.setText("");
                txtCpfPaciente.setText("");
                txtDataConsulta.setText("");
                txtHorarioConsulta.setText("");
                txtMedico.setText("");
                txtSintomas.setText("");
                cbRetorno.setSelectedIndex(0);
                cbConvenio.setSelectedIndex(0);
            }
        });

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exibindo lista de consultas cadastradas.");
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

    private String gerarIDConsulta() {
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastroConsultas().setVisible(true);
        });
    }
}
