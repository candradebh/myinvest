<template>
  <h3>Carteira ID {{ carteira.id }}</h3>
  <p><b>Nome: </b> {{ carteira.nome }}</p>
  <p><b>Descricao:</b> {{ carteira.descricao }}</p>
  
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
