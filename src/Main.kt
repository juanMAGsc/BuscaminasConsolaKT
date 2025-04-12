
fun main() {
    var buscaminas = Buscaminas()

    do {
        print("Introduzca el largo y ancho del tablero: ")
        val ancholargo = readln().split(" ")
        try {
            buscaminas.setTablerotam(ancholargo[0].toInt(),ancholargo[1].toInt())
        } catch (e: Exception) {
            println("Error: "+e.message)
        }
    } while (buscaminas.estado() == "Preparar tablero")

    do {
        print("Introduzca la cantidad de minas: ")
        try {
            val minascan = readln().toInt()
            buscaminas.setMinas(minascan)
        } catch (e: Exception) {
            println("Error: "+e.message)
        }
    } while (buscaminas.estado() == "Preparar minas")

    var tableros = buscaminas.tablerovisible

    while (buscaminas.estado() == "Jugando"){

        for(i in tableros){
            for (j in i){
                print("|")
                print(j)
            }
            print("|")
            println()
        }

        println("introduzca datos")
        val posicion = readln().split(" ")
        try {
            if (posicion[0] == "f"){
                buscaminas.inputuserflag('f',posicion[1].toInt(), posicion[2].toInt())
            } else if (posicion[0] == "qf"){
                buscaminas.inputuserflag('q',posicion[1].toInt(), posicion[2].toInt())
            }else {
                buscaminas.inputuser(posicion[0].toInt(), posicion[1].toInt())
            }
        } catch (e: Exception) {
            println("Error: "+e.message)
        }
        buscaminas.recuentocasillas()
    }

    if (buscaminas.estado() == "GANAR") { println("Ganaste") }
    if (buscaminas.estado() == "PERDER") {
        buscaminas.tablero.forEach { it.forEach { print("|"+it ) }
        println()
        }
        println("Perdiste") }

}
