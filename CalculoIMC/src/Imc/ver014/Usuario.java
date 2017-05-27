//****************************************************************************************************************************************
/**
 * Autor: Fábio Campêllo
 * Matricula: 201620240 
 * Disciplina: Linguagens de Programação
 * Professor: Francisco Edvan
 * Data: 16/03/2017 Atualização: 24/03/2017
 * 
 * Objetivo da classe: Classe que recebe os valores inseridos pelo usuário e calcula o IMC.
 * 
 */
//****************************************************************************************************************************************

package Imc.ver014;

//******************************************************************************************************************************
//CLASSE USUÁRIO
// ******************************************************************************************************************************
public class Usuario {

	//---------------------------------
	// DECLARAÇÃODE VARIÁVEIS DA CLASSE
	//---------------------------------
	private double peso;
	private double altura;
	private double resultado;

	//------------------
	// MÉTODOS ACESSORES
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
	// MÉTODO CONSTRUTOR DA CLASSE COM PASSAGEM DE DOIS PARÂMETROS
	//----------------------------------------------------------------------------
	public Usuario(double kg, double cm) {
		this.peso = kg;
		this.altura = cm;
	}

	//-----------------------------------------------------------
	// METODO PÚBLICO QUE CALCULA O IMC E RETORNA UM VALOR DOUBLE
	//-----------------------------------------------------------
	public Double calculoImc(double peso, double altura) {
		resultado = peso / (altura * altura);
		return resultado;
	}

}
