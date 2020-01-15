package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
//		parte 01: cenario (Arrange)
		Usuario joao = new Usuario("João");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 novo");
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		Avaliador leiloeiro = new Avaliador();
		
//		parte 02: acao (Act). O que eu quero testar 
		leiloeiro.avalia(leilao);
		
//		parte 03: validação (Assert).
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;
		
//		System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		
//		System.out.println(menorEsperado == leiloeiro.getMenorLance());
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
}
