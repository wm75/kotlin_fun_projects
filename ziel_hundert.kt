import java.util.Random
val rand: Random = Random()

fun main(M: Array<String>){
    // Ziel Hundert:einfaches Nim-ähnliches Spiel

    println("       Ziel Hundert")
    println("     -----------------")
    println("")
    println("Bei jedem Zug ist eine Zahl zwischen 1 und 10")
    println("zur bisherigen Zahl zu addieren.")
    println("Wer zuerst die Zahl 100 ereicht,hat Gewonnen")
    println("")

    
    var S = ermittleStartZahl()
    println("Startzahl: $S")

    while (true) {
        //Spielerzug

        var Z: Int
        while (true) {
            print("Wieviel addieren Sie? ")
            Z = readLine()!!.toInt()
            if (Z<1 || Z>10) {
                println(
                    "Falsche Eingabe!Bitte eine Zahl zwischen 1 und 10 eingeben"
                    )
                }
            else {
                break
            }
        }
        S = S + Z
        println("Neuer Stand: $S")

        if(S >= 100)  {
            println("Sie haben Gewonnen !!!")
            break
            }

        //Computerzug
        var G = ermittleGewinnzahl(S)
        Z = G - S
        if(Z >10){
            Z = rand.nextInt(10)+1
            }
        println("Ich addiere $Z")
        S = S + Z
        println("Neuer Stand $S")
        if(S >= 100){
        println("Sie haben leider verloren!!!")
        break
        }    
    }
    println("    SPIELENDE!!!!!!")
}

fun ermittleStartZahl(): Int {
    // Wahl einer zufälligen Startzahl zwischen 1 und 30
    var S: Int = rand.nextInt(30)+1
    if(S == 1 || S == 12 || S == 23){
        S = S + 1
        }
    return S
}

fun ermittleGewinnzahl(S: Int): Int {
    //ermittle nächste Gewinnzahl
    for (Zahl in 1..100 step 11){
        if(Zahl > S){
            return Zahl
            }
        }
    return 0
    }

