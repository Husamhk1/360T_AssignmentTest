#!/bin/bash

 

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Th Program is running from Shell Script......"
    #Run the Java program and call the specific method
    
   # Run the Java program
     java -cp target/palyerApp-1.0-SNAPSHOT.jar com.test.player.mainPlayer.Player       
	
else
    echo "Compilation failed. Please check your Java code for errors."
fi
chmod u+x my-script.sh




# Run the Java program
#java -cp $CLASSPATH $MAIN_CLASS

