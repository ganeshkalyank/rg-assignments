package in.ganeshkalyan;

public class EncapsulatedChocolate {
    private Boolean wrappedAndUneaten;

    public EncapsulatedChocolate() {
        this.wrappedAndUneaten = true;
    }

    public void eatChocolate() {
        if (wrappedAndUneaten) {
            System.out.println("Eating the chocolate.");
            wrappedAndUneaten = false;
        } else {
            System.out.println("Chocolate is already eaten or unwrapped.");
        }
    }
}
