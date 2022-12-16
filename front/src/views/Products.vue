<script>
import axios from "axios";

export default {
  props: ["id"],
  name: "ProductsList",
  data() {
    return {
      products: [],
    };
  },
  mounted() {
    this.getProducts();
  },
  methods: {
    async getProducts() {
      try {
        const products = await axios.get("http://localhost:8000/api/product/");
        this.products = products.data;
      } catch (error) {
        console.log("ERROR: ", error);
      }
    },
    async deleteProduct(id) {
      try {
        await axios.delete(`http://localhost:8000/api/product/${id}`);

        const index = this.products.findIndex((p) => p.id === id);

        if (index >= 0) this.products.splice(index, 1);
      } catch (error) {
        console.log("ERROR: ", error);
      }
    },
    goToCreateProduct() {
      this.$router.push("/products/create");
    },
  },
};
</script>

<template>
  <main>
    <div id="products">
      <div class="go_back">
        <button
          type="button"
          class="btn btn-primary go_to_create_button"
          @click="goToCreateProduct"
        >
          Create Product
        </button>
      </div>
      <table class="table table-striped table-dark">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr :key="item.id" v-for="(item, i) in products">
            <th scope="row">{{ i + 1 }}</th>
            <td>{{ item.name }}</td>
            <td>{{ item.price }}</td>
            <td>
              <div class="product_buttons d-flex justify-content-around m-auto">
                <router-link
                  :to="`/products/edit/${item.id}`"
                  type="button"
                  class="btn btn-outline-primary product_edit"
                >
                  Edit
                </router-link>
                <button
                  type="button"
                  class="btn btn-outline-danger product_delete"
                  @click="deleteProduct(item.id)"
                >
                  Delete
                </button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </main>
</template>

<style>
#products {
  display: grid;
}

.go_to_create_button {
  max-width: 150px;
  margin: auto;
}

.go_back {
  margin: 50px;
  display: flex;
}

.product_buttons {
}

.product_edit {
}

.product_delete {
}
</style>
