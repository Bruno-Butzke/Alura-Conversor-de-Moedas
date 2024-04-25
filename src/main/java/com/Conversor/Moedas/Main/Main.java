package com.Conversor.Moedas.Main;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.Conversor.Moedas.service.ConsumoAPI;

import java.util.Scanner;

public class Main {
    Scanner leitor = new Scanner(System.in);
    static ConsumoAPI consumo = new ConsumoAPI();
    private final String url = "https://v6.exchangerate-api.com/v6/"+System.getenv("DB_PASSWORD")+"/latest/";


    public void Comecar() throws JsonProcessingException {
        String telaInicio = """
                *******************************************************
                Seja Bem-Vindo/a ao Conversor de Moedas =]
                                    
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileiro
                4) Real Brasileiro =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Sair
                                    
                Escolha uma Opção Válida:
                """;
            System.out.println(telaInicio);
            int escolha = Integer.parseInt(leitor.nextLine());

            while (escolha != 8) {

                if(escolha == 1) {
                    System.out.println("Digite o valor de que deseja converter: ");
                    double valorConversao = Double.parseDouble(leitor.nextLine());
                    String moedaLocal = "USD";
                    String moedaExtrengeira = "ARS";
                    String endereco = url + moedaLocal;
                    double fim = ConversorMoeda(endereco, moedaLocal, moedaExtrengeira);
                    System.out.println(fim * valorConversao);
                }

                if(escolha == 2) {
                    System.out.println("Digite o valor de que deseja converter: ");
                    double valorConversao = Double.parseDouble(leitor.nextLine());
                    String moedaLocal = "ARS";
                    String moedaExtrengeira = "USD";
                    String endereco = url + moedaLocal;
                    double fim = ConversorMoeda(endereco, moedaLocal, moedaExtrengeira);
                    System.out.println(fim * valorConversao);

                }

                if(escolha == 3) {
                    System.out.println("Digite o valor de que deseja converter: ");
                    double valorConversao = Double.parseDouble(leitor.nextLine());
                    String moedaLocal = "USD";
                    String moedaExtrengeira = "BRL";
                    String endereco = url + moedaLocal;
                    double fim = ConversorMoeda(endereco, moedaLocal, moedaExtrengeira);
                    System.out.println(fim * valorConversao);

                }

                if(escolha == 4) {
                    System.out.println("Digite o valor de que deseja converter: ");
                    double valorConversao = Double.parseDouble(leitor.nextLine());
                    String moedaLocal = "BRL";
                    String moedaExtrengeira = "USD";
                    String endereco = url + moedaLocal;
                    double fim = ConversorMoeda(endereco, moedaLocal, moedaExtrengeira);
                    System.out.println(fim * valorConversao);

                }

                if(escolha == 5) {
                    System.out.println("Digite o valor de que deseja converter: ");
                    double valorConversao = Double.parseDouble(leitor.nextLine());
                    String moedaLocal = "USD";
                    String moedaExtrengeira = "BOB";
                    String endereco = url + moedaLocal;
                    double fim = ConversorMoeda(endereco, moedaLocal, moedaExtrengeira);
                    System.out.println(fim * valorConversao);

                }

                if(escolha == 6) {
                    System.out.println("Digite o valor de que deseja converter: ");
                    double valorConversao = Double.parseDouble(leitor.nextLine());
                    String moedaLocal = "BOB";
                    String moedaExtrengeira = "USD";
                    String endereco = url + moedaLocal;
                    double fim = ConversorMoeda(endereco, moedaLocal, moedaExtrengeira);
                    System.out.println(fim * valorConversao);

                }
                if(escolha == 7){
                System.out.println("Fim dos processos.");
                System.exit(0);
                }

                System.out.println(telaInicio);
                escolha = Integer.parseInt(leitor.nextLine());

        }
            System.out.println("Opção Inválida, encerrando sistema.");
            System.exit(0);
}

    private double ConversorMoeda(String endereco, String moedaLocal, String moedaExtrengeira) throws JsonProcessingException {
        var json = consumo.converteDados(endereco);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode JNode = mapper.readTree(json);
        JsonNode acessoJson = JNode.get("conversion_rates");
        double valor = acessoJson.get(moedaLocal).asDouble();
        double valor2 = acessoJson.get(moedaExtrengeira).asDouble();
        double resultado = (valor*valor2);

        return resultado;
    }
}
