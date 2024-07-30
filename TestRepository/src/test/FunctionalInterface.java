package test;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.Supplier;

public class FunctionalInterface {

	public static void main(String[] args) {
		consumer();
		supplier();
		function();
		operator();
		predicate();
	}

	public static void consumer() {
		System.out.println("--------------");
		Consumer<String> consumer1 = System.out::println;
		BiConsumer<String, String> consumer2 = (s1, s2) -> System.out.println(s1 + s2);

		consumer1.accept("consumer test");
		consumer2.accept("biconsumer", " test");
	}

	public static void supplier() {
		System.out.println("--------------");
		Supplier<String> supplier = () -> "supplier test";
		IntSupplier intsupplier = () -> 1;

		System.out.println(supplier.get());
		System.out.println("intsupplier: " + intsupplier.getAsInt());
	}

	public static void function() {
		System.out.println("--------------");
		Function<String, Integer> function1 = Integer::parseInt;
		IntToDoubleFunction function2 = Double::valueOf;

		System.out.println(function1.apply("123"));
		System.out.println(function2.applyAsDouble(456));
	}

	public static void operator() {
		System.out.println("--------------");
		IntBinaryOperator op1 = Math::max;
		DoubleBinaryOperator op2 = (a, b) -> a + b;

		System.out.println(op1.applyAsInt(20, 30));
		System.out.println(op2.applyAsDouble(36.5, 12.6));
	}

	public static void predicate() {
		System.out.println("--------------");
		BiPredicate<String, String> predicate1 = String::equals;
		IntPredicate predicate2 = (a) -> a > 80 ;

		System.out.println(predicate1.test("aaa", "bbb"));
		System.out.println(predicate2.test(79));
	}

}
