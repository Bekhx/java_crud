<script>
import axios from "axios";
export default {
  props: ["id"],
  data() {
    return {
      product: {
        name: "",
        price: "",
      },
      formButtonName: this.id ? "Edit" : "Create",
    };
  },
  mounted() {
    this.getById();
  },
  methods: {
    async getById() {
      try {
        if (this.id) {
          const { data } = await axios.get(
            `http://localhost:8000/api/product/${this.id}`
          );
          this.product.name = data.name;
          this.product.price = data.price;
        }
      } catch (error) {
        console.log("Error: ", error);
      }
    },
    async saveProduct() {
      try {
        if (this.id) {
          await axios.put(`http://localhost:8000/api/product/${this.id}`, {
            name: this.product.name,
            price: this.product.price,
          });
        } else {
          await axios.post("http://localhost:8000/api/product/", {
            name: this.product.name,
            price: this.product.price,
          });
        }

        this.$router.push("/products");
      } catch (error) {
        console.log("ERROR: ", error);
      }
    },
    backToProducts() {
      this.$router.push("/products");
    },
  },
};
</script>

<template>
  <div class="create_product">
    <button
      type="button"
      class="btn btn-primary go_back_button"
      @click="backToProducts"
    >
      Go To Products
    </button>
    <form v-on:submit.prevent="saveProduct">
      <div class="form-group">
        <label for="product_name">Name</label>
        <input
          v-model="product.name"
          type="text"
          required
          class="form-control name_input"
          id="product_name"
          placeholder="Enter name"
        />
      </div>
      <div class="form-group">
        <label for="product_price">Price</label>
        <input
          v-model="product.price"
          type="number"
          required
          step=".01"
          class="form-control price_input"
          id="product_price"
          placeholder="0.00"
        />
      </div>
      <button type="submit" class="btn btn-primary submit">
        {{ formButtonName }}
      </button>
    </form>
  </div>
</template>

<style>
.create_product {
  display: grid;
  align-items: center;
}

.submit {
  margin-top: 15px;
}

#product_price,
#product_name {
  background-color: #444;
}

.go_back_button {
  margin: auto;
  max-width: 150px;
}

.price_input,
.name_input {
  color: antiquewhite;
  border-color: #333;
}
</style>
