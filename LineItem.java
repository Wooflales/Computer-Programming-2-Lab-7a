public class LineItem extends Product{
    private Product product;
    private int quantity = 0;
    private double calculatedTotal = 0.0;

    public LineItem(String name, int quantity, double unitPrice, double calculatedTotal) {
        super(name,unitPrice);
        this.quantity = quantity;
        this.calculatedTotal = calculatedTotal;
    }
    public LineItem(Product product, int quantity, double calculatedTotal)
    {
        super(product.getName(), product.getUnitPrice());
        this.quantity = quantity;
        this.calculatedTotal = calculatedTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCalculatedTotal() {
        return calculatedTotal;
    }

    public void setCalculatedTotal(double calculatedTotal) {
        this.calculatedTotal = calculatedTotal;
    }

    public String generateDisplay() {
        return this.getName()+"          "+this.getQuantity()+"               "+this.getUnitPrice()+"          "+this.getCalculatedTotal();
    }
}
