import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private List<ItemComanda> itensComanda;
    private double taxaGarcom;
    private boolean fechada;

    // Construtor
    public Comanda(int codigoComanda, double taxaGarcom) {
        this.taxaGarcom = taxaGarcom;
        this.itensComanda = new ArrayList<>();
        this.fechada = false;
    }

    // Adicionar item à comanda
    public void adicionarItem(ItemComanda item) {
        if (!fechada) {
            itensComanda.add(item);
        } else {
            System.out.println("A comanda está fechada. Não é possível adicionar itens.");
        }
    }

    // Calcular total da comanda
    public double calcularTotalComanda() {
        double total = 0;
        for (ItemComanda item : itensComanda) {
            total += item.getProduto().getValorUnitario() * item.getQuantidade();
        }
        return total + taxaGarcom;
    }

    // Fechar comanda
    public void fecharComanda() {
        if (!fechada) {
            fechada = true;
            System.out.println("Comanda fechada. Total a pagar: R$" + calcularTotalComanda());
        } else {
            System.out.println("A comanda já está fechada.");
        }
    }

    // Efetuar pagamento
    public void efetuarPagamento(double valorPago) {
        if (fechada) {
            double totalComanda = calcularTotalComanda();
            if (valorPago >= totalComanda) {
                double troco = valorPago - totalComanda;
                System.out.println("Pagamento efetuado. Troco: R$" + troco);
            } else {
                System.out.println("Valor insuficiente para efetuar o pagamento.");
            }
        } else {
            System.out.println("A comanda ainda não foi fechada.");
        }
    }
}
