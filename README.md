# ⛽️ EtanolOuGasolina

Ajuda você a decidir rapidamente entre **etanol** e **gasolina** no posto, com base nos **preços** informados e na **eficiência relativa** do etanol no seu motor.

---

## 📲 Visão geral

- Interface em **Jetpack Compose (Material 3)**.
- Dois campos para **preço da gasolina** e **preço do etanol**.
- **Slider** para eficiência do etanol (de **70% a 80%**), refletindo faixas típicas de motores flex modernos.
- Resultado em **tempo real** à medida que você digita/move o slider.
- **Tema claro/escuro** e estado preservado em reconfigurações com `rememberSaveable`.
- **Sem permissões** e **funcionamento offline** (não coleta dados).

---

## 🧠 Como funciona

Ideia simples: compare o preço do etanol com um teto calculado a partir do preço da gasolina e da eficiência escolhida.
```
preco_max_etanol = eficiencia_relativa * preco_gasolina

Se (preco_etanol <= preco_max_etanol)  =>  RECOMENDA ETANOL
Senão                                   =>  RECOMENDA GASOLINA
```
Exemplos rápidos:

⦁	Exemplo A  

Gasolina = `5,00` • Etanol = `3,50` • Eficiência = `75%`  
`preco_max_etanol = 0,75 * 5,00 = 3,75` → `3,50 <= 3,75` ⇒ Etanol ✅

⦁	Exemplo B  

Gasolina = `5,00` • Etanol = `3,90` • Eficiência = `75%`  
`preco_max_etanol = 0,75 * 5,00 = 3,75` → `3,90 > 3,75` ⇒ Gasolina ✅


---

## 🚀 Instalação e execução

1. **Clonar o repositório**
   - Basta clonar este repositório

3. **Abrir no Android Studio**
   - Use uma versão atualizada do Android Studio com suporte ao Jetpack Compose.
   - Sincronize o Gradle normalmente.

4. **Executar**
   - Escolha um dispositivo físico (com depuração USB) ou um emulador.
   - Clique em **Run** ▶️.

---

## 🧩 O que foi usado?

- **Kotlin**
- **Jetpack Compose** (Material 3)
- Estado com **`rememberSaveable`**
- Canvas + gestos para **slider customizado** (faixa 70–80%)

---

## 🧪 Exemplo de uso

1. Informe **Preço da Gasolina** e **Preço do Etanol** (ex.: `5,00` e `3,50`).  
2. Ajuste **Eficiência do Etanol** (ex.: `75%`).  
3. O app exibirá: **“Você deve abastecer com Etanol”**.

> Dica: o app aceita **vírgula** ou **ponto** como separador decimal.

---

## ♿ Acessibilidade

- Tipografia e contraste pensados para leitura confortável.
- Textos claros e diretos.
- Disponível somente em pt-br

---

## 🔒 Privacidade

- O app não requer permissões especiais.
- Não coleta, armazena ou transmite dados pessoais.
- Funciona **offline**.


---

## 📎 Créditos

- Desenvolvido por **Lucas da Silva Gondim e Ana Gabriela Rodrigues Damasceno**.  
- Interface baseada em **Material 3** e **Jetpack Compose**.

