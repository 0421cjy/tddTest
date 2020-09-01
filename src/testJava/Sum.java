package testJava;

public class Sum implements Expression {
	Expression augend;
	Expression addend;
	
	Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}
	
	public Money reduce(Bank bank, String to) {
		return new Money(this.augend.reduce(bank, to).amount + this.addend.reduce(bank, to).amount, to);
	}
	
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	public Expression times(int multiplier) {
		return new Sum(augend.times(multiplier), addend.times(multiplier));
	}
}
