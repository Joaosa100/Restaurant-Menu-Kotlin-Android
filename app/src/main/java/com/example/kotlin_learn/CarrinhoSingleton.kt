package com.example.kotlin_learn

object CarrinhoSingleton {
    private val listaProdutos = mutableListOf<Produto>()

    fun adicionarProduto(produto: Produto) {
        listaProdutos.add(produto)
    }

    fun removerProduto(produto: Produto) {
        listaProdutos.remove(produto)
    }

    fun limparCarrinho() {
        listaProdutos.clear()
    }

    fun getProdutos(): List<Produto> {
        return listaProdutos.toList()
    }

    fun getTotal(): Double {
        var total = 0.0
        for (produto in listaProdutos) {
            // Verifica se o preço começa com "$" ou "R$"
            val precoString = produto.preco.trim()
            val precoNumerico = if (precoString.startsWith("$")) {
                precoString.substring(1).toDoubleOrNull() ?: 0.0
            } else if (precoString.startsWith("R$")) {
                precoString.substring(2).toDoubleOrNull() ?: 0.0
            } else {
                0.0
            }
            total += precoNumerico
        }
        return total
    }

}


