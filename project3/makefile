# Makefile for xkcdpwgen

# Compiler and flags
JAVAC = javac
JFLAGS = -g

# Source files and class name
SRCS = xkcdpwgen.java
CLASSES = xkcdpwgen.class

# Main target
all: $(CLASSES)

# Compile Java source files
$(CLASSES): $(SRCS)
	$(JAVAC) $(JFLAGS) $(SRCS)

# Clean up compiled files
clean:
	rm -f $(CLASSES)
