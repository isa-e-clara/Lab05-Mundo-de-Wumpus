# Destaques O Mundo de Wumpus

## Polimorfismo na inserção dos componentes nas salas
```
	public void conectaComponenteSala(int x, int y, Componente componente) {
		char tipo = componente.getTipo();
		if(tipo == 'P') {
			salas[x][y].conectaHeroi(componente);
		} else if(tipo == 'B') 
			salas[x][y].conectaBuraco(componente);
		(...)
	}
  
  //pode ser chamado da seguinte maneira
  componente.getCaverna().conectaComponenteSala(x, y, heroi);
```

## Divisão de tarefas específicas
```
	public Heroi(int x, int y) {
		super(x, y, 'P');
		super.temArtefato = true;
	}
	//só o heroi usa/tem artefato
	public void usouArtefato() {
		temArtefato = false;
	}
  
``` 

## 
No primeiro recorte de código, podemos observar uma função que recebe como parâmetro um objeto da classe componente. Isso facilita a utilização do código ao passo que explora o polimorfismo, uma vez que a função será chamada com o terceiro parâmetro sendo uma das classes herdeiras de Componente, como o herói (exemplificado na linha de comando abaixo da função), e a torna geral para qualquer herdeiro de Componente. Além disso, também podemos observar o encapsulamento aplicado, uma vez que todos os atributos são privados ou protegidos. Já o segundo recorte de código exemplifica a sobrecarga realizada pelo objeto herói, reescrevendo as funções de Componente de acordo com as necessidades dessa subclasse, o que evita a centralização de papéis e torna o código mais específico para cada objeto criado.
