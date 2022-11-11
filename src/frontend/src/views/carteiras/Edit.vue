<template>
  <h3>Editando {{ carteira.nome }} - {{ id }}</h3>
  <form v-on:submit="update">
    <div class="mb-3">
      <label for="nome" class="form-label">Nome</label>
      <input
        class="form-control"
        type="text"
        id="nome"
        placeholder="Nome da carteira"
        aria-label="Nome da carteira"
        v-model="carteira.nome"
      />
    </div>

    <div class="mb-3">
      <label for="descricao" class="form-label">Descrição</label>
      <input
        class="form-control"
        type="text"
        id="descricao"
        placeholder="Descrição da carteira"
        aria-label="Descrição da carteira"
        v-model="carteira.descricao"
      />
    </div>

    <button type="submit" class="btn btn-primary">Salvar</button>
  </form>
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
  methods: {
    update(e) {
      e.preventDefault(); // Prevent page from reloading.

      const requestOptions = {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(this.carteira),
      };

      fetch("/carteira/" + this.id, requestOptions)
        .then((response) => response.json())
        .then((data) => (this.carteira = data));

      this.$router.push({ name: "Carteiras" });
    },
  },

  mounted() {
    fetch("/carteira/" + this.id)
      .then((response) => response.json())
      .then((data) => (this.carteira = data));
  },
};
</script>
