package br.com.kritsolutions.main;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Main {

	public static void main(String[] args) {

		MethodType mtStrRetStrArg = MethodType.methodType(String.class,
				String.class);
		
		MethodType mtIntIntRetStrArg = MethodType.methodType(String.class,
				int.class, int.class);

		try {

			MethodHandle mhConcat = getConcatHandler(mtStrRetStrArg);

			System.out.println((String) mhConcat.invokeExact("Hello", " Java"));

			MethodHandle mhSubstring = getSubstringHandler(mtIntIntRetStrArg);

			System.out.println((String) mhSubstring.invokeExact("Test", 1, 2));

			System.out.println(" Sample executed ");

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	private static MethodHandle getSubstringHandler(MethodType mtIntIntRetStrArg)
			throws NoSuchMethodException, IllegalAccessException {
		
		MethodHandle mhSubstring = MethodHandles.lookup().findVirtual(
				String.class, "substring", mtIntIntRetStrArg);
		
		return mhSubstring;
	}

	private static MethodHandle getConcatHandler(MethodType mtStrRetStrArg)
			throws NoSuchMethodException, IllegalAccessException {
		
		MethodHandle mhConcat = MethodHandles.lookup().findVirtual(
				String.class, "concat", mtStrRetStrArg);
		
		return mhConcat;
	}

}
