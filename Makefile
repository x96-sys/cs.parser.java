BUILD_DIR     = out
MAIN_BUILD    = $(BUILD_DIR)/main
TEST_BUILD    = $(BUILD_DIR)/test

SRC_MAIN      = src/main
SRC_TEST      = src/test

TOOLS_DIR     = tools
LIB_DIR       = lib

KIND_VERSION = 1.0.0
KIND_BIN     = $(LIB_DIR)/org.x96.sys.lexer.token.kind.jar
KIND_URL     = https://github.com/x96-sys/lexer.token.kind.java/releases/download/v$(KIND_VERSION)/org.x96.sys.lexer.token.kind.jar
KIND_SHA256  = 55d12618cd548099d138cbc1e7beda2b78e6a09382ec725523e82f7eb5a31c69

CS_AST_VERSION = 1.0.0
CS_AST_BIN     = $(LIB_DIR)/org.x96.sys.cs.ast.jar
CS_AST_URL     = https://github.com/x96-sys/cs.ast.java/releases/download/v$(CS_AST_VERSION)/org.x96.sys.cs.ast.jar
CS_AST_SHA256  = 2a6a395ea6defdde47d5c9855dd83d47d4cf0d233f3789c3e95094e85b4597a4

TOKEN_VERSION = 1.0.0
TOKEN_BIN     = $(LIB_DIR)/org.x96.sys.lexer.token.jar
TOKEN_URL     = https://github.com/x96-sys/cs.lexer.token.java/releases/download/v$(TOKEN_VERSION)/org.x96.sys.lexer.token.jar
TOKEN_SHA256  = b58fa314148954ec78d3ead11a434da2670d6d64837807087d2b541190fcf40d

JUNIT_VERSION = 1.13.4
JUNIT_BIN     = $(TOOLS_DIR)/junit-platform-console-standalone.jar
JUNIT_URL     = https://maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(JUNIT_VERSION)/junit-platform-console-standalone-$(JUNIT_VERSION).jar
JUNIT_SHA256  = 3fdfc37e29744a9a67dd5365e81467e26fbde0b7aa204e6f8bbe79eeaa7ae892

JACOCO_VERSION = 0.8.13
JACOCO_BASE    = https://maven.org/maven2/org/jacoco

JACOCO_CLI_VERSION = $(JACOCO_VERSION)
JACOCO_CLI_BIN     = $(TOOLS_DIR)/jacococli.jar
JACOCO_CLI_URL     = $(JACOCO_BASE)/org.jacoco.cli/$(JACOCO_CLI_VERSION)/org.jacoco.cli-$(JACOCO_CLI_VERSION)-nodeps.jar
JACOCO_CLI_SHA256  = 8f748683833d4dc4d72cea5d6b43f49344687b831e0582c97bcb9b984e3de0a3

JACOCO_AGENT_VERSION = $(JACOCO_VERSION)
JACOCO_AGENT_BIN     = $(TOOLS_DIR)/jacocoagent-runtime.jar
JACOCO_AGENT_URL     = $(JACOCO_BASE)/org.jacoco.agent/$(JACOCO_AGENT_VERSION)/org.jacoco.agent-$(JACOCO_AGENT_VERSION)-runtime.jar
JACOCO_AGENT_SHA256  = 47e700ccb0fdb9e27c5241353f8161938f4e53c3561dd35e063c5fe88dc3349b

GJF_VERSION = 1.28.0
GJF_BIN     = $(TOOLS_DIR)/gjf.jar
GJF_URL     = https://maven.org/maven2/com/google/googlejavaformat/google-java-format/$(GJF_VERSION)/google-java-format-$(GJF_VERSION)-all-deps.jar
GJF_SHA256  = 32342e7c1b4600f80df3471da46aee8012d3e1445d5ea1be1fb71289b07cc735

define deps
$1/$2: $1
	@expected="$($3_SHA256)"; \
	bin="$($3_BIN)"; \
	url="$($3_URL)"; \
	tmp="$$$$(mktemp)"; \
	if [ ! -f "$$$$bin" ]; then \
		echo "[📦] [🚛] [$($3_VERSION)] [$2]"; \
		curl -sSL -o "$$$$tmp" "$$$$url"; \
		actual="$$$$(shasum -a 256 $$$$tmp | awk '{print $$$$1}')"; \
		if [ "$$$$expected" = "$$$$actual" ]; then mv "$$$$tmp" "$$$$bin"; \
		echo "[📦] [📍] [$($3_VERSION)] [$2] [🐚]"; else rm "$$$$tmp"; \
		echo "[❌] [hash mismatch] [$2]"; exit 1; fi; \
	else \
		actual="$$$$(shasum -a 256 $$$$bin | awk '{print $$$$1}')"; \
		if [ "$$$$expected" = "$$$$actual" ]; \
		then echo "[📦] [📍] [$($3_VERSION)] [🐚] [$2]"; \
		else \
			echo "[❌] [hash mismatch] [$2]"; \
			curl -sSL -o "$$$$tmp" "$$$$url"; \
			actual="$$$$(shasum -a 256 $$$$tmp | awk '{print $$$$1}')"; \
			if [ "$$$$expected" = "$$$$actual" ]; then mv "$$$$tmp" "$$$$bin"; \
			echo "[📦] [♻️] [$($3_VERSION)] [🐚] [$2]"; else rm "$$$$tmp"; \
			echo "[❌] [download failed] [$2]"; exit 1; fi; \
		fi; \
	fi
endef

JAVA_SOURCES      = $(shell find $(SRC_MAIN) -name "*.java")
JAVA_TEST_SOURCES = $(shell find $(SRC_TEST) -name "*.java")

CP = $(CS_AST_BIN):$(TOKEN_BIN):$(KIND_BIN)

DISTRO_BIN = org.x96.sys.cs.parser.jar

$(TOOLS_DIR) $(LIB_DIR):
	@mkdir -p $@

build: libs
	@javac -d $(MAIN_BUILD) -cp $(CP) $(JAVA_SOURCES)
	@echo "✅ source compiled successfully!"

build/test: kit build
	@javac -d $(TEST_BUILD) -cp $(JUNIT_BIN):$(MAIN_BUILD):$(CP) $(JAVA_TEST_SOURCES)
	@echo "✅ tests compiled successfully!"

test: build/test
	@java -jar $(JUNIT_BIN) \
     execute \
     --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CP) \
     --scan-class-path

coverage-run: build/test
	@java -javaagent:$(JACOCO_AGENT_BIN)=destfile=$(BUILD_DIR)/jacoco.exec \
       -jar $(JUNIT_BIN) \
       execute \
       --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CP) \
       --scan-class-path

coverage-report:
	@java -jar $(JACOCO_CLI_BIN) report \
     $(BUILD_DIR)/jacoco.exec \
     --classfiles $(MAIN_BUILD) \
     --sourcefiles $(SRC_MAIN) \
     --html $(BUILD_DIR)/coverage \
     --name "Coverage Report"

coverage: coverage-run coverage-report
	@echo "✅ Relatório de cobertura disponível em: out/coverage/index.html"
	@echo "🌐 Abrir com: open out/coverage/index.html"

format: tools/gjf
	@find src -name "*.java" -print0 | xargs -0 java -jar $(GJF_BIN) --aosp --replace
	@echo "[🤩] Código formatado com sucesso!"

libs: lib/ast lib/token lib/kind

$(eval $(call deps,lib,ast,CS_AST))
$(eval $(call deps,lib,token,TOKEN))
$(eval $(call deps,lib,kind,KIND))

kit: tools/junit tools/jacoco_cli tools/jacoco_agent tools/gjf

$(eval $(call deps,tools,jacoco_cli,JACOCO_CLI))
$(eval $(call deps,tools,jacoco_agent,JACOCO_AGENT))
$(eval $(call deps,tools,junit,JUNIT))
$(eval $(call deps,tools,gjf,GJF))

distro:
	@echo "📦 Criando JAR distribuível..."
	@jar cf $(DISTRO_BIN) -C $(MAIN_BUILD) .
	@echo "✅ JAR criado: $(DISTRO_BIN)"

clean:
	@rm -rf $(BUILD_DIR) $(TOOLS_DIR) $(LIB_DIR)
	@rm -rf *.jar
	@echo "[🧹] [clean] Build directory cleaned."
