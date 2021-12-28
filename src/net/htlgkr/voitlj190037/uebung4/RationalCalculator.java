package net.htlgkr.voitlj190037.uebung4;

public class RationalCalculator extends AbstractCalculator {

    public RationalCalculator(CalculateOperation add, CalculateOperation subtract, CalculateOperation muliply, CalculateOperation divide) {
        super(add, subtract, muliply, divide);
    }

    @Override
    public Number add(Number a, Number b) {
        return super.add.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return super.subtract.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return super.multiply.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return super.divide.calc(a, b);
    }
}
