<template>
  <h3>Minhas Carteiras</h3>

  <table class="table table-striped table-hover">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Descricao</th>
        <th>Total</th>
        <th>-</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="row in carteiras" :key="row.id">
        
        <td>{{ row.nome }}</td>
        <td>{{ row.descricao }}</td>
        <td>{{ row.total }}</td>
        <td>
          <router-link :to="'/carteiras/show/' + row.id">Ver</router-link> |
          <router-link :to="'/carteiras/edit/' + row.id">Editar</router-link>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  data() {
    return {
      carteiras: [],
    };
  },
  mounted() {
    fetch("/carteira/")
      .then((response) => response.json())
      .then((data) => (this.carteiras = data));
  },
};
</script>
