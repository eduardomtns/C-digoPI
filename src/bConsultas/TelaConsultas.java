package bConsultas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaConsultas extends JFrame {

    public TelaConsultas() {
        setTitle("Listagem de Consultas - Clínica Médica");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBackground(new Color(173, 216, 230));

        JLabel lblTitulo = new JLabel("Listagem de Consultas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel painelTabela = new JPanel();
        painelTabela.setLayout(new BorderLayout());
        painelTabela.setBackground(Color.WHITE);
        painelTabela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] colunas = {"ID", "Paciente", "Médico", "Data", "Status"};
        Object[][] dados = {
                {"1", "Everton", "Dra. Ana Lima", "20-12-2024 16:00", "Ativa"},
                {"2", "Beatriz Martins", "Dr. Carlos Silva", "18-12-2024 15:00", "Ativa"},
                {"3", "Camila Souza", "Dr. João Santos", "18-12-2024 12:00", "Ativa"},
                {"4", "Guilherme Pereira", "Dr. Lucas Rodrigues", "17-12-2024 18:00", "Ativa"},
                {"5", "Helena Costa", "Dr. Carlos Silva", "17-12-2024 15:00", "Ativa"},
                {"6", "Patrícia Costa", "Dra. Ana Lima", "16-12-2024 12:00", "Desativa"},
                {"7", "Fernanda Souza", "Dr. João Santos", "16-12-2024 09:00", "Desativa"},
                {"8", "Ana Júlia", "Dr. Lucas Rodrigues", "15-12-2024 17:00", "Desativa"},
                {"9", "Larissa Gomes", "Dr. João Santos", "15-12-2024 15:00", "Desativa"},
                {"10", "Mariana Rocha", "Dr. Carlos Silva", "15-12-2024 12:00", "Desativa"},
                {"11", "Felipe Santos", "Dra. Ana Lima", "15-12-2024 09:00", "Desativa"}
        };

        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);
        JTable tabelaConsultas = new JTable(modeloTabela);
        JScrollPane scrollTabela = new JScrollPane(tabelaConsultas);

        painelTabela.add(scrollTabela, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 1, 10, 10));
        painelBotoes.setBackground(new Color(173, 216, 230));

        JButton btnExcluir = new JButton("Excluir");
        JButton btnEditar = new JButton("Editar");
        JButton btnFechar = new JButton("Fechar");

        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnFechar);

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaConsultas.getSelectedRow();
                if (linhaSelecionada != -1) {
                    modeloTabela.removeRow(linhaSelecionada);
                    JOptionPane.showMessageDialog(null, "Consulta excluída com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma consulta para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaConsultas.getSelectedRow();
                if (linhaSelecionada != -1) {
                    String paciente = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
                    String status = (String) modeloTabela.getValueAt(linhaSelecionada, 4);
                    JOptionPane.showMessageDialog(null, "Editar consulta de: " + paciente + " - Status: " + status, "Editar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma consulta para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        painel.add(lblTitulo, BorderLayout.NORTH);
        painel.add(painelTabela, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.EAST);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaConsultas().setVisible(true);
        });
    }
}
