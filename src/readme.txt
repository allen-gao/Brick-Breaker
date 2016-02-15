A1: Breakout!
Allen Gao
20529760

// running the game
Running 'make run' will run the program with the default values
of 30 fps and a ball speed of 5. 

To run this program with custom command line arguments, run
'java com.example.BrickBreaker fps ballSpeed' from the root directory.

Note that ball speed must be an int between 1 to 10, where 1 is 
very slow (easy), 5 is average, and 10 is very fast (hard).


// in game extra features
You will notice that exactly one brick in the game will be changing
colours several times a second. This 'rainbow' brick gives a powerup
once it's broken - the paddle doubles in size and 1 more life is given.

You can also 'tilt' the screen using the left and right arrow keys, 
similar to Pinball on Windows XP. By doing this, the x velocity of the 
ball is changed, which allows for more interactive gameplay when the
ball has little horizontal movement.

Whenever the game starts or a life is lost, the game is in the
'aim phase' - you can accurately aim the ball with the mouse to have
it percisely shoot at that location.


// cheats
'Bounce on bottom screen': the ball simply bounces once it hits the
bottom edge of the screen. Useful for testing as all bricks will be
broken in a few minutes without having to play the game.

'Infinite lives': exactly what it sounds like, useful for accurately
aiming the ball numerous times to test collisions and powerups.


// keyboard keys
left and right arrows: tilts
P: pause
esc: exit to splash screen
