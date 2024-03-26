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
            // Remover o símbolo "R$" e converter para Double
            val precoNumerico = produto.preco.substring(2).toDoubleOrNull() ?: 0.0
            total += precoNumerico
        }
        return total
    }



}


