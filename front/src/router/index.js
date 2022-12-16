import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/Products.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/products",
      name: "products",
      component: HomeView,
    },
    {
      path: "/products/create",
      name: "create",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/CreateProduct.vue"),
    },
    {
      path: "/products/edit/:id",
      props: true,
      name: "edit",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/CreateProduct.vue"),
    },
  ],
});

export default router;
