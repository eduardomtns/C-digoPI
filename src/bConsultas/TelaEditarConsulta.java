package bConsultas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditarConsulta extends JFrame {

    public TelaEditarConsulta() {
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

        String[] colunas = {"ID", "Data", "Hora", "Nome", "Status"};
        Object[][] dados = {
                {"1", "20/12", "16:00", "EVERTON", "ATIVA"},
                {"2", "18/12", "15:00", "BEATRIZ MARTINS", "ATIVA"},
                {"3", "18/12", "12:00", "CAMILA SOUZA", "ATIVA"},
                {"4", "17/12", "18:00", "GUILHERME PEREIRA", "ATIVA"},
                {"5", "17/12", "15:00", "HELENA COSTA", "ATIVA"}
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
                    String nome = (String) modeloTabela.getValueAt(linhaSelecionada, 3);
                    if (nome.equals("EVERTON")) {
                        abrirTelaEditarConsulta(modeloTabela, linhaSelecionada);
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione a 1° consulta.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
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

    private void abrirTelaEditarConsulta(DefaultTableModel modeloTabela, int linhaSelecionada) {
        String dataAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
        String horaAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 2);
        String statusAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 4);

        JFrame telaEditar = new JFrame("Editar Consulta - Everton");
        telaEditar.setSize(400, 300);
        telaEditar.setLocationRelativeTo(null);

        JPanel painelEditar = new JPanel();
        painelEditar.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblData = new JLabel("Data:");
        JTextField tfData = new JTextField(dataAtual);
        JLabel lblHora = new JLabel("Hora:");
        JTextField tfHora = new JTextField(horaAtual);
        JLabel lblStatus = new JLabel("Status:");
        JTextField tfStatus = new JTextField(statusAtual);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");

        painelEditar.add(lblData);
        painelEditar.add(tfData);
        painelEditar.add(lblHora);
        painelEditar.add(tfHora);
        painelEditar.add(lblStatus);
        painelEditar.add(tfStatus);
        painelEditar.add(btnSalvar);
        painelEditar.add(btnCancelar);

        telaEditar.add(painelEditar);
        telaEditar.setVisible(true);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novaData = tfData.getText();
                String novaHora = tfHora.getText();
                String novoStatus = tfStatus.getText();

                // Atualizar os dados na tabela
                modeloTabela.setValueAt(novaData, linhaSelecionada, 1);
                modeloTabela.setValueAt(novaHora, linhaSelecionada, 2);
                modeloTabela.setValueAt(novoStatus, linhaSelecionada, 4);

                JOptionPane.showMessageDialog(null, "Consulta atualizada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                telaEditar.dispose(); 
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaEditar.dispose();  
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaEditarConsulta().setVisible(true);
        });
    }
}
