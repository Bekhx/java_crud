<template>
  <div class="create_product">
    <form>
      <div class="form-group">
        <label for="product_name">Name</label>
        <input
          type="email"
          class="form-control name_input"
          id="product_name"
          aria-describedby="emailHelp"
          placeholder="Enter name"
        />
      </div>
      <div class="form-group">
        <label for="product_price">Price</label>
        <input
          type="number"
          required
          step=".01"
          class="form-control price_input"
          id="product_price"
          placeholder="0.00"
        />
      </div>
      <button type="submit" class="btn btn-primary submit">Create</button>
    </form>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .create_product {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }

  .submit {
    margin-top: 15px;
  }

  #product_price,
  #product_name {
    background-color: #444;
  }

  .price_input,
  .name_input {
    border-color: #333;
  }
}
</style>
