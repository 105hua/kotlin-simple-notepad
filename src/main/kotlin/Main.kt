// Imports.
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

// Main Function, will be executed first.
fun writeNewLine(inputBufferedWriter: BufferedWriter){ // Function to write a new line to the buffered writer input.

    println("Please enter the line that you would like to write:") // Ask the user to enter the line they would like to write.
    val inputLine: String = readLine()!! // Read the users input.
    inputBufferedWriter.write(inputLine.plus("\n")) // Write the users input to the buffered writer, with the addition of \n to indicate a new line.

} // Closing of function.

fun main() { // Opening of main function.

    /*

    Print a Welcome Message

     */
    println("Welcome to SimpleNotepad, my first project with Kotlin.")
    println("=======================================================")
    println("Please enter the name of the text file that you would like to write to:")

    val inputFileName: String = readLine()!! // Create a variable that will store the users input for the file name. Insist that it be a string.
    val fileName = inputFileName.plus(".txt") // Create a variable that will store the actual file name.
    val file = File(fileName) // Create the file variable.

    if(!file.exists()){ // If the file doesn't exist.

        file.createNewFile() // Create it.

    } // Closing of if statement.

    if(!file.canWrite()){ // If the program cannot write to the file.

        error("It doesn't seem like we can write to this file! Please try again.") // Throw an exception.

    } // Closing of if statement.

    val writer = FileWriter(file) // Create a file writer for the file.
    val bWriter = BufferedWriter(writer) // Create a buffered writer with the file writer.
    var isDone = false // Create a boolean value that determines whether the user is done writing or not.

    while(!isDone){ // While the user is not done.

        writeNewLine(bWriter) // Call the writeNewLine function (See lines 7 through 13 for what this function does.)

        println("Are you done writing? (Y/N)") // Ask the user if they are done writing.
        var doneInput: String = readLine()!! // Get the users input to the question.

        while(doneInput.lowercase() != "y" && doneInput.lowercase() != "n"){ // While the input is not equal to y or n, as they are the only acceptable cases.

            println("That was not a valid input. Please try again.") // Tell the user that it wasn't a valid input.
            println("Are you done writing? (Y/N)") // Ask them if they are done writing again.
            doneInput = readLine()!! // Get the users new input.

        } // Closing of while loop.

        if(doneInput == "y"){ // If the user is done.

            isDone = true // Set isDone to true.

        } // Closing of if statement

    } // Closing of while loop.

    bWriter.close() // Close the buffered writer.

} // Closing of main function.