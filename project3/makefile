# Variables
JAVAC = javac
JAVA = java
SRC_DIR = cy2550
BIN_DIR = bin
MAIN_CLASS = xkcdpwgen

# Targets and Rules
all: build run

build:
	$(JAVAC) -d $(BIN_DIR) $(SRC_DIR)/*.java

run:
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BIN_DIR)/*
