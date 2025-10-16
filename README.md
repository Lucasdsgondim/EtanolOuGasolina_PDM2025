# ⛽️ EtanolOuGasolina

Ajuda você a decidir rapidamente entre **etanol** e **gasolina** no posto, com base nos **preços** informados e na **eficiência relativa** do etanol no seu motor.

> **Regra de bolso**: se \( preço\_etanol / preço\_gasolina \le \eta \), recomenda **Etanol**; caso contrário, **Gasolina**.  
> No app, \(\eta\) (eficiência relativa do etanol) é ajustável de **70% a 80%** via slider.

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

Seja \( p_E \) o preço do **etanol**, \( p_G \) o preço da **gasolina** e \( \eta \in [0{,}70, 0{,}80] \) a eficiência relativa do etanol:

\[
\textbf{Se } \frac{p_E}{p_G} \le \eta \Rightarrow \text{Etanol; caso contrário } \Rightarrow \text{Gasolina}.
\]

**Exemplo:** \(p_E = 3{,}50\), \(p_G = 5{,}00\), \(\eta = 0{,}75\) → \(3{,}50/5{,}00 = 0{,}70 \le 0{,}75\) → **Etanol**.

---

## 🚀 Instalação e execução

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/<seu-usuario>/<seu-repo>.git
   cd <seu-repo>
   ```

2. **Abrir no Android Studio**
   - Use uma versão atualizada do Android Studio com suporte ao Jetpack Compose.
   - Sincronize o Gradle normalmente.

3. **Executar**
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

