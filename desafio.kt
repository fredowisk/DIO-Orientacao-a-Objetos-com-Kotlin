enum class Nivel {BASICO, INTERMEDIARIO, DIFICIL}

data class Usuario(val id: Int, val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val listaCursos = mutableListOf<ConteudoEducacional>(
        ConteudoEducacional("Fundamentos do Kotlin", 10, Nivel.BASICO),
        ConteudoEducacional("Kotlin avançado", 25, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Kotlin expert", 50, Nivel.DIFICIL), 
    )

    val usuarios = hashMapOf(
        1 to "Fredowisk",
        2 to "Brunão"
    )
    
    val formacao = Formacao("Bootcamp Kotlin", listaCursos)
    
    for (usuario in usuarios){
        formacao.matricular(Usuario(usuario.key, usuario.value))
    }
    
    println("Formação:")
    println(formacao)
    println("Inscritos:")
    println(formacao.inscritos)
}
