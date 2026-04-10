# Estruturas, Pesquisa e Ordenação de Dados

Este repositório contém a implementação prática dos três projetos acadêmicos desenvolvidos para a disciplina de Estruturas de Dados.

## 📂 Estrutura do Repositório

* **/Projeto1-Arvores**: Implementação de Árvores BST, AVL, Rubro-Negra e Heurística do Caixeiro-Viajante.
* **/Projeto2-Busca**: Benchmark comparativo entre Busca Sequencial, Binária e em Árvore BST.
* **/Projeto3-Ordenacao**: Análise de desempenho entre Insertion Sort e Quick Sort em diferentes cenários.

---

## 🚀 Como Executar os Projetos (Experimentos Reproduzíveis)

Para garantir que os resultados obtidos nos relatórios técnicos possam ser reproduzidos, siga os passos abaixo:

### Pré-requisitos
* **Java JDK 17** ou superior (Desenvolvido no OpenJDK 26).
* Uma IDE de sua preferência (Recomendado: **IntelliJ IDEA**).

### Passos para Execução
1.  **Clonar o repositório:**
    ```bash
    git clone https://github.com/devgustavomoraes/EstruturaDeDados-Bimestre1.git
    ```
2.  **Abrir o projeto:** Importe as pastas dos projetos na sua IDE.
3.  **Localizar a classe Main:** Cada pasta de projeto possui sua própria classe `Main.java` configurada para rodar os testes automatizados.
4.  **Executar:** Rode a classe `Main`. O sistema executará automaticamente as 30 repetições de cada algoritmo e imprimirá a Média e o Desvio Padrão no console.

---

## 📊 Metodologia de Testes
Os experimentos foram desenhados para testar o **Pior Caso** em todos os algoritmos, utilizando volumes de dados que variam de 1.000 a 1.000.000 de elementos, dependendo do projeto. As métricas de tempo são capturadas em nanosegundos (`System.nanoTime()`) para maior precisão.

## 🎓 Acadêmico
* **Nome:** Luis Gustavo Moraes Kadanus
* **Instituição:** UniCesumar
* **Curso:** Análise e Desenvolvimento de Sistemas (ADS)
