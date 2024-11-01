# Challenge: Conversor de Moedas

<!--colocar imagem do menu inicial do projeto-->

## Sobre

Este desafio foi proposto como finalização da trilha **"Java e Orientação a Objetos G7 - ONE (Oracle Next Education)"** destinada aos alunos da especialização em back-end do programa ONE, desenvolvido pela **Alura** em parceria com a **Oracle**. </br>
O projeto visa aplicar todos os conteúdos aprendidos durantes os cursos da trilha em questão, fazendo o uso da Orientação a Objetos e o consumo de uma API para obtenção e tratamento dos dados de maneira dinâmica.</br>

## Funcionalidades

### Conversão
Com o uso de uma API (Exchange Rate API), foi feita a obtenção das taxas de câmbio, para que assim seja realizada a conversão atualizada e dinâmica das moedas selecionadas durante o uso do programa.

### Moedas
Foram solicitadas ao menos 6 moedas distintas para a conversão dos valores no projeto.</br>

Moedas selecionadas:
- Real brasileiro (BRL).
- Dólar Americano (USD).
- Euro (EUR).
- Peso Argentino (ARS).
- Libra Esterlina (GBP).
- Dólar Canadense (CAD).

### Histórico
Como extra, foi colocado um metodo para que as conversões realizadas fossem salvas em um arquivo ".json".

<!--colocar imagem do arquivo com o histórico-->

## Tecnologias Utilizadas

- Java JDK: versão 17.
- Gson: versão 2.11.0.
- Exchange Rate API: Uma API utilizada para obter as taxas de câmbio atualizadas.
- Postman: Utilizado para testes da API.
- IDE (preferencia pessoal): Foi utilizado o IntelliJ IDEA.

## Como executar o projeto

1. **Configurar o Ambiente:** Certifique-se de ter o Java JDK e a biblioteca Gson instalados.
2. **Obter o Projeto:** Faça o clone do projeto em sua máquina local.
3. **Obter a Chave API:** Entre em [Exchange Rate API](https://www.exchangerate-api.com/) e solicite a sua API KEY.
4. **Alterando a API:** Entre na classe "ConsultaCotacao.java" e altere o valor da variavel "chaveAPI" pela sua própria API KEY.
5. **Executar o Código:** Execute a aplicação da classe "Main.java" em sua IDE favorita.
6. **Selecionar Moedas e Converter Valores:** Siga as instruções no terminal para escolher as moedas de origem e destino, além do valor a ser convertido.
7. **Finalizar a Aplicação:** Ao selecionar para que a aplicação seja encerrada, um aquivo "historico_conversoes.json" será gerado contendo os dados das conversões realizadas.

## Badge de Conclusão

<!--colocar imagem da badge de conclusão-->
