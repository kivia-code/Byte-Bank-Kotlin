fun main() {
    println("** Bem vindo ao Bytebank **")
    val contaKivia = Conta(titular= "Kivia",numero= 1000)
    contaKivia.deposita(5200.0)

    val contaFran = Conta(titular="Fran", numero= 1001)
    contaFran.deposita(3300.0)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)
    println()
    println(contaKivia.titular)
    println(contaKivia.numero)
    println(contaKivia.saldo)

    println("depositando na conta da Kivia")
    contaKivia.deposita(1050.0)
    println("Saldo: " + contaKivia.saldo)

    println("depositando na conta da Fran")
    contaFran.deposita(2070.0)
    println("Saldo: " + contaFran.saldo)

    println("sacando na conta da Kivia")
    contaKivia.saca(250.0)
    println("Saldo: " + contaKivia.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(100.0)
    println("Saldo: " + contaFran.saldo)

    println("saque em excesso na conta da Kivia")
    contaKivia.saca(100.0)
    println("Saldo: " + contaKivia.saldo)

    println("saque em excesso na conta da Fran")
    contaFran.saca(100.0)
    println("Saldo: " + contaFran.saldo)

    println("Transferência da conta da Fran para a Kivia")

    if (contaFran.transfere(valor= 300.0, destino= contaKivia)) {
        println("Transferência sucedida")
    } else {
        println("Falha na transferência")
    }

    println("Saldo Kivia : " + contaKivia.saldo)
    println("Saldo Fran: " + contaFran.saldo)
}

                //construtor secudário -->
class Conta(titular: String, numero: Int) {
    //atributos
    var titular = titular
    val numero = numero
    var saldo = 0.0
        private set

//    //construtor primário
//    constructor(titular: String, numero: Int) {
//        this.titular = titular;
//        this.numero = numero;
//    }

    //metodos
    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }

    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

    fun setSaldo(valor: Double) {
        if (valor > 0) {
            saldo = valor
        }
    }
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("João", 1002)
    var contaMaria = Conta("Maria", 1003)


    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular: String = "Kivia $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++
    }

    for (i in 5 downTo 1) {
        val titular: String = "Kivia $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}