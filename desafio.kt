enum class Nivel { 
    INICIANTE, INTERMEDIARIO, AVANÇADO 
}

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val curso: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    infix fun matricular(usuario: Usuario) { 
        inscritos.add(usuario) 
    }
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            inscritos.add(usuario)
        }
    }
    fun mostrarConteudo() {
    	for (conteudo in conteudos) {
    		println("${conteudo.nome}, ${conteudo.duracao} horas")
    	}
    }
        
    fun mostrarInscritos(){
    	for(inscrito in inscritos) {
    		println(inscrito.nome)
    	}
    }
}

fun main() {
    
    val listaConteudo: List<ConteudoEducacional> = listOf(
            ConteudoEducacional("Lógica de Programação", "Java", 20),
            ConteudoEducacional("Linguagem de Programação", "Java", 40),
            ConteudoEducacional("Orientação a Objetos", "Kotlin", 20),
            ConteudoEducacional("Arquiteturas de Software", "Fundamentos Software", 60))
    
    val jonathas = Usuario("Jonathas")
    val guilherme = Usuario("Gulherme")
    val edson = Usuario("Edson")
    
    val experiencia = Formacao("Programador Kotlin", listaConteudo, Nivel.INTERMEDIARIO)
    
    listaConteudo?.let {
        experiencia.matricular(jonathas, guilherme, edson)
    }
    
    println("Formação: \n${experiencia.nome}")
    println("")
    println("Conteúdos: ")
    experiencia.mostrarConteudo()
    println("")
    println("Inscritos:")
    experiencia.mostrarInscritos()
}
