import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CalculadoraSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento do funcionário(AAAA-MM-DD) ");
        String data = scanner.nextLine();
        LocalDate data2 = LocalDate.parse(data);

        System.out.print("Digite o salário do funcionário ");
        double salario = scanner.nextDouble();

        System.out.print("digite as horas extras do funcionário: ");
        int horasExtras = scanner.nextInt();

        System.out.print("Digite o valor da hora extra em percentual da remuneração : ");
        double valorExtra = scanner.nextDouble();

        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(data2, dataAtual);
        int idade = periodo.getYears();

        double salarioMajorado;
        double seguridadeSocial;
        if (idade > 18 && idade < 30) {
            salarioMajorado = salario * 1.07;
            seguridadeSocial = salario * 0.05;
        } else if (idade < 45) {
            salarioMajorado = salario * 1.115;
            seguridadeSocial = salario * 0.12;
        } else if (idade < 60) {
            salarioMajorado = salario * 1.1675;
            seguridadeSocial = salario * 0.0854;
        } else {
            salarioMajorado = salario * 1.2532;
            seguridadeSocial = 0;
        }
        
        double valorTotalHorasExtras = valorExtra * horasExtras;

        double salarioFinal = salarioMajorado + valorTotalHorasExtras;

        System.out.println("NOME DO FUNCIONÁRIO: " + nome);
        System.out.println("IDADE DO FUNCIONÁRIO: " + idade);
        System.out.println("SALÁRIO MAJORADO CONFORME REGRA: " + salarioMajorado);
        System.out.println("VALOR DA SEGURIDADE SOCIAL: " + seguridadeSocial);
        System.out.println("VALOR DAS HORAS EXTRAS: " + valorTotalHorasExtras);
        System.out.println("SALÁRIO FINAL: " + salarioFinal);

        scanner.close();
    }
}
