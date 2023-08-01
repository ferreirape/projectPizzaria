import java.util.ArrayList;
import java.util.List;

public class PedidoTeleEntrega {
    private int codigoPedido;
    private String nomeCliente;
    private String endereco;
    private String telefone;
    private List<ItemPedido> itensPedido;
    private boolean entregue;

    // Construtor
    public PedidoTeleEntrega(int codigoPedido, String nomeCliente, String endereco, String telefone) {
        this.codigoPedido = codigoPedido;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.telefone = telefone;
        this.itensPedido = new ArrayList<>();
        this.entregue = false;
    }

    // Adicionar item ao pedido
    public void adicionarItem(ItemPedido item) {
        if (!entregue) {
            itensPedido.add(item);
        } else {
            System.out.println("O pedido já foi entregue. Não é possível adicionar itens.");
        }
    }

    // Calcular total do pedido
    public double calcularTotalPedido() {
        double total = 0;
        for (ItemPedido item : itensPedido) {
            total += item.getProduto().getValorUnitario() * item.getQuantidade();
        }
        return total + calcularTaxaEntrega();
    }

    // Calcular taxa de entrega (exemplo simples)
    public double calcularTaxaEntrega() {
        return 5.0; // Exemplo: taxa fixa de R$5 para a entrega
    }

    // Atualizar status do pedido
    public void atualizarStatusPedido(boolean entregue) {
        this.entregue = entregue;
        if (entregue) {
            System.out.println("O pedido foi entregue.");
        } else {
            System.out.println("O pedido ainda está aguardando entrega.");
        }
    }

    // Efetuar pagamento
    public void efetuarPagamento(double valorPago) {
        if (entregue) {
            double totalPedido = calcularTotalPedido();
            if (valorPago >= totalPedido) {
                double troco = valorPago - totalPedido;
                System.out.println("Pagamento efetuado. Troco: R$" + troco);
            } else {
                System.out.println("Valor insuficiente para efetuar o pagamento.");
            }
        } else {
            System.out.println("O pedido ainda não foi entregue.");
        }
    }
}
