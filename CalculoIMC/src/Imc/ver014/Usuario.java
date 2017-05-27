//****************************************************************************************************************************************
/**
 * Autor: F�bio Camp�llo
 * Matricula: 201620240 
 * Disciplina: Linguagens de Programa��o
 * Professor: Francisco Edvan
 * Data: 16/03/2017 Atualiza��o: 24/03/2017
 * 
 * Objetivo da classe: Classe que recebe os valores inseridos pelo usu�rio e calcula o IMC.
 * 
 */
//****************************************************************************************************************************************

package Imc.ver014;

//******************************************************************************************************************************
//CLASSE USU�RIO
// ******************************************************************************************************************************
public class Usuario {

	//---------------------------------
	// DECLARA��ODE VARI�VEIS DA CLASSE
	//---------------------------------
	private double peso;
	private double altura;
	private double resultado;

	//------------------
	// M�TODOS ACESSORES
	//------------------
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	//----------------------------------------------------------------------------
	// M�TODO CONSTRUTOR DA CLASSE COM PASSAGEM DE DOIS PAR�METROS
	//----------------------------------------------------------------------------
	public Usuario(double kg, double cm) {
		this.peso = kg;
		this.altura = cm;
	}

	//-----------------------------------------------------------
	// METODO P�BLICO QUE CALCULA O IMC E RETORNA UM VALOR DOUBLE
	//-----------------------------------------------------------
	public Double calculoImc(double peso, double altura) {
		resultado = peso / (altura * altura);
		return resultado;
	}

}
