package cFuncionarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFuncionarios extends JFrame {

    public TelaFuncionarios() {
        setTitle("Listagem de Funcionários - Clínica Médica");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout(10, 10));
        painel.setBackground(new Color(173, 216, 230));

        JLabel lblTitulo = new JLabel("Listagem de Funcionários");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel painelTabela = new JPanel();
        painelTabela.setLayout(new BorderLayout());
        painelTabela.setBackground(Color.WHITE);
        painelTabela.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] colunas = {"ID", "Nome", "E-mail", "Perfil"};
        Object[][] dados = {
                {"1", "Gabriel Oliveira", "gabOliveira@gmail.com", "ADMINISTRADOR"},
                {"2", "Maria Eduarda", "maria@gmail.com", "ADMINISTRADOR"},
                {"3", "Everton", "a", "MÉDICO"},
                {"4", "João Santos", "joaoSantos@gmail.com", "MÉDICO"},
                {"5", "Ana Lima", "anaLima@gmail.com", "MÉDICO"},
                {"6", "Carlos Silva", "carlosSilva@gmail.com", "MÉDICO"},
                {"7", "Patrícia Costa", "patriciaCosta@gmail.com", "ATENDENTE"},
                {"8", "Fernanda Souza", "fernandaSouza@gmail.com", "ATENDENTE"},
                {"9", "Ricardo Pereira", "ricardoPereira@gmail.com", "ATENDENTE"},
                {"10", "Juliana Rocha", "julianaRocha@gmail.com", "ATENDENTE"}
        };

        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);
        JTable tabelaFuncionarios = new JTable(modeloTabela);
        JScrollPane scrollTabela = new JScrollPane(tabelaFuncionarios);

        painelTabela.add(scrollTabela, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 1, 10, 10));
        painelBotoes.setBackground(new Color(173, 216, 230));

        JButton btnExcluir = new JButton("Excluir");
        JButton btnEditar = new JButton("Editar");
        JButton btnFechar = new JButton("Fechar");
        JButton btnVerFuncionario = new JButton("Ver Funcionário");

        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnFechar);
        painelBotoes.add(btnVerFuncionario);

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
                if (linhaSelecionada != -1) {
                    modeloTabela.removeRow(linhaSelecionada);
                    JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um funcionário para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
                if (linhaSelecionada != -1) {
                    String nome = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
                    JOptionPane.showMessageDialog(null, "Editar informações do funcionário: " + nome, "Editar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um funcionário para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnVerFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
                if (linhaSelecionada != -1) {
                    String nomeFuncionario = (String) modeloTabela.getValueAt(linhaSelecionada, 1);

                    if (nomeFuncionario.equals("Everton")) {
                        mostrarDadosFuncionarioEverton();
                    } else {
                        JOptionPane.showMessageDialog(null, "Visualizando informações do funcionário: " + nomeFuncionario, "Funcionário", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um funcionário para visualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        painel.add(lblTitulo, BorderLayout.NORTH);
        painel.add(painelTabela, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.EAST);

        add(painel);
    }

    private void mostrarDadosFuncionarioEverton() {
        JOptionPane.showMessageDialog(null,
                "Nome Completo: Everton\n" +
                        "E-mail: a\n" +
                        "Perfil: Médico\n" +
                        "Documento de Identificação: a\n" +
                        "Data de Nascimento: a\n" +
                        "Sexo: Masculino\n" +
                        "Telefone de Contato: a\n" +
                        "Cidade: a\n" +
                        "Bairro: a\n" +
                        "Estado: a\n" +
                        "Usuário: a\n" +
                        "Senha: a",
                "Dados do Funcionário - Everton", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaFuncionarios().setVisible(true);
        });
    }
}
