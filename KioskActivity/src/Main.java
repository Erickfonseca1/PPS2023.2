import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Kiosk kiosk = new Kiosk();

        while (true) {
            if (!kiosk.hasAvaiableCourse()) {
                System.out.println("Não há mais cursos disponíveis");
                break;
            }

            if (kiosk.getState() instanceof EmEsperaState) {
                System.out.println("Digite sua matrícula:");
                String matricula = sc.nextLine();
                try {
                    boolean valid = kiosk.validateMatricula(matricula);
                    if (valid) {
                        System.out.println("Matrícula válida");
                    } else {
                        System.out.println("Matrícula inválida");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (kiosk.getState() instanceof IdentificadoState) {
                System.out.println("Cursos disponíveis:");
                // para cada curso, imprime um id incremental para cada curso, nome do curso e vagas disponíveis
                for (int i = 0; i < kiosk.getCourses().size(); i++) {
                    System.out.println(i+1 + " - " + kiosk.getCourses().get(i).getName());
                }

                System.out.println("Digite o id do curso:");
                int idCurso = sc.nextInt();

                try {
                    if (idCurso > 4) {
                        System.out.println("Curso inválido");
                    } else {
                        boolean valid = false;

                        switch (idCurso) {
                            case 1:
                                valid = kiosk.validateCourse("GPT");
                                break;
                            case 2:
                                valid = kiosk.validateCourse("Blockchain");
                                break;
                            case 3:
                                valid = kiosk.validateCourse("IoT");
                                break;
                            case 4:
                                valid = kiosk.validateCourse("VR");
                                break;
                            default:
                                System.out.println("Curso inválido");
                                continue;
                        }

                        if (valid) {
                            System.out.println("Curso selecionado com sucesso");
                        } else {
                            System.out.println("Curso inválido");
                            continue;
                        }
                    }
                } catch (Exception e) {
                   System.out.println(e.getMessage());
                   continue;
                }
            } else if (kiosk.getState() instanceof ProcessandoState) {
                sc.nextLine();
                System.out.println("Digite o número do cartão de crédito:");
                String creditCard = sc.nextLine();
                try {
                    boolean valid = kiosk.validateCreditCard(creditCard);
                    if (valid) {
                        System.out.println("Cartão de crédito válido");
                    } else {
                        System.out.println("Cartão de crédito inválido");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (kiosk.getState() instanceof InscritoState) {
                try {
                    String ticket = kiosk.createTicket();
                    System.out.println("Ticket criado com sucesso: " + ticket);


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                //Pergunta se deseja realizar outra inscrição, se sim (S) volta para o estado inicial, se não (N) finaliza o programa
                System.out.println("Deseja realizar outra inscrição? (S/N)");
                String answer = sc.nextLine();
                answer = answer.toUpperCase();
                if (answer.equals("S")) {
                    kiosk.setState(new EmEsperaState(kiosk));
                } else if (answer.equals("N")) {
                    break;
                } else {
                    System.out.println("Opção inválida");
                    break;
                }
            }
        }
    }
}