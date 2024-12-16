package eProntuarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaProntuarios extends JFrame {

    public TelaProntuarios() {
        setTitle("Listagem de Prontuários - Clínica Médica");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBackground(new Color(173, 216, 230));

        JLabel lblTitulo = new JLabel("Listagem de Prontuários");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel painelTabela = new JPanel();
        painelTabela.setLayout(new BorderLayout());
        painelTabela.setBackground(Color.WHITE);
        painelTabela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] colunas = {"ID", "Prontuário"};
        Object[][] dados = {
                {"1", "Prontuário de Everton"},
                {"2", "Prontuário de Ana Clara"},
                {"3", "Prontuário de João Lima"},
                {"4", "Prontuário de Carla Souza"},
                {"5", "Prontuário de Ricardo Martins"}
        };

        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);
        JTable tabelaProntuarios = new JTable(modeloTabela);
        tabelaProntuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollTabela = new JScrollPane(tabelaProntuarios);

        painelTabela.add(scrollTabela, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 1, 10, 10));
        painelBotoes.setBackground(new Color(173, 216, 230));

        JButton btnVerProntuario = new JButton("Ver Prontuário");

        painelBotoes.add(btnVerProntuario);

        btnVerProntuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaProntuarios.getSelectedRow();
                if (linhaSelecionada != -1) {
                    String nomeProntuario = (String) modeloTabela.getValueAt(linhaSelecionada, 1);

                    if (nomeProntuario.equals("Prontuário de Everton")) {
                        mostrarDadosProntuarioEverton();
                    } else {
                        JOptionPane.showMessageDialog(null, "Visualizando prontuário de: " + nomeProntuario, "Prontuário", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um prontuário para visualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        painel.add(lblTitulo, BorderLayout.NORTH);
        painel.add(painelTabela, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        add(painel);
    }

    private void mostrarDadosProntuarioEverton() {
        JOptionPane.showMessageDialog(null,
                "CPF do Paciente: 111.111.111-11\n" +
                        "Nome Completo: Everton\n" +
                        "Data de Nascimento: a\n" +
                        "Sexo: Masculino\n" +
                        "Telefone: a\n" +
                        "E-mail: a\n" +
                        "Endereço: a\n" +
                        "Cidade: a\n" +
                        "Estado: AC\n" +
                        "Motivo da Consulta: a\n" +
                        "Sintomas: a\n" +
                        "Diagnóstico: a\n" +
                        "Exames Solicitados: a\n" +
                        "Procedimento Realizado: a",
                "Prontuário de Everton", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaProntuarios().setVisible(true);
        });
    }
}
