# CS495_Grosse_Kotlin_GUI_Project

This is a complete project for the Carroll College Computer Science Seminar: Kotlin GUI Project.

The minimum requirement for this project is to utilize Java Swing in Kotlin to print "Hello World" to the screen.

For this project, I developed a password generator application. I tought myself gradle as well as Kotlin's TornadoFX and by extension some JavaFX. For those reasons this project far exceeds the minimum requirements.

The code included is functional and runs while accounting for input validation as there are no free-input fields included; therefore, there cannot be invalid inputs.


In order to run the program, clone the repository, and, in a terminal window, navigate to the top layer of the repository folder on your computer. Then run the following commands (without quotation marks):

"./gradlew build"

"./gradlew run"

In the case that the command is not found, in the same directory, elevate the permissions of "gradlew" (without quotes) to include execution. This will look something like the following for mac or linux "chmod -x gradlew" (without quotes). This is by no means a comprehensive guide to changing file permissions and you should refer to a proper online guide for this process.

IMPORTANT RUN NOTES:
1. Ensure you are running an admin terminal or you elevate the permission level of the command (both to include execution and to elevate at the command level e.g. 
"sudo") depending on your operating system.
2. If there is a Java version error, ensure that you are using Oracle OpenJDK version 17.0.1.
3. Ensure you elevate the permission of the terminal (Windows) or command (MacOS/Linux).

Extra Note because I worked extra hard and this is my first time using gradle for anything:
You do not need gradle to run this program, the wrapper is built properly and the proper java runtime version is supposed to be downloaded automatically to use at runtime. (This is why it takes so long to build/run the first time).
