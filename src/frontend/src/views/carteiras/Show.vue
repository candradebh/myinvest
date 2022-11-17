<template>
  <h3>Carteira ID {{ carteira.id }}</h3>
  <p><b>Nome: </b> {{ carteira.nome }}</p>
  <p><b>Descricao:</b> {{ carteira.descricao }}</p>

  <table class="table table-striped table-hover">
    <thead>
      <tr>
        <th>Ticker</th>
        <th>Preço</th>
        <th>Quantidade</th>
        <th>Total</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="ativo in carteira.ativos" :key="ativo.id">
        <td>{{ativo.ticker}}</td>
        <td>{{ativo.preco}}</td>
        <td>{{ativo.quantidade}}</td>
        <td>{{ativo.total}}</td>
      </tr>
    </tbody>
  </table>
  
</template>

<script>
export default {
  props: {
    id: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      carteira: {},
    };
  },
  created() {
    console.log(this.carteira);
  },
  mounted() {
    fetch("/carteira/" + this.id)
      .then((response) => response.json())
      .then((data) => (this.carteira = data));
  },
};
</script>
