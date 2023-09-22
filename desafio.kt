enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val curso: String, val duracao: Int = 60)

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
    		println(conteudo.nome)
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
            ConteudoEducacional("Lógica de Programação", "Java"),
            ConteudoEducacional("Linguagem de Programação", "Java"),
            ConteudoEducacional("Orientação a Objetos", "Kotlin"),
            ConteudoEducacional("Arquiteturas de Software", "Fundamentos Software"))
    
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