package br.com.caelum.agiletickets.models;

import static org.junit.Assert.*;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
	@Test
	public void gerar1sessaoParaEspetaculoDeUmDiaDiario() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate("2015-08-14");
		LocalDate fim = new LocalDate("2015-08-14");
		LocalTime horario = new LocalTime("10:04");
		Periodicidade periodicidade = Periodicidade.DIARIA;
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);
		assertEquals(1, sessoes.size());
		assertEquals("14/08/15", sessoes.get(0).getDia());
		assertEquals("10:04", sessoes.get(0).getHora());
		assertEquals(espetaculo, sessoes.get(0).getEspetaculo());
	}
	@Test
	public void gerar1sessaoParaEspetaculoDeUmDiaSemanal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate("2015-08-14");
		LocalDate fim = new LocalDate("2015-08-14");
		LocalTime horario = new LocalTime("10:04");
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);
		assertEquals(1, sessoes.size());
		assertEquals("14/08/15", sessoes.get(0).getDia());
		assertEquals("10:04", sessoes.get(0).getHora());
		assertEquals(espetaculo, sessoes.get(0).getEspetaculo());
	}
	@Test
	public void gerar2sessoesParaEspetaculoDe2DiasDiario() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate("2015-08-14");
		LocalDate fim = new LocalDate("2015-08-15");
		LocalTime horario = new LocalTime("10:04");
		Periodicidade periodicidade = Periodicidade.DIARIA;
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);
		assertEquals(2, sessoes.size());
		assertEquals("14/08/15", sessoes.get(0).getDia());
		assertEquals("10:04", sessoes.get(0).getHora());
		assertEquals(espetaculo, sessoes.get(0).getEspetaculo());
		assertEquals("15/08/15", sessoes.get(1).getDia());
		assertEquals("10:04", sessoes.get(1).getHora());
		assertEquals(espetaculo, sessoes.get(1).getEspetaculo());
	}
	@Test
	public void gerar1sessaoParaEspetaculoDe2DiasSemanal() throws Exception {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate("2015-08-14");
		LocalDate fim = new LocalDate("2015-08-15");
		LocalTime horario = new LocalTime("10:04");
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);
		assertEquals(2, sessoes.size());
		assertEquals("14/08/15", sessoes.get(0).getDia());
		assertEquals("10:04", sessoes.get(0).getHora());
		assertEquals(espetaculo, sessoes.get(0).getEspetaculo());
	}
}
