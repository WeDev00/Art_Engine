#Standalone Art Engine- you provide basic traits, Art_Engine gives you all the possible piece of art

!!!!!!!!!!!!DISCLAIMER:!!!!!!!!!!!!
Failure to comply with the rules described below compromises the use and result of the software itself


The setup file follows the following rules (THIS RULES INCLUDE THE SPACE AROUND THE "="):

1)FIRST LINE MUST BE THE MAX_IMAGE_AMOUNT LINE, for example:
		MAX_IMAGE_AMOUNT = 100 
if this number is 0, the program return all combinations of layers given in input;
if this number is >0, the program return MAX_IMAGE_AMOUNT image that respect the given rarities.


2)SECOND LINE MUST BE THE NUMBER_OF_LEVEL LINE: 
3-4)THIRD AND FOURTH LINES MUST BE THE WIDTH AND THE HEIGHT LINES
5)\n
6) FROM THIS LINE (6 INCLUDED) YOU HAVE TO WRITE, FOR EACH LEVEL OF YOUR IMAGE CONCEPT,THE FOLLOW LEVEL DESCRIPTION:

PathLev0 = /*THE PATH OF YOUR LEVEL 0 LAYERS*/
Rarities_lev0 /*NAME OF YOUR LEVEL, FOR EXAMPLE 'BACKGROUND'*/ = 
/*NAME OF THE FIRST VARIANT OF YOUR LEVEL */ /*AN INTEGER THAT RAPPRESENT THE RARITY YOU ASSIGN AT THIS VARIANT*/
/*NAME OF THE SECOND VARIANT OF YOUR LEVEL */ /*AN INTEGER THAT RAPPRESENT THE RARITY YOU ASSIGN AT THIS VARIANT*/
		                       .
		                       .
		                       .
		                       .
		                       .

PathLev1 = /*THE PATH OF YOUR LEVEL 1 LAYERS*/
Rarities_lev1 /*NAME OF YOUR LEVEL, FOR EXAMPLE 'SKIN'*/ = 
/*NAME OF THE FIRST VARIANT OF YOUR LEVEL */ /*AN INTEGER THAT RAPPRESENT THE RARITY YOU ASSIGN AT THIS VARIANT*/
/*NAME OF THE SECOND VARIANT OF YOUR LEVEL */ /*AN INTEGER THAT RAPPRESENT THE RARITY YOU ASSIGN AT THIS VARIANT*/
		                       .
		                       .
		                       .
		                       .
		                       .
			                       
		
		
FROM THE LAST CHARACTER OF THE LAST LINES OF THE LAST LEVEL DESCRIPTION YOU HAVE PRESS ENTER 2 TIMES (2 \n) AND WRITE:

Result_path = /*PATH OF THE FOLDER THAT WILL CONTAIN ALL THE GRAPHICS THAT HAVE BEEN CALCULATED*/
Metadatas_path= /*PATH OF THE FOLDER THAT WILL CONTAIN ALL THE METADATAS THAT HAVE BEEN CALCULATED*/


Save this file with 'setup.txt' name in the "assets" folder of the project

Now go to the project folder using the Explorer file of your operating system, visit the "assets" folder and copy the path of the "setup.txt" file.
Paste the newly copied path in line 13 of the "setup" class, after the "=" of course.


Now you can run the class runner.java and have fun with your graphic art engine!


Following an example of a setup file

MAX_IMAGE_AMOUNT = 100
NUMBER_OF_LEVEL = 5
IMAGE_WIDTH = 3419
IMAGE_HEIGHT = 5002

PathLev0 = C:/Users/Desktop/assets/base/0
Rarities_lev0 Background = 
White 100

PathLev1 = C:/Users/Desktop/assets/base/1
Rarities_lev1 Q =
Red 15
Grey 15
Black 30
Blue 20
Purple 20

PathLev2 = C:/Users/Desktop/assets/base/2
Rarities_lev2 Skin =
Beige 15
Grey 15
Black 30
Red 20
Purple 20

PathLev3 = C:/Users/Desktop/assets/base/3
Rarities_lev3 Jacket =
Blue 15
Grey 15
Black 30
Red 20
Purple 20

PathLev4 = C:/Users/Desktop/assets/base/4
Rarities_lev4 Decorations =
Beige 15
Grey 15
Black 30
Red 20
Purple 20

Result_path = C:/Users/Desktop/assets/result/images
Metadatas_path= C:/Users/Desktop/assets/result/metadatas
