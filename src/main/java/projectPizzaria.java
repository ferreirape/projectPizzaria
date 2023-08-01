// Arquivo: Main.java
public class projectPizzaria {
    public static void main(String[] args) {
        // Criando alguns produtos
        Produto pizzaCalabresa = new Produto(1, "Pizza Calabresa", 35.0);
        Produto pizzaMargherita = new Produto(2, "Pizza Margherita", 30.0);
        Produto refrigerante = new Produto(3, "Refrigerante", 5.0);

        // Criando uma comanda
        Comanda comanda1 = new Comanda(101, 5.0);

        // Adicionando itens à comanda
        comanda1.adicionarItem(new ItemComanda(pizzaCalabresa, 2));
        comanda1.adicionarItem(new ItemComanda(pizzaMargherita, 1));
        comanda1.adicionarItem(new ItemComanda(refrigerante, 3));

        // Fechando a comanda e efetuando o pagamento
        comanda1.fecharComanda();
        comanda1.efetuarPagamento(100.0); // Valor pago maior que o total da comanda

        System.out.println("-----------------------");

        // Criando um pedido de tele-entrega
        PedidoTeleEntrega pedido1 = new PedidoTeleEntrega(201, "João", "Rua das Flores, 123", "(11) 98765-4321");

        // Adicionando itens ao pedido de tele-entrega
        pedido1.adicionarItem(new ItemPedido(pizzaMargherita, 2));
        pedido1.adicionarItem(new ItemPedido(refrigerante, 2));

        // Calculando o total do pedido e taxa de entrega
        double totalPedido = pedido1.calcularTotalPedido();
        double taxaEntrega = pedido1.calcularTaxaEntrega();
        System.out.println("Total do pedido: R$" + totalPedido);
        System.out.println("Taxa de entrega: R$" + taxaEntrega);

        // Atualizando status do pedido e efetuando o pagamento
        pedido1.atualizarStatusPedido(true); // Pedido entregue
        pedido1.efetuarPagamento(40.0); // Valor pago menor que o total do pedido

        // Tentando adicionar um item após o pedido estar entregue
        pedido1.adicionarItem(new ItemPedido(pizzaCalabresa, 1)); // Não permitido após entrega
    }
}
