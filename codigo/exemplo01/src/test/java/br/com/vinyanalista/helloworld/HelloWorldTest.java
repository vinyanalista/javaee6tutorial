package br.com.vinyanalista.helloworld;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testeDeExemplo() throws Exception {
		HelloWorld hello = new HelloWorld();
		assertNotNull(hello.mensagem2);
	}

}