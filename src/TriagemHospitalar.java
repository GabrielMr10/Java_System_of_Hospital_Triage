import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;
class Paciente implements Comparable<Paciente> {
    String nome;

    long cpf;
    long telefone;
    String endereco;
    String sintomas;
    boolean febre;
    boolean cortes;
    boolean ulceras;
    int prioridade;

    public Paciente(String nome, long cpf, long telefone, String endereco, String
            sintomas, boolean febre, boolean cortes, boolean ulceras, int prioridade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sintomas = sintomas;
        this.febre = febre;
        this.cortes = cortes;
        this.ulceras = ulceras;
        this.prioridade = prioridade;
    }

    @Override
    public int compareTo(Paciente outroPaciente) {
        return Integer.compare(this.prioridade, outroPaciente.prioridade);
    }

    @Override
    public String toString() {
        String prioridadeStr;
        switch (prioridade) {
            case 1:
                prioridadeStr = "Emergência";
                break;
            case 2:
                prioridadeStr = "Muito Urgente";
                break;
            case 3:
                prioridadeStr = "Urgente";
                break;
            case 4:
                prioridadeStr = "Pouco Urgente";
                break;
            case 5:
                prioridadeStr = "Não Urgente";
                break;
            default:
                prioridadeStr = "Não Classificado";
        }
        return "Nome: " + nome + ", CPF: " + cpf + ", Prioridade: " + prioridadeStr;
    }
}

public class TriagemHospitalar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        PriorityQueue<Paciente> filaAtendimento = new PriorityQueue<>();

        while (true) {
            System.out.println("\n1. Cadastrar Paciente");
            System.out.println("2. Classificar Paciente");
            System.out.println("3. Atender Paciente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = 0;

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Escolha a opção correta!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarPaciente(scanner, pacientes);
                    break;
                case 2:
                    classificarPaciente(scanner, pacientes, filaAtendimento);
                    break;
                case 3:
                    atenderPaciente(filaAtendimento, pacientes);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Escolha a opção correta!");
            }
        }
    }

    private static void cadastrarPaciente(Scanner scanner, ArrayList<Paciente>
            pacientes) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        long cpf = 0;
        while (true) {
            try {
                System.out.print("CPF: ");
                cpf = scanner.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro.");
                scanner.nextLine();
            }
        }

        long telefone = 0;
        while (true) {
            try {
                System.out.print("Telefone: ");
                telefone = scanner.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro.");
                scanner.nextLine();
            }
        }

        String endereco;
        while (true) {
            System.out.print("Endereço (rua + número): ");
            endereco = scanner.nextLine();
            if (endereco.matches(".*[a-zA-Z].*\\d.*")) {
                break;
            } else {
                System.out.println("Insira o nome da rua + número da casa.");
            }
        }


        String sintomas;
        while (true) {
            System.out.print("Sintomas: ");
            sintomas = scanner.nextLine();
            if (sintomas.matches(".*[a-zA-Z].*")) {
                break;
            } else {
                System.out.println("Insira letras.");
            }
        }

        boolean febre = false;
        while (true) {
            System.out.print("Febre (sim/não): ");
            String febreStr = scanner.nextLine().toLowerCase();
            if (febreStr.equals("sim")) {
                febre = true;
                break;
            } else if (febreStr.equals("não")) {
                febre = false;
                break;
            } else {
                System.out.println("Insira sim ou não.");
            }
        }

        boolean cortes = false;
        while (true) {
            System.out.print("Cortes (sim/não): ");
            String cortesStr = scanner.nextLine().toLowerCase();
            if (cortesStr.equals("sim")) {
                cortes = true;
                break;
            } else if (cortesStr.equals("não")) {
                cortes = false;
                break;
            } else {
                System.out.println("Insira sim ou não.");
            }
        }

        boolean ulceras = false;
        while (true) {
            System.out.print("Úlceras (sim/não): ");
            String ulcerasStr = scanner.nextLine().toLowerCase();
            if (ulcerasStr.equals("sim")) {
                ulceras = true;
                break;
            } else if (ulcerasStr.equals("não")) {
                ulceras = false;
                break;
            } else {
                System.out.println("Insira sim ou não.");
            }
        }

        Paciente paciente = new Paciente(nome, cpf, telefone, endereco, sintomas,
                febre, cortes, ulceras, 0);
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso! Aperte Enter para continuar!");
        scanner.nextLine();
    }

    private static void classificarPaciente(Scanner scanner, ArrayList<Paciente>
            pacientes, PriorityQueue<Paciente> filaAtendimento) {
        if (pacientes.isEmpty()) {

            System.out.println("Não há pacientes cadastrados.");
            return;
        }

        System.out.println("Pacientes cadastrados:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).nome);
        }

        System.out.print("Escolha o número do paciente para classificar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 1 || escolha > pacientes.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        System.out.println("Classificação de Risco:");
        System.out.println("1 - Emergência (Atendimento imediato)");
        System.out.println("2 - Muito Urgente (Atendimento quase imediato)");
        System.out.println("3 - Urgente (Atendimento rápido, mas pode aguardar)");
        System.out.println("4 - Pouco Urgente (Pode aguardar ou ser encaminhado a outro serviço)");
        System.out.println("5 - Não Urgente (Pode aguardar ou ser encaminhado a outro serviço)");
        System.out.print("Escolha a prioridade: ");
        int prioridade = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = pacientes.get(escolha - 1);
        paciente.prioridade = prioridade;
        filaAtendimento.add(paciente);
        System.out.println("Paciente classificado e adicionado à fila de atendimento. Aperte Enter para continuar!");
        scanner.nextLine();
    }

    private static void atenderPaciente(PriorityQueue<Paciente> filaAtendimento,
                                        ArrayList<Paciente> pacientes) {
        if (filaAtendimento.isEmpty()) {
            System.out.println("Não há pacientes na fila de atendimento.");
            return;
        }

        Paciente paciente = filaAtendimento.poll();
        System.out.println("Atendendo paciente: " + paciente);
        pacientes.removeIf(p -> p.cpf == paciente.cpf);
        System.out.println("Paciente atendido com sucesso! Aperte Enter para continuar!");
    }
}