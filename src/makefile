JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        com/example/Ball.java \
	com/example/Brick.java \
	com/example/BrickBreaker.java \
	com/example/GameLogic.java \
	com/example/GameWindow.java \
	com/example/Paddle.java

default: classes

target: myprog

classes: $(CLASSES:.java=.class)

MAIN = java com.example.BrickBreaker

clean:
	$(RM) com/example/*.class

run: classes
	$(JVM) $(MAIN)
