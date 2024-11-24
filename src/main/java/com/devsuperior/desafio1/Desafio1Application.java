package com.devsuperior.desafio1;

import com.devsuperior.desafio1.entities.Order;
import com.devsuperior.desafio1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Desafio1Application.class, args);
    }

    @Override
    public void run(String... args) {
        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite o código: ");
            int code = sc.nextInt();

            System.out.println("Digite o valor do produto: ");
            double basic = sc.nextDouble();

            System.out.println("Digite a percentagem de desconto: ");
            double discount = sc.nextDouble();

            // Validação de entrada
            if (basic < 0 || discount < 0 || discount > 100) {
                System.out.println("Erro: valores inválidos para o pedido.");
                return;
            }

            // Criação do objeto Order
            Order order = new Order(code, basic, discount);

            // Cálculo do total
            double total = orderService.total(order);


            System.out.println("Código: " + order.getCode());
            System.out.printf("Valor total: %.2f%n", total);
        }
    }
}
